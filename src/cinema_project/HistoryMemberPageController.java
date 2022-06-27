/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import com.mysql.cj.protocol.Resultset;
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
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author laurentdavenne
 */
public class HistoryMemberPageController implements Initializable {

    @FXML
    private TableColumn<History, String> Screensessioncolumn;

    @FXML
    private TableColumn<History, String> Ticketnumbercolumn;

    @FXML
    private TableColumn<History, String> Titlecolumn;

    @FXML
    private TableView<History> historique = new TableView();

    @FXML
    private Label historyname;

    @FXML
    private Button button1;
    
    @FXML
    private Button button2;
    
    String membername;
    
    @FXML
    void hundleButtonAction(ActionEvent event) {
    SQLHistory();
    historique.setVisible(true);
    }
    
    @FXML
    void hundleButtonAction2(ActionEvent event) throws IOException {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    loadScene();
    }


    public void setMemberName(String memberName) {
        this.membername = memberName;
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void SQLHistory() {
         
        Connection conn = null;

        try {

            String url = "jdbc:mysql://localhost:8889/cinema_project_1";
            String user = "root";
            String password = "root";

            conn = DriverManager.getConnection(url, user, password);
            
            Titlecolumn.setCellValueFactory(new PropertyValueFactory<>("title"));
            Screensessioncolumn.setCellValueFactory(new PropertyValueFactory<>("screensession"));
            Ticketnumbercolumn.setCellValueFactory(new PropertyValueFactory<>("ticketnumber"));
            
            Statement stmt = conn.createStatement();
            System.out.println(historyname.getText());
            System.out.println(membername);
            ResultSet rs = stmt.executeQuery("SELECT ID from member where USER = '"+membername+"' ");
            rs.next();
            int id = rs.getInt(1);    
            
            rs = stmt.executeQuery("SELECT * from historique where IDmember='"+id+"' ");
            
            while(rs.next()){
              historique.getItems().add(new History(rs.getString(1),rs.getString(2),rs.getString(3)));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void loadScene() throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root =(Parent) loader.load(); 
        HomePageController s3Controller = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("HomePage");
        stage.show();
    }
     
    
}
