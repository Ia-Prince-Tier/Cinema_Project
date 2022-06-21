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
    private ComboBox<?> Combo1;

    @FXML
    private ComboBox<?> Combo2;

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
    private Label Label7;
    
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
    
    
    @FXML
    void handleButtonAction1(ActionEvent event) {
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
                            System.out.println(rs3.getInt(1));
                            
                            }
                            
                        }else{
                            
                        ResultSet rs3=stmt.executeQuery("select Title, Duration, Genre, Synopsis from movies where ID='"+(rs2.getInt(1)+1)+"' ");
                        
                            if(rs3.next()){
                    
                            setTitle(rs3.getString(1));
                            setDuration("Duration : " + rs3.getString(2) + " min.");
                            setGenre("Genre : " + rs3.getString(3));
                            setSynopsis("Synopsis : " + rs3.getString(4));
                            System.out.println(rs3.getInt(1));
                
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
    
    /*ObservableList<String> Dateslist = new SortedList<String>();


       String url       = "jdbc:mysql://localhost:3306/cinema_project_1";
       String user      = "root";
       String password  = "root";


       public void SQLDate (){
           Connection conn = null;
        try {

                String url       = "jdbc:mysql://localhost:3306/cinema_projet_1";
                String user      = "root";
                String password  = "root";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);

                Statement stmt=conn.createStatement(); 
                ResultSet rs=stmt.executeQuery("select Date from screensession"); 
                while(rs.next()){
                System.out.println(rs.getString(1));
                DatesList.add(rs.getString(1)); 
                }

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
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //SQLDate();
       //Combo1.setItems(DatesList);
    
       //imageview1.setImage(new Image("image1.png"));
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
    
    
    
}
