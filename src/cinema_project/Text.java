package cinema_project;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author tad-t
 */
public class Text {
    
                String url       = "jdbc:mysql://localhost:3306/cinema_project_1";
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

public ArrayList<String> SQLshowtimes() {
        Connection conn = null;
        ArrayList<String> Times = new ArrayList<String>();
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);

            // method code
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("select Time from screensession"); 
            while(rs.next()){
                Times.add(rs.getString(1));
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
System.out.println(Times);
return Times;
}
  

 public static void main(String[] args) {
         Text a = new Text();
         a.SQLshowdates();
    }
 
}
 
