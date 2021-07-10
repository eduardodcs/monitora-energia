package br.com.eduardo.monitoraenergia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eduardo.monitoraenergia.modelo.Consumo;

public interface ConsumoRepository extends JpaRepository<Consumo, Long> {
	
	Optional<Consumo> findById(Long id);
	
}
