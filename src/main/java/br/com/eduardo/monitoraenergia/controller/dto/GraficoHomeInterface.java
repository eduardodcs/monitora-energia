package br.com.eduardo.monitoraenergia.controller.dto;

import java.time.LocalDate;

public interface GraficoHomeInterface {
	String getEquipamento();
	Double getConsumo();
	LocalDate getDia();
}
