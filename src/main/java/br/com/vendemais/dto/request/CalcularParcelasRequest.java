package br.com.vendemais.dto.request;
import java.math.BigDecimal;


public class CalcularParcelasRequest {
    
    BigDecimal valor;
    int quantidade;

    public CalcularParcelasRequest(BigDecimal valor, int quantidade) {
        this.valor = valor;
        this.quantidade = quantidade;
    }
    
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
