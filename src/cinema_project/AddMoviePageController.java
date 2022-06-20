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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddMoviePageController implements Initializable {

    @FXML
    private TextField TextField1;

    @FXML
    private TextField TextField2;

    @FXML
    private TextField TextField3;

    @FXML
    private TextField TextField4;

    @FXML
    private Button button1;

    @FXML
    private Button button2;
    
    @FXML
    private Label IncorrectLabel1;

    @FXML
    private Label IncorrectLabel2;

    @FXML
    private Label IncorrectLabel3;
    
    public boolean isStringInt(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
    
    @FXML
    void hundleButtonAction1(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene1();
    }

    @FXML
    void hundleButtonAction2(ActionEvent event) throws IOException {
        
            if(TextField2.getText().equals("") || TextField4.getText().equals("")){
                
                IncorrectLabel3.setVisible(true);
            }else{
                
                try{
 
                String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                String User      = "root";
                String Password  = "root";
                
                Connection conn = DriverManager.getConnection(url, User, Password);

                Statement stmt=conn.createStatement(); 
   
                int rs=stmt.executeUpdate("INSERT INTO movies (ID, Title, Duration, Genre) VALUES ('"+TextField1.getText()+"', '"+TextField2.getText()+"', '"+TextField3.getText()+"', '"+TextField4.getText()+"')");;
                            
                    if(rs==0){
                                
                    IncorrectLabel1.setVisible(true);
                    IncorrectLabel2.setVisible(true);
                                
                    }else{
                    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                    loadScene2();
                    }
                    
              
                } catch(SQLException e) {
                    System.out.println(e.getMessage());
                    IncorrectLabel1.setVisible(true);
                    IncorrectLabel2.setVisible(true);
                    
                } 

            }           
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void loadScene1() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeMoviesPage.fxml"));
    Parent root1 =(Parent) loader.load();
    EmployeeMoviesPageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("EmployeeMoviesPage");
    stage.show();
    }
    
    private void loadScene2() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("MovieSucessfullyAddedPage.fxml"));
    Parent root1 =(Parent) loader.load();
    MovieSucessfullyAddedPageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("MovieSucessfullyAddedPage");
    stage.show();
    }
    
    
    
}
