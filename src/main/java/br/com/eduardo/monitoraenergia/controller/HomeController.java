package br.com.eduardo.monitoraenergia.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eduardo.monitoraenergia.controller.dto.GraficoHomeInterface;
import br.com.eduardo.monitoraenergia.controller.dto.RelatorioHomeInterface;
import br.com.eduardo.monitoraenergia.modelo.Status;
import br.com.eduardo.monitoraenergia.repository.ConsumoRepository;
import br.com.eduardo.monitoraenergia.repository.EquipamentoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private EquipamentoRepository equipamentoRepository;
	@Autowired
	private ConsumoRepository consumoRepository;
	
	
	@GetMapping
	public String home(Model model){
		LocalDate inicio = LocalDate.of(2021, 07, 03);
		LocalDate fim = LocalDate.of(2021, 07, 05);
		List<RelatorioHomeInterface> equipamentos = equipamentoRepository.findByStatusAndUltimoConsumo();
		List<GraficoHomeInterface> dadosConsumo = consumoRepository.findByDatas(inicio, fim);
		model.addAttribute("equipamentos", equipamentos);
		model.addAttribute("dadosConsumo", dadosConsumo);
		return "home";
	}

}
