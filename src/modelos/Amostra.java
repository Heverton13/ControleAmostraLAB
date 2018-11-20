
package modelos;

import java.util.Date;

/**
 *
 * @author Heverton
 */
public class Amostra {
    
    private int id;
    private String id_amostra;
    private int id_solicitante;
    private int id_responsavel;
    private String descricao;
    private int frascos;
    private String observacoes;
    private Date data_entrada;
    
    public Amostra(int id, String id_amostra, int id_solicitante, int id_responsavel, String descricao, int frascos, String observacoes, Date data_entrada) {
        this.id = id;
        this.id_amostra = id_amostra;
        this.id_solicitante = id_solicitante;
        this.id_responsavel = id_responsavel;
        this.descricao = descricao;
        this.frascos = frascos;
        this.observacoes = observacoes;
        this.data_entrada = data_entrada;
        
    }

    public Amostra(String id_amostra, int id_solicitante, int id_responsavel, String descricao, int frascos, String observacoes, Date data_entrada) {
        
        this.id_amostra = id_amostra;
        this.id_solicitante = id_solicitante;
        this.id_responsavel = id_responsavel;
        this.descricao = descricao;
        this.frascos = frascos;
        this.observacoes = observacoes;
        this.data_entrada = data_entrada;
        
    }

    public String getId_amostra() {
        return id_amostra;
    }

    public void setId_amostra(String id_amostra) {
        this.id_amostra = id_amostra;
    }

    public int getId_solicitante() {
        return id_solicitante;
    }

    public void setId_solicitante(int id_solicitante) {
        this.id_solicitante = id_solicitante;
    }

    public int getId_responsavel() {
        return id_responsavel;
    }

    public void setId_responsavel(int id_responsavel) {
        this.id_responsavel = id_responsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFrascos() {
        return frascos;
    }

    public void setFrascos(int frascos) {
        this.frascos = frascos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    @Override
    public String toString() {
        return id_amostra;
    }
    
    
}
