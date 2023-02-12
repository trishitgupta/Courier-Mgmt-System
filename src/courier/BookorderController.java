/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package courier;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class BookorderController implements Initializable {
    
    ObservableList serviceList=FXCollections.observableArrayList();

    
    @FXML
    private DatePicker datepicker;
    @FXML
    private ChoiceBox<?> servicetype;
    @FXML
    private Button btnbook;
    @FXML
    private Label warn;
    @FXML
    private TextField fromadd;
    @FXML
    private TextField toadd;
    @FXML
    private Button clr;
    
   
    @FXML
    private TextField ContactText;
    @FXML
    private Label error_pno;
    @FXML
    private TextField nameField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        additems();
        
    }    
    
     public void additems() //user created method to initialize choiceb box items
    {
        String d1="regular delivery";
        String d2="overnight delivery";
        
        
        serviceList.addAll(d1,d2);
        servicetype.getItems().addAll(serviceList);
        
        
     }

    @FXML
    private void handleBooking(ActionEvent event) {
        
        try{
        
        
         
         
         
        String date=datepicker.getValue().toString();
        
        String service=(servicetype.getValue()).toString();
        
        
        String from=fromadd.getText();
        String to=toadd.getText();
        String cont=ContactText.getText();
        
        if(validate(cont))
        {
            
        if(!(from.isBlank()) && !(to.isBlank()))
        {
        
        try{
              
              Class.forName("com.mysql.cj.jdbc.Driver");       
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/courproj","root","");      
              Statement s = con.createStatement();
              String s1 = "insert into bookingdet(date,contact,service,Fromadd,Toadd) values ('"+date+"','"+cont+"','"+service+"','"+from+"','"+to+"');";       
          System.out.println("sucess");        
          
          s.executeUpdate(s1);      
          }
          catch(Exception e){
              System.out.println(e);
          }
        
            
        
        
        error_pno.setText("");
        warn.setText("booked Successfully");
        }
        else{
            error_pno.setText("");
            warn.setText("fill all fields!!");
        }
        }
        else{
            warn.setText("");
            error_pno.setText("invalid pno");
        }
        
        }
        catch(Exception e)
        {
         warn.setText("fill all fields");   
        }
        
    }

    boolean validate(String c)
    {
         String strPattern = "^[0-9]{10}$";
         
         boolean f=c.matches(strPattern);
         System.out.println(f);
         
         return f;
        
    }
    
    @FXML
    private void handleclr(ActionEvent event) {
      
        datepicker.setValue(null);
        fromadd.setText("");
        toadd.setText("");
        warn.setText("");
        ContactText.setText("");
        nameField.setText("");
    }
    
}
