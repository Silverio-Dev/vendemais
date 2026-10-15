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

    //cadastrar produto//
    public Produto cadastrarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    //Listar produtos//
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    //alterar preço do produto//
    @Transactional
    public Produto alterarPreco(Long id, Produto produto) {
        Produto produtoExistente = produtoRepository.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoException("Produto nao foi encontrado"));
        if (produtoExistente.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraNegocioException("O preço do produto não pode ser negativo.");
        }
        produtoExistente.setPreco(produto.getPreco());
        return produtoRepository.save(produtoExistente);
    }

    //Desconto de Aniversário e Promoção//
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
    //Desconto de 30%//
    @Transactional
    public Produto aplicarDesconto(Long id, Produto produto){
        Produto produtoExistente = produtoRepository.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoException("Produto nao foi encontrado."));
        produtoExistente.setPreco(produto.getPreco());
        BigDecimal desconto = produtoExistente.getPreco().multiply(BigDecimal.valueOf(0.30));
        BigDecimal precoComDesconto = produtoExistente.getPreco().subtract(desconto);
        produtoExistente.setPreco(precoComDesconto);
        return produtoRepository.save(produtoExistente);
        

    }

    //Baixar estoques//
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

    //5 Parcelas sem juros//
    public BigDecimal calcularParcelas(BigDecimal valor, int quantidade) {
        if (quantidade < 1 || quantidade > 5) {
            throw new RegraNegocioException("Quantidade de parcelas deverá ser entre 1 e 5.");
        }
        return valor.divide(BigDecimal.valueOf(quantidade), 2, RoundingMode.HALF_UP);
    }


    // 6 ou mais Parcelas//
    public BigDecimal calcularParcelamento(BigDecimal valor, int quantidade) {
        if (quantidade < 6 ) {
            throw new RegraNegocioException(
                "Para esse tipo de parcelamento, são nescessarias no minimo 6 parcelas");
        }
        BigDecimal acrecimo = BigDecimal.valueOf(5);
        BigDecimal acrecimoTotal = acrecimo.multiply(BigDecimal.valueOf(quantidade));
        BigDecimal valorComAcrecimo = valor.add(acrecimoTotal);
        return valorComAcrecimo.divide(BigDecimal.valueOf(quantidade), 2, RoundingMode.HALF_UP);
    }

    //Verificação de Produto Acima de 800 Reais//
    public List<Produto> listarProdutoAcimOitocentoReais(){
        return produtoRepository.findAll()
                .stream()
                .filter(produto -> produto.getPreco()
                .compareTo(BigDecimal.valueOf(800.00)) > 0)
                .toList();
    }
    

}
