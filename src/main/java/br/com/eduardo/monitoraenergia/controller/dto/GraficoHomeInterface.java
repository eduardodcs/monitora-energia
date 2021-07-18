package br.com.eduardo.monitoraenergia.controller.dto;

import java.time.LocalDate;

public interface GraficoHomeInterface {
	//String getEquipamento();
	LocalDate getDia();
	Double getConsumo();
	
}
