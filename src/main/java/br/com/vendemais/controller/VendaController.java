package br.com.vendemais.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendemais.dto.request.ValidarPagamentoRequest;
import br.com.vendemais.dto.request.ValidarQuantidadeItensRequest;
import br.com.vendemais.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    
    private final VendaService vendaService;
    

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping("/validar-pagamento")
    public void validarPagamento(@RequestBody ValidarPagamentoRequest request) {
        vendaService.validarPagamento(request.getFormaPagamento());
    }

    @PostMapping("/validar-quantidade-itens")
    public void validarQuantidadeItens(@RequestBody ValidarQuantidadeItensRequest request) {
        vendaService.validarQuantidadeItens(request.getQuantidadeItens());
    }
}
