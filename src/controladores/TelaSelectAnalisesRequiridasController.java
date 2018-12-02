/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import modelos.Amostra;
import modelos.Amostra_Analise;
import modelos.Analises;
import persistencia.AmostraDAO;
import persistencia.AmostraEmAnaliseDAO;
import persistencia.AnalisesDAO;

/**
 * FXML Controller class
 *
 * @author Denys
 */
public class TelaSelectAnalisesRequiridasController implements Initializable {
    //Para listar analises  
    private AnalisesDAO anBanco = new AnalisesDAO();
    // Para listar amostras
    private AmostraDAO amostraBanco = new AmostraDAO();
    
    private Amostra_Analise adicionar;
    
    private AmostraEmAnaliseDAO amostraAnaliseDAO = new AmostraEmAnaliseDAO();
    
    
    private ObservableList<Analises> analises = FXCollections.observableArrayList();
    
    private ObservableList<Amostra> amostras = FXCollections.observableArrayList();

    @FXML
    private JFXComboBox<Amostra> comboAmostra;

    @FXML
    private JFXComboBox<Analises> comboAnalise;

    @FXML
    private JFXButton btAmostraAnalise; 
    
    @FXML
    private Label labelMovimento;
    
    /**
     * Initializes the controller class.
     */
     
    @FXML
    private void addAnalises(){
        
        if (!comboAmostra.getSelectionModel().isEmpty() &&
            !comboAnalise.getSelectionModel().isEmpty()) {
   
        adicionar = new Amostra_Analise(
                
                comboAmostra.getSelectionModel().getSelectedItem().getId(),
                comboAnalise.getSelectionModel().getSelectedItem().getId_analise()             
        );
        }
        
                else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Campos em branco");
            alert.setContentText("Por favor, preencha todas as informações antes de adicionar");
            alert.showAndWait();
        }
        
        amostraAnaliseDAO.insertAnaliseAmostra(adicionar);
        labelMovimento.setText("ANALISE "+comboAnalise.getSelectionModel().getSelectedItem().getNome_analise() + " FOI ADICIONADA A AMOSTRA " +  comboAmostra.getSelectionModel().getSelectedItem().getId_amostra());
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        amostras.addAll(amostraBanco.list());
        comboAmostra.setItems(amostras);
        
        analises.addAll(anBanco.listarAnalise());
        comboAnalise.setItems(analises);
        
        
    }    
    
}