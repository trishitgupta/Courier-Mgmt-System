
package courier;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Courier extends Application {

   
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        try{
         Parent root=FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        
        Scene scname=new Scene(root);
        stage.setTitle("login");
        stage.setScene(scname);
        stage.show();
        } catch(Exception e){
              System.out.println(e);
          }
    }
    
}
