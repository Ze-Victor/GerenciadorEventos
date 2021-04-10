package br.ufrn.imd.controle;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.modelo.DataBase;

import java.io.IOException;

import java.util.Date;

import br.ufrn.imd.modelo.EventoMensal;
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

    public void cadastrarEvento(ActionEvent event) {
    	
    	btnConfirmarClicked = true;
    	
    	if (btnConfirmarClicked){
    	
    		db = DataBase.getInstance();
    		
	    	EventoMensal e = new EventoMensal();
	    	
	    	e.setTituloEvento(textTituloEvento.getText());
	    	e.setTipoEvento();
	      	e.setDescricaoEvento(textDescricaoEvento.getText());
	    	
	    	Date dataInicio = new Date(datePickerInicioEvento.getValue().toEpochDay());
	    	e.setDataInicioEvento(dataInicio);
	    	
	    	Date dataFinal = new Date(datePickerFinalEvento.getValue().toEpochDay());
	    	e.setDataFinalEvento(dataFinal);
	    	
	    	db.inserirEvento(e);
	    	System.out.println("Evento Mensal Inserido!");

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