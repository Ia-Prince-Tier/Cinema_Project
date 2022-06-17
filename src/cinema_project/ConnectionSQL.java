/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_project;
import java.sql.*;

/**
 *
 * @author tad-t
 */

/*
Une classe avec des getter et des setter pour chaque classe lié a une table ==> C'est le modelle qui sert a tranfere un object avec toute ses composantes ( customer c1 avec nom prenom etc)
==> Utiliser pour transferer les donnees
Appel des methodes avec les requetes SQL dans les controller de chaque panel




*/
public class ConnectionSQL {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = null;
        try {
                // db parameters - ptest is the name of the database
                String url       = "jdbc:mysql://localhost:3306/cinema_croject";
                String user      = "root";
                String password  = "root";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);
                // more processing here
                // ...   
                Statement stmt=conn.createStatement(); 
                ResultSet rs=stmt.executeQuery("select * from test_table"); 
                while(rs.next()) 
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)); 

            } catch(SQLException e) {
                 System.out.println(e.getMessage());
            } finally {
                 try{
                         if(conn != null)
                         conn.close();
                     }catch(SQLException ex){
                            System.out.println(ex.getMessage());
                    }
        }       
    } 
}