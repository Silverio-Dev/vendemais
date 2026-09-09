package br.com.vendemais.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Produto {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nome;
   private BigDecimal preco;
   private Integer estoque;
   private String categoria;
   private Integer quantidade;
   private String descricao;
   private boolean emPromocao;

   
   public Produto(Long id, String nome, BigDecimal preco, Integer estoque, String categoria, Integer quantidade,
         String descricao, boolean emPromocao) {
      this.id = id;
      this.nome = nome;
      this.preco = preco;
      this.estoque = estoque;
      this.categoria = categoria;
      this.quantidade = quantidade;
      this.descricao = descricao;
      this.emPromocao = emPromocao;
   }

   public Produto(){
      
   }
   public Long getId() {
      return id;
   }
   public void setId(Long id) {
      this.id = id;
   }
   public String getNome() {
      return nome;
   }
   public void setNome(String nome) {
      this.nome = nome;
   }
   public BigDecimal getPreco() {
      return preco;
   }
   public void setPreco(BigDecimal preco) {
      this.preco = preco;
   }
   public Integer getEstoque() {
      return estoque;
   }
   public void setEstoque(Integer estoque) {
      this.estoque = estoque;
   }
   public String getCategoria() {
      return categoria;
   }
   public void setCategoria(String categoria) {
      this.categoria = categoria;
   }
   public Integer getQuantidade() {
      return quantidade;
   }
   public void setQuantidade(Integer quantidade) {
      this.quantidade = quantidade;
   }
   public String getDescricao() {
      return descricao;
   }
   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }
   public boolean isEmPromocao() {
      return emPromocao;
   }
   public void setEmPromocao(boolean emPromocao) {
      this.emPromocao = emPromocao;
   }
}
