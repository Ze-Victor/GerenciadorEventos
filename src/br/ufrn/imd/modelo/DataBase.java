package br.ufrn.imd.modelo;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;


public class DataBase {
	
	private List<Evento> eventos;
	
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
	
	
	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public void inserirEvento(Evento e)  {
		eventos.add(e);
		//System.out.println("Evento Inserido com Sucesso!!");
	}
	
	public List<Evento> listar() {
		return eventos;
	}
	
	public void save(){
		try {
			Type listType = new TypeToken<ArrayList<Evento>>(){}.getType();
			GsonBuilder gson = new GsonBuilder();
			gson.registerTypeAdapter(Evento.class, new EventoAdpter());
			String dir = System.getProperty("user.dir");
			dir += "/db.json";
			File file = new File(dir);
			file.createNewFile();
			Writer writer = Files.newBufferedWriter(Paths.get(dir));
			writer.write(gson.create().toJson(eventos));
			writer.flush();
			writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}	
	
	public List<Evento> getData(){
		List<Evento> ev = new ArrayList<Evento>();
		try {
			Type listType = new TypeToken<ArrayList<Evento>>(){}.getType();
			GsonBuilder gson = new GsonBuilder();
			gson.registerTypeAdapter(Evento.class, new EventoAdpter());
			String dir = System.getProperty("user.dir");
			dir += "/db.json";
			File file = new File(dir);
			if (!file.exists()) {
				return ev;
			}
			JsonReader reader = new JsonReader(new FileReader(dir));
			ev = Arrays.asList(gson.create().fromJson(reader, Evento[].class));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return ev;
	}
}