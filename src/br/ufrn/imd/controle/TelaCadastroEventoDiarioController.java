package br.ufrn.imd.controle;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.modelo.DataBase;
import br.ufrn.imd.modelo.EventoDiario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaCadastroEventoDiarioController {

	private Stage clienteStage;
	
	DataBase db;
	
	private boolean btnConfirmarClicked = false;
		
	@FXML
	private TextArea textDescricaoEvento;

	@FXML
	private TextField textTituloEvento;

	@FXML
	private DatePicker datePickerEvento;

	@FXML
	private Button buttonCadastrarEvento;

	@FXML	
	public void cadastrarEventoDB(ActionEvent event) throws IOException {
		btnConfirmarClicked = true;

    	
    	if (btnConfirmarClicked){
    	
    		db = DataBase.getInstance();
    		
	    	EventoDiario e = new EventoDiario();
	    	
	    	e.setTituloEvento(textTituloEvento.getText());
	    	e.setTipoEvento();
	      	e.setDescricaoEvento(textDescricaoEvento.getText());
	      	
	      	LocalDate data = datePickerEvento.getValue();
	        Instant instant = Instant.from(data.atStartOfDay(ZoneId.systemDefault()));
	        Date date = Date.from(instant);
	        
	    	//Date data = new Date(datePickerEvento.getValue().toEpochDay());
	    	e.setDataInicioEvento(date);
	    	
	    	System.out.println("Data: " + date);
	    	
	    	MainApp.eventos.add(e);
	    	MainApp.carregarEventosDia();
	    	db.save();
	    	System.out.println("Evento Diário Inserido! ");
    	}
    	
    	clienteStage.close();
	}

	public void setClienteStage(Stage clienteStage) {
		// TODO Auto-generated method stub
		this.clienteStage = clienteStage;
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