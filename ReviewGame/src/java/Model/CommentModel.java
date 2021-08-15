package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import MyUtils.DBConnection;
import ObjecInfo.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommentModel {

    //declare variables
    public Connection con;
    public PreparedStatement pst;
    public ResultSet rs;
    static java.sql.Statement st;
    public ArrayList<Comment> cmt;
    public String str;
    public static int SoDong_Trang = 10;
    public ArrayList<Comment> list;

    /**
     * Constructor comment model
     */
    public CommentModel() {
        try {
            con = DBConnection.getConnection();
            st = con.createStatement();
            pst = null;
            rs = null;
            str = null;
            cmt = new ArrayList<>();
        } catch (SQLException ex) {
            Logger.getLogger(CommentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Load model comment
     *
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public ArrayList<Comment> loadModelComment() throws Exception, SQLException {
        try {
            //load data form sql and add it to arraylist
            cmt = new ArrayList<>();
            str = "SELECT `ID_Comment`, `ID_Post`, `ID_Account`, `Content_Comment`, `Date_Comment`, `Status` FROM `comment` WHERE 1";//query of sql server
            rs = st.executeQuery(str);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int ID_Cmt = rs.getInt("ID_Comment");
                    int ID_Post = rs.getInt("ID_Post");
                    int ID_Account = rs.getInt("ID_Account");
                    String Content = rs.getString("Content_Comment");
                    String Date_Cmt = rs.getString("Date_Comment");
                    int Status = rs.getInt("Status");
                    if (Status != 0) {
                        cmt.add(new Comment(ID_Cmt, ID_Account, ID_Post, Content, Date_Cmt, Status));//add data to array list 
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return cmt;
    }

    public ArrayList<Comment> loadCommentOrderByDateAndID(int idPost) throws Exception, SQLException {
        try {
            //load data form sql and add it to arraylist
            cmt = new ArrayList<>();
            str = "SELECT * FROM `comment` WHERE `ID_Post` = " + idPost + " ORDER BY `Date_Comment` DESC";//query of sql server
            rs = st.executeQuery(str);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int ID_Cmt = rs.getInt("ID_Comment");
                    int ID_Post = rs.getInt("ID_Post");
                    int ID_Account = rs.getInt("ID_Account");
                    String Content = rs.getString("Content_Comment");
                    String Date_Cmt = rs.getString("Date_Comment");
                    int Status = rs.getInt("Status");
                    if (Status != 0) {
                        cmt.add(new Comment(ID_Cmt, ID_Account, ID_Post, Content, Date_Cmt, Status));//add data to array list 
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return cmt;
    }

    /**
     * get paging
     * @param page
     * @param search
     * @param sortColumn
     * @return 
     */
    public ArrayList<Comment> getPaging(int page, String search, String sortColumn) {
        try {
            String sqlStr = "";
            sqlStr += " SELECT a.* , b.`ID_Post` FROM `comment` as a, `posts` as b ";
            sqlStr += " WHERE a.`ID_Post` = b.`ID_Post` AND a.`Status` = 1 ";
            if (search != "") {
                //thuc hien tim kiem
                sqlStr += " AND b.Title_Post  LIKE '%" + search + "%' ";
            }

            if (sortColumn != "") {
                //thuc hien sap xep
            }

            //phan trang
            int tongSoSanPham = getNumberOfProduct(page, search, sortColumn);
            int tongSoTrang = (int) Math.ceil(tongSoSanPham / (float) SoDong_Trang);
            System.out.println(tongSoSanPham);
            System.out.println(tongSoTrang);
            int index = (page - 1) * SoDong_Trang;

            sqlStr += " LIMIT " + index + ", " + SoDong_Trang;

            this.st = this.con.createStatement();
            this.rs = this.st.executeQuery(sqlStr);
            list = new ArrayList<Comment>();
            while (rs.next()) {
                int ID_Cmt = rs.getInt("ID_Comment");
                int ID_Post = rs.getInt("ID_Post");
                int ID_Account = rs.getInt("ID_Account");
                String Content = rs.getString("Content_Comment");
                String Date_Cmt = rs.getString("Date_Comment");
                int Status = rs.getInt("Status");
                if (Status == 1) {
                    list.add(new Comment(ID_Cmt, ID_Account, ID_Post, Content, Date_Cmt, Status));//add data to array list 
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.list;
    }

    /**
     * get number of product
     * @param page
     * @param search
     * @param sortColumn
     * @return
     * @throws SQLException 
     */
    public int getNumberOfProduct(int page, String search, String sortColumn) throws SQLException {
        String sqlStr = "";
        sqlStr += " SELECT count(*) as soLuong ";
        sqlStr += " FROM `comment` as a, `posts` as b ";
        sqlStr += " WHERE a.`ID_Post` = b.`ID_Post` ";
        sqlStr += " AND a.`Status` = 1 ";
        if (search != "") {
            //thuc hien tim kiem
            sqlStr += " AND b.Title_Post  LIKE '%" + search + "%' ";
        }
        this.st = this.con.createStatement();
        this.rs = this.st.executeQuery(sqlStr);
        rs.next();
        return rs.getInt("soLuong");
    }

    /**
     * get paging string
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
     * Insert comment model
     *
     * @param ID_Post
     * @param ID_Account
     * @param Content
     * @param Date_Comment
     * @throws SQLException
     * @throws Exception
     */
    public void insertComment(int ID_Post, int ID_Account, String Content) throws SQLException, Exception {
        try {
            //insert into sql          
            str = "INSERT INTO `comment`(`ID_Post`, `ID_Account`, `Content_Comment`, `Status`) VALUES (?,?,?,1)";//query of sql serverl
            pst = con.prepareStatement(str, java.sql.Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, ID_Post);
            pst.setInt(2, ID_Account);
            pst.setString(3, Content);
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            e.printStackTrace();//exception
        }
    }

    /**
     * update comment model
     *
     * @param ID_Comment
     * @param ID_Post
     * @param ID_Account
     * @param Content
     * @param Date_Comment
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public boolean updateComment(int ID_Comment, int ID_Post, int ID_Account, String Content, String Date_Comment) throws SQLException, Exception {
        boolean check = true;
        try {
            //insert into sql          
            str = "UPDATE `comment` SET `ID_Post`=? ,`ID_Account`= ? ,`Content_Comment`= ? ,`Date_Comment`= ? WHERE `ID_Comment`= ?";//query of sql server
            pst = con.prepareStatement(str);
            pst.setInt(1, ID_Post);
            pst.setInt(2, ID_Account);
            pst.setString(3, Content);
            pst.setString(4, Date_Comment);
            pst.setInt(5, ID_Comment);
            pst.executeUpdate();
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return check;
    }

    /**
     * delete comment model
     *
     * @param ID_Comment
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public boolean deleteComment(int ID_Comment) throws SQLException, Exception {
        boolean check = true;
        try {
            //insert into sql          
            str = "UPDATE `comment` SET `Status`= 0 WHERE `ID_Comment`= ?";//query of sql server
            pst = con.prepareStatement(str);
            pst.setInt(1, ID_Comment);
            pst.executeUpdate();
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return check;
    }

    /**
     * print word by number character
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
    public ArrayList<Comment> searchGameByID(int Id) {
        String query = "SELECT * FROM `comment` WHERE 	ID_Comment= " + Id;
        list = new ArrayList<Comment>();
        try {
            this.st = this.con.createStatement();
            rs = st.executeQuery(query);//execute query

            while (rs.next()) {
                int ID_Cmt = rs.getInt("ID_Comment");
                int ID_Post = rs.getInt("ID_Post");
                int ID_Account = rs.getInt("ID_Account");
                String Content = rs.getString("Content_Comment");
                String Date_Cmt = rs.getString("Date_Comment");
                int Status = rs.getInt("Status");

                list.add(new Comment(ID_Cmt, ID_Account, ID_Post, Content, Date_Cmt, Status));//add data to array list 

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
     * Accept comment 
     * @param ID_Comment
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean AcceptComment(int ID_Comment) throws SQLException, Exception {
        boolean check = true;
        try {
            //insert into sql          
            str = "UPDATE `comment` SET `Status`= 2 WHERE `ID_Comment`= ?";//query of sql server
            pst = con.prepareStatement(str);
            pst.setInt(1, ID_Comment);
            pst.executeUpdate();
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return check;
    }

}
