package br.com.eduardo.monitoraenergia.controller.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import br.com.eduardo.monitoraenergia.modelo.Setor;
import br.com.eduardo.monitoraenergia.modelo.Status;

public class RequisicaoNovoSetor {
	@NotBlank
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Setor toSetor() {
		Setor setor = new Setor();
		setor.setDescricao(descricao);
		setor.setStatus(Status.ATIVO);
		setor.setData_criacao(LocalDateTime.now());
		return setor;
	}
}
