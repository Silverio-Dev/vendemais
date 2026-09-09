package br.com.vendemais.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataVenda;
    private BigDecimal desconto;
    private BigDecimal juros;
    private BigDecimal total;  
    @ManyToOne 
    private Cliente cliente;
    @ManyToOne
    private Pagamento pagamento;
    
    public Venda(Long id, LocalDateTime dataVenda, BigDecimal desconto, BigDecimal juros, BigDecimal total,
            Cliente cliente, Pagamento pagamento) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.desconto = desconto;
        this.juros = juros;
        this.total = total;
        this.cliente = cliente;
        this.pagamento = pagamento;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }
    public BigDecimal getDesconto() {
        return desconto;
    }
    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }
    public BigDecimal getJuros() {
        return juros;
    }
    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Pagamento getPagamento() {
        return pagamento;
    }
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
}
