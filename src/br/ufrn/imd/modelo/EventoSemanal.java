package br.ufrn.imd.modelo;

import java.util.Date;

public class EventoSemanal extends Evento{
	
	public EventoSemanal() {
		//
	}
	
	public EventoSemanal(String titulo, String tipo, String descricao) {
		super(titulo, tipo, descricao);
		// TODO Auto-generated constructor stub
	}

	private Date dataFinalEvento;
	private Date dataInicioEvento;
	
	public Date getDataInicioEvento() {
		return dataInicioEvento;
	}

	public void setDataInicioEvento(Date dataFinalEvento) {
		this.dataInicioEvento = dataFinalEvento;
	}
	
	public Date getDataFinalEvento() {
		return dataFinalEvento;
	}

	public void setDataFinalEvento(Date dataFinalEvento) {
		this.dataFinalEvento = dataFinalEvento;
	}

	public void setTipoEvento(){
		this.setTipoEvento("Semanal");
	}
	
}
