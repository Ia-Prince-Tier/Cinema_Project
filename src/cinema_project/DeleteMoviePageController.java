/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_project;

import com.mysql.cj.protocol.Resultset;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author laurentdavenne
 */
public class DeleteMoviePageController implements Initializable {

    
    @FXML
    private Button button1;
    
    @FXML
    private Button button2;
   
    @FXML
    private TextField movieTextField;
    
    @FXML
    private Label movieText;

    @FXML
    private Label noMovieText;

    @FXML
    void handleButtonAction1(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene();
    }
    
    @FXML
    void hundleButtonAction2(ActionEvent event) throws IOException, SQLException{
        
        int lastid;
        
                try {
 
                String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                String User      = "root";
                String Password  = "root";
                
                Connection conn = DriverManager.getConnection(url, User, Password);

                Statement stmt=conn.createStatement(); 
    
                int rs=stmt.executeUpdate("delete from movies Where Title='"+movieTextField.getText()+"'");
                
                stmt.executeUpdate("SET @autoid := 0");
                stmt.executeUpdate("UPDATE movies SET ID = @autoid := (@autoid+1)");
                stmt.executeUpdate("ALTER TABLE movies AUTO_INCREMENT = 1");
                    
                    if (rs==0){
                    noMovieText.setVisible(true);
                    }else{
                        
    
                    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                    loadScene2();  
                        }       
                            

                } catch(SQLException e) {
                 System.out.println(e.getMessage());
                } 
 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    private void loadScene() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeMoviesPage.fxml"));
    Parent root1 =(Parent) loader.load();
    EmployeeMoviesPageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("EmployeeMoviesPage");
    stage.show();
    }
     
    private void loadScene2() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("MovieSucessfullyDeletedPage.fxml"));
    Parent root1 =(Parent) loader.load();
    MovieSucessfullyDeletedPageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("MovieSucessfullyDeletedPage");
    stage.show();
    }
    
    
}
