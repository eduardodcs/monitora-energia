package br.com.eduardo.monitoraenergia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eduardo.monitoraenergia.controller.dto.RequisicaoNovoSetor;
import br.com.eduardo.monitoraenergia.controller.dto.RequisicaoNovoTipo;
import br.com.eduardo.monitoraenergia.modelo.Setor;
import br.com.eduardo.monitoraenergia.modelo.Status;
import br.com.eduardo.monitoraenergia.repository.SetorRepository;

@Controller
@RequestMapping("/setores")
public class SetorController {
	
	@Autowired
	private SetorRepository setorRepository;
	

	@GetMapping("/relatorio")
	public String relatorio(Model model){
		List<Setor> setores = setorRepository.findByStatus(Status.ATIVO);
		model.addAttribute("setores", setores);
		return "setores/relatorio";
	}
	
	@GetMapping("/formulario")
	public String formulario(RequisicaoNovoSetor requisicao, Model model) {
		return "setores/formulario";
	}
	
	@PostMapping("/novo")
	public String novo(RequisicaoNovoSetor requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "setores/formulario";
		}
		
		Setor novo = requisicao.toSetor();
		setorRepository.save(novo);
		return "redirect:/setores/relatorio";
	}
	
	
}
