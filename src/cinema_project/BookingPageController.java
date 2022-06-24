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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author laurentdavenne
 */
public class BookingPageController implements Initializable {

    
    @FXML
    private Label Label1;

    @FXML
    private Label Label2;

    @FXML
    private Label Label3;

    @FXML
    private Label Label4;

    @FXML
    private Label Label5;
    
    
    public void setTitleBooking(String nameTitle){
        Label1.setText(nameTitle);
    }
    
    public void setDurationBooking(String duration){
        Label2.setText(duration);
    }
    
    public void setGenreBooking(String genre){
        Label3.setText(genre);
    }
    
    public void setSreenSesssionBooking(String screensession){
        Label4.setText(screensession);
    }
    
    public void setPriceBooking(String price){
        Label4.setText(price);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    void hundleButtonAction1(ActionEvent event) {
        
        /* try{
                
            String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
            String User      = "root";
            String Password  = "root";
                
            Connection conn = DriverManager.getConnection(url, User, Password);

            Statement stmt=conn.createStatement(); 
   
            ResultSet rs1=stmt.executeQuery("SELECT ID from movies where Title='"+Label1.getText()+"' ");
                     
                    if(rs1.next()){
                        
                     System.out.println(rs1.getInt(1));
                     
                     ResultSet rs2=stmt.executeQuery("SELECT Seats already booked from screensession where IDmovie='"+rs1.getInt(1)+"' AND Date='"+Label4.getText().substring(0, 10)+"' AND Time='"+Label4.getText().substring(14, 19)+"' ");
                     
                        if(rs2.next()){
                            
                          System.out.println(rs2.getInt(1));
                          int y = rs2.getInt(1);
                          
                          ResultSet rs3=stmt.executeQuery("SELECT IDscreen from screensession where IDmovie='"+rs1.getInt(1)+"' AND Date='"+Label4.getText().substring(0, 10)+"' AND Time='"+Label4.getText().substring(14, 19)+"' ");
                          
                          if(rs3.next()){
                              
                          System.out.println(rs3.getInt(1));
                          int x = rs3.getInt(1);
                          
                          ResultSet rs3=stmt.executeQuery("SELECT Seats from screen where ID ='"+rs2.getInt(1)+"' ");
                            
                            if(rs3.next()){
                                
                                System.out.println(rs3.getInt(1));
                                String text = TextField1.getText();
                                int x = Integer.parseInt(text);
                                System.out.println(x);
                                
                                if(rs3.getInt(1)>=x){
                                    
                                    int avalaibleseats=rs3.getInt(1)-x;
                                    int rs4=stmt.executeUpdate("UPDATE screen SET Seats='"+avalaibleseats+"' where ID ='"+y+"' ");
                                    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                                    loadScene2();
                                }else{
                                   IncorrectLabel1.setVisible(true); 
                                }
                            }
                        }
                    }
                }       
                
                        
            
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());          
        } */

    }

    @FXML
    void hundleButtonAction2(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene1();
    }
    
    private void loadScene1() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
    Parent root1 =(Parent) loader.load();
    HomePageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("HomeMoviesPage");
    stage.show();
    }
    
    
}
