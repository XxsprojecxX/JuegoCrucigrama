package co.edu.poli.crucigrama.view;

import java.io.IOException;
import java.util.Scanner;
import co.edu.poli.crucigrama.controller.ControladorVistaPrincipal;
import co.edu.poli.crucigrama.model.Crucigrama;
import co.edu.poli.crucigrama.model.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class VistaImplementacion extends Application {
	public void start(Stage primaryStage) throws IOException {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaPrincipal.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("CRUCIGRAMA");
			primaryStage.setScene(scene);
			ControladorVistaPrincipal controladorVistaPrincipal = loader.getController();
			controladorVistaPrincipal.setStage(primaryStage);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
