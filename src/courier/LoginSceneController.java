/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package courier;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginSceneController implements Initializable {

    @FXML
    private TextField t1;
    @FXML
    private Button b1;
    @FXML
    private PasswordField t2;
    
     Connection con;
   
   PreparedStatement pst;
    
    ResultSet rs;
    @FXML
    private Button b2;
    @FXML
    private Label warn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlesubmit(ActionEvent event) {
        
          String uname=t1.getText();
        String pass=t2.getText();
        
        if(uname.equals("") || pass.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Username or password blank");
        }
        
        else
        {
            try{
                  Class.forName("com.mysql.cj.jdbc.Driver");       
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/courproj","root","");
               pst=con.prepareStatement("select * from logindet where username=? and password=?");
              
              pst.setString(1, uname);
              pst.setString(2, pass);
              
              rs= pst.executeQuery();
              if(rs.next())
              {
                  JOptionPane.showMessageDialog(null,"login success");
                  
                  try{
                 Parent root=FXMLLoader.load(getClass().getResource("MainScene.fxml"));
                 
                 Stage stage=new Stage();
                 Scene scname=new Scene(root);
        stage.setTitle("courier mgmt sys");
        stage.setScene(scname);
        stage.show();
                  }catch (Exception e)
                  {
                      
                  }
                
                 
                  
              }
              else
              {
                  JOptionPane.showMessageDialog(null,"failed");
                  t1.setText("");
                  t2.setText("");
              }
              
              
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
    }
    
    }

    @FXML
    private void handleSignup(ActionEvent event) {
        
         String uname=t1.getText();
        String pass=t2.getText();
        
        try        {
              
              Class.forName("com.mysql.cj.jdbc.Driver");       
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/courproj","root","");      
              Statement s = con.createStatement();
              String s1 = "insert into logindet( username, password) values ('"+uname+"','"+pass+"');";       
          warn.setText("     SIGNED UP SUCCESSFULLY-- NOW LOGIN");       
          
          s.executeUpdate(s1);      
          }
          catch(Exception e){
              System.out.println(e);
          }
    }
}
