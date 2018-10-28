
package modelos;

/**
 *
 * @author Heverton
 */
public class Solicitante_Academico {
    
    private String id_solicitante;

    public String getId_solicitante() {
        return id_solicitante;
    }

    public void setId_solicitante(String id_solicitante) {
        this.id_solicitante = id_solicitante;
    }

    public Solicitante_Academico(String id_solicitante) {
        this.id_solicitante = id_solicitante;
    }
    private String nome;
    private String id_Professor;
    private String telefone;
    private String email;

    public Solicitante_Academico(String nome, String po1, String telefone, String email) {
        this.nome = nome;
        this.id_Professor = po1;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId_Professor() {
        return id_Professor;
    }

    public void setId_Professor(String id_Professor) {
        this.id_Professor = id_Professor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
