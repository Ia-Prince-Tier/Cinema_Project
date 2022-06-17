 
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
public class MemberPageController implements Initializable {

    @FXML
    private TextField LoginText;

    @FXML
    private TextField PasswordText;
    
    @FXML
    private Label IncorrectLabel;
    
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
    
                ResultSet rs=stmt.executeQuery("select * from Member Where Login='"+LoginText.getText()+"' And Password='"+PasswordText.getText()+"'");
                if(rs.next()) {
                    loadScene();
                    }else{
                    IncorrectLabel.setVisible(true);
                    }
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
