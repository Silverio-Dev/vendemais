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
    //Listar//
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
    //Cadastrar//
    public List<Cliente> cadastrarClientes(List<Cliente> clientes) {
        return clienteRepository.saveAll(clientes);
    }
    //Deletar//
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
    //Alterar//
    public Cliente alterCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    //Buscar//
    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + id));
    }


   
}
