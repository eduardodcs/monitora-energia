package br.com.eduardo.monitoraenergia.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eduardo.monitoraenergia.controller.dto.GraficoHomeInterface;
import br.com.eduardo.monitoraenergia.modelo.Consumo;

public interface ConsumoRepository extends JpaRepository<Consumo, Long> {
	
	Optional<Consumo> findById(Long id);
	
	
	@Query(value = "SELECT E.DESCRICAO AS EQUIPAMENTO, SUM(C.CONSUMO) AS CONSUMO, CAST(C.DATA_CRIACAO AS DATE) AS DIA "
			+ "FROM CONSUMO C JOIN EQUIPAMENTO E "
			+ "ON E.ID = C.EQUIPAMENTO_ID "
			+ "WHERE C.DATA_CRIACAO > :dataInicio "
			+ "AND C.DATA_CRIACAO < :dataFim "
			+ "GROUP BY DIA, EQUIPAMENTO", nativeQuery = true)
	List<GraficoHomeInterface> findByDatas(LocalDate dataInicio, LocalDate dataFim);
	
}
