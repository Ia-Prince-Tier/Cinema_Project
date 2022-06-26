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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    
    @FXML
    private Label IncorrectLabel1;
    
    @FXML
    private TextField TextField1;

    @FXML
    private TextField TextField2;

    @FXML
    private TextField TextField3;
    
    @FXML
    private ImageView imageview1;
    
    @FXML
    private ComboBox<String> Combo1;

    @FXML
    private ComboBox<String> Combo2;
    
    @FXML
    private Label membernamelabel;
    
      @FXML
    private Label membernamelabelmain;
    
    
    
    
    public void setImage(String Title){
    Image myimage = new Image(getClass().getResourceAsStream(Title+".png"));
    imageview1.setImage(myimage);
    }
    
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
    
    public void setMemberBooking(String membername){
        membernamelabel.setText(membername);
    }
    
    public void setMembernameinvisible(String membername){
       membernamelabelmain.setVisible(true); 
       membernamelabel.setVisible(true);
    }
    
    
    public ObservableList<String> SQLMonth (){
        
        ObservableList<String> Dateslist = FXCollections.observableArrayList();
      
            for(int i=1; i<=12; i++){
                 
            String str_x2 = String.valueOf(i);
            
                if(i<10){
                Dateslist.add("0" + str_x2); 
                }else{
                Dateslist.add(str_x2);   
                }
            }
           
        Combo1.setItems(Dateslist);
        
        return Dateslist;
        
    }
    
    
    public ObservableList<String> SQLYear (){
        
        ObservableList<String> Dateslist2 = FXCollections.observableArrayList();
        
             
        for(int i=2022; i<=2035; i++){
                 
            String str_x2 = String.valueOf(i);
                 
            Dateslist2.add(str_x2);
            
        }
            
        Combo2.setItems(Dateslist2);
        
        return Dateslist2;
            
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SQLYear();
        SQLMonth();
    }  
    
    @FXML
    void hundleButtonAction1(ActionEvent event) throws IOException {
        
        IncorrectLabel1.setVisible(false);
        
        if(Combo1.getValue() == null || Combo2.getValue() == null || TextField1.getText().equals("") || TextField2.getText().equals("") || TextField3.getText().equals("")){
            
            IncorrectLabel1.setVisible(true);
        
        }else{
            
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
                                
                                    if(membernamelabel.getText() != "Label" ){
                                    
                                    ResultSet rs6=stmt.executeQuery("SELECT ID from member where USER ='"+membernamelabel.getText()+"'");
                                    
                                        if(rs6.next()){
                                        stmt.executeUpdate("INSERT INTO Historique (Title,Screensession,Ticketnumber,IDmember) VALUES ('"+Label1.getText()+"','"+Label4.getText()+"','"+Label5.getText()+"','"+rs6.getString(1)+"')");
                                        }
                                    }  
                                }
                            }
                        }
                    }
            
            } catch(SQLException e) {
            System.out.println(e.getMessage());          
            } 

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
