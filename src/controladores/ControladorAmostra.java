/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
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
public class ControladorAmostra implements Initializable {

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
    @FXML
    private JFXTimePicker HoraAmostra;
    @FXML
    private JFXDatePicker DataAmostra1;
    @FXML
    private JFXButton selecionarAnalises;
    @FXML
    private JFXButton concluirAmostra;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
