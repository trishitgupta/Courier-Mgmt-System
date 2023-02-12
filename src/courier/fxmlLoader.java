/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courier;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;


public class fxmlLoader {
    private Pane view;
    
    
    public Pane getPage(String fileName)
    {
        try{
            URL fileUrl=Courier.class.getResource("/courier/"+ fileName+ ".fxml");
            
            if(fileUrl==null)
            {
                throw new java.io.FileNotFoundException("fxml cant be found");
                
            }
            
            view=new FXMLLoader().load(fileUrl);
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return view;
    }
    
    
}
