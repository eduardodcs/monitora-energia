package br.com.eduardo.monitoraenergia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eduardo.monitoraenergia.controller.dto.ConsultaHomeEquipamento;
import br.com.eduardo.monitoraenergia.controller.dto.IConsultaHomeEquipamento;
import br.com.eduardo.monitoraenergia.modelo.Equipamento;
import br.com.eduardo.monitoraenergia.modelo.Status;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

	List<Equipamento> findByStatus(Status ativo);
	
	@Query(value = "SELECT e.id, e.descricao, e.status, t.descricao AS tipo, s.descricao AS setor, MAX(c.data_criacao) AS ult_consumo "
			+ "FROM equipamento e "
			+ "JOIN consumo c ON e.id = c.equipamento_id "
			+ "JOIN setor s ON e.setor_id = s.id "
			+ "JOIN tipo t ON e.tipo_id = t.id "
			+ "WHERE e.status = 'ATIVO' "
			+ "GROUP BY e.id ", nativeQuery = true)
	List<IConsultaHomeEquipamento> findByStatusAndUltimoConsumo();

}
