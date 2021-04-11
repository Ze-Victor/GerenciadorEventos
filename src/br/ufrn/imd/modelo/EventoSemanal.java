package br.ufrn.imd.modelo;

import java.util.Date;

import javafx.beans.property.SimpleStringProperty;

public class EventoSemanal extends Evento{
	
	private String diaSemana;


	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public EventoSemanal() {
		this.setTipoEvento();
	}
	
	public EventoSemanal(String titulo, String tipo, String descricao) {
		super(titulo, tipo, descricao);
		// TODO Auto-generated constructor stub
	}
	
	public void setTipoEvento() {
		this.tipoEvento.set("Semanal");
	}
}
