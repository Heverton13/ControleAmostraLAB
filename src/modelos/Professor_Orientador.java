
package modelos;

/**
 *
 * @author Heverton
 */
public class Professor_Orientador {
    
    private String nome;
    private String departamento;
    private String telefone;
    private String email;

    public Professor_Orientador(String nome, String departamento, String telefone, String email) {
        this.nome = nome;
        this.departamento = departamento;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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
