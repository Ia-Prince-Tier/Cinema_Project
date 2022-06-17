/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
/**
 * FXML Controller class
 *
 * @author tad-t
 */
public class MoviesController implements Initializable {

    
    @FXML
    private AnchorPane AnchorPane1;

    @FXML
    private AnchorPane AnchorPane2;

    @FXML
    private ImageView Imageview1;

    @FXML
    private MenuButton MenuButton1;

    @FXML
    private MenuButton MenuButton2;
    
        @FXML
    private ComboBox<?> Combo1;

    @FXML
    private ComboBox<?> Combo2;

    
    
    public void  start(Stage s)
    {

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
