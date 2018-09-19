
package modelos;

/**
 *
 * @author Heverton
 */
public class Solicitante_Academico {
    
    private String nome;
    private Professor_Orientador po1;
    private String telefone;
    private String email;

    public Solicitante_Academico(String nome, Professor_Orientador po1, String telefone, String email) {
        this.nome = nome;
        this.po1 = po1;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor_Orientador getPo1() {
        return po1;
    }

    public void setPo1(Professor_Orientador po1) {
        this.po1 = po1;
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
