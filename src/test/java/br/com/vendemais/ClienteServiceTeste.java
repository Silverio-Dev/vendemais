package br.com.vendemais;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.vendemais.model.Cliente;
import br.com.vendemais.repository.ClienteRepository;
import br.com.vendemais.service.ClienteService;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTeste {

    @InjectMocks 
    private ClienteService clienteService;

    @Mock 
    private ClienteRepository clienteRepository;

    @Test 
    public void deveCadastrarClientes() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        Cliente cliente3 = new Cliente();
        cliente3.setId(3L);
        List<Cliente> clientes = List.of(cliente1, cliente2, cliente3);
        when(clienteRepository.saveAll(clientes)).thenReturn(clientes);
        List<Cliente> resultado = clienteService.cadastrarClientes(clientes);
        assertEquals(3, resultado.size());
        System.out.println("Quantidade de clientes cadastrados: " + resultado);

    } 

    @Test 
    public void deveListarClientes() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        Cliente cliente3 = new Cliente();
        cliente3.setId(3L);
        List<Cliente> clientes = List.of(cliente1, cliente2, cliente3);
        when(clienteRepository.findAll()).thenReturn(clientes);
        assertEquals(3, clienteService.listarClientes().size());
        System.out.println("Quantidade de clientes listados: " + clientes.size());
    }

    @Test 
    public void deveAlterarCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        when(clienteRepository.save(cliente)).thenReturn(cliente);
        Cliente resultado = clienteService.alterCliente(cliente);
        assertEquals(cliente, resultado);
        System.out.println("Cliente alterado com sucesso: ID " + resultado.getId());
    }

    @Test 
    public void deveBuscarClientePorId() {
        Cliente clienteExistente = new Cliente();
        clienteExistente.setId(1L);
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(clienteExistente));
        Cliente resultado = clienteService.buscarClientePorId(1L);
        assertEquals(clienteExistente, resultado);
        System.out.println("Cliente encontrado com sucesso: ID " + resultado.getId());
    }
    
    @Test 
    public void deveDeletarCliente() {
        Long id = 4L;
        clienteService.deletarCliente(id);
        verify(clienteRepository).deleteById(4L);
        System.out.println("Cliente deletado com sucesso: ID " + id);


    }
}
