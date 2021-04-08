package br.ufrn.imd.modelo;

import java.util.Date;

public class EventoMensal extends Evento{
	
	private Date dataFinalEvento;
	
	public Date getDataFinalEvento() {
		return dataFinalEvento;
	}

	public void setDataFinalEvento(Date dataFinalEvento) {
		this.dataFinalEvento = dataFinalEvento;
	}
	
	public void setTipoEvento(){
		this.setTipoEvento("Mensal");
	}
	
}
