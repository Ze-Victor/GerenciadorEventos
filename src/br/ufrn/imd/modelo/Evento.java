package br.ufrn.imd.modelo;

import java.util.Date;

public class Evento {

	private String tituloEvento;
	private Date dataInicioEvento;
	private String tipoEvento;
	private String descricaoEvento;
	
	
	
	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getTituloEvento() {
		return tituloEvento;
	}
	public void setTituloEvento(String tituloEvento) {
		this.tituloEvento = tituloEvento;
	}
	public Date getDataInicioEvento() {
		return dataInicioEvento;
	}
	public void setDataInicioEvento(Date dataInicioEvento) {
		this.dataInicioEvento = dataInicioEvento;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getDescricaoEvento() {
		return descricaoEvento;
	}
	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}
	@Override
	public String toString() {
		return "Evento [tituloEvento=" + tituloEvento + ", dataInicioEvento=" + dataInicioEvento + ", tipoEvento="
				+ tipoEvento + ", descricaoEvento=" + descricaoEvento + "]";
	}
	
	
	
}
