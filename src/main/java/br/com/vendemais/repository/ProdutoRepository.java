package br.com.vendemais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vendemais.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
