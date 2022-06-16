/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_project;


import java.io.IOException;
import static java.lang.Class.forName;
import java.net.URL;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static sun.security.jgss.GSSUtil.login;

 
public class MemberPageController implements Initializable {

/*private Button button;
    
 @FXML
 
private void handleButtonAction(ActionEvent event) throws IOException {
       
     
    /*Class.forName("com.mysql.jbdc.Driver");
    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8888/Test","root", "");
    String sql = "Select * from member where Login=? and Password=?";
    PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
    pst.setString(1,Login.getText());
    pst.setString(2,Password.getText());
    ResultSet rs = pst.executeQuery();
    
    if(rs.next()){
        loadScene();

    }else{
    System.exit(0);
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
    
    con.close();
    
    }catch(Exception e){
     JOptionPane.showMessageDialog(null,e);
    }
        
     try {
                // db parameters - ptest is the name of the database
                String url       = "jdbc:mysql://localhost:8888/Test";
                String Login      = "root";
                String Password  = "root";

                // create a connection to the database
                Connection conn = (Connection) DriverManager.getConnection(url, Login, Password);
                String sql = "Select * from member where Login=? and Password=?";
                PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                loadScene();
                }else{
                System.exit(0);
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    } 

            } catch(SQLException e) {
                 System.out.println(e.getMessage());

            }            
    
*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    /*private void loadScene() throws IOException {
        
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeMember.fxml"));
        Parent root1 =(Parent) loader.load();
        HomeMemberController s3Controller = loader.getController(); 
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("HomeMember");
        stage.show();
    }
}*/


}

