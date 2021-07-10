package br.com.eduardo.monitoraenergia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eduardo.monitoraenergia.controller.dto.RequisicaoNovoEquipamento;
import br.com.eduardo.monitoraenergia.controller.dto.RequisicaoNovoTipo;
import br.com.eduardo.monitoraenergia.modelo.Setor;
import br.com.eduardo.monitoraenergia.modelo.Status;
import br.com.eduardo.monitoraenergia.modelo.Tipo;
import br.com.eduardo.monitoraenergia.repository.TipoRepository;

@Controller
@RequestMapping("/tipos")
public class TipoController {
	
	@Autowired
	private TipoRepository tipoRepository;
	

	@GetMapping("/relatorio")
	public String relatorio(Model model){
		List<Tipo> tipos = tipoRepository.findByStatus(Status.ATIVO);
		model.addAttribute("tipos", tipos);
		return "tipos/relatorio";
	}
	
	@GetMapping("/formulario")
	public String formulario(RequisicaoNovoTipo requisicao, Model model) {
		return "tipos/formulario";
	}
	
	@PostMapping("/novo")
	public String novo(RequisicaoNovoTipo requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "tipos/formulario";
		}
		
		Tipo novo = requisicao.toTipo();
		tipoRepository.save(novo);
		return "redirect:/tipos/relatorio";
	}
	
}
