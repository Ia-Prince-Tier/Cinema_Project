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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.ArrayBufferView.length;

/**
 * FXML Controller class
 *
 * @author laurentdavenne
 */
public class UpdateMoviePageController implements Initializable {


    
    @FXML
    private TextField TextField1;

    @FXML
    private TextField TextField2;

    @FXML
    private TextField TextField3;

    @FXML
    private TextField TextField4;
   
    @FXML
    private Button IncorrectLabel2;

    @FXML
    private Button IncorrectLabel1;
    
    @FXML
    private Button IncorrectLabel3;


    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    void hundleButtonAction1(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene1();
    }
    
    public boolean isStringInt(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }

    @FXML
    void hundleButtonAction2(ActionEvent event) throws IOException {

            IncorrectLabel1.setVisible(false);
            IncorrectLabel2.setVisible(false);
            IncorrectLabel3.setVisible(false);
            
            if(TextField1.getText().equals("") || TextField2.getText().equals("") || TextField3.getText().equals("") || TextField4.getText().equals("")){
 
                    IncorrectLabel3.setVisible(true);
                    
            }else{
                    
                if(isStringInt(TextField3.getText())==false){
                    IncorrectLabel2.setVisible(true);
                }else{
                    
                    try{
 
                                String url       = "jdbc:mysql://localhost:8889/cinema_project";
                                String User      = "root";
                                String Password  = "root";
                
                                Connection conn = DriverManager.getConnection(url, User, Password);

                                Statement stmt=conn.createStatement(); 
                    
                                int rs=stmt.executeUpdate("UPDATE movies SET ID='"+TextField1.getText()+"', Title='"+TextField2.getText()+"', Duration='"+TextField3.getText()+"', Genre='"+TextField4.getText()+"' where ID='"+TextField1.getText()+"' ");
                            
                                if(rs==0){
                                
                                IncorrectLabel1.setVisible(true);
                                
                                }else{
                                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                                loadScene2();
                                }
                               
                            
                            } catch(SQLException e) {
                            
                                System.out.println(e.getMessage());
                    
                        }
                             
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MovieSucessfullyUpdatedPage.fxml"));
        Parent root1 =(Parent) loader.load();
        MovieSucessfullyUpdatedPageController s3Controller = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("MovieSucessfullyUpdatedPage");
        stage.show();
        }
    
}
