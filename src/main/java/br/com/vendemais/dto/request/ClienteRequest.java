package br.com.vendemais.dto.request;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ClienteRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String telefone;
    
    public ClienteRequest(@NotBlank String nome, @NotBlank String cpf, @NotBlank String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
