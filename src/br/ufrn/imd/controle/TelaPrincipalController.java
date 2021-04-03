package br.ufrn.imd.controle;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaPrincipalController {

    @FXML
    private MenuItem menuItemCadastro;

    @FXML
    private MenuItem menuItemEditar;

    @FXML
    private MenuItem menuItemListar;

    @FXML
    private MenuItem menuItemSobreApp;

    @FXML
    private MenuItem menuItemSair;

    @FXML
    private Button buttonSairApp;

    @FXML
    private Button buttonContinuar;

    @FXML
    void buttonSairApp(ActionEvent event) {
    	//
    	System.exit(0);
    }

    @FXML
    void cadastrarEvento(ActionEvent event) throws IOException{
    	carregarTelaPrincipal();
    }

    @FXML
    void continuarCadastroEvento(ActionEvent event) throws IOException {
    	//
    	carregarTelaPrincipal();
    }

    @FXML
    void editarEvento(ActionEvent event) throws IOException {
    	//
    	carregarTelaEditarEvento();
    }

    @FXML
    void listarEventos(ActionEvent event) throws IOException {
    	//
    	carregarTelaListarEventos();
    }

    @FXML
    void sairApp(ActionEvent event) {
    	//
    	System.exit(0);
    }

    @FXML
    void sobreAplicacao(ActionEvent event) throws IOException {
    	carregarTelaSobreApp();
    }
    
    private void carregarTelaPrincipal() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaCadastroEventoController.class.getResource("/br/ufrn/imd/visao/TelaCadastroEvento.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage clienteStage = new Stage();
    	clienteStage.setTitle("Cadastro de Clientes");
    	clienteStage.setResizable(false);
    	Scene scene = new Scene(page);
    	clienteStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaCadastroEventoController controller = loader.getController();
    	controller.setClienteStage(clienteStage);
    	clienteStage.showAndWait();
    }
    
    private void carregarTelaSobreApp() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaSobreAppController.class.getResource("/br/ufrn/imd/visao/TelaSobreApp.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage clienteStage = new Stage();
    	clienteStage.setTitle("Sobre App");
    	clienteStage.setResizable(false);
    	Scene scene = new Scene(page);
    	clienteStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaSobreAppController controller = loader.getController();
    	controller.setClienteStage(clienteStage);
    	clienteStage.showAndWait();
    }
    
    private void carregarTelaEditarEvento() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaEditarEventoController.class.getResource("/br/ufrn/imd/visao/TelaEditarEvento.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage clienteStage = new Stage();
    	clienteStage.setTitle("Editar Evento");
    	clienteStage.setResizable(false);
    	Scene scene = new Scene(page);
    	clienteStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaEditarEventoController controller = loader.getController();
    	controller.setClienteStage(clienteStage);
    	clienteStage.showAndWait();
    }
    
    private void carregarTelaListarEventos() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaListarEventosController.class.getResource("/br/ufrn/imd/visao/TelaListarEventos.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage clienteStage = new Stage();
    	clienteStage.setTitle("Editar Evento");
    	clienteStage.setResizable(false);
    	Scene scene = new Scene(page);
    	clienteStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaListarEventosController controller = loader.getController();
    	controller.setClienteStage(clienteStage);
    	clienteStage.showAndWait();
    }
    
}