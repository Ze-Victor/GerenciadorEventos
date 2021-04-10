package br.ufrn.imd.modelo;

import java.util.Date;

public class EventoMensal extends Evento{
	private Date dataFinalEvento;
	private Date dataInicioEvento;
	
	public EventoMensal() {
		this.setTipoEvento();
	}
	
	public EventoMensal(String titulo, String tipo, String descricao) {
		super(titulo, tipo, descricao);
	}
	
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
	
	public void setTipoEvento() {
		this.tipoEvento.set("Mensal");
	}
		
}
