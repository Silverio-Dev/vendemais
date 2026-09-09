package br.com.vendemais;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.vendemais.exception.RegraNegocioException;
import br.com.vendemais.repository.VendaRepository;
import br.com.vendemais.service.VendaService;

@ExtendWith (MockitoExtension.class)
public class VendaServiceTeste {

    @InjectMocks 
    private VendaService vendaService;

    @Mock
    private VendaRepository vendaRepository;
    
    @Test 
    public void deveValidarPagamento(){
        String formaPagento = "cheque";
        assertThrows(RegraNegocioException.class, () ->  vendaService.validarPagamento(formaPagento),
        "Pagamento nao é aceito.");
        System.out.println("Validação de pagamento: cheque não permitido.");
    }

    @Test
    public void deveValidarQuantidadeItens() {
        Integer quantidade = 0;
        assertThrows(RegraNegocioException.class, () -> vendaService.validarQuantidadeItens(quantidade),
    "A venda deve ter pelo menos um item.");
        System.out.println("Validação de quantidade de itens: venda sem itens não é permitida.");
    }
}
