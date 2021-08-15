package Model;

import MyUtils.DBConnection;
import ObjecInfo.CategoryException;
import ObjecInfo.Game;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class GameModel {

    public static int SoDong_Trang = 5;
    private Connection con;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private String str;
    ArrayList<Game> list;
    ArrayList<Game> listByID;

    /**
     * Create game model
     *
     * @throws SQLException
     */
    public GameModel() throws SQLException {
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
     * Load all game
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Game> loadAllGame() throws SQLException {
        ArrayList<Game> Games = new ArrayList<Game>();
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            str = "SELECT * FROM `game`";
            rs = st.executeQuery(str);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int ID_Game = rs.getInt("ID_Game");
                    int ID_Category = rs.getInt("ID_Category");
                    String Name_Game = rs.getString("Name_Game");
                    String Image_Game = rs.getString("Image_Game");
                    String Video_Game = rs.getString("Video_Game");
                    String Description = rs.getString("Description");
                    int CountRate = rs.getInt("CountRate");
                    int TotalRatePoint = rs.getInt("TotalRatePoint");
                    int Status = rs.getInt("Status");
                    if (Status != 0) {
                        Games.add(new Game(ID_Game, ID_Category, Name_Game, Image_Game, Video_Game, Description, CountRate, TotalRatePoint, Status));
                    }
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Can't load games");
        }
        return Games;
    }

    /**
     * insert new game
     *
     * @param ID_Category
     * @param Name_Game
     * @param Image_Game
     * @param Video_Game
     * @param Description
     * @param CountRate
     * @param TotalRatePoint
     * @return
     * @throws SQLException
     */
    public void insertGames(int ID_Category, String Name_Game, String Image_Game,
            String Video_Game, String Description, int CountRate, int TotalRatePoint) throws SQLException {
        int id;
        try {
            str = "INSERT INTO `game`(`ID_Category`, `Name_Game`, `Image_Game`, `Video_Game`,"
                    + " `Description`, `CountRate`, `TotalRatePoint`, `Status`)"
                    + " VALUES (?,?,?,?,?,?,?,1)";
            pst = con.prepareStatement(str, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, ID_Category);
            pst.setString(2, Name_Game);
            pst.setString(3, Image_Game);
            pst.setString(4, Video_Game);
            pst.setString(5, Description);
            pst.setInt(6, CountRate);
            pst.setInt(7, TotalRatePoint);
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            throw new SQLException("Can't insert games");
        }
    }

    /**
     * Update game
     *
     * @param ID_Game
     * @param ID_Category
     * @param Name_Game
     * @param Image_Game
     * @param Video_Game
     * @param Description
     * @param CountRate
     * @param TotalRatePoint
     * @return
     * @throws SQLException
     * @throws CategoryException
     */
    public boolean updateGame(int ID_Game, int ID_Category, String Name_Game, String Image_Game,
            String Video_Game, String Description) throws SQLException, CategoryException {
        try {
            str = "UPDATE `game` SET `ID_Category`=?,`Name_Game`=?,"
                    + "`Image_Game`=?,`Video_Game`=?,"
                    + "`Description`=?"
                    + "WHERE `ID_Game`=?";
            pst = con.prepareStatement(str);
            pst.setInt(1, ID_Category);
            pst.setString(2, Name_Game);
            pst.setString(3, Image_Game);
            pst.setString(4, Video_Game);
            pst.setString(5, Description);
            pst.setInt(6, ID_Game);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException("Can't update game");
        }
    }

    /**
     * Update rate
     *
     * @param ID_Game
     * @param CountRate
     * @param TotalRatePoint
     * @return
     * @throws SQLException
     * @throws CategoryException
     */
    public boolean updateRate(int ID_Game, int CountRate, int TotalRatePoint) throws SQLException, CategoryException {
        try {
            str = "UPDATE `game` SET `CountRate`=?,`TotalRatePoint`=? WHERE `ID_Game`=?";
            pst = con.prepareStatement(str);
            pst.setInt(1, CountRate);
            pst.setInt(2, TotalRatePoint);
            pst.setInt(3, ID_Game);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException("Can't update game");
        }
    }

    /**
     * Delete game
     *
     * @param ID_Game
     * @return
     * @throws SQLException
     */
    public boolean deleteGame(int ID_Game) throws SQLException {
        try {
            str = "UPDATE `game` SET `Status`=0 WHERE `ID_Game`=?";
            pst = con.prepareStatement(str);
            pst.setInt(1, ID_Game);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException("Can't delete game");
        }
    }

    /**
     * Get top game
     * @return 
     */
    public ArrayList<Game> getTopGame() {
        try {
            String sqlStr = "SELECT * FROM game\n"
                    + "order by `TotalRatePoint` desc LIMIT 3";

            this.st = this.con.createStatement();
            this.rs = this.st.executeQuery(sqlStr);
            list = new ArrayList<Game>();
            while (rs.next()) {
                int ID_Game = rs.getInt("ID_Game");
                int ID_Category = rs.getInt("ID_Category");
                String Name_Game = rs.getString("Name_Game");
                String Image_Game = rs.getString("Image_Game");
                String Video_Game = rs.getString("Video_Game");
                String Description = rs.getString("Description");
                int CountRate = rs.getInt("CountRate");
                int TotalRatePoint = rs.getInt("TotalRatePoint");
                int Status = rs.getInt("Status");

                list.add(new Game(ID_Game, ID_Category, Name_Game, Image_Game, Video_Game, Description, CountRate, TotalRatePoint, Status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.list;
    }

    /**
     * List game by category
     * @param cate
     * @return 
     */
    public ArrayList<Game> ListByCate(int cate) {
        try {
            String sqlStr = "SELECT * FROM `game` WHERE `ID_Category` = " + cate + " AND `Status` = 1 LIMIT 3";
           
            this.st = this.con.createStatement();
            this.rs = this.st.executeQuery(sqlStr);
            list = new ArrayList<Game>();
            while (rs.next()) {
                int ID_Game = rs.getInt("ID_Game");
                int ID_Category = rs.getInt("ID_Category");
                String Name_Game = rs.getString("Name_Game");
                String Image_Game = rs.getString("Image_Game");
                String Video_Game = rs.getString("Video_Game");
                String Description = rs.getString("Description");
                int CountRate = rs.getInt("CountRate");
                int TotalRatePoint = rs.getInt("TotalRatePoint");
                int Status = rs.getInt("Status");

                list.add(new Game(ID_Game, ID_Category, Name_Game, Image_Game, Video_Game, Description, CountRate, TotalRatePoint, Status));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.list;
    }

    /**
     * Get number of product by cate
     * @param page
     * @param search
     * @param sortColumn
     * @param cate
     * @return
     * @throws SQLException 
     */
    public int getNumberOfProductByCate(int page, String search, String sortColumn, int cate) throws SQLException {
        String sqlStr = "";
        sqlStr += " SELECT count(*) as soLuong FROM `game` WHERE ID_Category= " + cate;
        sqlStr += " AND `Status` = 1 ";
        if (search != "") {
            //thuc hien tim kiem
            sqlStr += " AND `Name_Game` LIKE '%" + search + "%' ";
        }
        sqlStr += " ORDER BY `ID_Game` DESC ";
        this.st = this.con.createStatement();
        this.rs = this.st.executeQuery(sqlStr);
        rs.next();
        return rs.getInt("soLuong");
    }

    /**
     * Get paging by category
     * @param page
     * @param search
     * @param sortColumn
     * @param cate
     * @return 
     */
    public ArrayList<Game> getPagingByCate(int page, String search, String sortColumn, int cate) {
        try {
            String sqlStr = "";
            sqlStr += " SELECT * FROM `game` WHERE `ID_Category` = " + cate;
            sqlStr += " AND `Status` = 1 ";
            if (search != "") {
                //thuc hien tim kiem
                sqlStr += " AND `Name_Game` LIKE '%" + search + "%' ";
            }
            sqlStr += " ORDER BY `ID_Game` DESC ";
            //phan trang
            int tongSoSanPham = getNumberOfProductByCate(page, search, sortColumn, cate);
            int tongSoTrang = (int) Math.ceil(tongSoSanPham / (float) 3);
            System.out.println(tongSoSanPham);
            System.out.println(tongSoTrang);
            int index = (page - 1) * 3;

            sqlStr += " LIMIT " + index + ", " + 3;

            this.st = this.con.createStatement();
            this.rs = this.st.executeQuery(sqlStr);
            list = new ArrayList<Game>();
            while (rs.next()) {
                int ID_Game = rs.getInt("ID_Game");
                int ID_Category = rs.getInt("ID_Category");
                String Name_Game = rs.getString("Name_Game");
                String Image_Game = rs.getString("Image_Game");
                String Video_Game = rs.getString("Video_Game");
                String Description = rs.getString("Description");
                int CountRate = rs.getInt("CountRate");
                int TotalRatePoint = rs.getInt("TotalRatePoint");
                int Status = rs.getInt("Status");
                if (Status != 0) {
                    list.add(new Game(ID_Game, ID_Category, Name_Game, Image_Game, Video_Game, Description, CountRate, TotalRatePoint, Status));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.list;
    }

    /**
     * Get paging
     * @param page
     * @param search
     * @param sortColumn
     * @return 
     */
    public ArrayList<Game> getPaging(int page, String search, String sortColumn) {
        try {
            String sqlStr = "";
            sqlStr += " SELECT a.* , b.ID_Category ";
            sqlStr += " FROM `game` as a, `category` as b ";
            sqlStr += " WHERE a.ID_Category = b.ID_Category ";
            sqlStr += " AND a.Status = 1 ";

            if (search != "") {
                //thuc hien tim kiem
                sqlStr += " AND (a.Name_Game LIKE '%" + search + "%' OR  b.Name_Category LIKE '%" + search + "%')";
            }
            
            if (sortColumn != "") {
                //thuc hien sap xep
            }
            
            sqlStr += " ORDER BY `ID_Game` DESC ";
            //phan trang
            int tongSoSanPham = getNumberOfProduct(page, search, sortColumn);
            int tongSoTrang = (int) Math.ceil(tongSoSanPham / (float) SoDong_Trang);
            System.out.println(tongSoSanPham);
            System.out.println(tongSoTrang);
            int index = (page - 1) * SoDong_Trang;

            sqlStr += " LIMIT " + index + ", " + SoDong_Trang;

            this.st = this.con.createStatement();
            this.rs = this.st.executeQuery(sqlStr);
            list = new ArrayList<Game>();
            while (rs.next()) {
                int ID_Game = rs.getInt("ID_Game");
                int ID_Category = rs.getInt("ID_Category");
                String Name_Game = rs.getString("Name_Game");
                String Image_Game = rs.getString("Image_Game");
                String Video_Game = rs.getString("Video_Game");
                String Description = rs.getString("Description");
                int CountRate = rs.getInt("CountRate");
                int TotalRatePoint = rs.getInt("TotalRatePoint");
                int Status = rs.getInt("Status");
                if (Status != 0) {
                    list.add(new Game(ID_Game, ID_Category, Name_Game, Image_Game, Video_Game, Description, CountRate, TotalRatePoint, Status));
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(GameModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.list;
    }


    /**
     * Get number of product
     * @param page
     * @param search
     * @param sortColumn
     * @return
     * @throws SQLException 
     */
    public int getNumberOfProduct(int page, String search, String sortColumn) throws SQLException {
        String sqlStr = "";
        sqlStr += " SELECT count(*) as soLuong ";
        sqlStr += " FROM `game` as a, `category` as b ";
        sqlStr += " WHERE a.ID_Category = b.ID_Category ";
        sqlStr += " AND a.`Status` = 1 ";
        if (search != "") {
            //thuc hien tim kiem
            sqlStr += " AND (a.`Name_Game` LIKE '%" + search + "%' OR  b.`Name_Category` LIKE '%" + search + "%')";
        }
        sqlStr += " ORDER BY `ID_Game` DESC ";
        this.st = this.con.createStatement();
        this.rs = this.st.executeQuery(sqlStr);
        rs.next();
        return rs.getInt("soLuong");
    }

    /**
     * Get paging string by category
     * @param currentPage
     * @param search
     * @param sortColumn
     * @param cate
     * @return 
     */
    public String getPagingStringByCate(int currentPage, String search, String sortColumn, int cate) {
        String strPaging = "<div class='site-pagination'>";
        try {
            int tongSoSanPham = getNumberOfProductByCate(currentPage, search, sortColumn, cate);
            int tongSoTrang = (int) Math.ceil(tongSoSanPham / (float) 3);
            for (int stt_trang = 1; stt_trang <= tongSoTrang; stt_trang++) {

                if (search == "") {
                    if (stt_trang == currentPage) {
                        strPaging += "<a class='active' href='?page=" + stt_trang + "&cate=" + cate + "'>" + stt_trang + "</a>";
                    } else {
                        strPaging += "<a href='?page=" + stt_trang + "&cate=" + cate + "'>" + stt_trang + "</a>";
                    }
                } else if (stt_trang == currentPage) {
                    strPaging += "<a class='active' href='?page=" + stt_trang + "&s=" + search + "&cate=" + cate + "'>" + stt_trang + "</a>";
                } else {
                    strPaging += "<a href='?page=" + stt_trang + "&s=" + search + "&cate=" + cate + "'>" + stt_trang + "</a>";
                }
            }
            strPaging += "</div>";
        } catch (SQLException ex) {
            Logger.getLogger(GameModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strPaging;
    }

    /**
     * Get paging string
     * @param currentPage
     * @param search
     * @param sortColumn
     * @return 
     */
    public String getPagingString(int currentPage, String search, String sortColumn) {
        String strPaging = "<div class='pagination'>";
        try {
            int tongSoSanPham = getNumberOfProduct(currentPage, search, sortColumn);
            int tongSoTrang = (int) Math.ceil(tongSoSanPham / (float) SoDong_Trang);
            for (int stt_trang = 1; stt_trang <= tongSoTrang; stt_trang++) {
                if (search == "") {
                    if (stt_trang == currentPage) {
                        strPaging += "<a class='active' href='?page=" + stt_trang + "'>" + stt_trang + "</a>";
                    } else {
                        strPaging += "<a href='?page=" + stt_trang + "'>" + stt_trang + "</a>";
                    }
                } else if (stt_trang == currentPage) {
                    strPaging += "<a class='active' href='?page=" + stt_trang + "&s=" + search + "'>" + stt_trang + "</a>";
                } else {
                    strPaging += "<a href='?page=" + stt_trang + "&s=" + search + "'>" + stt_trang + "</a>";
                }
            }
            strPaging += "</div>";
        } catch (SQLException ex) {
            Logger.getLogger(GameModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strPaging;
    }

    /**
     * Print word by number character
     * @param words
     * @param number
     * @return 
     */
    public String printWord(String words, int number) {
        String AllWord = "";
        String[] getsaveWord = words.split("\\s+");
        int i = 0;
        do {
            AllWord += " " + getsaveWord[i];
            i++;
            if (AllWord.length() >= number) {
                AllWord += " ...";
            }
        } while (AllWord.length() < 100 && i < getsaveWord.length);

        return AllWord;
    }

    /**
     * Search game by id
     * @param Id
     * @return 
     */
    public ArrayList<Game> searchGameByID(int Id) {
        String query = "SELECT game.*,category.ID_Category "
                + " FROM `game`,category WHERE game.ID_Game = " + Id
                + " AND game.ID_Category = category.ID_Category ";
        list = new ArrayList<Game>();
        try {
            this.st = this.con.createStatement();
            rs = st.executeQuery(query);//execute query

            while (rs.next()) {
                int ID_Game = rs.getInt("ID_Game");
                int ID_Category = rs.getInt("ID_Category");
                String Name_Game = rs.getString("Name_Game");
                String Image_Game = rs.getString("Image_Game");
                String Video_Game = rs.getString("Video_Game");
                String Description = rs.getString("Description");
                int CountRate = rs.getInt("CountRate");
                int TotalRatePoint = rs.getInt("TotalRatePoint");
                int Status = rs.getInt("Status");
                list.add(new Game(ID_Game, ID_Category, Name_Game, Image_Game, Video_Game, Description, CountRate, TotalRatePoint, Status));

            }

            return this.list;
        } catch (SQLException e) {
            System.out.println("Can't search game.");
            return null;
        } catch (Exception e) {
            System.out.println("Can't search game.");
            return null;
        }
    }

    /**
     * Get type game
     * @param type
     * @return 
     */
    public String getTypeGame(int type) {
        String StringType = "";
        switch (type) {
            case 1:
                StringType = "Action";
                break;
            case 2:
                StringType = "Adventure";
                break;
            case 3:
                StringType = "Tactic";
                break;
            case 4:
                StringType = "Roleplaying";
                break;
            case 5:
                StringType = "Horror";
                break;
        }
        return StringType;
    }

    /**
     * get name of game by id
     * @param id
     * @return
     * @throws SQLException 
     */
    public String getNameGameByID(int id) throws SQLException {
        String Name = "";
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            str = "SELECT * FROM `game` where `ID_Game` = '" + id + "'";
            rs = st.executeQuery(str);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    Name = rs.getString("Name_Game");
                }
            }

        } catch (SQLException e) {
            throw new SQLException("Can't load games");
        }
        return Name;
    }

}
