
package modelos;

/**
 *
 * @author Heverton
 */
public class Responsavel_Servico {
    
    private String nome;
    private String cnpj;
    private String razao_Social;
    private String endereco;
    private String email;
    private String telefone;

    public Responsavel_Servico(String nome, String cnpj, String razao_Social, String endereco, String email, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.razao_Social = razao_Social;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_Social() {
        return razao_Social;
    }

    public void setRazao_Social(String razao_Social) {
        this.razao_Social = razao_Social;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
