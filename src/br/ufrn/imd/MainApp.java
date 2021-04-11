package br.ufrn.imd;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.ufrn.imd.modelo.DataBase;
import br.ufrn.imd.modelo.Evento;
import br.ufrn.imd.modelo.EventoDiario;
import br.ufrn.imd.modelo.EventoMensal;
import br.ufrn.imd.modelo.EventoSemanal;
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
	public static List<Evento> listaVazia;

	public void change_scene(Scene s)
    {
        mStage.setScene(s);
    }

	@Override
	public void start(Stage stage) throws Exception {
		DataBase db = DataBase.getInstance();
		MainApp.eventos = db.getEventos();
		MainApp.eventosDoDia = new ArrayList<Evento>();
		carregarEventosDia();
		try {
			System.out.println(MainApp.eventos.toString());
			System.out.println(MainApp.eventosDoDia.toString());
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
		System.out.println(today);
		for(Evento e : MainApp.eventos){
			if(e.getTipoEvento().equals("Semanal")){
				if(today.after(((EventoSemanal)e).getDataInicioEvento()) && today.before(((EventoSemanal)e).getDataFinalEvento())) {
					MainApp.eventosDoDia.add(e);
				}
			}
			else if(e.getTipoEvento().equals("Diario")){
				if(compareDate(today, (((EventoDiario)e).getDataInicioEvento()))) {
					MainApp.eventosDoDia.add(e);
				}
			}
			else if(e.getTipoEvento().equals("Mensal")){
				if(today.after(((EventoMensal)e).getDataInicioEvento()) && today.before(((EventoMensal)e).getDataFinalEvento())) {
					MainApp.eventosDoDia.add(e);
				}
			}
			
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
	
	public static void main(String[] args) {
		launch(args);
	}

}
