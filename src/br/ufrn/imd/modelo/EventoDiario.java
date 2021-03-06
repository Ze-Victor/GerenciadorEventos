package br.ufrn.imd.modelo;

import javafx.beans.property.SimpleStringProperty;

public class EventoDiario extends Evento{
	
	private String periodo;

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public EventoDiario() {
		this.setTipoEvento();
		this.setDescricaoCompleta();
		// TODO Auto-generated constructor stub
	}

	public EventoDiario(String titulo, String tipo, String descricao) {
		super(titulo, tipo, descricao);
		// TODO Auto-generated constructor stub
		this.setDescricaoCompleta();
	}
	
	public void setTipoEvento() {
		this.tipoEvento.set("Diario");
	}

	public void setDescricaoCompleta() {
		this.descricaoCompleta.set(periodo+": "+this.getDescricaoEvento());
	}
}