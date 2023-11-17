/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hadac
 */
public class DatabaseHelper {
  public static String connectionUrl = "jdbc:sqlserver://localhost;databaseName=PRO1041;user=sa;password=hhaauu2714;encrypt=false";
    public static Connection getDBConnect(){
        Connection conn = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(Exception e){
            System.out.println("Chua co driver"+e.toString());
        }
        try{
            conn = DriverManager.getConnection(connectionUrl);
            return conn;
        }catch(Exception e){
            System.out.println("Loi connect" +e.toString());
        }
        return null;
    }
}
