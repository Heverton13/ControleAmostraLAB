/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Date;

/**
 *
 * @author Heverton
 */
public class Amostra_Analise {
    
    private int id_amostra_analise;
    private int id_amostra;
    private int id_analise;
    
    //TODO
    private String identificao_amostra, descricao,nome_solicitante, nome_analise; 
    private Date data_entrada;
    
    

    public Amostra_Analise(int id_amostra_analise, int id_amostra, int id_analise) {
        this.id_amostra_analise = id_amostra_analise;
        this.id_amostra = id_amostra;
        this.id_analise = id_analise;
    }

    public Amostra_Analise(int id_amostra, int id_analise) {
        this.id_amostra = id_amostra;
        this.id_analise = id_analise;
    }
    
    //Contrutor para Historico

    public Amostra_Analise(String identificao_amostra, String descricao, String nome_solicitante, Date data_entrada, String nome_analise) {
        this.identificao_amostra = identificao_amostra;
        this.descricao = descricao;
        this.nome_solicitante = nome_solicitante;
        this.nome_analise = nome_analise;
        this.data_entrada = data_entrada;
    }
    
    
   

    public int getId_amostra_analise() {
        return id_amostra_analise;
    }

    public void setId_amostra_analise(int id_amostra_analise) {
        this.id_amostra_analise = id_amostra_analise;
    }

    public int getId_amostra() {
        return id_amostra;
    }

    public void setId_amostra(int id_amostra) {
        this.id_amostra = id_amostra;
    }

    public int getId_analise() {
        return id_analise;
    }

    public void setId_analise(int id_analise) {
        this.id_analise = id_analise;
    }

    public String getIdentificao_amostra() {
        return identificao_amostra;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome_analise() {
        return nome_analise;
    }

    public String getNome_solicitante() {
        return nome_solicitante;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    @Override
    public String toString() {
        return "Amostra_Analise{" + "identificao_amostra=" + identificao_amostra + ", descricao=" + descricao + ", nome_solicitante=" + nome_solicitante + ", nome_analise=" + nome_analise + ", data_entrada=" + data_entrada + '}';
    }

    

    
    

   
    
    
}
