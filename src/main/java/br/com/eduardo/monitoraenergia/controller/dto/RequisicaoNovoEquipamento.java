package br.com.eduardo.monitoraenergia.controller.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import br.com.eduardo.monitoraenergia.modelo.Equipamento;
import br.com.eduardo.monitoraenergia.modelo.Status;

public class RequisicaoNovoEquipamento {
	@NotBlank
	private String descricao;
	@NotBlank
	private Long tipo;
	@NotBlank
	private Long setor;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getTipo() {
		return tipo;
	}

	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}

	public Long getSetor() {
		return setor;
	}

	public void setSetor(Long setor) {
		this.setor = setor;
	}

	public Equipamento toEquipamento() {
		Equipamento equipamento = new Equipamento();
		equipamento.setDescricao(descricao);
		equipamento.setStatus(Status.ATIVO);
		equipamento.setData_criacao(LocalDateTime.now());
		return equipamento;
	}
}
