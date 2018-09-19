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
public class CadastroSolicitanteController implements Initializable {

    @FXML
    private JFXButton bt_cadeslocitante;
    @FXML
    private JFXButton bt_amostra;
    @FXML
    private JFXButton bt_fim_amostra;
    @FXML
    private JFXButton bt_sair;
    @FXML
    private JFXTextField Autorizador;
    @FXML
    private JFXTextField nome_solicitante;
    @FXML
    private JFXTextField Telefone_do_Solicitante;
    @FXML
    private JFXTextField Email_Solicitante;
    @FXML
    private JFXButton bt_cadastrar_solicitante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
