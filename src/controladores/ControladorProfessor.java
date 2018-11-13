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
import javafx.scene.input.MouseEvent;

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
        refreshTable();
        limparTextField();
        
        
    }
    
    @FXML
    private void retornarItens(){
        
        nomeProfessor.setText(professorEdit.getNome());
        departamentoProfessor.setText(professorEdit.getDepartamento());
        telefoneProfessor.setText(professorEdit.getTelefone());
        emailProfessor.setText(professorEdit.getEmail());
    }
    
    @FXML
    private void mouseClicked (MouseEvent event) {
        Professor_Orientador professor = tabelaProfessor.getSelectionModel().getSelectedItem();
        nomeProfessor.setText(professor.getNome());
        emailProfessor.setText(professor.getEmail());
        departamentoProfessor.setText(professor.getDepartamento());
        telefoneProfessor.setText(professor.getTelefone());
    }
    
    @FXML
    private void updateProfessor(){
        
        Professor_Orientador professor = tabelaProfessor.getSelectionModel().getSelectedItem();
        
        if(professor != null){
            
            if(!nomeProfessor.getText().equals("")){
                professor.setNome(nomeProfessor.getText());
            }
            if(!departamentoProfessor.getText().equals("")){
                professor.setDepartamento(departamentoProfessor.getText());
            }
            if(!telefoneProfessor.getText().equals("")){
                professor.setTelefone(telefoneProfessor.getText());
            }
            if(!emailProfessor.getText().equals("")){
                professor.setEmail(emailProfessor.getText());
            }
            pbanco.updateProfessor(professor);
            
        }
        
        refreshTable();
        limparTextField();
        
    }
    
    @FXML
    private void deleteProfessor(){
        
        pbanco.deleteProfessor(tabelaProfessor.getSelectionModel().getSelectedItem().getId_professor());
        refreshTable();
    }
    
    @FXML
    private void listarProfessores(){
        
        professores = FXCollections.observableArrayList(pbanco.listProfessor_Orientador());
                
        
        tabelaProfessor.getColumns().get(0).setCellValueFactory(new  PropertyValueFactory<>("id_professor"));
        tabelaProfessor.getColumns().get(1).setCellValueFactory(new  PropertyValueFactory<>("nome"));
        tabelaProfessor.getColumns().get(2).setCellValueFactory(new  PropertyValueFactory<>("departamento"));
        tabelaProfessor.getColumns().get(3).setCellValueFactory(new  PropertyValueFactory<>("telefone"));
        tabelaProfessor.getColumns().get(4).setCellValueFactory(new  PropertyValueFactory<>("email"));
        tabelaProfessor.setItems(professores);
        
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listarProfessores();
       
        // TODO
    }    
    
}
