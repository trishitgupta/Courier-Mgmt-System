/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package courier;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class MainSceneController implements Initializable {

    @FXML
    private BorderPane mainPane;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button updbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    



    @FXML
    private void handleBook(ActionEvent event) {
        // System.out.println("You Clicked me");
        fxmlLoader object=new fxmlLoader();
        Pane view=object.getPage("bookorder");
        mainPane.setCenter(view);
    }

    @FXML
    private void handleSrchBook(ActionEvent event) {
         //System.out.println("You Clicked me");
        fxmlLoader object=new fxmlLoader();
        Pane view=object.getPage("cancel");
        mainPane.setCenter(view);
    }

    @FXML
    private void handleviewBookings(ActionEvent event) {
        
         //System.out.println("You Clicked me");
        fxmlLoader object=new fxmlLoader();
        Pane view=object.getPage("viewbooking");
        mainPane.setCenter(view);
        
        
    }

    @FXML
    private void handleUpdate(ActionEvent event) {
        // System.out.println("You Clicked me");
        fxmlLoader object=new fxmlLoader();
        Pane view=object.getPage("modify");
        mainPane.setCenter(view);
    }
    
}
