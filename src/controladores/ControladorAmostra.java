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
 * @author Denys
 */
public class ControladorAmostra implements Initializable {

  @FXML
    private JFXTextField idAmostra;

    @FXML
    private JFXTextField descricaoAmostra;

    @FXML
    private JFXTextField frascosAmostra;

    @FXML
    private JFXTextField recebidoPor;

    @FXML
    private JFXTextField responsavelAmostra;

    @FXML
    private JFXTextField obervacoesAmostra;

    @FXML
    private JFXDatePicker dataAmostra;

    @FXML
    private JFXTimePicker horaAmostra;

    @FXML
    private TableView<?> TabelaAmostra;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> descricao;

    @FXML
    private TableColumn<?, ?> frascos;

    @FXML
    private TableColumn<?, ?> recebido;

    @FXML
    private TableColumn<?, ?> responsavel;

    @FXML
    private TableColumn<?, ?> observacoes;

    @FXML
    private TableColumn<?, ?> data;

    @FXML
    private TableColumn<?, ?> hora;

    @FXML
    private JFXButton btCadastrarAmostra;

    @FXML
    private JFXButton btExcluirAmostra;

    @FXML
    private JFXButton btEditarAmostra;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
