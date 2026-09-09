package br.com.vendemais.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class ValidarPagamentoRequest {
    
    String formaPagamento;

    public ValidarPagamentoRequest(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
