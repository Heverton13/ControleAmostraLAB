/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Heverton
 */
public class Principal extends Application {
    
    public static void main(String[] args){
        launch(args);
    }
    
    public void start(Stage stage) throws Exception {
        
		Parent root = FXMLLoader.load(getClass().getResource("/TelaPrincipal.fxml"));
                Scene scene = new Scene(root);
                
                stage.setScene(scene);
                stage.setTitle("Gerenciar Amostras");
                stage.show();
    }
    
}
