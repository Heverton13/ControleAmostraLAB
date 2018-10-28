
package modelos;

import java.util.Date;

/**
 *
 * @author Heverton
 */
public class Amostra {
    
    private String id_amostra;
    private int id_solicitante;
    private int id_responsavel;
    private String descricao;
    private int frascos;
    private String observacoes;
    private Date data_entrada;
    
    public enum Analises_Requeridas {
    UMIDADE, MATERIA_SECA, MATERIA_MINERAL, EXTRATO_ETEREO, PROTEINA_BRUTA, FIBRA_EM_DERTERGENTE_ACIDO, 
    FIBRA_EM_DERTEGENTE_NEUTRO,PROTEINA_INSULUVEL_EM_DETERGENTE_NEUTRO, 
    PROTEINA_INSULUVEL_EM_DETERGENTE_ACIDO, CARBOIDRATOS_TOTAIS, CARBOIDRATOS_NAO_FIBROSOS,
    LIGNINA, CELULOSE, 	HEMICELULOSE, ENERGIA_DISGESTIVEL, NUTRIENTES_DIGESTIVOS_TOTAIS;
    };
    private String analises_aequeridas;

    public Amostra(String id_amostra, int id_solicitante, int id_responsavel, String descricao, int frascos, String observacoes, Date data_entrada, String analises_aequeridas) {
        this.id_amostra = id_amostra;
        this.id_solicitante = id_solicitante;
        this.id_responsavel = id_responsavel;
        this.descricao = descricao;
        this.frascos = frascos;
        this.observacoes = observacoes;
        this.data_entrada = data_entrada;
        this.analises_aequeridas = analises_aequeridas;
    }

    public Amostra(int id_solicitante, int id_responsavel, String id_amostra, String descricao, int frascos, String observacoes, Date data_entrada, String analises_aequeridas) {
        
        this.id_solicitante = id_solicitante;
        this.id_responsavel = id_responsavel;
        this.id_amostra = id_amostra;
        this.descricao = descricao;
        this.frascos = frascos;
        this.observacoes = observacoes;
        this.data_entrada = data_entrada;
        this.analises_aequeridas = analises_aequeridas;
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
    
    public String getAnalises_aequeridas() {
        return analises_aequeridas;
    }

    public void setAnalises_aequeridas(String analises_aequeridas) {
        this.analises_aequeridas = analises_aequeridas;
    }

    
    
}
