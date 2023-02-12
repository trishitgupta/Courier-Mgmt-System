/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courier;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class bookingclass  extends Application{

    @Override
    public void start(Stage stage) throws Exception {
         Parent root=FXMLLoader.load(getClass().getResource("bookorder.fxml"));
        
        Scene scname=new Scene(root);
        stage.setTitle("");
        stage.setScene(scname);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
