/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Heverton
 */
public class ControladorPrincipal implements Initializable {

    @FXML
    private BorderPane borderPrincipal;
    @FXML
    private Label labelPrincipal;
    @FXML
    private JFXButton BtInicio;
    @FXML
    private JFXButton Btlogin;
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
    private JFXButton btSolicitante;
    @FXML
    private Pane paneInicial;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelPrincipal.setAlignment(Pos.CENTER);
             
    }    
    
    
     @FXML
    private void inicio(){
        borderPrincipal.setCenter(paneInicial);
        labelPrincipal.setText("LABORATÓRIO");
     
    }
    
    @FXML
    private void cadastroSolicitante(){
        
        System.out.println("teste");
        try {
            URL url = getClass().getResource("/telasFX/CadastroSolicitante.fxml");
            Parent cadastroSolicitante = FXMLLoader.load(url);
            borderPrincipal.setCenter(cadastroSolicitante);
            labelPrincipal.setText("Cadastro de Solitantes");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void adicionarAmostra(){
        System.out.println("teste");
        try {
            Parent adicionarAmostra = FXMLLoader.load(getClass().getResource("/telasFX/TelaAmostra_1.fxml"));
            borderPrincipal.setCenter(adicionarAmostra);
            labelPrincipal.setText("Cadastro de Amostras");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    @FXML
    private void telaProfessor(){
         try {
            Parent telaLogin = FXMLLoader.load(getClass().getResource("/telasFX/TelaProfessor.fxml"));
            borderPrincipal.setCenter(telaLogin);
            labelPrincipal.setText("Cadastro de Professor");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void telaHistorico(){
         try {
            Parent telaH = FXMLLoader.load(getClass().getResource("/telasFX/TelaHistorico.fxml"));
            borderPrincipal.setCenter(telaH);
            labelPrincipal.setText("Tela de Histórico");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void telaResponsavel(){
         try {
            Parent telaE = FXMLLoader.load(getClass().getResource("/telasFX/TelaResponsavel.fxml"));
            borderPrincipal.setCenter(telaE);
            labelPrincipal.setText("Tela de Responsável");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void telaAjuda(){
         try {
            Parent telaA = FXMLLoader.load(getClass().getResource("/telasFX/TelaAjuda.fxml"));
            borderPrincipal.setCenter(telaA);
            labelPrincipal.setText("Tela de Ajuda");
        } catch (IOException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
	private void sair() {
		System.exit(0);
	}
    
}
