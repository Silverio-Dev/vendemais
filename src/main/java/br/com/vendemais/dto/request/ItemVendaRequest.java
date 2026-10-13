package br.com.vendemais.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ItemVendaRequest {

    @NotNull
    private Long produtoId;
    @Positive
    private Integer quantidade;
    
    
    public ItemVendaRequest(@NotNull Long produtoId, @Positive Integer quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    
    public Long getProdutoId() {
        return produtoId;
    }
    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
}
