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
	private List<GraficoHomeInterface> dadosConsumo(@RequestParam(value = "inicio", required = false) LocalDate inicio, @RequestParam(value = "fim", required = false) LocalDate fim) {
		if(inicio == null || fim == null) {
			inicio = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
			fim = inicio.plusMonths(1);
		} else {
			fim = fim.plusDays(1);
		}
		System.out.println(inicio);
		System.out.println(fim);
		List<GraficoHomeInterface> dadosGrafico = consumoRepository.findByDatas(inicio, fim);
		return dadosGrafico;
		
	}
}
