package br.ufrn.imd.controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaEditarEventoController {

    private Stage clienteStage;
	
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

}
