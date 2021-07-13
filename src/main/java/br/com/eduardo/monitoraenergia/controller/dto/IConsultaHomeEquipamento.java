package br.com.eduardo.monitoraenergia.controller.dto;

import java.sql.Timestamp;

public interface IConsultaHomeEquipamento {
	Long getId();
	String getDescricao();
	String getStatus();
	Timestamp getUlt_consumo();
	String getSetor();
	String getTipo();
}
