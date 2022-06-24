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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author laurentdavenne
 */
public class CustomerMoviesPageController implements Initializable {

    public int x;
    @FXML
    public ComboBox<String> Combo1;

    @FXML
    private ComboBox<String> Combo2;

    @FXML
    private Label Label1;

    @FXML
    private Label Label2;

    @FXML
    private Label Label3;

    @FXML
    private Label Label5;

    @FXML
    private Label Label6;

    @FXML
    private Label IncorrectLabel1;
    
    @FXML
    private Label IncorrectLabel2;
    
    @FXML
    private Label IncorrectLabel3;
    
    @FXML
    private TextArea TextArea1;

    @FXML
    private TextField TextField1;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private ImageView imageview1;
    
    public String Title;
    
    
    public void setTitle(String nameTitle){
        Label1.setText(nameTitle);
    }
    
    public void setDuration(String duration){
        Label2.setText(duration);
    }
    
    public void setGenre(String genre){
        Label3.setText(genre);
    }
    
    public void setSynopsis(String synopsis){
        TextArea1.setText(synopsis);
    }
    
       public void setMemberName(String memberEmployee){
        Label5.setText(memberEmployee);
    }
    
    //HomePageController homePage = new HomePageController();
    
    //Image myimage = new Image(getClass().getResourceAsStream(".png"));
    /*
    public void DisplayImage(){
     imageview1.setImage(myimage);   
    }
*/
    
    public void getFirstTitle1() {
           try {
 
                String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                String User      = "root";
                String Password  = "root";
                
                Connection conn = DriverManager.getConnection(url, User, Password);

                Statement stmt=conn.createStatement(); 
    
                ResultSet rs1=stmt.executeQuery("select Title from movies where ID=1");
                
                    while(rs1.next()) {
                        
                        Title=(rs1.getString(1));
                        Image myimage = new Image(getClass().getResourceAsStream(Title+".png"));
                        imageview1.setImage(myimage);
                    }
                    
        } catch(SQLException e) {
           System.out.println(e.getMessage());
        } 
        
        
    }
    
    
    public boolean isStringInt(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }

