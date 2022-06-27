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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author laurentdavenne
 */
public class DeleteMovieSessionPageController implements Initializable {

    @FXML
    private ComboBox<String> Combo1;

    @FXML
    private TextField TextField1;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;
    
    @FXML
    private Label IncorrectLabel1;
    
    @FXML
    private Label IncorrectLabel2;
    
    
    public ObservableList<String> SQLDate (){
 
       ObservableList<String> Dateslist3 = FXCollections.observableArrayList();  
       
           Connection conn = null;
           
        try {

            String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
            String user      = "root";
            String password  = "root";

            conn = DriverManager.getConnection(url, user, password);

            Statement stmt=conn.createStatement();

            ResultSet rs0=stmt.executeQuery("SELECT ID from movies where Title='"+TextField1.getText()+"' "); 
                    
                if(rs0.next()){
                    
                    ResultSet rs1=stmt.executeQuery("SELECT Date, Time, IDscreen from screensession where IDmovie='"+rs0.getInt(1)+"'"); 
                    
                    while(rs1.next()){
                        
                        Dateslist3.add(rs1.getString(1) + " at " + rs1.getString(2) + " in the cinema room number " + rs1.getString(3)); 
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
    void handleButtonAction3(ActionEvent event) throws IOException {
    
        Combo1.setVisible(false);
        button1.setVisible(false);
        IncorrectLabel1.setVisible(false);
        
        try {
 
                String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                String User      = "root";
                String Password  = "root";
                
                Connection conn = DriverManager.getConnection(url, User, Password);

                Statement stmt=conn.createStatement(); 
    
                ResultSet rs=stmt.executeQuery("select * from movies Where Title='"+TextField1.getText()+"'");
                
                    if (rs.next()){
                    
                    Combo1.setVisible(true);
                    button1.setVisible(true);
                    SQLDate();
                        
                    }else{
                    IncorrectLabel1.setVisible(true);
                    }

                } catch(SQLException e) {
                 System.out.println(e.getMessage());
                } 
        
    }
    
    @FXML
    void handleButtonAction1(ActionEvent event) throws IOException {
    
        IncorrectLabel2.setVisible(false);
        
        if(Combo1.getValue() == null){
            
           IncorrectLabel2.setVisible(true);
           
        }else{
                try {
 
                String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                String User      = "root";
                String Password  = "root";
                
                Connection conn = DriverManager.getConnection(url, User, Password);

                Statement stmt=conn.createStatement(); 
                
                ResultSet rs1=stmt.executeQuery("SELECT ID from movies where Title='"+TextField1.getText()+"'");
                
                    if(rs1.next()){
                        
                        System.out.println(Combo1.getValue().substring(0, 10));
                        System.out.println(Combo1.getValue().substring(14, 22));
                        System.out.println(Combo1.getValue().substring(49));
                        System.out.println(Combo1.getValue().substring(0, 9));
                        System.out.println(Combo1.getValue().substring(15, 21));
                        System.out.println(Combo1.getValue().substring(49));
 
                        int rs2=stmt.executeUpdate("delete from screensession Where Date='"+Combo1.getValue().substring(0, 10)+"' and Time='"+Combo1.getValue().substring(14, 22)+"' and IDmovie ='"+rs1.getInt(1)+"' and Idscreen ='"+Combo1.getValue().substring(49)+"' "); 
                        
                        stmt.executeUpdate("SET @autoid := 0");
                        stmt.executeUpdate("UPDATE screensession SET ID = @autoid := (@autoid+1)");
                        stmt.executeUpdate("ALTER TABLE screensession AUTO_INCREMENT = 1");
                        
                        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                        loadScene();
                        
                    }else{ 
                        
                        Combo1.setVisible(false);
                        button1.setVisible(false);
                        IncorrectLabel1.setVisible(false);
                    }       

                } catch(SQLException e) {
                 System.out.println(e.getMessage());
                } 
        }
    }
    
    @FXML
    void handleButtonAction2(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene2();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void loadScene2() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeMoviesPage.fxml"));
    Parent root1 =(Parent) loader.load();
    EmployeeMoviesPageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("EmployeeMoviesPage");
    stage.show();
    }  
    
    private void loadScene() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("MovieSessionSucessfullyDeletedPage.fxml"));
    Parent root1 =(Parent) loader.load();
    MovieSessionSucessfullyDeletedPageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("MovieSessionSucessfullyDeletedPage");
    stage.show();
    }
    
}
