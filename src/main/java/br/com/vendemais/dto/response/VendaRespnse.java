package br.com.vendemais.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public class VendaRespnse {
     private Long Id;
     private LocalDateTime dataVenda;
     private Long clienteId;
     private List<ItemVendaResponse> itens;
     private BigDecimal desconto;
     private BigDecimal juros;
     private BigDecimal total;

     
     public VendaRespnse(Long id, LocalDateTime dataVenda, Long clienteId, List<ItemVendaResponse> itens,
               BigDecimal desconto, BigDecimal juros, BigDecimal total) {
          Id = id;
          this.dataVenda = dataVenda;
          this.clienteId = clienteId;
          this.itens = itens;
          this.desconto = desconto;
          this.juros = juros;
          this.total = total;
     }
     public Long getId() {
          return Id;
     }
     public void setId(Long id) {
          Id = id;
     }
     public LocalDateTime getDataVenda() {
          return dataVenda;
     }
     public void setDataVenda(LocalDateTime dataVenda) {
          this.dataVenda = dataVenda;
     }
     public Long getClienteId() {
          return clienteId;
     }
     public void setClienteId(Long clienteId) {
          this.clienteId = clienteId;
     }
     public List<ItemVendaResponse> getItens() {
          return itens;
     }
     public void setItens(List<ItemVendaResponse> itens) {
          this.itens = itens;
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
}
