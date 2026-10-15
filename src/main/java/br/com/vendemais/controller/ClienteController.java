package br.com.vendemais.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.vendemais.dto.response.ClienteResponse;
import br.com.vendemais.model.Cliente;
import br.com.vendemais.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
 
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    @GetMapping
    public List<ClienteResponse> listarClientes() {
        return clienteService.listarClientes()
        .stream()
        .map(cliente -> new ClienteResponse( 
            cliente.getId(),
            cliente.getNome(),
            cliente.getCpf(),
            cliente.getTelefone()
        ))
        .toList();
    }

    @GetMapping({"/{id}"})
    public ClienteResponse buscarClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        return new ClienteResponse(
            cliente.getId(),
            cliente.getNome(),
            cliente.getCpf(),
            cliente.getTelefone()
        );
    }

    @PostMapping
    public List<ClienteResponse> cadastrarClientes(@RequestBody List<Cliente> clientes) {
        return clienteService.cadastrarClientes(clientes)
        .stream()
        .map(cliente -> new ClienteResponse(
            cliente.getId(),
            cliente.getNome(),
            cliente.getCpf(),
            cliente.getTelefone()
        ))
        .toList();
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }

    @PutMapping("/{id}")
    public ClienteResponse alterarCliente( @PathVariable Long id, @RequestBody Cliente cliente) {
    Cliente clienteAlterado = clienteService.alterarCliente(id, cliente);
    return new ClienteResponse(
        clienteAlterado.getId(),
        clienteAlterado.getNome(),
        clienteAlterado.getCpf(),
        clienteAlterado.getTelefone()
    );
    
    }
}

