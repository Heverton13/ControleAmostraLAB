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
        aBanco.inserirAmostra(amostraEdit);
        limparTextFild();
    }
    
    @FXML
    private void telaSelectAnalisesRequiridas() throws Exception {
        Stage s1 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/telasFX/TelaSelectAnalisesRequiridas.fxml"));
        Scene scene = new Scene(root);

        s1.setScene(scene);
        s1.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dataAmostra.setConverter(data());
        
        responsaveis.addAll(rBanco.listResponsavel());
        comboResponsavel.setItems(responsaveis);
        solicitantes.addAll(sBanco.listSolicitante());
        comboSolicitante.setItems(solicitantes);
        
    }   
 }
        