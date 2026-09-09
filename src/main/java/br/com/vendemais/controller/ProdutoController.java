package br.com.vendemais.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendemais.dto.request.AplicarDescontoAniversarioRequest;
import br.com.vendemais.dto.request.CalcularParcelasRequest;
import br.com.vendemais.model.Produto;
import br.com.vendemais.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    private final ProdutoService produtoService;
    
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PutMapping("{id}/produto")
    public Produto altetrarPreco(@PathVariable Long id, @RequestBody Produto produto){
        return produtoService.alterarPreco(id, produto);
    }

    @PutMapping("/desconto-aniversario")
        public Produto aplicarDescontoAniversario(@RequestBody AplicarDescontoAniversarioRequest request) {
            return produtoService.aplicarDescontoEspeciais(request.getProduto(), request.getCliente());
    }

    @PutMapping("{id}/desconto")
    public Produto aplicarDesconto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.aplicarDesconto(id, produto);
    }

    @PutMapping("/{produtoId}/baixa-estoque/")
    public Produto baixarEstoque(@PathVariable Long produtoId, @RequestBody Integer quantidade) {
        return produtoService.baixarEstoque(produtoId, quantidade);
    }

    @PostMapping("/cadastrar")
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return produtoService.cadastrarProduto(produto);
    }

    @PostMapping("/parcelas")
    public BigDecimal calcularParcelas(@RequestBody CalcularParcelasRequest request) {
        return produtoService.calcularParcelas(request.getValor(), request.getQuantidade());
    }

    @PostMapping("/parcelamento")
    public BigDecimal calcularParcelamento(@RequestBody CalcularParcelasRequest request) {
        return produtoService.calcularParcelamento(request.getValor(), request.getQuantidade());
    }

    @GetMapping()
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/verificar-acima-oito-centos")
    public boolean verificarProdutoAcimaDeOitoCentosReais(@RequestBody Produto produto) {
        return produtoService.verificarProdutoAcimaDeOitoCentosReais(produto);
    }

}
