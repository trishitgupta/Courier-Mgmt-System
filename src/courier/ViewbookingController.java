/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package courier;

import java.net.URL;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ViewbookingController implements Initializable {

    @FXML
    private TableView<ModelTable> table;
    
    
    ObservableList<ModelTable> oblist=FXCollections.observableArrayList();
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
