package br.com.eduardo.monitoraenergia.controller.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import br.com.eduardo.monitoraenergia.modelo.Status;
import br.com.eduardo.monitoraenergia.modelo.Tipo;

public class RequisicaoNovoTipo {
	@NotBlank
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Tipo toTipo() {
		Tipo tipo = new Tipo();
		tipo.setDescricao(descricao);
		tipo.setStatus(Status.ATIVO);
		tipo.setData_criacao(LocalDateTime.now());
		return tipo;
	}
}
