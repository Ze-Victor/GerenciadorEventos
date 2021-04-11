package br.ufrn.imd.controle;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.modelo.Evento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaPrincipalController implements Initializable {
	
	private List<Evento> lista;
    private ObservableList <Evento> observableLista;

    @FXML
    private AnchorPane rootPane;
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
    private TableView<Evento> tableViewEventosDia;

    @FXML
    private TableColumn<Evento, String> tableColumnTitulo;

    @FXML
    private TableColumn<Evento, String> tableColumnTipo;

    @FXML
    private TableColumn<Evento, String> tableColumnDescricao;

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
    
    @Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		carregarTableViewEvento();
	}
    
    public void carregarTableViewEvento() {

    	tableColumnTitulo.setCellValueFactory(new PropertyValueFactory<>("tituloEvento"));
    	tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricaoCompleta"));
    	tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipoEvento"));
		
		lista = MainApp.eventosDoDia;
		
		observableLista = FXCollections.observableArrayList(lista);
		
		tableViewEventosDia.setItems(observableLista);
    }
    
    private void carregarTelaPrincipal() throws IOException, IllegalStateException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaCadastroEventoController.class.getResource("/br/ufrn/imd/visao/TelaCadastroEvento.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage clienteStage = MainApp.mStage;
    	clienteStage.setTitle("Cadastro de Clientes");
    	clienteStage.setResizable(false);
    	Scene scene = new Scene(page);
    	clienteStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaCadastroEventoController controller = loader.getController();
    	controller.setClienteStage(clienteStage);
    	//clienteStage.showAndWait();
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
    	controller.pai = this;
    	controller.setClienteStage(clienteStage);
    	clienteStage.showAndWait();
    }
    
    private void carregarTelaListarEventos() throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaListarEventosController.class.getResource("/br/ufrn/imd/visao/TelaListarEventos.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage clienteStage = new Stage();
    	clienteStage.setTitle("Lista de Eventos");
    	clienteStage.setResizable(false);
    	Scene scene = new Scene(page);
    	clienteStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaListarEventosController controller = loader.getController();
    	controller.setClienteStage(clienteStage);
    	clienteStage.showAndWait();
    }
    
}