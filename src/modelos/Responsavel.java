
package modelos;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Heverton
 */
public class Responsavel {


    private String id_amostra;

    public String getId_amostra() {
        return id_amostra;
    }

    public void setId_amostra(String id_amostra) {
        this.id_amostra = id_amostra;
    }

    public String getId_responsavel() {
        return id_responsavel;
    }

    public void setId_responsavel(String id_responsavel) {
        this.id_responsavel = id_responsavel;
    }

    public Responsavel(String id_amostra, String id_responsavel) {
        this.id_amostra = id_amostra;
        this.id_responsavel = id_responsavel;
    }
    private String id_responsavel;
    private String nome;
    private Date data;
    private Time hora;
    private String assinatura;

    public Responsavel(String nome, Date data, Time hora, String assinatura) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.assinatura = assinatura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }
    
}
