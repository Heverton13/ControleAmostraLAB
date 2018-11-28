/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelos.Amostra_Analise;
import persistencia.AmostraEmAnaliseDAO;

/**
 * FXML Controller class
 *
 * @author Heverton
 */
public class TelaHistoricoController implements Initializable {

    private AmostraEmAnaliseDAO amDAO = new AmostraEmAnaliseDAO();
    
    private ObservableList<Amostra_Analise> am_an;
    
    @FXML
    private TableView<Amostra_Analise> tabelaHistorico;
    @FXML
    private TableColumn<?, ?> colunaAmostra;
    @FXML
    private TableColumn<?, ?> colunaDescricao;
    @FXML
    private TableColumn<?, ?> colunaFrascos;
    @FXML
    private TableColumn<?, ?> colunaAR;
    @FXML
    private JFXButton btGerarEtiqueta;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void listHistorico(){
        
        am_an = FXCollections.observableArrayList(amDAO.listAnalise_Amostra());
        
        
        tabelaHistorico.getColumns().get(0).setCellValueFactory(new  PropertyValueFactory<>("getAm().getId_amostra()"));
        //tabelaHistorico.getColumns().get(1).setCellValueFactory(new  PropertyValueFactory<>("am.getDescricao()"));
        //tabelaHistorico.getColumns().get(2).setCellValueFactory(new  PropertyValueFactory<>("am.getFrascos()"));
        //tabelaHistorico.getColumns().get(3).setCellValueFactory(new  PropertyValueFactory<>("anal.getNome_analise()"));
        tabelaHistorico.setItems(am_an);
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listHistorico();
    }    
    
}
