/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.StringConverter;
import modelos.Responsavel;
import persistencia.ResponsavelDAO;

/**
 * FXML Controller class
 *
 * @author Heverton
 */
public class ControladorResponsavel implements Initializable {

    private Responsavel rEdit;
    
    private ResponsavelDAO rbanco = new ResponsavelDAO();
    
     private ObservableList<Responsavel> responsaveis;
    
    @FXML
    private JFXTextField nomeResponsavel;
    @FXML
    private JFXTextField assResponsavel;
    @FXML
    private JFXDatePicker dataRecebimento;
    @FXML
    private JFXTimePicker horaRecebimento;
    @FXML
    private TableView<Responsavel> tabelaResponsavel;
    @FXML
    private TableColumn<Responsavel, Integer> id_responsavelT;
    @FXML
    private TableColumn<Responsavel, String> nomeTableResponsavel;
    @FXML
    private TableColumn<Responsavel, String> assinaturaResponsavel;
    @FXML
    private JFXButton btCadastrar;
    @FXML
    private JFXButton btExcluir;
    @FXML
    private JFXButton btEditar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dataRecebimento.setConverter(data());
    }   
    
    @FXML
    private void limparTextos(){
        nomeResponsavel.clear();
        assResponsavel.clear();
        dataRecebimento.setValue(null);
        horaRecebimento.setValue(null);
    }
    
    @FXML
    private void refreshTable(){
        responsaveis.clear();
        responsaveis.addAll(rbanco.listResponsavel());
        tabelaResponsavel.setItems(responsaveis);
    }
    
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
    private void addResponsavel() throws ParseException{
       
       Date dataRecebimento = Date.valueOf(this.dataRecebimento.getValue());
       Time horaRecebimento = Time.valueOf(this.horaRecebimento.getValue());
       
        System.out.println("Hora: " + horaRecebimento);
        System.out.println("Hora: " + nomeResponsavel.getText());
        
        rEdit = new Responsavel(
                nomeResponsavel.getText(),
                dataRecebimento,
                horaRecebimento,
                assResponsavel.getText()
        );
        rbanco.insertResponsavel(rEdit);
        limparTextos();
//        refreshTable();
    }
     
    
}
