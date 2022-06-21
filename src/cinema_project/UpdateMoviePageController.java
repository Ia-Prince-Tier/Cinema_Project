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
import static jdk.nashorn.internal.objects.ArrayBufferView.length;

/**
 * FXML Controller class
 *
 * @author laurentdavenne
 */
public class UpdateMoviePageController implements Initializable {


    
 @FXML
    private Label IncorrectLabel1;

    @FXML
    private Label IncorrectLabel2;

    @FXML
    private Label IncorrectLabel3;

    @FXML
    private Label Label1;

    @FXML
    private Label Label2;

    @FXML
    private Label Label3;

    @FXML
    private Label Label4;

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
    private Button button3;

    
    public boolean isStringInt(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }

    
    @FXML
    void hundleButtonAction1(ActionEvent event) {
        
        IncorrectLabel1.setVisible(false);
        
        try {
 
                String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                String User      = "root";
                String Password  = "root";
                
                Connection conn = DriverManager.getConnection(url, User, Password);

                Statement stmt=conn.createStatement(); 
    
                ResultSet rs=stmt.executeQuery("select * from movies Where Title='"+TextField1.getText()+"'");
                
                    if (rs.next()){
                    
                    Label1.setVisible(true);
                    Label2.setVisible(true);
                    Label3.setVisible(true);
                    Label4.setVisible(true);
                    TextField2.setVisible(true);
                    TextField3.setVisible(true);
                    TextField4.setVisible(true);
                    button2.setVisible(true);
                    button3.setVisible(true);
                    
                    }else{
                    IncorrectLabel1.setVisible(true);
                    }

                } catch(SQLException e) {
                 System.out.println(e.getMessage());
                } 
    }

    @FXML
    void hundleButtonAction2(ActionEvent event) throws IOException {

            IncorrectLabel2.setVisible(false);
            IncorrectLabel3.setVisible(false);
            
            if(TextField2.getText().equals("") || TextField3.getText().equals("") || TextField4.getText().equals("")){
 
                    IncorrectLabel3.setVisible(true);
                    
            }else{
                    
                if(isStringInt(TextField3.getText())==false){
                    IncorrectLabel2.setVisible(true);
                }else{
                    
                    try{
 
                                String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                                String User      = "root";
                                String Password  = "root";
                
                                Connection conn = DriverManager.getConnection(url, User, Password);

                                Statement stmt=conn.createStatement(); 
                    
                                int rs=stmt.executeUpdate("UPDATE movies SET Title='"+TextField2.getText()+"', Duration='"+TextField3.getText()+"', Genre='"+TextField4.getText()+"' where Title='"+TextField1.getText()+"' ");
                            
                                if(rs==0){
                                
                                IncorrectLabel1.setVisible(true);
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

    @FXML
    void hundleButtonAction3(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene1();
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
