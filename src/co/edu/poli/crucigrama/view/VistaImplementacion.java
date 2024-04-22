package co.edu.poli.crucigrama.view;

import java.util.Scanner;
import co.edu.poli.crucigrama.model.Crucigrama;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class VistaImplementacion extends Application {
	@Override
	public void start(Stage primaryStage) {

		Crucigrama crucigrama = new Crucigrama();
		crucigrama.obtenerPalabras();
		Scanner teclado = new Scanner(System.in);
		int cerrar = 0;

		while (cerrar == 0) {
			System.out.println("\nCRUCIGRAMA\n");
			crucigrama.mostrarCrucigrama();
			crucigrama.imprimirRespuestas();
			System.out.println("\nIngrese el id de la palabra a validar:");
			int id = teclado.nextInt();
			crucigrama.validarPalabra(id);
		}

		try {
			Parent root = FXMLLoader.load(getClass().getResource("crucigrama.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("CRUCIGRAMA");
			primaryStage.setScene(scene);
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
