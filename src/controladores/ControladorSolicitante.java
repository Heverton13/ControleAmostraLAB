/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modelos.Professor_Orientador;
import modelos.Solicitante_Academico;
import persistencia.ProfessorDAO;
import persistencia.SolicitanteDAO;

/**
 * FXML Controller class
 *
 * @author Heverton Gomes
 */
public class ControladorSolicitante implements Initializable {
    
    private Solicitante_Academico solicitanteEdit;
    
    private SolicitanteDAO sDAO = new SolicitanteDAO();
    
    private ProfessorDAO pbanco = new ProfessorDAO();
    
    private ObservableList<Professor_Orientador> professores = FXCollections.observableArrayList();
    
    private ObservableList<Solicitante_Academico> solicitantes;

    @FXML
    private JFXComboBox<Professor_Orientador> comboProfessores;
    @FXML
    private JFXTextField NomeSolicitante;
    @FXML
    private JFXTextField TelefoneSolicitante;
    @FXML
    private JFXTextField EmailSolicitante;
    @FXML
    private TableView<Solicitante_Academico> tableSolicitante;
    @FXML
    private TableColumn<Solicitante_Academico, Integer> id_Solicitante;
    @FXML
    private TableColumn<Solicitante_Academico, Integer> id_Professor;
    @FXML
    private TableColumn<Solicitante_Academico, String> nomeSolicitante;
    @FXML
    private TableColumn<Solicitante_Academico, String> telefoneSolicitante;
    @FXML
    private TableColumn<Solicitante_Academico, String> emailSolicitante;
    @FXML
    private JFXButton BtAdicionar;
    @FXML
    private JFXButton BtCancelar;
    @FXML
    private JFXButton BtEditar;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void limparTextos(){
        NomeSolicitante.clear();
        TelefoneSolicitante.clear();
        EmailSolicitante.clear();
    }
    
    @FXML
    private void refreshTable(){
        
        solicitantes.clear();
        solicitantes.addAll(sDAO.listSolicitante());
        tableSolicitante.setItems(solicitantes);
        
    }
    
    @FXML
    private void mouseClicked(MouseEvent event) {
        Solicitante_Academico solicitante = tableSolicitante.getSelectionModel().getSelectedItem();
        NomeSolicitante.setText(solicitante.getNome());
        TelefoneSolicitante.setText(solicitante.getTelefone());
        EmailSolicitante.setText(solicitante.getEmail_solicitante());
        
        //TODO
        Professor_Orientador prof = null;
        for(Professor_Orientador p: professores){
            if(p.getId_professor() == solicitante.getId_Professor())
                prof = p;
        }
       
        comboProfessores.setValue(prof);
       
    }
    
    @FXML
    private void addSolicitante(){
        
  if (!comboProfessores.getSelectionModel().isEmpty() &&
            !NomeSolicitante.getText().equals("") &&
            !TelefoneSolicitante.getText().equals("") &&
            !EmailSolicitante.getText().equals("")) {
            
            solicitanteEdit = new Solicitante_Academico
                   (comboProfessores.getSelectionModel().getSelectedItem().getId_professor(),
                    NomeSolicitante.getText(),
                    TelefoneSolicitante.getText(),
                    EmailSolicitante.getText());
            sDAO.insertSolicitante(solicitanteEdit);
            limparTextos();
            refreshTable();
            
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Campos em branco");
            alert.setContentText("Por favor, preencha todas as informações antes de adicionar");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void updateSolicitante(){
        
        Solicitante_Academico solicitante = tableSolicitante.getSelectionModel().getSelectedItem();
        
        
        if(solicitante != null){
        
        
        solicitante.setId_Professor(comboProfessores.getSelectionModel().getSelectedItem().getId_professor());
        
        if(!NomeSolicitante.getText().equals("")){
            solicitante.setNome(NomeSolicitante.getText());
        }
        if(!TelefoneSolicitante.getText().equals("")){
            solicitante.setTelefone( TelefoneSolicitante.getText());
        }
        if(!EmailSolicitante.getText().equals("")){
            solicitante.setEmail_solicitante( EmailSolicitante.getText());
        }
        sDAO.updateSolicitante(solicitante);
        
        }
        limparTextos();
        refreshTable();
    }
    
    @FXML
    private void deleteSolicitante(){
    
        sDAO.deleteSolicitante(tableSolicitante.getSelectionModel().getSelectedItem().getId_solicitante());
        refreshTable();
    }
    
    @FXML
    private void listarSolicitante(){
        
        solicitantes = FXCollections.observableArrayList(sDAO.listSolicitante());
        tableSolicitante.getColumns().get(0).setCellValueFactory(new  PropertyValueFactory<>("id_solicitante"));
        tableSolicitante.getColumns().get(1).setCellValueFactory(new  PropertyValueFactory<>("id_Professor"));
        tableSolicitante.getColumns().get(2).setCellValueFactory(new  PropertyValueFactory<>("nome"));
        tableSolicitante.getColumns().get(3).setCellValueFactory(new  PropertyValueFactory<>("telefone"));
        tableSolicitante.getColumns().get(4).setCellValueFactory(new  PropertyValueFactory<>("email_solicitante"));
        tableSolicitante.setItems(solicitantes);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        professores.addAll(pbanco.listProfessor_Orientador());
        comboProfessores.setItems(professores);
        listarSolicitante();
      
    }    
    
}
