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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Heverton
 */
public class ControladorResponsavel implements Initializable {

    @FXML
    private JFXTextField nomeResponsavel1;
    @FXML
    private JFXTextField assResponsavel;
    @FXML
    private JFXDatePicker dataRecebimento;
    @FXML
    private JFXTimePicker horaRecebimento;
    @FXML
    private TableView<?> tabelaResponsavel;
    @FXML
    private TableColumn<?, ?> nomeTableResponsavel;
    @FXML
    private TableColumn<?, ?> assinaturaResponsavel;
    @FXML
    private JFXButton btCadastrar;
    @FXML
    private JFXButton btExcluir;
    @FXML
    private JFXButton btEditar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
