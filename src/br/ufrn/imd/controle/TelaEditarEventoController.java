package br.ufrn.imd.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.modelo.DataBase;
import br.ufrn.imd.modelo.Evento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TelaEditarEventoController implements Initializable{

    private Stage clienteStage;
    
    DataBase db;
    
    private List<Evento> lista;
    private ObservableList <Evento> observableLista;
    
    @FXML
    private TableView<Evento> tableViewnEventos;

    @FXML
    private TableColumn<Evento, String> tableColunmTItulo;

    @FXML
    private TableColumn<Evento, String> tableColunmTipo;
    
    @FXML
    private TableColumn<Evento, String> tableColunmDescricao;
	
	@FXML
    private Button btnRetornar;

    @FXML
    void retornarTelaPrincipal(ActionEvent event) {
    	//
    	clienteStage.close();
    }

	public void setClienteStage(Stage clienteStage) {
		// TODO Auto-generated method stub
		this.clienteStage = clienteStage;
	}

	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		carregarTableViewEvento();
	}


	public void carregarTableViewEvento() {
		
		db = DataBase.getInstance();
		
		tableColunmTItulo.setCellValueFactory(new PropertyValueFactory<>("tituloEvento"));
		tableColunmDescricao.setCellValueFactory(new PropertyValueFactory<>("descricaoEvento"));
		tableColunmTipo.setCellValueFactory(new PropertyValueFactory<>("tipoEvento"));
		
		lista = db.listar();
		
		observableLista = FXCollections.observableArrayList(lista);
		
		tableViewnEventos.setItems(observableLista);
    }

}
