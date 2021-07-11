package br.com.eduardo.monitoraenergia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eduardo.monitoraenergia.controller.dto.ConsultaHomeEquipamento;
import br.com.eduardo.monitoraenergia.modelo.Equipamento;
import br.com.eduardo.monitoraenergia.modelo.Status;
import br.com.eduardo.monitoraenergia.repository.EquipamentoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	
	@GetMapping
	public String home(Model model){
		List<ConsultaHomeEquipamento> equipamentos = equipamentoRepository.findByStatusAndUltimoConsumo(Status.ATIVO);
		model.addAttribute("equipamentos", equipamentos);
		return "home";
	}

}
