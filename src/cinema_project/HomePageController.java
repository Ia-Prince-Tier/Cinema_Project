/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 *
 * @author laurentdavenne
 */
public class HomePageController implements Initializable {
    
    
    @FXML
    private Button button;
    @FXML
    private RadioButton RadioB1;
    @FXML
    private RadioButton RadioB2;
    @FXML
    private RadioButton RadioB3;

    
 @FXML
 
private void handleButtonAction(ActionEvent event) throws IOException {
       
    if(RadioB1.isSelected())
    loadScene();
    else if (RadioB2.isSelected())
    loadScene2();
    else if(RadioB3.isSelected())
    loadScene3();
    else
    System.exit(0);
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        
}

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    private void loadScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GuestPage.fxml"));
        Parent root =(Parent) loader.load();
        GuestPageController s3Controller = loader.getController(); 
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("GuestPage");
        stage.show();
    }
   
     private void loadScene2() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MemberPage.fxml"));
        Parent root =(Parent) loader.load(); 
        MemberPageController s3Controller = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("MemberPage");
        stage.show();
    }
    
     private void loadScene3() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeePage.fxml"));
        Parent root =(Parent) loader.load(); 
        EmployeePageController s3Controller = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("EmployeePage");
        stage.show();
    }

}







