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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Heverton Gomes
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
    private TableView<?> tabelaProfessor;
    @FXML
    private TableColumn<?, ?> nome;
    @FXML
    private TableColumn<?, ?> departamento;
    @FXML
    private TableColumn<?, ?> telefone;
    @FXML
    private TableColumn<?, ?> email;
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
