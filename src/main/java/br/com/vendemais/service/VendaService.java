package br.com.vendemais.service;

import org.springframework.stereotype.Service;

import br.com.vendemais.exception.RegraNegocioException;
import br.com.vendemais.repository.VendaRepository;

@Service
public class VendaService {
    
    private final VendaRepository vendaRepository;
 

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    //Validação de Pagamento//
    public void validarPagamento(String formaPagamento){
        if ("cheque".equals(formaPagamento)) {
            throw new RegraNegocioException("Essa forma de pagamento não é permitida.");
        }
    }
    
    //Validação de Quantidade de Itens//
    public void validarQuantidadeItens(Integer quantidadeItens) {
        if (quantidadeItens < 1) {
            throw new RegraNegocioException("A venda deve ter pelo menos um item.");
        }
    }

    
}
