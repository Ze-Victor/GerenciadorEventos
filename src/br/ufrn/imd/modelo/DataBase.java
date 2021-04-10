package br.ufrn.imd.modelo;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
	
	private List<Evento> eventos;
	
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
		//System.out.println("Evento Inserido com Sucesso!!");
	}
	
	public List<Evento> listar() {
		return eventos;
	}
		
	
}