package br.com.vendemais;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.vendemais.model.Cliente;
import br.com.vendemais.model.Produto;
import br.com.vendemais.repository.ProdutoRepository;
import br.com.vendemais.service.ClienteService;
import br.com.vendemais.service.ProdutoService;


@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTeste {

    @InjectMocks 
    private ProdutoService produtoService;
    @InjectMocks 
    private ClienteService clienteService;

    @Mock 
    private ProdutoRepository produtoRepository;

    @Test
    public void deveCadastrarProduto() {
        Produto produto = new Produto();
        produto.setId(1L);
        when(produtoRepository.save(produto)).thenReturn(produto);
        Produto resultado = produtoService.cadastrarProduto(produto);
        assertEquals(produto, resultado);
        
    }

    @Test
    public void deveListarProdutos() {
        Produto produto1 = new Produto();
        produto1.setId(1L);
        Produto produto2 = new Produto();
        produto2.setId(2L);
        List<Produto> produtos = List.of(produto1, produto2);
        when(produtoRepository.findAll()).thenReturn(produtos);
        assertEquals(2, produtoService.listarProdutos().size());
      
    }


    
    @Test
    public void deveAlterarPreco() {
    Produto produtoExistente = new Produto();
    produtoExistente.setPreco(new BigDecimal("300.00"));
    when(produtoRepository.findById(1L)).thenReturn(Optional.of(produtoExistente));
    when(produtoRepository.save(produtoExistente)).thenReturn(produtoExistente);
    Produto resultado = produtoService.alterarPreco(1L, new BigDecimal("600.00"));
    assertEquals(0, new BigDecimal("600.00").compareTo(resultado.getPreco()));
}



    @Test 
    public void deveAplicacrDescontoAniversaioEspeciais() {
        Produto produto = new Produto();
        produto.setPreco(new BigDecimal("200.00"));
        produto.setEmPromocao(true);
        Cliente cliente = new Cliente();
        cliente.setAniversario(LocalDate.now());
        Produto resultado = produtoService.aplicarDescontoEspeciais(produto, cliente);
        assertEquals(0, resultado.getPreco().compareTo(new BigDecimal("144.50")));
        
    }

    @Test
    public void deveAplicarDesconto(){
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setPreco(new BigDecimal("600.00"));
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));
        when(produtoRepository.save(produto)).thenReturn(produto);
        Produto resultado = produtoService.aplicarDesconto(1L, produto);
        assertEquals(0, resultado.getPreco().compareTo(new BigDecimal("420.00")));
        
    }

    @Test 
    public void deveBaixarEstoque(){
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setEstoque(8);
        Integer quantidade = 3;
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));
        when(produtoRepository.save(produto)).thenReturn(produto);
        Produto resultado = produtoService.baixarEstoque(1L, quantidade);
        assertEquals(5, resultado.getEstoque());
        
    }

    @Test 
    public void deveCalcularParcelas() {
        BigDecimal valor = new BigDecimal("500.00");
        Integer quantidade  = 5;
        BigDecimal resultado = produtoService.calcularParcelas(valor, quantidade);
        assertEquals(0, resultado.compareTo(new BigDecimal("100.00")));
        
    }

    @Test 
    public void deveCalcularParcelamento() {
        BigDecimal valor = new BigDecimal("600.00");
        BigDecimal resultado = produtoService.calcularParcelamento(valor, 6);
        assertEquals(0, resultado.compareTo(new BigDecimal("105.00")));
       
    }

    @Test
    public void deveListarProdutosAcimaDe800() {
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        produto1.setPreco(new BigDecimal("900.00"));
        produto2.setPreco(new BigDecimal("200.00"));
        List<Produto> produtos = List.of(produto1, produto2);
        when(produtoRepository.findAll()).thenReturn(produtos);
       List<Produto> resultado = produtoService.listarProdutoAcimaOitocentoReais();
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(produto1));
        assertFalse(resultado.contains(produto2));
        
    }

    @Test 
    public void deveListarProdutoAbaixoDe100(){
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        produto1.setPreco(new BigDecimal(90.00));
        produto2.setPreco(new BigDecimal(120.00));
        List<Produto> produtos = List.of(produto1, produto2);
        when(produtoRepository.findAll()).thenReturn(produtos);
        List<Produto> resultado = produtoService.listarProdutoAbaixoCemReais();
        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(produto1));
        assertFalse(resultado.contains(produto2));
    }
    
    
}
