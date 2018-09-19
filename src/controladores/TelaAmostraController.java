/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Heverton
 */
public class TelaAmostraController implements Initializable {

    @FXML
    private JFXButton bt_cadeslocitante;
    @FXML
    private JFXButton bt_amostra;
    @FXML
    private JFXButton bt_fim_amostra;
    @FXML
    private JFXButton bt_sair;
    @FXML
    private JFXTextField id_amostra;
    @FXML
    private JFXTextField descricao;
    @FXML
    private JFXTextField qtd_frascos;
    @FXML
    private JFXTextField nome_responsavel;
    @FXML
    private JFXTextField nome_recebido;
    @FXML
    private JFXTextArea text_obs;
    @FXML
    private JFXDatePicker data_recebido;
    @FXML
    private JFXTimePicker hora_recido;
    @FXML
    private JFXCheckBox op_umidade;
    @FXML
    private JFXCheckBox op_ms;
    @FXML
    private JFXCheckBox op_ee;
    @FXML
    private JFXCheckBox op_todos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
