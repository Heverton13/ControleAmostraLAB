
package modelos;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Heverton
 */
public class Responsavel {
    
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
