package br.com.eduardo.monitoraenergia.controller.dto;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import br.com.eduardo.monitoraenergia.modelo.Consumo;
import br.com.eduardo.monitoraenergia.modelo.Equipamento;
import br.com.eduardo.monitoraenergia.repository.EquipamentoRepository;

public class RequisicaoNovoRegistroConsumo {
	@NotEmpty
	private Long equipamento;
	@NotEmpty
	private Double consumo;
	private LocalDateTime data_criacao = LocalDateTime.now();

	public Long getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Long equipamento) {
		this.equipamento = equipamento;
	}
	public Double getConsumo() {
		return consumo;
	}
	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}
	public LocalDateTime getData_criacao() {
		return data_criacao;
	}
	public void setData_criacao(LocalDateTime data_criacao) {
		this.data_criacao = data_criacao;
	}
	
	public Consumo toConsumo() {
		Consumo consumo = new Consumo();
		consumo.setConsumo(this.consumo);
		consumo.setData_criacao(this.data_criacao);
		return consumo;
	}
	
}
