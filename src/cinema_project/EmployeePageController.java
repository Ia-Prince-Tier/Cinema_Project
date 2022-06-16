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

/**
 * FXML Controller class
 *
 * @author laurentdavenne
 */
public class EmployeePageController implements Initializable {

    @FXML
    private TextField LoginText;

    @FXML
    private TextField PasswordText;
    
    @FXML
    private Button button;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException {
        
            try {
 
                String url       = "jdbc:mysql://localhost:8889/Test";
                String Login      = "root";
                String Password  = "root";
                
                Connection conn = DriverManager.getConnection(url, Login, Password);

                Statement stmt=conn.createStatement(); 
                //ResultSet rs=stmt.executeQuery("select count(1) from Member Where Login= '" + LoginText.getText() + "' And Password = '" + PasswordText.getText());
                ResultSet rs=stmt.executeQuery("select * from Member");
                while(rs.next()) {
                System.out.println(rs.getString(2)+"  "+rs.getString(3));
                }
                /* if(rs.next()){
                    loadScene();
                    }else{
                    System.exit(0);
                    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                    System.out.println("Login or Password Error");
                    } 
                    System.out.println(rs.getInt(1));*/

                /*while(rs.next()){
                    if(LoginText.getText().equals(rs.getString(2)) && PasswordText.getText().equals(rs.getString(3))){
                    loadScene();
                    }else{
                    System.exit(0);
                    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                    }
                }*/
            } catch(SQLException e) {
                 System.out.println(e.getMessage());
            } 
    }   
         
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        private void loadScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeMember.fxml"));
        Parent root1 =(Parent) loader.load();
        HomeMemberController s3Controller = loader.getController(); 
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("HomeMember");
        stage.show();
    }
    
    
}
