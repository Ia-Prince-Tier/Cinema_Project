/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_project;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 *
 * @author laurentdavenne
 */
public class HomePageController implements Initializable {
    
    public String FirstTitle;
    
    public String getFirstTitle(){
        return FirstTitle;
    }
    
    @FXML
    private Button button;
    @FXML
    private RadioButton RadioB1;
    @FXML
    private RadioButton RadioB2;
    @FXML
    private RadioButton RadioB3;

    
 @FXML
 
private void handleButtonAction(ActionEvent event) throws IOException {
       
    if(RadioB1.isSelected())
    loadScene();
    else if (RadioB2.isSelected())
    loadScene2();
    else if(RadioB3.isSelected())
    loadScene3();
    else
    System.exit(0);
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        
}

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    private void loadScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerMoviesPage.fxml"));
        Parent root =(Parent) loader.load();
        CustomerMoviesPageController s3Controller = loader.getController(); 
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("CustomerMoviesPage");
        
        try {
 
                String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                String User      = "root";
                String Password  = "root";
                
                Connection conn = DriverManager.getConnection(url, User, Password);

                Statement stmt=conn.createStatement(); 
    
                ResultSet rs1=stmt.executeQuery("select Title, Duration, Genre, Synopsis from movies where ID=1");
                
                    while(rs1.next()) {
                        s3Controller.setTitle(rs1.getString(1));
                        FirstTitle=(rs1.getString(1));
                        s3Controller.setDuration("Duration : " + rs1.getString(2) + " min.");
                        s3Controller.setGenre("Genre : " + rs1.getString(3));
                        s3Controller.setSynopsis("Synopsis : " + rs1.getString(4));
                        s3Controller.DisplayImage();
                        s3Controller.SQLDate();  
                    }
                    
        } catch(SQLException e) {
           System.out.println(e.getMessage());
        } 
        stage.show();
    }
   
     private void loadScene2() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MemberRegisterPage.fxml"));
        Parent root =(Parent) loader.load(); 
        MemberRegisterPageController s3Controller = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("MemberRegisterPage");
        stage.show();
    }
    
     private void loadScene3() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeRegisterPage.fxml"));
        Parent root =(Parent) loader.load(); 
        EmployeeRegisterPageController s3Controller = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("EmployeeRegisterPage");
        stage.show();
    }

}







