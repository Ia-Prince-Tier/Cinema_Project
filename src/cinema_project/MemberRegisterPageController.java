 
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author laurentdavenne
 */
public class MemberRegisterPageController implements Initializable {
    
    public String FirstTitle;
    
    public String getFirstTitle(){
        return FirstTitle;
    }

    @FXML
    private TextField LoginText;

    @FXML
    private PasswordField PasswordText;
    
    @FXML
    private Label IncorrectLabel;
    
    @FXML
    private Button button;
    
    @FXML
    private Button button1;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException {
        
            try {
 
                String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                String User      = "root";
                String Password  = "root";
                
                Connection conn = DriverManager.getConnection(url, User, Password);

                Statement stmt=conn.createStatement(); 
    
                ResultSet rs=stmt.executeQuery("select * from member Where USER='"+LoginText.getText()+"' And PASSWORD='"+PasswordText.getText()+"'");
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
        s3Controller.setMemberName("Hello " + LoginText.getText() + "!");
        s3Controller.setPrice(8.50);
        s3Controller.setMemberName2(LoginText.getText());
        
                try {
 
                String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                String User      = "root";
                String Password  = "root";
                
                Connection conn = DriverManager.getConnection(url, User, Password);

                Statement stmt=conn.createStatement(); 
    
                ResultSet rs1=stmt.executeQuery("select Title, Duration, Genre, Synopsis from movies where ID=1");
                
                    while(rs1.next()) {
                        s3Controller.setTitle(rs1.getString(1));
                        FirstTitle=(rs1.getString(1));
                        s3Controller.setDuration("Duration : " + rs1.getString(2) + " min.");
                        s3Controller.setGenre("Genre : " + rs1.getString(3));
                        s3Controller.setSynopsis("Synopsis : " + rs1.getString(4));
                        s3Controller.getFirstTitle1();
                        s3Controller.SQLDate();  
                    }
                    
        } catch(SQLException e) {
           System.out.println(e.getMessage());
        } 
        
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
