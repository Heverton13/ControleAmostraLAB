/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import modelos.Amostra_Analise;
import persistencia.AmostraEmAnaliseDAO;
import sun.rmi.runtime.Log;

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
    private void refreshTable() {
        am_an.clear();
        am_an.addAll(amDAO.listAnalise_Amostra());
        tabelaHistorico.setItems(am_an);
    }

    @FXML
    private void deleteEtiqueta() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Execluir Etiquta");
        alert.setHeaderText("Ateção, Ao apagar etiqueta você precisara adicionar novamente a analise a amostra");
        alert.setContentText("Se deseja apagar, Aperte OK");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            amDAO.deleteAnaliseAmostra(tabelaHistorico.getSelectionModel().getSelectedItem().getId_amostra_analise());
            refreshTable();
        } else {

        }

    }

    @FXML
    private void listHistorico() {

        am_an = FXCollections.observableArrayList(amDAO.listAnalise_Amostra());

        tabelaHistorico.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id_amostra_analise"));
        tabelaHistorico.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("identificao_amostra"));
        tabelaHistorico.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tabelaHistorico.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("nome_solicitante"));
        tabelaHistorico.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("data_entrada"));
        tabelaHistorico.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("nome_analise"));
        tabelaHistorico.setItems(am_an);

    }

    @FXML
    private void gerarEtiqueta() {

        int cont = 0;
        am_an = tabelaHistorico.getSelectionModel().getSelectedItems();

        Document doc = new Document();

        try {
            PdfWriter.getInstance(doc, new FileOutputStream("arquivos/Etiquetas.pdf"));

            doc.open();
            Font ft = new Font(FontFamily.TIMES_ROMAN, 10.0f, Font.BOLD, BaseColor.BLACK);
            Font f = new Font(FontFamily.TIMES_ROMAN, 7.0f, Font.NORMAL, BaseColor.BLACK);
            Font lista = new Font(FontFamily.HELVETICA, 13.0f, Font.BOLD, BaseColor.BLACK);

            Paragraph p1 = new Paragraph(" LISTAGEM DE ETIQUETAS ", lista);
            p1.setAlignment(Element.ALIGN_CENTER);
            doc.add(p1);

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setSpacingAfter(35f);
            table.setSpacingBefore(35f);

            for (int i = 0; i < am_an.size(); i++) {

                String dados = dados = am_an.get(i).getIdentificao_amostra()
                        + "\n" + "TIPO AMOSTRA: " + am_an.get(i).getDescricao()
                        + "\n" + "SOLICITANTE: " + am_an.get(i).getNome_solicitante()
                        + "\n" + "DATA ENTRADA: " + am_an.get(i).getData_entrada()
                        + "\n" + "ANÁLISES: " + am_an.get(i).getNome_analise() + "\n";

                PdfPCell cell = new PdfPCell(new Paragraph(dados, f));
                //System.out.println(dados); 
                cell.setPadding(10);

                table.addCell(cell);
                //System.out.println(cell);

                //Log.i("VDC", ""+dados);
                cont++;
            }
            doc.add(table);
            doc.add(new Paragraph("  "));

        } catch (FileNotFoundException | DocumentException ex) {
            System.err.println("Erro: " + ex);
        } finally {

            doc.close();
        }

        try {
            Desktop.getDesktop().open(new File("arquivos/Etiquetas.pdf"));
        } catch (IOException ex) {
            System.err.println("Erro: " + ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabelaHistorico.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listHistorico();
    }

}
