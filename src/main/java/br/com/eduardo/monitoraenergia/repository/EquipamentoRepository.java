package br.com.eduardo.monitoraenergia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eduardo.monitoraenergia.modelo.Equipamento;
import br.com.eduardo.monitoraenergia.modelo.Status;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

	List<Equipamento> findByStatus(Status ativo);
	
}
