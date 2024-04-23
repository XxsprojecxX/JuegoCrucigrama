package co.edu.poli.crucigrama.view;

import java.io.IOException;
import java.util.Scanner;

import co.edu.poli.crucigrama.controller.ControladorVistaPrincipal;
import co.edu.poli.crucigrama.model.Crucigrama;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class VistaImplementacion extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {

		Crucigrama crucigrama = new Crucigrama();
		crucigrama.obtenerPalabras();
//		crucigrama.validarPalabra("Algoritmo");
//		Scanner teclado = new Scanner(System.in);
//		int cerrar = 0;
//
//		while (cerrar == 0) {
//			System.out.println("\nCRUCIGRAMA\n");
//			crucigrama.mostrarCrucigrama();
//			crucigrama.imprimirRespuestas();
//			System.out.println("\nIngrese el id de la palabra a validar:");
//			int id = teclado.nextInt();
//			crucigrama.validarPalabra(id);
//		}

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
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
