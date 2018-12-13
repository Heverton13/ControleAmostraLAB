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
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    
    @FXML
    private void mouseClicked(MouseEvent event) {
        Responsavel responsavel = tabelaResponsavel.getSelectionModel().getSelectedItem();
        nomeResponsavel.setText(responsavel.getNome());
        assResponsavel.setText(responsavel.getAssinatura());        
        
        Instant instant = Instant.ofEpochMilli(responsavel.getData().getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        dataRecebimento.setValue(localDate);
        
        Instant instant2 = Instant.ofEpochMilli(responsavel.getHora().getTime());
        LocalTime localTime = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault()).toLocalTime();
        horaRecebimento.setValue(localTime);
        
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
    private void addResponsavel(){
       
       Date dataRecebimento = Date.valueOf(this.dataRecebimento.getValue());
       Time horaRecebimento = Time.valueOf(this.horaRecebimento.getValue());
       
        
       if (!nomeResponsavel.getText().equals("") &&
           !assResponsavel.getText().equals("") //&&
               //NAO TA APARENDO ALERTA SE DEIXAR DATA E HORA VAZIAS, MAS TAMBÉM NÃO TA DEIXANDO ADICIONAR
               //SE NAO PREENCHER
              //dataRecebimento == null  &&
              //horaRecebimento == null
               )
       {
 
        rEdit = new Responsavel(
                nomeResponsavel.getText(),
                dataRecebimento,
                horaRecebimento,
                assResponsavel.getText()
        );
        rbanco.insertResponsavel(rEdit);
        limparTextos();
        refreshTable();
        
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Campos em branco");
            alert.setContentText("Por favor, preencha todas as informações antes de adicionar");
            alert.showAndWait();
        }
   
    }
    
    @FXML
    private void deleteResponsavel(){
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Execluir Professor");
        alert.setHeaderText("Atenção, ao apagar o responsavel você apagará todos itens relacionados a ele");
        alert.setContentText("Se deseja apagar, Aperte OK");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            rbanco.deleteResponsavel(tabelaResponsavel.getSelectionModel().getSelectedItem().getId_responsavel());
        } else {
            System.out.println("Não");
        }  
        
        limparTextos();
        refreshTable();
        
    }
     
    @FXML
    private void updateResponsavel(){
        
        Responsavel r = tabelaResponsavel.getSelectionModel().getSelectedItem();
        
        if(r != null){
            
            if(!nomeResponsavel.getText().equals("")){
                r.setNome(nomeResponsavel.getText());
            }
            if(!assResponsavel.getText().equals("")){
                r.setAssinatura(assResponsavel.getText());
            }
            if(!dataRecebimento.getValue().equals("")){
                r.setData(Date.valueOf(dataRecebimento.getValue()));
            }
            
            if(!horaRecebimento.getValue().equals("")){
                r.setHora(Time.valueOf(horaRecebimento.getValue()));
            }
            
            rbanco.updateResponsavel(r);
            
        }
        
        limparTextos();
        refreshTable();
    }
    
    @FXML
    private void listResponsavel(){
        
        
        responsaveis = FXCollections.observableArrayList(rbanco.listResponsavel());
       

         tabelaResponsavel.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id_responsavel"));
         tabelaResponsavel.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("nome"));
         tabelaResponsavel.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("data"));
         tabelaResponsavel.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("hora"));
         tabelaResponsavel.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("assinatura"));
         
         tabelaResponsavel.setItems(responsaveis);
         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dataRecebimento.setConverter(data());
        listResponsavel();
                                                                                                                                                  
    }   
}
