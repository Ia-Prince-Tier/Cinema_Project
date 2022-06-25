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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author laurentdavenne
 */
public class AddMovieSessionPageController implements Initializable {
    
    @FXML
    public ComboBox<String> Combo1;

    @FXML
    private ComboBox<String> Combo2;

    @FXML
    private DatePicker DatePicker;

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
    private RadioButton RadioButton1;

    @FXML
    private RadioButton RadioButton2;

    @FXML
    private RadioButton RadioButton3;

    @FXML
    private TextField TextField1;

    @FXML
    private TextField TextField2;

    @FXML
    private TextField TextField3;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;
    
    public ObservableList<String> SQLDateAdd (){
 
    ObservableList<String> Dateslist = FXCollections.observableArrayList(); 
   
        for(int n=0; n<=23; n++){
                 
            String str_x = String.valueOf(n);
                    
                if(n<10){
                Dateslist.add("0" + str_x); 
                }else{
                Dateslist.add(str_x);   
                }
        }
        
    Combo1.setItems(Dateslist);
                         
    return Dateslist;
 
    }
    
    public ObservableList<String> SQLDateAdd2 (){
        
        ObservableList<String> Dateslist2 = FXCollections.observableArrayList();
        
            for(int i=0; i<=59; i++){
                 
            String str_x2 = String.valueOf(i);
                    
                if(i<10){
                Dateslist2.add("0" + str_x2); 
                }else{
                Dateslist2.add(str_x2);   
                }
            }
            
        Combo2.setItems(Dateslist2);
        
        return Dateslist2;
    }
    
    @FXML
    void hundleButtonAction1(ActionEvent event) {
        
        DatePicker.setVisible(false);
        IncorrectLabel1.setVisible(false);
        IncorrectLabel2.setVisible(false);
        IncorrectLabel3.setVisible(false);
        Label1.setVisible(false);
        Label2.setVisible(false);
        Label3.setVisible(false);
        Label4.setVisible(false);
        RadioButton1.setVisible(false);
        RadioButton2.setVisible(false);
        RadioButton3.setVisible(false);
        button2.setVisible(false);
        Combo1.setVisible(false);
        Combo2.setVisible(false);
        
        try {
 
                String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                String User      = "root";
                String Password  = "root";
                
                Connection conn = DriverManager.getConnection(url, User, Password);

                Statement stmt=conn.createStatement(); 
    
                ResultSet rs=stmt.executeQuery("select * from movies Where Title='"+TextField1.getText()+"'");
                
                    if (rs.next()){
                    
                        DatePicker.setVisible(true);
                        Label1.setVisible(true);
                        Label2.setVisible(true);
                        Label3.setVisible(true);
                        Label4.setVisible(true);
                        RadioButton1.setVisible(true);
                        RadioButton2.setVisible(true);
                        RadioButton3.setVisible(true);
                        TextField1.setVisible(true);
                        button2.setVisible(true);
                        Combo1.setVisible(true);
                        Combo2.setVisible(true);
                        
                    }else{
                    IncorrectLabel1.setVisible(true);
                    }

                } catch(SQLException e) {
                 System.out.println(e.getMessage());
                } 
    }
    
    @FXML
    void handleButtonAction2(ActionEvent event) throws IOException, SQLException {
    
        IncorrectLabel2.setVisible(false);
        IncorrectLabel3.setVisible(false);
        
            if(DatePicker.getValue()==null || Combo1.getValue()==null || Combo2.getValue()==null){
                
                IncorrectLabel3.setVisible(true);
                
            }else{
                    
                try{
 
                    String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                    String User      = "root";
                    String Password  = "root";
                
                    Connection conn = DriverManager.getConnection(url, User, Password);

                    Statement stmt=conn.createStatement(); 
                    
                    ResultSet rs0=stmt.executeQuery("select ID from movies Where Title='"+TextField1.getText()+"' ");
                    
                    String x = Combo1.getValue()+":"+Combo2.getValue()+":"+"00";
                    System.out.println(x);
                    
                    if(rs0.next()){
                    
                        System.out.println(rs0.getInt(1));
                        
                        if(RadioButton1.isSelected()){
                            
                            int rs=stmt.executeUpdate("INSERT INTO screensession (Date, Time, IDmovie, Idscreen, Seats_already_booked) VALUES ('"+DatePicker.getValue()+"', '"+x+"', '"+rs0.getInt(1)+"', '1','0')");
                            
                        }else if (RadioButton2.isSelected()){
                            
                            int rs=stmt.executeUpdate("INSERT INTO screensession (Date, Time, IDmovie, Idscreen, Seats_already_booked) VALUES ('"+DatePicker.getValue()+"', '"+x+"', '"+rs0.getInt(1)+"', '2','0')");
                            
                        }else if(RadioButton3.isSelected()){
                            
                            int rs=stmt.executeUpdate("INSERT INTO screensession (Date, Time, IDmovie, Idscreen, Seats_already_booked) VALUES ('"+DatePicker.getValue()+"', '"+x+"', '"+rs0.getInt(1)+"', '3','0')");
                            
                        }else{
                            IncorrectLabel2.setVisible(true);
                        }
                            
                    }else{
                        
                        DatePicker.setVisible(false);
                        IncorrectLabel1.setVisible(false);
                        IncorrectLabel2.setVisible(false);
                        IncorrectLabel3.setVisible(false);
                        Label1.setVisible(false);
                        Label2.setVisible(false);
                        Label3.setVisible(false);
                        Label4.setVisible(false);
                        RadioButton1.setVisible(false);
                        RadioButton2.setVisible(false);
                        RadioButton3.setVisible(false);
                        button2.setVisible(false);
                        Combo1.setVisible(false);
                        Combo2.setVisible(false);
                    }
                     
                } catch(SQLException e) {
                        System.out.println(e.getMessage());
                   
                } 
            }   
                
    }
    
    
    @FXML
    void handleButtonAction3(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene3();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SQLDateAdd ();
        SQLDateAdd2 ();
    }    
    
    private void loadScene3() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeMoviesPage.fxml"));
    Parent root1 =(Parent) loader.load();
    EmployeeMoviesPageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("EmployeeMoviesPage");
    stage.show();
    }
    
}
