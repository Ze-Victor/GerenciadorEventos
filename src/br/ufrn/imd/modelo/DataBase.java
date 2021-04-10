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

import br.ufrn.imd.MainApp;


public class DataBase {
	
	private List<Evento> eventos;
	
	private static DataBase eventos_db;
	
	private int tamanho;

	
	private DataBase(){
		eventos = getData();
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
		//System.out.println();
		tamanho++;
	}
	
	public List<Evento> listar() {
		return eventos;
	}
	
	public void atualizar() {
		Evento e;
		for (int i=0; i<MainApp.eventos.size(); ++i) {
			if(MainApp.eventos.get(i).getTipoEvento().equals("Semanal")) {
				e = new EventoSemanal(MainApp.eventos.get(i).getTituloEvento(), MainApp.eventos.get(i).getTipoEvento(), MainApp.eventos.get(i).getDescricaoEvento());
				((EventoSemanal)e).setDataInicioEvento(((EventoSemanal)MainApp.eventos.get(i)).getDataInicioEvento());
				((EventoSemanal)e).setDataFinalEvento(((EventoSemanal)MainApp.eventos.get(i)).getDataFinalEvento());
				eventos.set(i, e);
			}
			else if (MainApp.eventos.get(i).getTipoEvento().equals("Mensal")) {
				e = new EventoMensal(MainApp.eventos.get(i).getTituloEvento(), MainApp.eventos.get(i).getTipoEvento(), MainApp.eventos.get(i).getDescricaoEvento());
				((EventoMensal)e).setDataInicioEvento(((EventoMensal)MainApp.eventos.get(i)).getDataInicioEvento());
				((EventoMensal)e).setDataFinalEvento(((EventoMensal)MainApp.eventos.get(i)).getDataFinalEvento());
				eventos.set(i, e);			
			}
			else if (MainApp.eventos.get(i).getTipoEvento().equals("Diario")) {
				e = new EventoDiario(MainApp.eventos.get(i).getTituloEvento(), MainApp.eventos.get(i).getTipoEvento(), MainApp.eventos.get(i).getDescricaoEvento());
				((EventoDiario)e).setDataInicioEvento(((EventoDiario)MainApp.eventos.get(i)).getDataInicioEvento());
				eventos.set(i, e);
			}
		}
	}
	
	public void save(){
		atualizar();
		try {
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

	public void removeEvento(Evento evento) {
		// TODO Auto-generated method stub
		eventos.remove(evento);
	}

	public int tamanho() {
		if (eventos_db == null) {
			eventos_db = new DataBase();
			tamanho = 0;
		}
		return tamanho;
	}
	
	public ArrayList<Evento> getData(){
		ArrayList<Evento> ev = new ArrayList<Evento>();
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
			ev = gson.create().fromJson(reader, listType);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return ev;
	}
}