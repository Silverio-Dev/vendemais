package br.com.vendemais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vendemais.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
