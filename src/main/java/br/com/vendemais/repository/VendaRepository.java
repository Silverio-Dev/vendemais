package br.com.vendemais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vendemais.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
    
}
