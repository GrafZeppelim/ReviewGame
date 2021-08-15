package Model;


import MyUtils.DBConnection;
import ObjecInfo.Category;
import ObjecInfo.CategoryException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class CategoryModel {

    private Connection con;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private String str;

    /**
     * Create category
     *
     * @throws SQLException
     */
    public CategoryModel() throws SQLException {
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            pst = null;
            rs = null;
            str = "";
        } catch (Exception e) {
            throw new SQLException("PLEASE CONNECT TO DATABASE BEFORE START");
        }
    }

    /**
     * Load all category
     * @return
     * @throws SQLException
     */
    public ArrayList<Category> loadAllCategory() throws SQLException {
        ArrayList<Category> Categorys = new ArrayList<Category>();
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            str = "SELECT * FROM `category`";
            rs = st.executeQuery(str);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int ID_Category = rs.getInt("ID_Category");
                    String Name_Category = rs.getString("Name_Category");
                    int Status = rs.getInt("Status");
                    if (Status != 0) {
                        Categorys.add(new Category(ID_Category, Name_Category, Status));
                    }

                }

            }
        } catch (SQLException e) {
            throw new SQLException("Can't load categorys");
        }
        return Categorys;
    }

    /**
     * Insert category
     *
     * @param ID_Category
     * @param Name_Category
     * @return
     * @throws SQLException
     */
    public void insertCategory(int ID_Category, String Name_Category) throws SQLException {
        int id;
        try {
            str = "INSERT INTO `category`(`ID_Category`, `Name_Category`, `Status`) VALUES (?,?,1)";
            pst = con.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, ID_Category);
            pst.setString(2, Name_Category);
            pst.executeUpdate();
            rs.next();
        } catch (SQLException e) {
            throw new SQLException("Can't insert category");
        }

    }

    /**
     * Update category
     *
     * @param ID_Category
     * @param Name_Category
     * @return
     * @throws SQLException
     * @throws CategoryException
     */
    public boolean updateCategory(int ID_Category, String Name_Category) throws SQLException, CategoryException {
        try {
            str = "UPDATE `category` SET `Name_Category`=? WHERE `ID_Category`=?";
            pst = con.prepareStatement(str);
            pst.setString(1, Name_Category);
            pst.setInt(2, ID_Category);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException("Can't update category");
        }
    }

    /**
     * Delete category
     *
     * @param ID_Category
     * @return
     * @throws SQLException
     */
    public boolean deleteCategory(int ID_Category) throws SQLException {
        try {
            str = "UPDATE `category` SET `Status`=0 WHERE `ID_Category`=?";
            pst = con.prepareStatement(str);
            pst.setInt(1, ID_Category);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException("Can't delete category");
        }
    }
}
