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
		
	@Query(value = "SELECT CAST(C.DATA_CRIACAO AS DATE) AS DIA, SUM(C.CONSUMO) AS CONSUMO "
			+ "FROM CONSUMO C "
			+ "WHERE C.DATA_CRIACAO >= :inicio "
			+ "AND C.DATA_CRIACAO < :fim "
			+ "GROUP BY DIA", nativeQuery = true)
	List<GraficoHomeInterface> findByDatas(LocalDate inicio, LocalDate fim);
	
	
}
