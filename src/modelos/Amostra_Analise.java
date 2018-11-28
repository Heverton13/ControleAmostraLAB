/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Heverton
 */
public class Amostra_Analise {
    
    private int id_amostra_analise;
    private int id_amostra;
    private int id_analise;
    // Abaixo para histórico
    private Amostra am = new Amostra();
    private Analises anal = new Analises();    
    
    

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
    public Amostra_Analise(String identificao_amostra,String descricao, int frascos, String nome_analise){
        am.setId_amostra(identificao_amostra);
        am.setDescricao(descricao);
        am.setFrascos(frascos);
        anal.setNome_analise(nome_analise);
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

    public Amostra getAm() {
        return am;
    }

    public void setAm(Amostra am) {
        this.am = am;
    }

    public Analises getAnal() {
        return anal;
    }

    public void setAnal(Analises anal) {
        this.anal = anal;
    }
    /*
    public static void main(String[] args) {
        Amostra_Analise an = null;
        an.getAm().getId_amostra();
    }
    */
    
}
