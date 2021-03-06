package br.ufrn.imd.controle;

import java.io.IOException;

import br.ufrn.imd.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaCadastroEventoController {
	
	ObservableList lista = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> selectorTipoEvento;
    
    private Stage clienteStage;
    
    @FXML
    private Label labelDefault;

    @FXML
    private Button buttonAvançar;
    
    @FXML
    private Button buttonVoltar;

    @FXML
    void avançarCadastro(ActionEvent event) throws IOException {
    	String tipo = selectorTipoEvento.getValue();
    	if(tipo == null) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("SELECIONE UM TIPO DE EVENTO");
			alert.show();
    	}else if(tipo == "Diário"){
    		eventoDiario();
    		//clienteStage.close();
    	}else if(tipo == "Semanal"){
    		eventoSemanal();
    		//clienteStage.close();
    		
    	}else if(tipo == "Mensal"){
    		eventoMensal();
    		//clienteStage.close();
    		
    	}else if(tipo == "Temporario") {
    		eventoTemporario();
    	}
    	
    }
    
    @FXML
    void voltarTelaPrincipal(ActionEvent event) throws IOException {
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
		String d = "Temporario";
		
		lista.addAll(a,b,c,d);
		selectorTipoEvento.getItems().addAll(lista);
	}
	
	private void eventoDiario() throws IOException , IllegalStateException{
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaCadastroEventoDiarioController.class.getResource("/br/ufrn/imd/visao/TelaCadastroEventoDiario.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage clienteStage = new Stage();
    	clienteStage.setTitle("Cadastro de Evento");
    	clienteStage.setResizable(false);
    	Scene scene = new Scene(page);
    	clienteStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaCadastroEventoDiarioController controller = loader.getController();
    	controller.setClienteStage(clienteStage);
    	clienteStage.showAndWait();
	}
	
	private void eventoSemanal() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaCadastroEventoSemanalController.class.getResource("/br/ufrn/imd/visao/TelaCadastroEventoSemanal.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage clienteStage = new Stage();
    	clienteStage.setTitle("Cadastro de Evento");
    	clienteStage.setResizable(false);
    	Scene scene = new Scene(page);
    	clienteStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaCadastroEventoSemanalController controller = loader.getController();
    	controller.setClienteStage(clienteStage);
    	clienteStage.showAndWait();
    	
	}
	
	private void eventoMensal() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaCadastroEventoMensalController.class.getResource("/br/ufrn/imd/visao/TelaCadastroEventoMensal.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage clienteStage = new Stage();
    	clienteStage.setTitle("Cadastro de Evento");
    	clienteStage.setResizable(false);
    	Scene scene = new Scene(page);
    	clienteStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaCadastroEventoMensalController controller = loader.getController();
    	controller.setClienteStage(clienteStage);
    	clienteStage.showAndWait();
	}
	
	private void eventoTemporario() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaCadastroEventoTemporarioController.class.getResource("/br/ufrn/imd/visao/TelaCadastroEventoTemporario.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage clienteStage = new Stage();
    	clienteStage.setTitle("Cadastro de Evento");
    	clienteStage.setResizable(false);
    	Scene scene = new Scene(page);
    	clienteStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaCadastroEventoTemporarioController controller = loader.getController();
    	controller.setClienteStage(clienteStage);
    	clienteStage.showAndWait();
	}

}