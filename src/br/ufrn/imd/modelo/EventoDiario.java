package br.ufrn.imd.modelo;

import java.util.Date;

public class EventoDiario extends Evento{
	private Date dataInicioEvento;
	
	public EventoDiario() {
		this.setTipoEvento();
		// TODO Auto-generated constructor stub
	}

	public EventoDiario(String titulo, String tipo, String descricao) {
		super(titulo, tipo, descricao);
		// TODO Auto-generated constructor stub
	}
	
	public Date getDataInicioEvento() {
		return dataInicioEvento;
	}

	public void setDataInicioEvento(Date dataFinalEvento) {
		this.dataInicioEvento = dataFinalEvento;
	}
	
	public void setTipoEvento() {
		this.tipoEvento.set("Diario");
	}
}