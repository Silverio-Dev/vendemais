package br.com.vendemais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vendemais.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
