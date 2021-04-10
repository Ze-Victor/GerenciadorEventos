package br.ufrn.imd.modelo;

import java.util.Date;

import javafx.beans.property.SimpleStringProperty;

public class Evento {

	private SimpleStringProperty tituloEvento = new SimpleStringProperty();
	//private Date dataInicioEvento;
	private SimpleStringProperty tipoEvento = new SimpleStringProperty();
	private SimpleStringProperty descricaoEvento = new SimpleStringProperty();
	
	public Evento() {
		//
	}
	
	public Evento(String titulo, String tipo, String descricao) {
		this.tituloEvento = new SimpleStringProperty(titulo);
		this.tipoEvento = new SimpleStringProperty(tipo);
		this.descricaoEvento = new SimpleStringProperty(descricao);
	}
	
	public String getTituloEvento() {
        return tituloEvento.get();
    }
	
	public SimpleStringProperty tituloEventoProperty() {
        return tituloEvento;
    }

    public void setTituloEvento(String titulo) {
        this.tituloEvento.set(titulo);
    }
    
    public String getTipoEvento() {
        return tipoEvento.get();
    }

	public SimpleStringProperty tipoEventoProperty() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipo) {
        this.tipoEvento.set(tipo);
    }
    
    public String getDescricaoEvento() {
        return descricaoEvento.get();
    }
    
    public SimpleStringProperty descricaoEventoProperty() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String tipo) {
        this.descricaoEvento.set(tipo);
    }
	
	
	
}
