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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Denys
 */
public class ControladorAmostra implements Initializable {

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
    private TableView<?> TabelaAmostra;

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
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  
    @FXML
      private void telaSelectAnalisesRequiridas() throws Exception {
        
		Parent root = FXMLLoader.load(getClass().getResource("/telasFX/TelaSelectAnalisesRequiridas.fxml"));
                Scene scene = new Scene(root);
                System.out.println("tste");
                
                Stage stage = null;
                stage.setTitle("Selecionar Analises");
                stage.setScene(scene);
                stage.show();
                 
    } 
    
   /* @FXML
    protected void telaSelectAnalisesRequiridas(ActionEvent event) {
 
        try {

            Parent root = FXMLLoader.load(getClass().getResource("TelaSelectAnalisesRequiridas.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 400, 240);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
       
} */
    }
        