package br.com.vendemais.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
    private BigDecimal valorTotal;
    private BigDecimal valorParcelas;

    
    public Pagamento(Long id, FormaPagamento formaPagamento, BigDecimal valorTotal, BigDecimal valorParcelas) {
        this.id = id;
        this.formaPagamento = formaPagamento;
        this.valorTotal = valorTotal;
        this.valorParcelas = valorParcelas;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    public BigDecimal getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    public BigDecimal getValorParcelas() {
        return valorParcelas;
    }
    public void setValorParcelas(BigDecimal valorParcelas) {
        this.valorParcelas = valorParcelas;
    }


}
