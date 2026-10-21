package br.com.vendemais.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import br.com.vendemais.exception.EstoqueInsuficienteException;
import br.com.vendemais.exception.RecursoNaoEncontradoException;
import br.com.vendemais.exception.RegraNegocioException;
import br.com.vendemais.model.Cliente;
import br.com.vendemais.model.Produto;
import br.com.vendemais.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;


    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    
    public Produto cadastrarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    
    @Transactional
    public Produto alterarPreco(Long id, BigDecimal preco) {
    Produto produtoExistente = produtoRepository.findById(id)
            .orElseThrow(() ->
                    new RecursoNaoEncontradoException("Produto nao foi encontrado"));
    if (preco == null || preco.compareTo(BigDecimal.ZERO) <= 0) {
        throw new RegraNegocioException("O preço deve ser maior que zero.");
    }
    produtoExistente.setPreco(preco);
    return produtoRepository.save(produtoExistente);

    }

    
   
    public Produto aplicarDescontoEspeciais(Produto produto, Cliente cliente) {
        if (cliente.getAniversario().getDayOfMonth() == LocalDate.now().getDayOfMonth() &&
        cliente.getAniversario().getMonth() == LocalDate.now().getMonth()) {
            BigDecimal desconto = produto.getPreco().multiply(BigDecimal.valueOf(0.15));
            produto.setPreco(produto.getPreco().subtract(desconto));
        }
        if (produto.isEmPromocao()) {
            BigDecimal descontoPromocao =produto.getPreco()
            .multiply(BigDecimal.valueOf(0.15));

            produto.setPreco(produto.getPreco().subtract(descontoPromocao));
        }
        return produto;

    }
    
   @Transactional
public Produto aplicarDesconto(Long id, BigDecimal desconto) {
    Produto produto = produtoRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Produto nao foi encontrado."));
    if (desconto == null
            || desconto.compareTo(BigDecimal.ZERO) <= 0
            || desconto.compareTo(BigDecimal.valueOf(100)) > 0) {
        throw new IllegalArgumentException("O desconto deve ser maior que 0 e menor ou igual a 100.");
    }
    BigDecimal percentual = desconto.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);
    BigDecimal valorDesconto = produto.getPreco().multiply(percentual);
    BigDecimal novoPreco = produto.getPreco().subtract(valorDesconto);
    produto.setPreco(novoPreco.setScale(2, RoundingMode.HALF_UP));
    return produtoRepository.save(produto);


    }

    
    @Transactional
    public Produto baixarEstoque(Long produtoId, Integer quantidade) {
        Produto produto = produtoRepository.findById(produtoId)
        .orElseThrow(() -> new RecursoNaoEncontradoException("Produto nao foi encontrado."));
        if (quantidade > produto.getEstoque()) {
            throw new EstoqueInsuficienteException(
                "Estoque insuficiente para o produto."
            );
        }
        produto.setEstoque(produto.getEstoque() - quantidade);
        return produtoRepository.save(produto);
    }

    
    public BigDecimal calcularParcelas(BigDecimal valor, int quantidade) {
        if (quantidade < 1 || quantidade > 4) {
            throw new RegraNegocioException("Quantidade de parcelas deverá ser entre 1 e 3.");
        }
        return valor.divide(BigDecimal.valueOf(quantidade), 2, RoundingMode.HALF_UP);
    }


  
    public BigDecimal calcularParcelamento(BigDecimal valor, int quantidade) {
        if (quantidade <= 5 || quantidade >= 12) {
            throw new RegraNegocioException(
                "Para esse tipo de parcelamento, são nescessarias no minimo 5 parcelas e no maximo 12");
        }
        BigDecimal acrecimo = BigDecimal.valueOf(5);
        BigDecimal acrecimoTotal = acrecimo.multiply(BigDecimal.valueOf(quantidade));
        BigDecimal valorComAcrecimo = valor.add(acrecimoTotal);
        return valorComAcrecimo.divide(BigDecimal.valueOf(quantidade), 2, RoundingMode.HALF_UP);
    }

    public List<Produto> listarProdutoAcimaOitocentoReais(){
        return produtoRepository.findAll()
                .stream()
                .filter(produto -> produto.getPreco()
                .compareTo(BigDecimal.valueOf(800.00)) > 0)
                .toList();
    }

    public List<Produto> listarProdutoAbaixoCemReais(){
        return produtoRepository.findAll()
        .stream().filter(produto -> produto.getPreco()
        .compareTo(BigDecimal.valueOf(100)) < 0)
        .toList();
    }
    

}
