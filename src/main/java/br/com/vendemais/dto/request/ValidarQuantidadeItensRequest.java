package br.com.vendemais.dto.request;



public class ValidarQuantidadeItensRequest {
    
    Integer quantidadeItens;
    
    public ValidarQuantidadeItensRequest(Integer quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }
    public Integer getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(Integer quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

}
