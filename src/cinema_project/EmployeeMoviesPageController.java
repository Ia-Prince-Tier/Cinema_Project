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
public class EmployeeMoviesPageController implements Initializable {

    @FXML
    private Label label;
    
     @FXML
    private Button button;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;
    
    
    
    public void setEmployeeName(String nameEmployee){
        label.setText(nameEmployee);
    }
    
    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene1();
    }

    @FXML
    void hundleButtonAction2(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene2();
    }

    @FXML
    void hundleButtonAction3(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene3();
    }

    @FXML
    void hundleButtonAction4(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene4();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void loadScene1() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("AddMoviePage.fxml"));
    Parent root1 =(Parent) loader.load();
    AddMoviePageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("AddMoviePage");
    stage.show();
    }
    
    private void loadScene2() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteMoviePage.fxml"));
    Parent root1 =(Parent) loader.load();
    DeleteMoviePageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("DeleteMoviePage");
    stage.show();
    }
    
    private void loadScene3() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateMoviePage.fxml"));
    Parent root1 =(Parent) loader.load();
    UpdateMoviePageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("UpdateMoviePage");
    stage.show();
    }
    
    private void loadScene4() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeRegisterPage.fxml"));
    Parent root1 =(Parent) loader.load();
    EmployeeRegisterPageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("EmployeeRegisterPage");
    stage.show();
    }
        
}
