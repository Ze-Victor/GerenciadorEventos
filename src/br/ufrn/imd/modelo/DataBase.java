package br.ufrn.imd.modelo;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;


public class DataBase {
	
	private ArrayList<Evento> eventos;
	
	private static DataBase eventos_db;

	
	private DataBase(){
		eventos  = getData();
	}
	
	// Singleton
	public static DataBase getInstance() {
		if (eventos_db == null) {
			eventos_db = new DataBase();
		}
		return eventos_db;
	}
	
	
	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
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
	
	public void save(){
		try {
			Gson gson = new Gson();
			String dir = System.getProperty("user.dir");
			dir += "/db.json";
			File file = new File(dir);
			file.createNewFile();
			Writer writer = Files.newBufferedWriter(Paths.get(dir));
			gson.toJson(eventos, writer);
			writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}	
	
	public ArrayList<Evento> getData(){
		ArrayList<Evento> ev = new ArrayList<Evento>();
		try {
			Gson gson = new Gson();
			String dir = System.getProperty("user.dir");
			dir += "/db.json";
			File file = new File(dir);
			if (!file.exists()) {
				return ev;
			}
			JsonReader reader = new JsonReader(new FileReader(dir));
			ev = gson.fromJson(reader, new TypeToken<List<Evento>>(){}.getType());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return ev;
	}
}