package br.com.vendemais.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class VendaRequest {
    @NotNull
    private Long clienteId;
    @NotEmpty
    private List<ItemVendaRequest> itens;
    
    
    public VendaRequest(@NotNull Long clienteId, @NotEmpty List<ItemVendaRequest> itens) {
        this.clienteId = clienteId;
        this.itens = itens;
    }
    public Long getClienteId() {
        return clienteId;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    public List<ItemVendaRequest> getItens() {
        return itens;
    }
    public void setItens(List<ItemVendaRequest> itens) {
        this.itens = itens;
    }
    
}
