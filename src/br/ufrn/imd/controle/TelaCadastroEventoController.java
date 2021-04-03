package br.ufrn.imd.controle;


import java.util.Date;

import br.ufrn.imd.modelo.Evento;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastroEventoController {
	
	ObservableList lista = FXCollections.observableArrayList();
	
	private Stage clienteStage;
	

    @FXML
    private TextField textFieldTítuloEvento;

    @FXML
    private TextArea textDescricao;

    @FXML
    private DatePicker datePickerEvento;

    @FXML
    private ChoiceBox<String> selectorTipoEvento;

    @FXML
    private Button buttonCadatrarEvento;

    @FXML
    private Button buttonCancelar;

    @FXML
    void buttonCancelarCadastro(ActionEvent event) {
    	//
    	clienteStage.close();
    }

    @FXML
    void cadastrarEventoNoDB(ActionEvent event) {
    	
    	Evento e = new Evento();
    	
    	e.setTituloEvento(textFieldTítuloEvento.getText());
    	
    	//Pegar tipo do evento com choiceBox
    	String tipo = selectorTipoEvento.getValue();
    	if(tipo == null) {
    		System.out.println("Selecione um item");
    	}else {
    		e.setTipoEvento(tipo);
    	}
    	
    	//pegar data do datePicker
    	Date data = new Date(datePickerEvento.getValue().toEpochDay());
    	e.setDataEvento(data);
    	
    	e.setDescricaoEvento(textDescricao.getText());
    	
    	System.out.println("Evento Cadastrado");
    }

	public void setClienteStage(Stage clienteStage) {
		// TODO Auto-generated method stub
		this.clienteStage = clienteStage;
		loaderData();
	}
	
	private void loaderData() {
		lista.removeAll(lista);
		
		String a = "Diário";
		String b = "Semanal";
		String c = "Mensal";
		
		lista.addAll(a,b,c);
		selectorTipoEvento.getItems().addAll(lista);
	}

}