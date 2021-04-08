package br.ufrn.imd.controle;

import br.ufrn.imd.modelo.DataBase;

import java.util.Date;

import br.ufrn.imd.modelo.EventoMensal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastroEventoMensalController {

	private Stage clienteStage;
	
	private boolean btnConfirmarClicked = false;
	
	DataBase db;
	
    @FXML
    private TextArea textDescricaoEvento;

    @FXML
    private TextField textTituloEvento;

    @FXML
    private DatePicker datePickerInicioEvento;

    @FXML
    private DatePicker datePickerFinalEvento;

    @FXML
    private Button buttonCadastrarEvento;

    @FXML
    void cadastrarEvento(ActionEvent event) {
    	
    	btnConfirmarClicked = true;
    	
    	if (btnConfirmarClicked){
    	
    		db = DataBase.getInstance();
    		
	    	EventoMensal e = new EventoMensal();
	    	e.setTituloEvento(textTituloEvento.getText());
	    	e.setDescricaoEvento(textDescricaoEvento.getText());
	    	e.setTipoEvento();
	    	
	    	
	    	Date dataInicio = new Date(datePickerInicioEvento.getValue().toEpochDay());
	    	e.setDataInicioEvento(dataInicio);
	    	
	    	Date dataFinal = new Date(datePickerFinalEvento.getValue().toEpochDay());
	    	e.setDataFinalEvento(dataFinal);
	    	
	    	db.inserirEvento(e);
	    	//db.list();

    	}
    	
    	clienteStage.close();
    	
    }
    
    

	public void setClienteStage(Stage clienteStage) {
		// TODO Auto-generated method stub
		this.clienteStage = clienteStage;
	}

}