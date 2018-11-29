/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
        tabelaHistorico.getColumns().get(2).setCellValueFactory(new  PropertyValueFactory<>("frascos"));
        tabelaHistorico.getColumns().get(3).setCellValueFactory(new  PropertyValueFactory<>("nome_analise"));
        tabelaHistorico.setItems(am_an);
        
    }
    
    @FXML
    private void gerarEtiqueta(){
        
        am_anEdit = tabelaHistorico.getSelectionModel().getSelectedItem();
        
        Document doc = new Document();
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("arquivos/documento.pdf"));
            
            doc.open();
            doc.add(new Paragraph("IDENTIFICAÇÃO AMOSTRA: " + am_anEdit.getIdentificao_amostra()));
            doc.add(new Paragraph("DESCRIÇÃO: " + am_anEdit.getDescricao()));
            doc.add(new Paragraph("FRASCOS: "+ am_anEdit.getFrascos()));
            doc.add(new Paragraph("ANALISES: "+ am_anEdit.getNome_analise()));

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
