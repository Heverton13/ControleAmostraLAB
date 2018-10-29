/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Heverton
 */
public class ControladorProfessor implements Initializable {

    @FXML
    private JFXTextField nomeProfessor;
    @FXML
    private JFXTextField departamentoProfessor;
    @FXML
    private JFXTextField telefoneProfessor;
    @FXML
    private JFXTextField emailProfessor;
    @FXML
    private JFXButton btCadastrar;
    @FXML
    private JFXButton btEditar;
    @FXML
    private JFXButton btExcluir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
