package br.ufrn.imd.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.modelo.DataBase;
import br.ufrn.imd.modelo.Evento;
import br.ufrn.imd.modelo.EventoDiario;
import br.ufrn.imd.modelo.EventoMensal;
import br.ufrn.imd.modelo.EventoSemanal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TelaEditarEventoController implements Initializable{

    private Stage clienteStage;
    
    ObservableList listaChoice = FXCollections.observableArrayList();
    
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
    private TextField textFieldTitulo;

    @FXML
    private ChoiceBox<String> choiceBoxTipo;

    @FXML
    private TextArea textDescricao;

    @FXML
    private Button buttonSalvar;

    @FXML
    private Button buttonRemover;

    @FXML
    void removerEvento(ActionEvent event) {
    	Evento evento = tableViewnEventos.getSelectionModel().getSelectedItem();
    	
    	if(evento != null) {
    		db.removeEvento(evento);
    	} else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("SELECIONE UM ITEM NA TABELA");
    		alert.show();
    	}
    }

    @FXML
    void salvarAleteracoes(ActionEvent event) {
    	// TODO Auto-generated method stub
    	Evento evento = tableViewnEventos.getSelectionModel().getSelectedItem();
    	db = DataBase.getInstance();
    			
    	if(evento != null) {
    		evento.setTituloEvento(textFieldTitulo.getText());
    		//evento.setTipoEvento(choiceBoxTipo.getValue());
    		evento.setDescricaoEvento(textDescricao.getText());
    				
    		//carregarTableViewEvento();
    				
    	} else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("SELECIONE UM ITEM NA TABELA");
    		alert.show();
    	}
    	//db.setEventos((ArrayList<Evento>)db.getEventos());
    	db.save();
    }

	@FXML
    void retornarTelaPrincipal(ActionEvent event) {
    	//
    	clienteStage.close();
    }

	public void setClienteStage(Stage clienteStage) {
		// TODO Auto-generated method stub
		this.clienteStage = clienteStage;
		carregarChoice();
	}

	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		carregarTableViewEvento();
		
		tableViewnEventos.getSelectionModel().selectedItemProperty().addListener(
				(observableValue, oldValue, newValue) -> selectionEventoTableView(newValue));
	}


	public void selectionEventoTableView(Evento newValue) {
		// TODO Auto-generated method stub
		textFieldTitulo.setText(newValue.getTituloEvento());
		textDescricao.setText(newValue.getDescricaoEvento());
		choiceBoxTipo.setValue(newValue.getTipoEvento());
	}

	public void carregarTableViewEvento() {

		tableColunmTItulo.setCellValueFactory(new PropertyValueFactory<>("tituloEvento"));
		tableColunmDescricao.setCellValueFactory(new PropertyValueFactory<>("descricaoEvento"));
		tableColunmTipo.setCellValueFactory(new PropertyValueFactory<>("tipoEvento"));
		
		lista = MainApp.eventos;
		
		observableLista = FXCollections.observableArrayList(lista);
		
		tableViewnEventos.setItems(observableLista);
    }
	
	private void carregarChoice() {
		listaChoice.removeAll(listaChoice);
		
		String a = "Diário";
		String b = "Semanal";
		String c = "Mensal";
		
		listaChoice.addAll(a,b,c);
		choiceBoxTipo.setItems(listaChoice);
	}

}
