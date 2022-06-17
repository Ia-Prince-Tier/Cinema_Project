/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_project;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author tad-t
 */
public class SQLQueries {
    
                String url       = "jdbc:mysql://localhost:3306/cinema_project";
                String user      = "root";
                String password  = "root";
                
                
public ArrayList<String> SQLshowdates() {
        Connection conn = null;
        ArrayList<String> Dates = new ArrayList<String>();
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);

            // method code
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("select Date from screensession"); 
            while(rs.next()){
                Dates.add(rs.getString(1));
            } 
            // System.out.println("");

            ///////// end of code of the method
        } catch (SQLException e) { 
            System.out.println(e.getMessage());
        } finally { 
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
System.out.println(Dates);
return Dates;
}
  

 public static void main(String[] args) {
         SQLQueries a = new SQLQueries();
         a.SQLshowdates();
    }
 
}