    public ObservableList<String> SQLDate (){
 
       ObservableList<String> Dateslist2 = FXCollections.observableArrayList();  
       
           Connection conn = null;
           
        try {

            String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
            String user      = "root";
            String password  = "root";

            conn = DriverManager.getConnection(url, user, password);

            Statement stmt=conn.createStatement();
    
            ResultSet rs1=stmt.executeQuery("SELECT Date, Time from screensession where IDmovie=1 "); 
                
            while(rs1.next()){
                
                Dateslist2.add(rs1.getString(1) + " at " + rs1.getString(2)); 
                
            }
                     
            Combo1.setItems(Dateslist2);
                
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

        return Dateslist2;
    }
    
     public ObservableList<String> SQLDate2 (){
 
       ObservableList<String> Dateslist3 = FXCollections.observableArrayList();  
       
           Connection conn = null;
           
        try {

            String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
            String user      = "root";
            String password  = "root";

            conn = DriverManager.getConnection(url, user, password);

            Statement stmt=conn.createStatement();

            ResultSet rs0=stmt.executeQuery("SELECT ID from movies where Title='"+Label1.getText()+"' "); 
                    
                if(rs0.next()){
                    
                    ResultSet rs1=stmt.executeQuery("SELECT Date, Time from screensession where IDmovie='"+rs0.getInt(1)+"'"); 
                    
                    while(rs1.next()){
                        
                        Dateslist3.add(rs1.getString(1) + " at " + rs1.getString(2)); 
                    }
                }
                    
            Combo1.setItems(Dateslist3);
                          
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

        return Dateslist3;
    }
    
    @FXML
    void handleButtonAction1(ActionEvent event) throws IOException {
        
       IncorrectLabel1.setVisible(false);
       IncorrectLabel2.setVisible(false);
       IncorrectLabel3.setVisible(false);
        
       try{
            String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
            String User      = "root";
            String Password  = "root";
                
            Connection conn = DriverManager.getConnection(url, User, Password);

            Statement stmt=conn.createStatement(); 
   
            if(TextField1.getText().equals("")){
                IncorrectLabel1.setVisible(true);
                
            }else{
                    
                if(isStringInt(TextField1.getText())==false ){
                    IncorrectLabel2.setVisible(true);   
              
                }else{
                    
                    ResultSet rs1=stmt.executeQuery("SELECT ID from movies where Title='"+Label1.getText()+"' ");
                    
                    System.out.println(Label1.getText());
                     
                    if(rs1.next()){
                        
                    System.out.println(rs1.getInt(1));
                    System.out.println(Combo1.getValue().substring(0, 10));
                    System.out.println(Combo1.getValue().substring(14, 22));
                    int z = rs1.getInt(1);
                    
                    ResultSet rs2=stmt.executeQuery("SELECT IDscreen from screensession where IDmovie='"+rs1.getInt(1)+"' and Date='"+Combo1.getValue().substring(0, 10)+"' and Time='"+Combo1.getValue().substring(14, 22)+"' ");
                   
                        if(rs2.next()){
                            
                        System.out.println(rs2.getInt(1));
                        int y = rs2.getInt(1);
                          
                        ResultSet rs3=stmt.executeQuery("SELECT Seats_already_booked from screensession where IDmovie='"+z+"' and Date='"+Combo1.getValue().substring(0, 10)+"' and Time='"+Combo1.getValue().substring(14, 22)+"' ");
                     
                            if(rs3.next()){
                            
                            System.out.println(rs3.getInt(1));
                            int x = rs3.getInt(1);    
                          
                            ResultSet rs4=stmt.executeQuery("SELECT Seats from screen where ID ='"+y+"' ");
                            
                                if(rs4.next()){
                                    
                                System.out.println(rs4.getInt(1));
                                
                                String text = TextField1.getText();
                                int t = Integer.parseInt(text);
                                System.out.println(t);
                                
                                    if(rs4.getInt(1)>=t+x){
                                    
                                    System.out.println("requete4 validée");
                                    
                                    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                                    loadScene2();
                                    
                                    }else{
                                    IncorrectLabel3.setVisible(true); 
                                    }
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


    @FXML
    void hundleButtonAction2(ActionEvent event) {
        int x;    

            try {
 
                String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                String User      = "root";
                String Password  = "root";
                
                Connection conn = DriverManager.getConnection(url, User, Password);

                Statement stmt=conn.createStatement(); 
                
                ResultSet rs1=stmt.executeQuery("SELECT count(*) from movies");
                
                if(rs1.next()){
                
                    x=rs1.getInt(1);
                    ResultSet rs2=stmt.executeQuery("SELECT ID from movies where Title='"+Label1.getText()+"' ");

                    if(rs2.next()){ 

                        if(rs2.getInt(1)==x){
                    
                        ResultSet rs3=stmt.executeQuery("select Title, Duration, Genre, Synopsis from movies where ID=1 ");
                        
                            if(rs3.next()){

                            setTitle(rs3.getString(1));
                            setDuration("Duration : " + rs3.getString(2) + " min.");
                            setGenre("Genre : " + rs3.getString(3));
                            setSynopsis("Synopsis : " + rs3.getString(4));
                            SQLDate();
                            Image myimage = new Image(getClass().getResourceAsStream(rs3.getString(1)+".png"));
                            imageview1.setImage(myimage);
                            }

                            
                        }else{
                            
                        ResultSet rs3=stmt.executeQuery("select Title, Duration, Genre, Synopsis from movies where ID='"+(rs2.getInt(1)+1)+"' ");
                        
                            if(rs3.next()){
                    
                            setTitle(rs3.getString(1));
                            setDuration("Duration : " + rs3.getString(2) + " min.");
                            setGenre("Genre : " + rs3.getString(3));
                            setSynopsis("Synopsis : " + rs3.getString(4));
                            SQLDate2();
                            Image myimage = new Image(getClass().getResourceAsStream(rs3.getString(1)+".png"));
                            imageview1.setImage(myimage);
                            }    
                        }
                    }
                }
      
            } catch(SQLException e) {
                System.out.println(e.getMessage());
            } 
    }

    
    @FXML
    void hundleButtonAction3(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene1();
    }   
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   

    private void loadScene1() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
    Parent root1 =(Parent) loader.load();
    HomePageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("HomePage");
    stage.show();
    }
    
    private void loadScene2() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("BookingPage.fxml"));
    Parent root1 =(Parent) loader.load();
    BookingPageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("BookingPage");
    stage.show();
    s3Controller.setTitleBooking(Label1.getText());
    s3Controller.setDurationBooking(Label2.getText());
    s3Controller.setGenreBooking(Label3.getText());
    s3Controller.setSreenSessionBooking(Combo1.getValue());
    s3Controller.setNumberOfTicketsBooking(TextField1.getText());
    
    }
    
    
    
}
