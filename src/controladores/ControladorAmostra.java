/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import modelos.Amostra;
import modelos.Responsavel;
import modelos.Solicitante_Academico;
import persistencia.AmostraDAO;
import persistencia.ResponsavelDAO;
import persistencia.SolicitanteDAO;

/**
 * FXML Controller class
 *
 * @author Denys
 */
public class ControladorAmostra implements Initializable {

    private AmostraDAO aBanco = new AmostraDAO();
    
    private ResponsavelDAO rBanco = new ResponsavelDAO();
    
    private SolicitanteDAO sBanco = new SolicitanteDAO();
    
    private Amostra amostraEdit;
    
    private ObservableList<Solicitante_Academico> solicitantes = FXCollections.observableArrayList();
    
    private ObservableList<Responsavel> responsaveis = FXCollections.observableArrayList();
    
    private ObservableList<Amostra> amostras;
    
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
    private TableView<Amostra> TabelaAmostra;

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
    
    @FXML
    private JFXButton btSelecionarAnalise;
    
    @FXML
    private JFXComboBox<Solicitante_Academico> comboSolicitante;

    @FXML
    private JFXComboBox<Responsavel> comboResponsavel;
    /**
     * Initializes the controller class.
     */
    // Esse método converte minha data
    private StringConverter<LocalDate> data(){
        
        String pattern = "yyyy-MM-dd";
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>(){
            DateTimeFormatter formatar = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if(date != null){
                    return formatar.format(date);
                }else{
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if(string != null && !string.isEmpty()){
                    return LocalDate.parse(string,formatar);
                }else{
                    return null;
                }
            }
            
        };
        return converter;
    }
    
    @FXML
    private void limparTextFild(){
        idAmostra.clear();
        descricaoAmostra.clear();
        obervacoesAmostra.clear();
        frascosAmostra.clear();
        dataAmostra.setValue(null);
    }
    @FXML
    private void refreshTable(){
        amostras.clear();
        amostras.addAll(aBanco.list());
        TabelaAmostra.setItems(amostras);
                
    }
    
    @FXML
    private void mouseClicked(MouseEvent event) {
        Amostra amostras = TabelaAmostra.getSelectionModel().getSelectedItem();
        idAmostra.setText(amostras.getId_amostra());
        descricaoAmostra.setText(amostras.getDescricao());
        frascosAmostra.setText(Integer.toString(amostras.getFrascos()));
        obervacoesAmostra.setText(amostras.getObservacoes());
        dataAmostra.setValue(null);
    }
    
    @FXML
    private void addAmostra(){
        
        Date dataEntrega = Date.valueOf(this.dataAmostra.getValue());
        
        int frascos = Integer.parseInt(frascosAmostra.getText());
        
        amostraEdit = new Amostra(
                idAmostra.getText(),
                comboResponsavel.getSelectionModel().getSelectedItem().getId_responsavel(),
                comboSolicitante.getSelectionModel().getSelectedItem().getId_solicitante(),
                descricaoAmostra.getText(),
                frascos,
                obervacoesAmostra.getText(),
                dataEntrega
        );
        System.out.println(amostraEdit);
        aBanco.add(amostraEdit);
        limparTextFild();
        refreshTable();
    }
    
    @FXML
    private void updateAmostra(){
         
        Amostra a = TabelaAmostra.getSelectionModel().getSelectedItem();
        
        
        if(a != null){
            
            if(!idAmostra.getText().equals("")){
                a.setId_amostra(idAmostra.getText());
                
            }
            
            if(!descricao.getText().equals("")){
                a.setDescricao(descricaoAmostra.getText());
            }
            
            if(!obervacoesAmostra.getText().equals("")){
                a.setObservacoes(obervacoesAmostra.getText());
            }
            
            if(!frascosAmostra.getText().equals("")){
                int frasco = Integer.parseInt(frascosAmostra.getText());
                a.setFrascos(frasco);
            }
            aBanco.update(a);
            
        }
        
      
       
        limparTextFild();
        refreshTable();
        
    }
    
    @FXML
    private void deletarAmostra(){
        
        aBanco.remove(TabelaAmostra.getSelectionModel().getSelectedItem().getId());
        limparTextFild();
        refreshTable();
        
    }
    
    @FXML
    private void telaSelectAnalisesRequiridas() throws Exception {
        Stage s1 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/telasFX/TelaSelectAnalisesRequiridas.fxml"));
        Scene scene = new Scene(root);

        s1.setScene(scene);
        s1.show();
    }
    
    @FXML
    private void listarAmostras(){
        
        amostras = FXCollections.observableArrayList(aBanco.list());
        
        TabelaAmostra.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        TabelaAmostra.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("id_amostra"));
        TabelaAmostra.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("descricao"));
        TabelaAmostra.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("frascos"));
        TabelaAmostra.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("id_responsavel"));
        TabelaAmostra.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("id_solicitante"));
        TabelaAmostra.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("observacoes"));
        TabelaAmostra.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("data_entrada"));
        
        TabelaAmostra.setItems(amostras);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dataAmostra.setConverter(data());
        
        responsaveis.addAll(rBanco.listResponsavel());
        comboResponsavel.setItems(responsaveis);
        solicitantes.addAll(sBanco.listSolicitante());
        comboSolicitante.setItems(solicitantes);
        listarAmostras();
        
    }   
 }
        