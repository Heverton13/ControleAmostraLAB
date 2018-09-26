
package modelos;

/**
 *
 * @author Heverton
 */
public class Amostra {
    
    private String id_amostra;
    private String descricao;
    private int frascos;
    private String observacoes;
    private Solicitante_Academico sa;  
    private Responsavel r; 

    public Amostra(String id_amostra, String descricao, int frascos, String observacoes, Solicitante_Academico sa, Responsavel r) {
        this.id_amostra = id_amostra;
        this.descricao = descricao;
        this.frascos = frascos;
        this.observacoes = observacoes;
        this.sa = sa;
        this.r = r;
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

    public Solicitante_Academico getSa() {
        return sa;
    }

    public void setSa(Solicitante_Academico sa) {
        this.sa = sa;
    }

    public Responsavel getR() {
        return r;
    }

    public void setR(Responsavel r) {
        this.r = r;
    }
        
}
