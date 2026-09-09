package br.com.vendemais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vendemais.model.Pagamento;

public interface PagamentoRepository extends JpaRepository< Pagamento, Long> {
    
}
