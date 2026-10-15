package br.com.vendemais.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.com.vendemais.model.Cliente;
import br.com.vendemais.repository.ClienteRepository;



@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
    
    public List<Cliente> cadastrarClientes(List<Cliente> clientes) {
        return clienteRepository.saveAll(clientes);
    }
    
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
    
    public Cliente alterarCliente(Long id, Cliente cliente) {
    Cliente clienteExistente = clienteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    clienteExistente.setNome(cliente.getNome());
    clienteExistente.setCpf(cliente.getCpf());
    clienteExistente.setTelefone(cliente.getTelefone());
    return clienteRepository.save(clienteExistente);

    }
    
    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + id));
    }

}
