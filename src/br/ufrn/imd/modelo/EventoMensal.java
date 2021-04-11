package br.ufrn.imd.modelo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EventoMensal extends Evento{
	
	private int diaDoMes;

	public int getDiaDoMes() {
		return diaDoMes;
	}

	public void setDiaDoMes(int diaDoMes) {
		this.diaDoMes = diaDoMes;
	}

	public EventoMensal() {
		this.setTipoEvento();
		this.setDescricaoCompleta();
	}
	
	public EventoMensal(String titulo, String tipo, String descricao) {
		super(titulo, tipo, descricao);
		this.setDescricaoCompleta();
	}
	
	public void setTipoEvento() {
		this.tipoEvento.set("Mensal");
	}

	public void setDescricaoCompleta() {
		this.descricaoCompleta.set("Dia "+diaDoMes+": "+this.getDescricaoEvento());
	}
		
}
