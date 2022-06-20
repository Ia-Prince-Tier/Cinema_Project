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
public class CustomerMoviesPageController implements Initializable {


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
    private Label Label4;

    @FXML
    private Label Label5;

    @FXML
    private Label Label6;

    @FXML
    private Label Label7;

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
    
   

    @FXML
    void handleButtonAction1(ActionEvent event) {

    }

    @FXML
    void hundleButtonAction2(ActionEvent event) {

    }

    @FXML
    void hundleButtonAction3(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene1();
    }
    
    ObservableList DatesList = FXCollections.observableArrayList();

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
                while(rs.next()) 
                DatesList.add(rs.getString(1)); 

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
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //Combo1.setItems(DatesList);
       imageview1.setImage(new Image("image1.png"));
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
