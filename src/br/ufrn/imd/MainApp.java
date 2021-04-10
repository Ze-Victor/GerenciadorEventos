package br.ufrn.imd;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import br.ufrn.imd.modelo.DataBase;
import br.ufrn.imd.modelo.Evento;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	public static Stage mStage;
	public static ArrayList<Evento> eventos;
	public static ArrayList<Evento> eventosDoDia;

	public void change_scene(Scene s)
    {
        mStage.setScene(s);
    }

	@Override
	public void start(Stage stage) throws Exception {
		DataBase db = DataBase.getInstance();
		MainApp.eventos = db.getEventos();
		MainApp.eventosDoDia = new ArrayList<Evento>();
		Date today = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		for(Evento e : MainApp.eventos){
			if(fmt.format(today).equals(fmt.format(e.getDataInicioEvento()))) {
				MainApp.eventosDoDia.add(e);
			}
		}
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
		mStage.setTitle("AgendaVirtal");
		mStage.setResizable(false);
		mStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
