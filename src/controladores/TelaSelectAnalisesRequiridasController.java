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
import javafx.scene.control.SingleSelectionModel;
import modelos.Amostra;
import modelos.Amostra_Analise;
import modelos.Analises;
import persistencia.AmostraDAO;
import persistencia.AnalisesDAO;

/**
 * FXML Controller class
 *
 * @author Denys
 */
public class TelaSelectAnalisesRequiridasController implements Initializable {
  
    private AnalisesDAO anBanco = new AnalisesDAO();
    
    private Amostra_Analise adicionar;
    
    private AmostraDAO amostraBanco = new AmostraDAO();
    
    private ObservableList<Analises> analises = FXCollections.observableArrayList();
    
    private ObservableList<Amostra> amostras = FXCollections.observableArrayList();

    @FXML
    private JFXComboBox<Amostra> comboAmostra;

    @FXML
    private JFXComboBox<Analises> comboAnalise;

    @FXML
    private JFXButton btAmostraAnalise;    
    
    /**
     * Initializes the controller class.
     */
     
    @FXML
    private void addAnalises(){
        anBanco.preencherAnalises();
          
        adicionar = new Amostra_Analise(
                
                comboAmostra.getSelectionModel().getSelectedItem().getId(),
                comboAnalise.getSelectionModel().getSelectedItem().getId_analise()
                
        );
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        amostras.addAll(amostraBanco.list());
        comboAmostra.setItems(amostras);
        
        analises.addAll(anBanco.listarAnalise());
        comboAnalise.setItems(analises);
        
        
    }    
    
}