package br.com.vendemais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vendemais.model.ItemVenda;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {
    
}
