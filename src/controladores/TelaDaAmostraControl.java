/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class TelaDaAmostraControl implements Initializable {

    @FXML
    private JFXButton BtInicio;
    @FXML
    private JFXButton Btlogin;
    @FXML
    private JFXButton BtSolicitante;
    @FXML
    private JFXButton BtAmostra;
    @FXML
    private JFXButton BtHistorico;
    @FXML
    private JFXButton BtPedido;
    @FXML
    private JFXButton BtAjuda;
    @FXML
    private JFXButton BtSair;
    @FXML
    private AnchorPane DataAmostra;
    @FXML
    private JFXTimePicker HoraAmostra;
    @FXML
    private JFXTextField Frascos;
    @FXML
    private JFXTextField Observacoes;
    @FXML
    private JFXTextField RecebidoPor;
    @FXML
    private JFXTextField Responsavel;
    @FXML
    private JFXTextField Descricao;
    @FXML
    private JFXTextField IdentificacaoAmostra;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
