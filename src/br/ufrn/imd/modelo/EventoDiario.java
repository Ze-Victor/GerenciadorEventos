package br.ufrn.imd.modelo;

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
		// TODO Auto-generated constructor stub
	}

	public EventoDiario(String titulo, String tipo, String descricao) {
		super(titulo, tipo, descricao);
		// TODO Auto-generated constructor stub
	}
	
	public void setTipoEvento() {
		this.tipoEvento.set("Diario");
	}
}