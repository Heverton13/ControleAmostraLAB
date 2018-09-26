
package modelos.futuros;

/**
 *
 * @author Heverton
 */
public class Solicitante_Servico {
    
    private String cnpj;
    private String razao_Social;
    private String endereco;
    private String cidade;
    private String contato;
    private String email;
    private String telefone;

    public Solicitante_Servico(String cnpj, String razao_Social, String endereco, String cidade, String contato, String email, String telefone) {
        this.cnpj = cnpj;
        this.razao_Social = razao_Social;
        this.endereco = endereco;
        this.cidade = cidade;
        this.contato = contato;
        this.email = email;
        this.telefone = telefone;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
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
