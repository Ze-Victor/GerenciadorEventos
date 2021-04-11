package br.ufrn.imd.controle;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.modelo.DataBase;
import br.ufrn.imd.modelo.EventoSemanal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaCadastroEventoSemanalController {

	private Stage clienteStage;
	
	ObservableList listaDiaSemana = FXCollections.observableArrayList();
	
	private boolean btnConfirmarClicked = false;
	
	DataBase db;
	
    @FXML
    private TextArea textDescricaoEvento;

    @FXML
    private TextField textTituloEvento;
    
    @FXML
    private ChoiceBox<String> choiceBoxDiaSemana;

    @FXML
    private Button buttonCadastrarEvento;

    @FXML

    public void cadastrarEventoDB(ActionEvent event) {
    	btnConfirmarClicked = true;
    	
    	if (btnConfirmarClicked){
    	
    		db = DataBase.getInstance();
    		
	    	EventoSemanal e = new EventoSemanal();
	    	
	    	e.setTituloEvento(textTituloEvento.getText());
	    	e.setTipoEvento();
	      	e.setDescricaoEvento(textDescricaoEvento.getText());
	      	e.setDiaSemana(choiceBoxDiaSemana.getValue());
	    	
	    	MainApp.eventos.add(e);
	    	db.save();
	    	System.out.println("Evento Semanal Inserido!");
	    	
	    	//System.out.println("Data: " + e.getDataInicioEvento() + " Até " + e.getDataFinalEvento());
    	
    	}
    	
    	clienteStage.close();

    }
    
    private void loaderDiaSemana() {
		listaDiaSemana.removeAll(listaDiaSemana);
		
		String a = "DOMINGO";
		String b = "SEGUNDA-FEIRA";
		String c = "TERÇA-FEIRA";
		String d = "QUARTA-FEIRA";
		String e = "QUINTA-FEIRA";
		String f = "SEXTA-FEIRA";
		String g = "SABADO";
		
		listaDiaSemana.addAll(a,b,c, d, e, f, g);
		choiceBoxDiaSemana.setItems(listaDiaSemana);
	}
    
	public void setClienteStage(Stage clienteStage) {
		// TODO Auto-generated method stub
		this.clienteStage = clienteStage;
		loaderDiaSemana();
	}
	
	void voltarTelaPrincipal() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaPrincipalController.class.getResource("/br/ufrn/imd/visao/TelaPrincipal.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage clienteStage = MainApp.mStage;
    	clienteStage.setTitle("AgendaVirtal");
    	clienteStage.setResizable(false);
    	Scene scene = new Scene(page);
    	clienteStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaPrincipalController controller = loader.getController();
    	//controller.setClienteStage(clienteStage);
    	//clienteStage.showAndWait();
    }


}