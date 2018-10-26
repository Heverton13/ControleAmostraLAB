
package modelos;

import java.util.Date;

/**
 *
 * @author Heverton
 */
public class Amostra {
    
    private String id_amostra;
    private String descricao;
    private int frascos;
    private String observacoes;
    private Date data_entrada;
    private String id_Solicitante;  
    private String id_Responsavel; 
    
    enum Analises_Requeridas {
    UMIDADE, MATERIA_SECA, MATERIA_MINERAL, EXTRATO_ETEREO, PROTEINA_BRUTA, FIBRA_EM_DERTERGENTE_ACIDO, 
    FIBRA_EM_DERTEGENTE_NEUTRO,PROTEINA_INSULUVEL_EM_DETERGENTE_NEUTRO, 
    PROTEINA_INSULUVEL_EM_DETERGENTE_ACIDO, CARBOIDRATOS_TOTAIS, CARBOIDRATOS_NAO_FIBROSOS,
    LIGNINA, CELULOSE, 	HEMICELULOSE, ENERGIA_DISGESTIVEL, NUTRIENTES_DIGESTIVOS_TOTAIS;
    };
    private String analises_aequeridas;

    public Amostra(String id_amostra, String descricao, int frascos, String observacoes, Date data_entrada, String id_Solicitante, String id_Responsavel, String ar) {
        this.id_amostra = id_amostra;
        this.descricao = descricao;
        this.frascos = frascos;
        this.observacoes = observacoes;
        this.data_entrada = data_entrada;
        this.id_Solicitante = id_Solicitante;
        this.id_Responsavel = id_Responsavel;
        this.analises_aequeridas = ar;
    }

    public String getId_amostra() {
        return id_amostra;
    }

    public void setId_amostra(String id_amostra) {
        this.id_amostra = id_amostra;
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

    public String getId_Solicitante() {
        return id_Solicitante;
    }

    public void setId_Solicitante(String id_Solicitante) {
        this.id_Solicitante = id_Solicitante;
    }

    public String getId_Responsavel() {
        return id_Responsavel;
    }

    public void setId_Responsavel(String id_Responsavel) {
        this.id_Responsavel = id_Responsavel;
    }

    public String getAnalises_aequeridas() {
        return analises_aequeridas;
    }

    public void setAnalises_aequeridas(String analises_aequeridas) {
        this.analises_aequeridas = analises_aequeridas;
    }
    
        
}
