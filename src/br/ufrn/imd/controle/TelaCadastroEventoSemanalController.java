package br.ufrn.imd.controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastroEventoSemanalController {

	private Stage clienteStage;
	
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
    	//
    }

	public void setClienteStage(Stage clienteStage) {
		// TODO Auto-generated method stub
		this.clienteStage = clienteStage;
	}


}
