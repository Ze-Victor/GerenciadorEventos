package br.ufrn.imd.controle;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.modelo.DataBase;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import br.ufrn.imd.modelo.EventoMensal;
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

public class TelaCadastroEventoMensalController {

	private Stage clienteStage;
	
	ObservableList listaDia = FXCollections.observableArrayList();
	
	private boolean btnConfirmarClicked = false;
	
	DataBase db;
	
    @FXML
    private TextArea textDescricaoEvento;

    @FXML
    private TextField textTituloEvento;
    
    @FXML
    private ChoiceBox<Integer> choiceBoxDia;

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
	      	e.setDiaDoMes(choiceBoxDia.getValue());
	      	e.setDescricaoCompleta();
	      
	    	
	    	MainApp.eventos.add(e);
	    	MainApp.carregarEventosDia();
	    	db.save();
	    	System.out.println("Evento Mensal Inserido!");
	    	
	    	//System.out.println("Data: " + e.getDataInicioEvento() + "Até" + e.getDataFinalEvento());

    	}
    	
    	clienteStage.close();
    }
    
    private void loaderDia() {
		listaDia.removeAll(listaDia);
		
		for(int i = 1; i<31; i++) {
			listaDia.add(i);
		}
		
		choiceBoxDia.setItems(listaDia);
	}
    
    

	public void setClienteStage(Stage clienteStage) {
		// TODO Auto-generated method stub
		this.clienteStage = clienteStage;
		loaderDia();
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