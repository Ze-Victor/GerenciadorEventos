package br.ufrn.imd;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.ufrn.imd.modelo.DataBase;
import br.ufrn.imd.modelo.Evento;
import br.ufrn.imd.modelo.EventoDiario;
import br.ufrn.imd.modelo.EventoMensal;
import br.ufrn.imd.modelo.EventoSemanal;
import br.ufrn.imd.modelo.EventoTemporario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	public static Stage mStage;
	public static List<Evento> eventos;
	public static List<Evento> eventosDoDia;

	public void change_scene(Scene s)
    {
        mStage.setScene(s);
    }

	@Override
	public void start(Stage stage) throws Exception {
		DataBase db = DataBase.getInstance();
		MainApp.eventos = db.getEventos();
		carregarEventosDia();
		try {
			//System.out.println(MainApp.eventos.toString());
			//System.out.println(MainApp.eventosDoDia.toString());
		}
		catch (Exception e) {
			//e.printStackTrace();
		}
		mStage = stage;
		Parent root = FXMLLoader.load(getClass().getResource("visao/TelaPrincipal.fxml"));
		Scene scene = new Scene(root);
		mStage.setScene(scene);
		mStage.setTitle("AgendaVirtual");
		mStage.setResizable(false);
		mStage.show();
	}
	
	public static void carregarEventosDia() {
		Date today = new Date();
		MainApp.eventosDoDia = new ArrayList<Evento>();
		//System.out.println(today);
		//System.out.println(getWeek(today));
		
		for(Evento e : MainApp.eventos){
			if(e.getTipoEvento().equals("Semanal")){
				if(((EventoSemanal)e).getDiaSemana().equals(getWeek(today))) {
					MainApp.eventosDoDia.add(e);
				}
			}
			else if(e.getTipoEvento().equals("Diario")){
				MainApp.eventosDoDia.add(e);
			}
			else if(e.getTipoEvento().equals("Mensal")){
				if(compareDia(today, ((EventoMensal)e).getDiaDoMes())) {
					MainApp.eventosDoDia.add(e);
				}
			}
			else if(e.getTipoEvento().equals("Temporario")) {
				if(compareDate(today, ((EventoTemporario)e).getDataEvento())) {
					MainApp.eventosDoDia.add(e);
				}
			}
			
		}

	}
	public static boolean compareDia(Date dataHoje, int dia) {
		
		Calendar data = Calendar.getInstance();
		data.setTime(dataHoje);
		
		if(data.get(Calendar.DAY_OF_MONTH) == dia) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean compareDate(Date data1, Date data2) {
		
		Calendar d1 = Calendar.getInstance();
		d1.setTime(data1);
		
		Calendar d2 = Calendar.getInstance();
		d2.setTime(data2);

		if(d1.get(Calendar.DAY_OF_MONTH) == d2.get(Calendar.DAY_OF_MONTH) 
					  && d1.get(Calendar.MONTH) == d2.get(Calendar.MONTH) 
				      && d1.get(Calendar.YEAR) == d2.get(Calendar.YEAR)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static String getWeek(Date date){
	    String dayWeek = "---";
	    GregorianCalendar gc = new GregorianCalendar();
	        //gc.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(date));
	        switch (gc.get(Calendar.DAY_OF_WEEK)) {
	            case Calendar.SUNDAY:
	                dayWeek = "DOMINGO";
	                break;
	            case Calendar.MONDAY:
	                dayWeek = "SEGUNDA-FEIRA";
	                break;
	            case Calendar.TUESDAY:
	                dayWeek = "TERCA-FEIRA";
	            break;
	            case Calendar.WEDNESDAY:
	                dayWeek = "QUARTA-FEIRA";
	                break;
	            case Calendar.THURSDAY:
	                dayWeek = "QUINTA-FEIRA";
	                break;
	            case Calendar.FRIDAY:
	                dayWeek = "SEXTA-FEIRA";
	                break;
	            case Calendar.SATURDAY:
	                dayWeek = "SABADO";
	          }
	    return dayWeek;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
