/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

import modelos.Amostra_Analise;
import persistencia.AmostraEmAnaliseDAO;

/**
 * FXML Controller class
 *
 * @author Heverton
 */
public class TelaHistoricoController implements Initializable {

    private AmostraEmAnaliseDAO amDAO = new AmostraEmAnaliseDAO();
    
    private Amostra_Analise am_anEdit;
    
    private ObservableList<Amostra_Analise> am_an;
    
    @FXML
    private TableView<Amostra_Analise> tabelaHistorico;
    @FXML
    private TableColumn<?, ?> colunaAmostra;
    @FXML
    private TableColumn<?, ?> colunaDescricao;
    @FXML
    private TableColumn<?, ?> colunaFrascos;
    @FXML
    private TableColumn<?, ?> colunaAR;
    @FXML
    private JFXButton btGerarEtiqueta;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void listHistorico(){
        
        am_an = FXCollections.observableArrayList(amDAO.listAnalise_Amostra());
        
        
        tabelaHistorico.getColumns().get(0).setCellValueFactory(new  PropertyValueFactory<>("identificao_amostra"));
        tabelaHistorico.getColumns().get(1).setCellValueFactory(new  PropertyValueFactory<>("descricao"));
        tabelaHistorico.getColumns().get(2).setCellValueFactory(new  PropertyValueFactory<>("nome_solicitante"));
        tabelaHistorico.getColumns().get(3).setCellValueFactory(new  PropertyValueFactory<>("nome_analise"));
        tabelaHistorico.getColumns().get(4).setCellValueFactory(new  PropertyValueFactory<>("data_entrada"));
        tabelaHistorico.setItems(am_an);
        
    }
    
    @FXML
    private void gerarEtiqueta(){
        
        am_anEdit = tabelaHistorico.getSelectionModel().getSelectedItem();
        
        Document doc = new Document();
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("arquivos/documento.pdf"));
             
            doc.open();
            Font ft = new Font(FontFamily.TIMES_ROMAN, 10.0f, Font.BOLD, BaseColor.BLACK);
            Font f = new Font(FontFamily.TIMES_ROMAN, 7.0f, Font.NORMAL, BaseColor.BLACK);
            
            doc.add(new Paragraph(am_anEdit.getIdentificao_amostra(),ft));
            doc.add(new Paragraph("TIPO AMOSTRA: " + am_anEdit.getDescricao(),f));
            doc.add(new Paragraph("SOLICITANTE: " + am_anEdit.getNome_solicitante(),f));
            doc.add(new Paragraph("DATA ENTRADA: " + am_anEdit.getData_entrada(),f));
            doc.add(new Paragraph("ANÁLISES: " + am_anEdit.getNome_analise(),f));
            
            
            Alert dialogoErro = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType btnSim = new ButtonType("Sim",ButtonData.CANCEL_CLOSE);
            ButtonType btnNao = new ButtonType("Não",ButtonData.CANCEL_CLOSE);
            //Apresentação
            dialogoErro.setTitle("Geração de Etiquetas");
            dialogoErro.setHeaderText("Geração em Andamento");
            dialogoErro.setContentText("ATENÇÃO! INFORME SE DESEJA ADICIONAR MAIS ETIQUETAS A FOLHA!");
            dialogoErro.getButtonTypes().setAll(btnSim, btnNao);
            
            Optional<ButtonType> result =  dialogoErro.showAndWait();
            
            if(result.get() == btnSim){
              
            
            }else{
                btnNao.getButtonData();
            }
            
            
        } catch (FileNotFoundException | DocumentException ex) {
            System.err.println("Erro: "+ex);
        }finally{
            doc.close();
        }
        
        
        try {
            Desktop.getDesktop().open(new File("arquivos/documento.pdf"));
        } catch (IOException ex) {
            System.err.println("Erro: "+ex);
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listHistorico();
    }    
    
}
