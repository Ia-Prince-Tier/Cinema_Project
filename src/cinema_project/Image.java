/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_project;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author laurentdavenne
 */
public class Image {
     
    public Image(String location) throws Exception {
            
        try {
 
                String url       = "jdbc:mysql://localhost:8889/cinema_project_1";
                String User      = "root";
                String Password  = "root";
                
                Connection conn = DriverManager.getConnection(url, User, Password);
                
                File img=new File(location);
                FileInputStream istreamImage = new FileInputStream(img);
                Statement stmt=conn.createStatement(); 
                
                PreparedStatement ps = conn.prepareStatement("insert into movies (Image) where ID=1");
                ps.setBinaryStream(1,istreamImage, (int)img.length());
                ps.executeUpdate();
                
                        
                            

        } catch(SQLException e) {
        System.out.println(e.getMessage());
        } 
    }
}