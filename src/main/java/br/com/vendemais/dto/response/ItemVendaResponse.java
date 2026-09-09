package br.com.vendemais.dto.response;


import java.math.BigDecimal;



public class ItemVendaResponse {
    
    private Long produtoId;
    private String nomeProduto;
    private Integer quantidade;
    private BigDecimal precoProdutoMomentoCompra;
    private BigDecimal subtotal;


    public ItemVendaResponse(Long produtoId, String nomeProduto, Integer quantidade,
            BigDecimal precoProdutoMomentoCompra, BigDecimal subtotal) {
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoProdutoMomentoCompra = precoProdutoMomentoCompra;
        this.subtotal = subtotal;
    }
    public Long getProdutoId() {
        return produtoId;
    }
    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public BigDecimal getPrecoProdutoMomentoCompra() {
        return precoProdutoMomentoCompra;
    }
    public void setPrecoProdutoMomentoCompra(BigDecimal precoProdutoMomentoCompra) {
        this.precoProdutoMomentoCompra = precoProdutoMomentoCompra;
    }
    public BigDecimal getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
