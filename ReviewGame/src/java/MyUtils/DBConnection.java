/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyUtils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection {
    static Connection con = null;
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/testreviewgame";
            String username = "root";
            String password = "";    
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = (Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            System.out.println("success");
            return con;
        }
    }
      public  static  void  main (String[] argn)
    {
      
        DBConnection con = new DBConnection();       
        System.out.println(con.getConnection());
       
        
    }
}
