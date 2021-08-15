package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import MyUtils.DBConnection;
import ObjecInfo.Type_Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Type_AccountModel {
    //declare variables
    public Connection con;
    public PreparedStatement pst;
    public ResultSet rs;
    static java.sql.Statement st;
    public ArrayList<Type_Account> type_acc;
    public String str;

    /**
     * constructor Type_AccountModel
     */
    public Type_AccountModel() {
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            pst = null;
            rs = null;
            str = null;
            type_acc = new ArrayList<>();
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * load model type account
     * @return
     * @throws Exception
     * @throws SQLException 
     */
    public ArrayList<Type_Account> loadModelTypeAccount() throws Exception, SQLException {
        try {
            //load data form sql and add it to arraylist
            type_acc = new ArrayList<>();
            str = "SELECT `ID_TypeAccount`, `Name_Type`, `Status` FROM `type_account` WHERE 1";//query of sql server
            rs = st.executeQuery(str);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int ID_TypeAccount = rs.getInt("ID_TypeAccount");
                    String Name = rs.getString("Name_Type");
                    int Status = rs.getInt("Status");
                    if (Status != 0) {
                        type_acc.add(new Type_Account(ID_TypeAccount, Name, Status));//add data to array list
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return type_acc;
    }
    
    /**
     * insert type account
     * @param ID_TypeAccount
     * @param Name
     * @throws SQLException
     * @throws Exception 
     */
    public void insertTypeAccount(int ID_TypeAccount, String Name) throws SQLException, Exception {
        try {
            //insert into sql          
            str = "INSERT INTO `type_account`(`ID_TypeAccount`, `Name_Type`, `Status`) VALUES (?,?,1)";//query of sql serverl
            pst = con.prepareStatement(str, java.sql.Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, ID_TypeAccount);
            pst.setString(2, Name);
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            e.printStackTrace();//exception
        }
    }
    
    /**
     * update type account
     * @param ID_TypeAccount
     * @param Name
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean updateTypeAccount(int ID_TypeAccount, String Name) throws SQLException, Exception {
        boolean check = true;
        try {
            //insert into sql          
            str = "UPDATE `type_account` SET `Name_Type`=? WHERE `ID_TypeAccount`=?";//query of sql server
            pst = con.prepareStatement(str);
            pst.setString(1, Name);
            pst.setInt(2, ID_TypeAccount);
            pst.executeUpdate();
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return check;
    }
    
    /**
     * delete type account
     * @param ID_TypeAccount
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean deleteTypeAccount(int ID_TypeAccount) throws SQLException, Exception {
        boolean check = true;
        try {
            //insert into sql          
            str = "UPDATE `type_account` SET `Status`= 0 WHERE `ID_TypeAccount`= ?";//query of sql server
            pst = con.prepareStatement(str);
            pst.setInt(1, ID_TypeAccount);
            pst.executeUpdate();
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return check;
    }
}
