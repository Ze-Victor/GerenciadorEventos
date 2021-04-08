package br.ufrn.imd.controle;
<<<<<<< HEAD
=======
import java.io.IOException;
>>>>>>> ee179e232821f7f07e0b4b547ba06cf3ddf12f30
import java.util.Date;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.modelo.DataBase;
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
<<<<<<< HEAD
	void cadastrarEventoDB(ActionEvent event) {
		
		btnConfirmarClicked = true;
=======
	void cadastrarEventoDB(ActionEvent event) throws IOException {
btnConfirmarClicked = true;
>>>>>>> ee179e232821f7f07e0b4b547ba06cf3ddf12f30
    	
    	if (btnConfirmarClicked){
    	
    		db = DataBase.getInstance();
    		
	    	EventoMensal e = new EventoMensal();
	    	e.setTituloEvento(textTituloEvento.getText());
	    	e.setDescricaoEvento(textDescricaoEvento.getText());
	    	e.setTipoEvento();
	    	
	    	
	    	Date data = new Date(datePickerEvento.getValue().toEpochDay());
	    	e.setDataInicioEvento(data);
	    	
	    	db.inserirEvento(e);
<<<<<<< HEAD
    	
    	}
    	
    	clienteStage.close();
=======
	    	
    	
    	}
    	voltarTelaPrincipal();
>>>>>>> ee179e232821f7f07e0b4b547ba06cf3ddf12f30
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