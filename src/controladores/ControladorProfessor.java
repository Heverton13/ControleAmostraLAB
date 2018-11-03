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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelos.Professor_Orientador;
import persistencia.ProfessorDAO;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author Heverton Gomes
 */
public class ControladorProfessor implements Initializable {
    
    private Professor_Orientador professorEdit;
    
    private ProfessorDAO pbanco = new ProfessorDAO();
    
    private ObservableList<Professor_Orientador> professores;
    
    
    @FXML
    private JFXButton btCadastrar;
    @FXML
    private JFXButton btExcluir;
    @FXML
    private JFXButton btEditar;
    @FXML
    private JFXTextField nomeProfessor;
    @FXML
    private JFXTextField departamentoProfessor;
    @FXML
    private JFXTextField telefoneProfessor;
    @FXML
    private JFXTextField emailProfessor;
    @FXML
    private TableView<Professor_Orientador> tabelaProfessor;
    @FXML
    private TableColumn<Professor_Orientador, Integer> id_Professor;
    @FXML
    private TableColumn<Professor_Orientador, String> nome;
    @FXML
    private TableColumn<Professor_Orientador, String> departamento;
    @FXML
    private TableColumn<Professor_Orientador, String> telefone;
    @FXML
    private TableColumn<Professor_Orientador, String> email;

    
    /**
     * Initializes the controller class.
     */
    
    private void limparTextField(){
        
        nomeProfessor.clear();
        telefoneProfessor.clear();
        departamentoProfessor.clear();
        emailProfessor.clear();
        
    }
    
    @FXML
    private void refreshTable(){
        
        professores.clear();
        professores.addAll(pbanco.listProfessor_Orientador());
        tabelaProfessor.setItems(professores);
        
    }
    
    @FXML
    private void addProfessor(){
        
        professorEdit = new Professor_Orientador(nomeProfessor.getText(),departamentoProfessor.getText(),telefoneProfessor.getText(),emailProfessor.getText());
        //Fazer tratamentos aqui, Pedir explicação a Laura
        pbanco.insertProfessor(professorEdit);
        limparTextField();
        //refreshTable();
        
    }
    
    @FXML
    private void updateProfessor(){
        
        professorEdit.setNome(nomeProfessor.getText());
        professorEdit.setDepartamento(departamentoProfessor.getText());
        professorEdit.setTelefone(telefoneProfessor.getText());
        professorEdit.setEmail(emailProfessor.getText());
        pbanco.updateProfessor(professorEdit);
        
        limparTextField();
        //refreshTable();
    }
    
    @FXML
    private void deleteProfessor(){
        
        pbanco.deleteProfessor(tabelaProfessor.getSelectionModel().getSelectedItem().getId_professor());
        
    }
    
    @FXML
    private void listarProfessores(){
        
        professores = FXCollections.observableArrayList(pbanco.listProfessor_Orientador());
        
        //id_Professor.setCellValueFactory(new PropertyValueFactory<Professor_Orientador, Integer>("ID_PROFESSOR"));
        
        
        tabelaProfessor.getColumns().get(0).setCellValueFactory(new  PropertyValueFactory<>("ID_PROFESSOR"));
        tabelaProfessor.getColumns().get(1).setCellValueFactory(new  PropertyValueFactory<>("NOME_PROFESSOR"));
        tabelaProfessor.getColumns().get(2).setCellValueFactory(new  PropertyValueFactory<>("DEPARTAMENTO"));
        tabelaProfessor.getColumns().get(3).setCellValueFactory(new  PropertyValueFactory<>("TELEFONE"));
        tabelaProfessor.getColumns().get(4).setCellValueFactory(new  PropertyValueFactory<>("EMAIL_PROFESSOR"));
        tabelaProfessor.setItems(professores);
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listarProfessores();
        // TODO
    }    
    
}
