/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Heverton
 */
public class TelaHistoricoController implements Initializable {

    @FXML
    private TableColumn<?, ?> colunaAmostra;
    @FXML
    private TableColumn<?, ?> colunaDescricao;
    @FXML
    private TableColumn<?, ?> colunaFrascos;
    @FXML
    private TableColumn<?, ?> colunaAR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}