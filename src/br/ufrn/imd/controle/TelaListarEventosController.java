package br.ufrn.imd.controle;

import java.util.List;
import java.util.ResourceBundle;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.modelo.Evento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TelaListarEventosController implements Initializable {

	private Stage clienteStage;
	
	private List<Evento> lista;
    private ObservableList <Evento> observableLista;
	
	 @FXML
	 private TableView<Evento> tableViewEventos;

	 @FXML
	 private TableColumn<Evento, String> tableColumnTitulo;
	 
	 @FXML
	 private TableColumn<Evento, String> tableColumnTipo;

	 @FXML
	 private TableColumn<Evento, String> tableColumnDescricao;

	 @FXML
	 private Button buttonRetornar;

	 @FXML
	 private Label textLabelTitulo;

	 @FXML
	 private Label textLabelTipo;

	 @FXML
	 private Label textLabelDescricao;


	    
	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
			carregarTableViewEvento();
			
			tableViewEventos.getSelectionModel().selectedItemProperty().addListener(
					(observableValue, oldValue, newValue) -> selectionEventoTableView(newValue));
	}
	
	private void selectionEventoTableView(Evento newValue) {

		textLabelTitulo.setText(newValue.getTituloEvento());
		textLabelTipo.setText(newValue.getTipoEvento());
		textLabelDescricao.setText(newValue.getDescricaoEvento());
	}

	public void carregarTableViewEvento() {

    	tableColumnTitulo.setCellValueFactory(new PropertyValueFactory<>("tituloEvento"));
    	tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricaoEvento"));
    	tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipoEvento"));
 		
		lista = MainApp.eventos;
		
		observableLista = FXCollections.observableArrayList(lista);
		
		tableViewEventos.setItems(observableLista);
    }
    

    @FXML
    void retornarTelaPrincipal(ActionEvent event) {
    	clienteStage.close();
    }

	public void setClienteStage(Stage clienteStage) {
		// TODO Auto-generated method stub
		this.clienteStage = clienteStage;
	}

}
