package br.com.eduardo.monitoraenergia.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduardo.monitoraenergia.controller.dto.GraficoHomeInterface;
import br.com.eduardo.monitoraenergia.controller.dto.RequisicaoNovoRegistroConsumo;
import br.com.eduardo.monitoraenergia.modelo.Consumo;
import br.com.eduardo.monitoraenergia.modelo.Equipamento;
import br.com.eduardo.monitoraenergia.repository.ConsumoRepository;
import br.com.eduardo.monitoraenergia.repository.EquipamentoRepository;

@RestController
@RequestMapping("api/dados")
public class DadosGraficoHomeRest {

	@Autowired
	private ConsumoRepository consumoRepository;
	
	@GetMapping
	private List<GraficoHomeInterface> dadosConsumo() {
		
		List<GraficoHomeInterface> dadosGrafico = consumoRepository.findByDatas();
		System.out.println(dadosGrafico);
		
		return dadosGrafico;
		
	}
}
