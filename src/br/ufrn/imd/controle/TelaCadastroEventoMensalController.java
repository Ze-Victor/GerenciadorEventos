package br.ufrn.imd.controle;

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
    	
    	EventoMensal e = new EventoMensal();
    	e.setTituloEvento(textTituloEvento.getText());
    	e.setDescricaoEvento(textDescricaoEvento.getText());
    	e.setTipoEvento();
    	
    	Date dataInicio = new Date(datePickerInicioEvento.getValue().toEpochDay());
    	e.setDataInicioEvento(dataInicio);
    	
    	Date dataFinal = new Date(datePickerFinalEvento.getValue().toEpochDay());
    	e.setDataFinalEvento(dataFinal);
    	
    	System.out.println("Evento " + e.getTipoEvento() + " Cadastrado para " + dataInicio + " até " + dataFinal);
    	
    	
    }

	public void setClienteStage(Stage clienteStage) {
		// TODO Auto-generated method stub
		this.clienteStage = clienteStage;
	}

}