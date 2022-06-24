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
    
    @FXML
    private Label Label6;
    
    
    public void setTitleBooking(String nameTitle){
        Label1.setText(nameTitle);
    }
    
    public void setDurationBooking(String duration){
        Label2.setText(duration);
    }
    
    public void setGenreBooking(String genre){
        Label3.setText(genre);
    }
    
    public void setSreenSessionBooking(String screensession){
        Label4.setText(screensession);
    }
    
    public void setNumberOfTicketsBooking(String price){
        Label5.setText(price);
    }
    
    public void setPriceBooking(String price){
        Label6.setText(price);
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    void hundleButtonAction1(ActionEvent event) throws IOException {
        
        try{
                
            String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
            String User      = "root";
            String Password  = "root";
                
            Connection conn = DriverManager.getConnection(url, User, Password);

            Statement stmt=conn.createStatement(); 
   
            ResultSet rs1=stmt.executeQuery("SELECT ID from movies where Title='"+Label1.getText()+"' ");
                     
                if(rs1.next()){
                        
                    System.out.println(rs1.getInt(1));
                    System.out.println(Label4.getText().substring(0, 10));
                    System.out.println(Label4.getText().substring(14, 22));
                    int z = rs1.getInt(1);
                    
                    ResultSet rs2=stmt.executeQuery("SELECT IDscreen from screensession where IDmovie='"+rs1.getInt(1)+"' and Date='"+Label4.getText().substring(0, 10)+"' and Time='"+Label4.getText().substring(14, 22)+"' ");
                   
                        if(rs2.next()){
                            
                        System.out.println(rs2.getInt(1));
                        int y = rs2.getInt(1);
                          
                        ResultSet rs3=stmt.executeQuery("SELECT Seats_already_booked from screensession where IDmovie='"+z+"' and Date='"+Label4.getText().substring(0, 10)+"' and Time='"+Label4.getText().substring(14, 22)+"' ");
                     
                            if(rs3.next()){
                            
                            System.out.println(rs3.getInt(1));
                            int x = rs3.getInt(1);    
                          
                            ResultSet rs4=stmt.executeQuery("SELECT Seats from screen where ID ='"+y+"' ");
                            
                                if(rs4.next()){
                                    
                                System.out.println(rs4.getInt(1));
                                
                                String text = Label5.getText();
                                int t = Integer.parseInt(text);
                                System.out.println(t);
                                
                                int seats_already_booked =x+t;
                                int rs5=stmt.executeUpdate("UPDATE screensession SET Seats_already_booked='"+seats_already_booked+"' where IDscreen ='"+y+"' and IDmovie = '"+z+"' ");
                                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                                loadScene2();  
                                }
                            }
                        }
                    }
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());          
        } 



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
    
    private void loadScene2() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Payment.fxml"));
    Parent root1 =(Parent) loader.load();
    PaymentController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("PaymentPage");
    stage.show();
    }
    
    
}
