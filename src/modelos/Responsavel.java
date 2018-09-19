
package modelos;

import java.util.Date;

/**
 *
 * @author Heverton
 */
public class Responsavel {
    
    private String nome;
    private Date data;
    private String hora;
    private String assinatura;

    public Responsavel(String nome, Date data, String hora, String assinatura) {
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }
    
}
