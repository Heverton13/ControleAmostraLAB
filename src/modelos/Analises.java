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
public class Analises {
    
    private int id_analise;
    private String nome_analise;

    public Analises(int id_analise, String nome_analise) {
        this.id_analise = id_analise;
        this.nome_analise = nome_analise;
    }

    public Analises(String nome_analise) {
        this.nome_analise = nome_analise;
    }

    public int getId_analise() {
        return id_analise;
    }

    public void setId_analise(int id_analise) {
        this.id_analise = id_analise;
    }

    public String getNome_analise() {
        return nome_analise;
    }

    public void setNome_analise(String nome_analise) {
        this.nome_analise = nome_analise;
    }

    @Override
    public String toString() {
        return nome_analise;
    }
    
    
    
}
