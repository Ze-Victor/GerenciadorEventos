package br.ufrn.imd.controle;
import java.util.Date;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.modelo.DataBase;
import br.ufrn.imd.modelo.EventoMensal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
	void cadastrarEventoDB(ActionEvent event) {
		
		btnConfirmarClicked = true;
    	
    	if (btnConfirmarClicked){
    	
    		db = DataBase.getInstance();
    		
	    	EventoMensal e = new EventoMensal();
	    	e.setTituloEvento(textTituloEvento.getText());
	    	e.setDescricaoEvento(textDescricaoEvento.getText());
	    	e.setTipoEvento();
	    	
	    	
	    	Date data = new Date(datePickerEvento.getValue().toEpochDay());
	    	e.setDataInicioEvento(data);
	    	
	    	db.inserirEvento(e);
    	
    	}
    	
    	clienteStage.close();
	}

	public void setClienteStage(Stage clienteStage) {
		// TODO Auto-generated method stub
		this.clienteStage = clienteStage;
	}

}