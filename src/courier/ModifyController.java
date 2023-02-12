/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package courier;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ModifyController implements Initializable {

    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable,String> col_id;
    @FXML
    private TableColumn<ModelTable,String> col_date;
    @FXML
    private TableColumn<ModelTable,String> col_contact;
    @FXML
    private TableColumn<ModelTable,String> col_service;
    @FXML
    private TableColumn<ModelTable,String> col_from;
    @FXML
    private TableColumn<ModelTable,String> col_to;
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;
    @FXML
    private TextField t5;
    @FXML
    private TextField t4;
    
     ObservableList<ModelTable> oblist=FXCollections.observableArrayList();
     
      ObservableList serviceList=FXCollections.observableArrayList();

  int index=-1;
  
  
    @FXML
    private ChoiceBox<?> servicetype;
    @FXML
    private Button updatebtn;
    @FXML
    private Label warn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        t1.setDisable(true);
         try{
        
         Class.forName("com.mysql.cj.jdbc.Driver");  
         
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/courproj","root","");
         
         ResultSet rs=con.createStatement().executeQuery("select * from bookingdet");
        
         while(rs.next())
         {
             oblist.add(new ModelTable(rs.getString("bookingId"),rs.getString("date"),
                     rs.getString("contact"),rs.getString("service"),rs.getString("Fromadd"),
                     rs.getString("Toadd")));  //use the column name from the database table not the tableview
         }
        }catch(Exception e)
        {
            
        }
        
         // here use the names used in model table
       col_id.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
       col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
       col_service.setCellValueFactory(new PropertyValueFactory<>("service"));
       col_contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
       
       col_from.setCellValueFactory(new PropertyValueFactory<>("Fromadd"));
       col_to.setCellValueFactory(new PropertyValueFactory<>("Toadd"));
       table.setItems(oblist);
       
        additems();
    }   
    
    @FXML
     void getSelected(MouseEvent event)
     {
      index= table.getSelectionModel().getSelectedIndex();
      if(index <=-1)
      {
          return;
      }
      
     
      
      t1.setText(col_id.getCellData(index).toString());
      t2.setText(col_date.getCellData(index).toString());
      t3.setText(col_contact.getCellData(index).toString());
      t4.setText(col_from.getCellData(index).toString());
      t5.setText(col_to.getCellData(index).toString());
      
     }
     
      public void additems() //user created method to initialize choiceb box items
    {
         
          
          
        String d1="regular delivery";
        String d2="overnight delivery";
        
        
        serviceList.addAll(d1,d2);
        
       // System.out.println("after adding"+ serviceList);
       
        servicetype.getItems().addAll(serviceList);
        
        
        
          
        
        
     }

    @FXML
    private void handleupdatebtn(ActionEvent event) {
        
         try{
        
         String bookingId=t1.getText();
         
         
         
        String date=t2.getText();
        
        String service=(servicetype.getValue()).toString();
        
        String namecont=t3.getText();
        
        
        String from=t4.getText();
        String to=t5.getText();
        
        
        try        {
              
              Class.forName("com.mysql.cj.jdbc.Driver");       
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/courproj","root","");      
              
              
              // create the java mysql update preparedstatement
      String query = "update bookingdet set date = ?,contact=?,service=?,Fromadd=? ,Toadd=? where bookingId = ?";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, date);
      preparedStmt.setString(2, namecont);
      preparedStmt.setString(3, service);
      preparedStmt.setString(4, from);
      preparedStmt.setString(5, to);
      preparedStmt.setString(6, bookingId);
      

      // execute the java preparedstatement
      preparedStmt.executeUpdate();     
          }
          catch(Exception e){
              System.out.println(e);
          }
       
            
        
        
        
        warn.setText("booking updated!!");
        }
        catch(Exception e)
        {
         warn.setText("fill all fields");   
        }
         
         
         //TO PRINT ALL THE TABLE AGAIN AFTER UPDATING
         
         table.getItems().clear();
          try{
        
         Class.forName("com.mysql.cj.jdbc.Driver");  
         
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/courproj","root","");
         
         ResultSet rs=con.createStatement().executeQuery("select * from bookingdet");
        
         while(rs.next())
         {
             oblist.add(new ModelTable(rs.getString("bookingId"),rs.getString("date"),
                     rs.getString("contact"),rs.getString("service"),rs.getString("Fromadd"),
                     rs.getString("Toadd")));  //use the column name from the database table not the tableview
         }
        }catch(Exception e)
        {
            
        }
        
         // here use the names used in model table
       col_id.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
       col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
       col_service.setCellValueFactory(new PropertyValueFactory<>("service"));
       col_contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
       
       col_from.setCellValueFactory(new PropertyValueFactory<>("Fromadd"));
       col_to.setCellValueFactory(new PropertyValueFactory<>("Toadd"));
       table.setItems(oblist);
         
         
         
    }

        
        
        
    }
    

