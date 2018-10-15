/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author Heverton
 */
public class ControladorSolicitante implements Initializable {

    @FXML
    private JFXButton BtAdicionar;
    @FXML
    private JFXButton BtCancelar;
    @FXML
    private JFXButton BtEditar;
    @FXML
    private JFXTextField NomeAutorizador;
    @FXML
    private JFXTextField TelefoneSolicitante;
    @FXML
    private JFXTextField EmailSolicitante;
    @FXML
    private JFXTextField NomeSolicitante;

    /**
     * Initializes the controller class.
     * 
     * 
     * 
     */
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
