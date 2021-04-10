package br.ufrn.imd.modelo;

import java.util.Date;

public class EventoDiario extends Evento{
	
	public EventoDiario() {
		
		this.setTipoEvento("Diario");
		// TODO Auto-generated constructor stub
	}

	public EventoDiario(String titulo, String tipo, String descricao) {
		super(titulo, tipo, descricao);
		// TODO Auto-generated constructor stub
	}

	private Date dataInicioEvento;
	
	public Date getDataInicioEvento() {
		return dataInicioEvento;
	}

	public void setDataInicioEvento(Date dataFinalEvento) {
		this.dataInicioEvento = dataFinalEvento;
	}
	
	public void setTipoEvento(){
		this.setTipoEvento("Diario");
	}
	
	
}
