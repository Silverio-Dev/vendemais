package br.com.vendemais.dto.request;

import java.math.BigDecimal;

public class AplicarDescontoRequest {
    
       private BigDecimal desconto;

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }
}
