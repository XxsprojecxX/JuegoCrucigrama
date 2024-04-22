package co.edu.poli.crucigrama.view;

import co.edu.poli.crucigrama.conexionBD.Conexion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class VistaImplementacion extends Application {
	@Override
	public void start(Stage primaryStage) {

		Conexion conexion = new Conexion(); 
		conexion.conectar(); 
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("cruci2.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("CRUCIGRAMA");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
