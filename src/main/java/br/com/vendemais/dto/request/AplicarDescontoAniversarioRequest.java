package br.com.vendemais.dto.request;

import br.com.vendemais.model.Cliente;
import br.com.vendemais.model.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class AplicarDescontoAniversarioRequest {
    
    Produto produto;
    Cliente cliente;

    
    public AplicarDescontoAniversarioRequest(Produto produto, Cliente cliente) {
        this.produto = produto;
        this.cliente = cliente;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
