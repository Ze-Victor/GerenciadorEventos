package br.ufrn.imd.modelo;

import java.util.ArrayList;

public class DataBase {
	
	private ArrayList<Evento> eventos;
	
	private static DataBase eventos_db;

	
	private DataBase(){
		eventos  = new ArrayList<Evento>();
	}
	
	// Singleton
	public static DataBase getInstance() {
		if (eventos_db == null) {
			eventos_db = new DataBase();
		}
		return eventos_db;
	}

	public void inserirEvento(Evento e)  {
		eventos.add(e);
		System.out.println("Evento Inserido com Sucesso!!");
	}
	
	public void list() {
		for(Evento evento : eventos) {
			System.out.println("Evento " + evento.getTituloEvento());
		}
	}
		
	
}