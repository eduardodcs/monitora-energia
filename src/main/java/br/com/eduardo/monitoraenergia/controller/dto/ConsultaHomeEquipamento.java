package br.com.eduardo.monitoraenergia.controller.dto;

import java.sql.Timestamp;


public class ConsultaHomeEquipamento {
	private Long id;
	private String descricao;
	private String status;
	private Timestamp ult_consumo;
	private String setor;
	private String tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getUlt_consumo() {
		return ult_consumo;
	}

	public void setUlt_consumo(Timestamp ult_consumo) {
		this.ult_consumo = ult_consumo;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
