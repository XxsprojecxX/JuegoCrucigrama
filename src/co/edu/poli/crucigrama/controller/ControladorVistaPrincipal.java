package co.edu.poli.crucigrama.controller;

import java.io.IOException;

import co.edu.poli.crucigrama.model.Crucigrama;
import co.edu.poli.crucigrama.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class ControladorVistaPrincipal {

	private Stage stage;

	@FXML
	private TextField txtCruzAlgoritmoPG;

	@FXML
	void ShowCrucigrama(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/poli/crucigrama/view/Crucigrama.fxml"));
		Parent root = loader.load();
		ControladorCrucigrama controller = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		controller.init(stage, this);
		stage.show();
		this.stage.close();
		Usuario nuevoUsuario = new Usuario(4, "Andre", 0);
		//nuevoUsuario.obtenerUsuario(3);

	}

	public void setStage(Stage primaryStage) {
		stage = primaryStage;
	}

}
