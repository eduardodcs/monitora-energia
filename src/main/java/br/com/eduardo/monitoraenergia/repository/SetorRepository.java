package br.com.eduardo.monitoraenergia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eduardo.monitoraenergia.modelo.Setor;
import br.com.eduardo.monitoraenergia.modelo.Status;

public interface SetorRepository extends JpaRepository<Setor, Long> {

	List<Setor> findByStatus(Status ativo);

	
}
