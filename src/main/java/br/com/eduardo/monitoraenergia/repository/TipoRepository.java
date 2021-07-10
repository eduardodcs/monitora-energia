package br.com.eduardo.monitoraenergia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eduardo.monitoraenergia.modelo.Status;
import br.com.eduardo.monitoraenergia.modelo.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long> {

	List<Tipo> findByStatus(Status ativo);

	
}
