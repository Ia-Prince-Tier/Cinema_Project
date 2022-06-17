 
package cinema_project;


import java.io.IOException;
import static java.lang.Class.forName;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author laurentdavenne
 */
public class MemberRegisterPageController implements Initializable {

    @FXML
    private TextField LoginText;

    @FXML
    private TextField PasswordText;
    
    @FXML
    private Label IncorrectLabel;
    
    @FXML
    private Button button;
    
    @FXML
    private Button button1;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException {
        
            try {
 
                String url       = "jdbc:mysql://localhost:8889/cinema_project";
                String User      = "root";
                String Password  = "root";
                
                Connection conn = DriverManager.getConnection(url, User, Password);

                Statement stmt=conn.createStatement(); 
    
                ResultSet rs=stmt.executeQuery("select * from Member Where USER='"+LoginText.getText()+"' And PASSWORD='"+PasswordText.getText()+"'");
                if(rs.next()) {
                    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                    loadScene();
                    }else{
                    IncorrectLabel.setVisible(true);
                    }
            } catch(SQLException e) {
                 System.out.println(e.getMessage());
            } 
    }  

    @FXML
    private void handleButtonAction2(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene2();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        private void loadScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerMoviesPage.fxml"));
        Parent root1 =(Parent) loader.load();
        CustomerMoviesPageController s3Controller = loader.getController(); 
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("CustomerMoviesPage");
        stage.show();
    }
            
        private void loadScene2() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root1 =(Parent) loader.load();
        HomePageController s3Controller = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("HomePage");
        stage.show();
        
        }


    
    
}
