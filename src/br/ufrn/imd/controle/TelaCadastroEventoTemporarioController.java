package br.ufrn.imd.controle;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.modelo.DataBase;
import br.ufrn.imd.modelo.EventoTemporario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastroEventoTemporarioController {

	private Stage clienteStage;
	
	DataBase db;
	
	private boolean btnConfirmarClicked = false;
	
    @FXML
    private TextField textTitulo;

    @FXML
    private TextArea textDescricao;

    @FXML
    private DatePicker datePickerEvento;
    
    @FXML
    private Button buttonCadastrarEvento;

    @FXML
    void cadastrarEventoDB(ActionEvent event) {
    	btnConfirmarClicked = true;

    	
    	if (btnConfirmarClicked){
    	
    		db = DataBase.getInstance();
    		
	    	EventoTemporario e = new EventoTemporario();
	    	
	    	e.setTituloEvento(textTitulo.getText());
	    	e.setTipoEvento();
	      	e.setDescricaoEvento(textDescricao.getText());
	      	
	      	LocalDate data = datePickerEvento.getValue();
	        Instant instant = Instant.from(data.atStartOfDay(ZoneId.systemDefault()));
	        Date date = Date.from(instant);
	        
	        e.setDataEvento(date);
	    	
	    	MainApp.eventos.add(e);
	    	MainApp.carregarEventosDia();
	    	db.save();
	    	System.out.println("Evento Temporario Inserido! ");
	    	System.out.println(date);
    	}
    	
    	clienteStage.close();
    }

	public void setClienteStage(Stage clienteStage) {
		// TODO Auto-generated method stub
		this.clienteStage = clienteStage;
	}

}
