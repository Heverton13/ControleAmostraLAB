
package modelos;

/**
 *
 * @author Heverton
 */
public class Amostra_Servico {
        
    private String id_amostra;
    private String descricao;
    private int frascos;
    //Private String Analise Requeridas, nessa parte sera usada enum, ainda sera visto sobre, podemos pesquisar so para demonstracao
    private String observacoes;
    private Solicitante_Servico ss; // essa parte sera revista pois pode ter mais de um solicitante, 
    private Responsavel_Servico r; // mesma coisa da de cima as proximas modelagens resolveram essa inconsistencia (heranca)
    private double valorUnidadeExame;
    private double valorTotal;

    public Amostra_Servico(String id_amostra, String descricao, int frascos, String observacoes, Solicitante_Servico ss, Responsavel_Servico r, double valorUnidadeExame, double valorTotal) {
        this.id_amostra = id_amostra;
        this.descricao = descricao;
        this.frascos = frascos;
        this.observacoes = observacoes;
        this.ss = ss;
        this.r = r;
        this.valorUnidadeExame = valorUnidadeExame;
        this.valorTotal = valorTotal;
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

    public Solicitante_Servico getSs() {
        return ss;
    }

    public void setSs(Solicitante_Servico ss) {
        this.ss = ss;
    }

    public Responsavel_Servico getR() {
        return r;
    }

    public void setR(Responsavel_Servico r) {
        this.r = r;
    }

    public double getValorUnidadeExame() {
        return valorUnidadeExame;
    }

    public void setValorUnidadeExame(double valorUnidadeExame) {
        this.valorUnidadeExame = valorUnidadeExame;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    

}
