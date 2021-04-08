package br.ufrn.imd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	public static Stage mStage;

	public void change_scene(Scene s)
    {
        mStage.setScene(s);
    }

	@Override
	public void start(Stage stage) throws Exception {
		mStage = stage;
		Parent root = FXMLLoader.load(getClass().getResource("visao/TelaPrincipal.fxml"));
		Scene scene = new Scene(root);
		mStage.setScene(scene);
		mStage.setTitle("AgendaVirtal");
		mStage.setResizable(false);
		mStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
