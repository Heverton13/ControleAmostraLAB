
package modelos;

/**
 *
 * @author Heverton
 */
public class Solicitante_Academico {
    
    private int id_solicitante;
    private String nome,nome_professor;
    private int id_Professor;
    private String telefone;
    private String email_solicitante;

    public Solicitante_Academico(int id_solicitante,int id_Professor, String nome, String telefone, String email_solicitante) {
        this.id_solicitante = id_solicitante;
        this.nome = nome;
        this.id_Professor = id_Professor;
        this.telefone = telefone;
        this.email_solicitante = email_solicitante;
    }

    public Solicitante_Academico(int po1, String nome, String telefone, String email_solicitante) {
        this.id_Professor = po1;
        this.nome = nome;
        this.telefone = telefone;
        this.email_solicitante = email_solicitante;
    }
    
    public int getId_solicitante() {
        return id_solicitante;
    }

    public void setId_solicitante(int id_solicitante) {
        this.id_solicitante = id_solicitante;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_Professor() {
        return id_Professor;
    }

    public void setId_Professor(int id_Professor) {
        this.id_Professor = id_Professor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail_solicitante() {
        return email_solicitante;
    }

    public void setEmail_solicitante(String email_solicitante) {
        this.email_solicitante = email_solicitante;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
}
