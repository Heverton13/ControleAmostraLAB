
package modelos;

/**
 *
 * @author Heverton
 */
public class Professor_Orientador {
   
    
    private int id_professor;   
    private String nome;
    private String departamento;
    private String telefone;
    private String email;

    public Professor_Orientador(int id_professor, String nome, String departamento, String telefone, String email) {
        this.id_professor = id_professor;
        this.nome = nome;
        this.departamento = departamento;
        this.telefone = telefone;
        this.email = email;
    }

    public Professor_Orientador(String nome, String departamento, String telefone, String email) {
        this.nome = nome;
        this.departamento = departamento;
        this.telefone = telefone;
        this.email = email;
    }
    
    public Professor_Orientador(){
        
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
    
    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }

    @Override
    public String toString() {
        return nome;
    }

      
}
