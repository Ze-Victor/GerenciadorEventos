package br.ufrn.imd.modelo;

import java.util.Date;

public class EventoTemporario extends Evento {
	
	Date dataEvento = new Date();

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public EventoTemporario() {
		this.setTipoEvento();
		// TODO Auto-generated constructor stub
	}
	
	public EventoTemporario(String titulo, String tipo, String descricao) {
		super(titulo, tipo, descricao);
		// TODO Auto-generated constructor stub
	}

	public void setTipoEvento() {
		// TODO Auto-generated method stub
		this.tipoEvento.set("Temporario");
	}
}
