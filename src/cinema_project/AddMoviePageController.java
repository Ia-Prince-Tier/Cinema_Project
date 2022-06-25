/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_project;

//import java.io.File;
import java.io.File;
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
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;


public class AddMoviePageController implements Initializable {


    @FXML
    private TextField TextField2;

    @FXML
    private TextField TextField3;

    @FXML
    private TextField TextField4;
    
    @FXML
    private TextField TextField5;

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

    @FXML
    private Label IncorrectLabel3;
    
    @FXML
    private Label lastLabel;
    
    public boolean isStringInt(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
    
    @FXML
    void hundleButtonAction(ActionEvent event) throws IOException {
    
        FileChooser fc = new FileChooser(); 
       
        fc.getExtensionFilters().add(new ExtensionFilter("Images Files", "*.png"));                   
        File f = fc.showOpenDialog(null);                                                            
        String pathImage;                                                                            
        String currentDirectory = System.getProperty("user.dir");                                    
        File source;
        File dest = new File(currentDirectory + "\\Cinema_project\\src\\" + TextField2.getText() + ".png");     
        if (f != null && ! TextField2.getText().equals("")) {                                           

            pathImage = f.getAbsolutePath();                                                         
            source = new File(pathImage);                                                            

            try {
                FileUtils.copyFile(source, dest);                                                    
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(dest);
            lastLabel.setText("Image successfully imported !");  
        } else {
            lastLabel.setText("No files/incompatible file OR name of movie not entered.");
        }  
        
    }
    
    @FXML
    void hundleButtonAction1(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene1();
    }

    @FXML
    void hundleButtonAction2(ActionEvent event) throws IOException {
        
        IncorrectLabel2.setVisible(false);
        IncorrectLabel3.setVisible(false);
        
            if(TextField2.getText().equals("") || TextField4.getText().equals("") || TextField4.getText().equals("") || TextField5.getText().equals("")){
                
                IncorrectLabel3.setVisible(true);
                
            }else{
                    
                if(isStringInt(TextField3.getText())==false){
                    IncorrectLabel2.setVisible(true);   
                
                }else{
                
                    try{
 
                    String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                    String User      = "root";
                    String Password  = "root";
                
                    Connection conn = DriverManager.getConnection(url, User, Password);

                    Statement stmt=conn.createStatement(); 
   
                    int rs=stmt.executeUpdate("INSERT INTO movies (Title, Duration, Genre, Synopsis) VALUES ('"+TextField2.getText()+"', '"+TextField3.getText()+"', '"+TextField4.getText()+"', '"+TextField5.getText()+"')");
                            

                    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                    loadScene2();
                    
                    
                    } catch(SQLException e) {
                        System.out.println(e.getMessage());
                   
                    } 
                }
            }           
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void loadScene1() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeMoviesPage.fxml"));
    Parent root1 =(Parent) loader.load();
    EmployeeMoviesPageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("EmployeeMoviesPage");
    stage.show();
    }
    
    private void loadScene2() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("MovieSucessfullyAddedPage.fxml"));
    Parent root1 =(Parent) loader.load();
    MovieSucessfullyAddedPageController s3Controller = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root1));
    stage.setTitle("MovieSucessfullyAddedPage");
    stage.show();
    }
    
    
    
}
