package br.ufrn.imd.modelo;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;

public abstract class Evento implements Serializable {
	protected SimpleStringProperty tituloEvento = new SimpleStringProperty();
	protected SimpleStringProperty tipoEvento = new SimpleStringProperty();
	protected SimpleStringProperty descricaoEvento = new SimpleStringProperty();
		
	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Evento(String titulo, String tipo, String descricao) {
		this.tituloEvento = new SimpleStringProperty(titulo);
		this.tipoEvento = new SimpleStringProperty(tipo);
		this.descricaoEvento = new SimpleStringProperty(descricao);
	}
		
	public SimpleStringProperty tituloEventoProperty() {
        return tituloEvento;
    }

    public void setTituloEvento(String titulo) {
        this.tituloEvento.set(titulo);
    }
    
    public String getTituloEvento() {
    	return this.tituloEvento.get();
    }
    
    public String getTipoEvento() {
        return tipoEvento.get();
    }
    
    public abstract void setTipoEvento();
    
	public SimpleStringProperty tipoEventoProperty() {
        return tipoEvento;
    }

    public SimpleStringProperty descricaoEventoProperty() {
        return descricaoEvento;
    }
    
    public String getDescricaoEvento() {
    	return this.descricaoEvento.get();
    }

    public void setDescricaoEvento(String tipo) {
        this.descricaoEvento.set(tipo);
    }

	@Override
	public String toString() {
		return "Evento [tituloEvento=" + tituloEvento + ", tipoEvento=" + tipoEvento + ", descricaoEvento="
				+ descricaoEvento + "]";
	}
}
