package br.com.eduardo.monitoraenergia.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eduardo.monitoraenergia.controller.dto.RequisicaoNovoEquipamento;
import br.com.eduardo.monitoraenergia.modelo.Equipamento;
import br.com.eduardo.monitoraenergia.modelo.Setor;
import br.com.eduardo.monitoraenergia.modelo.Status;
import br.com.eduardo.monitoraenergia.modelo.Tipo;
import br.com.eduardo.monitoraenergia.repository.EquipamentoRepository;
import br.com.eduardo.monitoraenergia.repository.SetorRepository;
import br.com.eduardo.monitoraenergia.repository.TipoRepository;

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {
	
	@Autowired
	private EquipamentoRepository equipamentoRepository;
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private SetorRepository setorRepository;
	
	@GetMapping("/formulario")
	public String formulario(RequisicaoNovoEquipamento requisicao, Model model) {
		List<Tipo> tipos = tipoRepository.findByStatus(Status.ATIVO);
		List<Setor> setores = setorRepository.findByStatus(Status.ATIVO);
		model.addAttribute("setores", setores);
		model.addAttribute("tipos", tipos);
		return "equipamentos/formulario";
	}
	
	@GetMapping("/relatorio")
	public String relatorio(Model model){
		List<Equipamento> equipamentos = equipamentoRepository.findByStatus(Status.ATIVO);
		model.addAttribute("equipamentos", equipamentos);
		return "equipamentos/relatorio";
	}
	
	@PostMapping("novo")
	public String novo(RequisicaoNovoEquipamento requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "equipamentos/formulario";
		}
		
		Optional<Tipo> tipoBuscado = tipoRepository.findById(requisicao.getTipo());
		Optional<Setor> setorBuscado = setorRepository.findById(requisicao.getSetor());
		if(!setorBuscado.isPresent() || !tipoBuscado.isPresent()) {
			return null;
		}
		
		Tipo tipo = tipoBuscado.get();
		Setor setor = setorBuscado.get();
		Equipamento novo = requisicao.toEquipamento();
		novo.setTipo(tipo);
		novo.setSetor(setor);
		equipamentoRepository.save(novo);
		return "redirect:/equipamentos/relatorio";	
	}
	
	
	

}
