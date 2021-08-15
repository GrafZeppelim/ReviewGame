package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import MyUtils.DBConnection;
import ObjecInfo.Posts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PostModel {

    //declare variables
    public static int SoDong_Trang = 5;
    public Connection con;
    public PreparedStatement pst;
    public ResultSet rs;
    static java.sql.Statement st;
    public ArrayList<Posts> post;
    ArrayList<Posts> list;
    public String str;

    /**
     * constructor PostModel
     */
    public PostModel() {
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            pst = null;
            rs = null;
            str = null;
            post = new ArrayList<>();
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Load model post
     *
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public ArrayList<Posts> loadModelPost() throws Exception, SQLException {
        try {
            //load data form sql and add it to arraylist
            post = new ArrayList<>();
            str = "SELECT `ID_Post`, `ID_Account`, `ID_Game`, `Content_Post`, `Title_Post`, `Image_Post`, `Video_Post`, `Status` FROM `posts` WHERE `Status` = 1";//query of sql server
            rs = st.executeQuery(str);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int ID_Post = rs.getInt("ID_Post");
                    int ID_Account = rs.getInt("ID_Account");
                    int ID_Game = rs.getInt("ID_Game");
                    String Content = rs.getString("Content_Post");
                    String Title = rs.getString("Title_Post");
                    String Image = rs.getString("Image_Post");
                    String Video = rs.getString("Video_Post");
                    int Status = rs.getInt("Status");
                    if (Status != 0) {
                        post.add(new Posts(ID_Post, ID_Account, ID_Game, Content, Title, Image, Video, Status));//add data to array list
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return post;
    }

    /**
     * insert post model
     *
     * @param ID_Account
     * @param ID_Game
     * @param Content
     * @param Title
     * @param Image
     * @param Video
     * @throws SQLException
     * @throws Exception
     */
    public void insertPost(int ID_Account, int ID_Game, String Content, String Title, String Image, String Video) throws SQLException, Exception {
        try {
            //insert into sql          
            str = "INSERT INTO `posts`(`ID_Account`, `ID_Game`, `Content_Post`, `Title_Post`, `Image_Post`, `Video_Post`, `Status`) VALUES (?,?,?,?,?,?,1)";//query of sql serverl
            pst = con.prepareStatement(str, java.sql.Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, ID_Account);
            pst.setInt(2, ID_Game);
            pst.setString(3, Content);
            pst.setString(4, Title);
            pst.setString(5, Image);
            pst.setString(6, Video);
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            e.printStackTrace();//exception
        }
    }

    /**
     * upload post model
     *
     * @param ID_Post
     * @param ID_Account
     * @param ID_Game
     * @param Content
     * @param Title
     * @param Image
     * @param Video
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public boolean updatePost(int ID_Post, int ID_Account, int ID_Game, String Content, String Title, String Image, String Video) throws SQLException, Exception {
        boolean check = true;
        try {
            //insert into sql          
            str = "UPDATE `posts` SET `ID_Account`= ? ,`ID_Game`= ? ,`Content_Post`= ? ,`Title_Post`= ? ,`Image_Post`= ? ,`Video_Post` = ? WHERE `ID_Post`= ? ";//query of sql server
            pst = con.prepareStatement(str);
            pst.setInt(1, ID_Account);
            pst.setInt(2, ID_Game);
            pst.setString(3, Content);
            pst.setString(4, Title);
            pst.setString(5, Image);
            pst.setString(6, Video);
            pst.setInt(7, ID_Post);
            pst.executeUpdate();
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return check;
    }

    /**
     * delete post model
     *
     * @param ID_Post
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public boolean deletePost(int ID_Post) throws SQLException, Exception {
        boolean check = true;
        try {
            //insert into sql          
            str = "UPDATE `posts` SET `Status`= 0 WHERE `ID_Post`= ?";//query of sql server
            pst = con.prepareStatement(str);
            pst.setInt(1, ID_Post);
            pst.executeUpdate();
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return check;
    }

    /**
     * Get paging
     * @param page
     * @param search
     * @param sortColumn
     * @return 
     */
    public ArrayList<Posts> getPaging(int page, String search, String sortColumn) {
        try {
            String sqlStr = "";
            sqlStr += " SELECT * FROM `posts` WHERE `Status` = 1 ";

            if (search != "") {
                //thuc hien tim kiem
                sqlStr += " AND `Title_Post` LIKE '%" + search + "%' ";
            }

            if (sortColumn != "") {
                //thuc hien sap xep
            }
             sqlStr += " ORDER BY `ID_Post` DESC ";
            //phan trang
            int tongSoSanPham = getNumberOfProduct(page, search, sortColumn);
            int tongSoTrang = (int) Math.ceil(tongSoSanPham / (float) SoDong_Trang);
            System.out.println(tongSoSanPham);
            System.out.println(tongSoTrang);
            int index = (page - 1) * SoDong_Trang;

            sqlStr += " LIMIT " + index + ", " + SoDong_Trang;

            this.st = this.con.createStatement();
            this.rs = this.st.executeQuery(sqlStr);
            list = new ArrayList<Posts>();
            while (rs.next()) {
                int ID_Post = rs.getInt("ID_Post");
                int ID_Account = rs.getInt("ID_Account");
                int ID_Game = rs.getInt("ID_Game");
                String Content = rs.getString("Content_Post");
                String Title = rs.getString("Title_Post");
                String Image = rs.getString("Image_Post");
                String Video = rs.getString("Video_Post");
                int Status = rs.getInt("Status");
                if (Status != 0) {
                    list.add(new Posts(ID_Post, ID_Account, ID_Game, Content, Title, Image, Video, Status));//add data to array list
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(GameModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.list;
    }

    /**
     * Get paging string
     * @param currentPage
     * @param search
     * @param sortColumn
     * @return 
     */
    public String getPagingString(int currentPage, String search, String sortColumn) {
        String strPaging = "<ul class='pagination'>";
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
            strPaging += "</ul>";
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
        sqlStr += " FROM `posts`  Where `Status` = 1 ";
        if (search != "") {
            //thuc hien tim kiem
            sqlStr += " AND `Title_Post` LIKE '%" + search + "%'";
        }
        sqlStr += " ORDER BY `ID_Post` DESC ";
        this.st = this.con.createStatement();
        this.rs = this.st.executeQuery(sqlStr);
        rs.next();
        return rs.getInt("soLuong");
    }

    /**
     * Get name post by id
     * @param id
     * @return
     * @throws SQLException 
     */
    public String getNamePostByID(int id) throws SQLException {
        String Name = "";
        try {

            con = DBConnection.getConnection();
            st = con.createStatement();
            str = "SELECT * FROM `posts` where `ID_Post` = '" + id + "'";
            rs = st.executeQuery(str);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    Name = rs.getString("Title_Post");
                }
            }

        } catch (SQLException e) {
            throw new SQLException("Can't load games");
        }
        return Name;
    }

    /**
     * get paging string format css by 'end game'
     * @param currentPage
     * @param search
     * @param sortColumn
     * @return 
     */
    public String getPagingStringEndGame(int currentPage, String search, String sortColumn) {
        String strPaging = "<div class='site-pagination'>";
        try {
            int tongSoSanPham = getNumberOfProduct(currentPage, search, sortColumn);
            int tongSoTrang = (int) Math.ceil(tongSoSanPham / (float) SoDong_Trang);
            for (int stt_trang = 1; stt_trang <= tongSoTrang; stt_trang++) {
                if (stt_trang == currentPage) {
                    strPaging += "<a class='active' href='?page=" + stt_trang + "'>" + stt_trang + "</a>";
                } else {
                    strPaging += "<a href='?page=" + stt_trang + "'>" + stt_trang + "</a>";
                }
            }
            strPaging += "</div>";
        } catch (SQLException ex) {
            Logger.getLogger(GameModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strPaging;
    }

    /**
     * search post by id
     * @param Id
     * @return 
     */
    public ArrayList<Posts> searchPostByID(int Id) {
        String query = "SELECT * FROM `posts` WHERE `ID_Post`= " + Id;
        list = new ArrayList<Posts>();
        try {
            this.st = this.con.createStatement();
            rs = st.executeQuery(query);//execute query

            while (rs.next()) {
                int ID_Post = rs.getInt("ID_Post");
                int ID_Account = rs.getInt("ID_Account");
                int ID_Game = rs.getInt("ID_Game");
                String Content = rs.getString("Content_Post");
                String Title = rs.getString("Title_Post");
                String Image = rs.getString("Image_Post");
                String Video = rs.getString("Video_Post");
                int Status = rs.getInt("Status");
                list.add(new Posts(ID_Post, ID_Account, ID_Game, Content, Title, Image, Video, Status));

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
}
