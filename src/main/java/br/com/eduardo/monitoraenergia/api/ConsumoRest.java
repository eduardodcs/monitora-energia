package br.com.eduardo.monitoraenergia.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduardo.monitoraenergia.controller.dto.RequisicaoNovoRegistroConsumo;
import br.com.eduardo.monitoraenergia.modelo.Consumo;
import br.com.eduardo.monitoraenergia.modelo.Equipamento;
import br.com.eduardo.monitoraenergia.repository.ConsumoRepository;
import br.com.eduardo.monitoraenergia.repository.EquipamentoRepository;

@RestController
@RequestMapping("api/consumo")
public class ConsumoRest {

	@Autowired
	private EquipamentoRepository equipamentoRepository;
	@Autowired
	private ConsumoRepository consumoRepository;
	
	@PostMapping
	private Consumo registraConsumo(@RequestBody RequisicaoNovoRegistroConsumo requisicao) {
		Optional<Equipamento> equipamentoBuscado = equipamentoRepository.findById(requisicao.getEquipamento());
		if(!equipamentoBuscado.isPresent()) {
			return null;
		}
		
		Equipamento equipamento = equipamentoBuscado.get();
		
		Consumo novo = requisicao.toConsumo();
		novo.setEquipamento(equipamento);
		consumoRepository.save(novo);
		return novo;
		
	}
}
