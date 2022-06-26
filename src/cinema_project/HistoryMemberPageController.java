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
    
    String membername;
    
    @FXML
    void hundleButtonAction(ActionEvent event) {
        SQLHistory();
        historique.setVisible(true);
    }


    public void setMemberName(String memberName) {
        this.membername = memberName;
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //SQLHistory();
        //historique.setVisible(true);
    }

    public void /*ObservableList<History>*/ SQLHistory() {
        //ObservableList<History> Datelisthistory = FXCollections.observableArrayList(); 
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
 /*           
            if (rs.next()) {
                int j = rs.getInt(1);
                System.out.println(rs.getInt(1));
                ResultSet rs0 = stmt.executeQuery("SELECT Title from historique where IDmember='"+j+"' ");
                   
                if (rs0.next()) {
                    System.out.println(rs0.getString(1));
                    String a = rs0.getString(1);
                    ResultSet rs1 = stmt.executeQuery("SELECT Screensession from historique where IDmember='"+j+"' ");

                    if (rs1.next()) {
                        System.out.println(rs1.getString(1));
                        String b = rs1.getString(1);
                        ResultSet rs3 = stmt.executeQuery("SELECT Ticketnumber from historique where IDmember='"+j+"' ");

                        if (rs3.next()) {
                            System.out.println(a);
                            System.out.println(b);
                            System.out.println(rs3.getString(1));
                            //ObservableList<History> Datelisthistory = FXCollections.observableArrayList(new History(a, b, rs3.getString(1)));
                            //new History(a, b, rs3.getString(1)); 

                            //historique.setEditable(true);
                            Titlecolumn.setCellValueFactory(new PropertyValueFactory<>("title"));
                            Screensessioncolumn.setCellValueFactory(new PropertyValueFactory<>("screensession"));
                            Ticketnumbercolumn.setCellValueFactory(new PropertyValueFactory<>("ticketnumber"));
                            //historique.setItems(Datelisthistory);
                            //historique.getColumns().addAll(Titlecolumn, Screensessioncolumn, Ticketnumbercolumn);
                            historique.getItems().add(new History(a,b,rs3.getString(1)));
                        }
                    }
                }
            }
*/
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
        //return Datelisthistory;
    }

}
