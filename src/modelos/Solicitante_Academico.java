
package modelos;

/**
 *
 * @author Heverton
 */
public class Solicitante_Academico {
    
    private int id_solicitante;
    private String nome;
    private int id_Professor;
    private String telefone;
    private String email;

    public Solicitante_Academico(int id_solicitante,int id_Professor, String nome, String telefone, String email) {
        this.id_solicitante = id_solicitante;
        this.nome = nome;
        this.id_Professor = id_Professor;
        this.telefone = telefone;
        this.email = email;
    }

    public Solicitante_Academico(int po1, String nome, String telefone, String email) {
        this.nome = nome;
        this.id_Professor = po1;
        this.telefone = telefone;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
