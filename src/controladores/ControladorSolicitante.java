/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Heverton Gomes
 */
public class ControladorSolicitante implements Initializable {

    @FXML
    private JFXComboBox<?> comboProfessores;
    @FXML
    private JFXTextField NomeSolicitante;
    @FXML
    private JFXTextField TelefoneSolicitante;
    @FXML
    private JFXTextField EmailSolicitante;
    @FXML
    private TableView<?> tableSolicitante;
    @FXML
    private TableColumn<?, ?> nomeSolicitante;
    @FXML
    private TableColumn<?, ?> telefoneSolicitante;
    @FXML
    private TableColumn<?, ?> emailSolicitante;
    @FXML
    private JFXButton BtAdicionar;
    @FXML
    private JFXButton BtCancelar;
    @FXML
    private JFXButton BtEditar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
