/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_project;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
/**
 * FXML Controller class
 *
 * @author tad-t
 */
public class MoviesController implements Initializable {

    
    @FXML
    private AnchorPane AnchorPane1;

    @FXML
    private AnchorPane AnchorPane2;

    @FXML
    private ImageView Imageview1;

    @FXML
    private MenuButton MenuButton1;

    @FXML
    private MenuButton MenuButton2;
    
        @FXML
    private ComboBox<?> Combo1;

    @FXML
    private ComboBox<?> Combo2;

  ObservableList DatesList = FXCollections.observableArrayList();
  
       String url       = "jdbc:mysql://localhost:3306/cinema_project";
       String user      = "root";
       String password  = "root";
       
       
       public void SQLDate (){
           Connection conn = null;
        try {
                // db parameters - ptest is the name of the database
                String url       = "jdbc:mysql://localhost:3306/cinema_projet";
                String user      = "root";
                String password  = "root";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);
                // more processing here
                // ...   
                Statement stmt=conn.createStatement(); 
                ResultSet rs=stmt.executeQuery("select Date from screensession"); 
                while(rs.next()) 
                DatesList.add(rs.getString(1)); 

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
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
