package co.edu.poli.crucigrama.view;

import java.io.IOException;

import co.edu.poli.crucigrama.controller.ControladorVistaPrincipal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * La clase {@code VistaImplementacion} es la implementaci�n principal de la interfaz de usuario para el crucigrama.
 * Extiende {@code Application} de JavaFX para iniciar la aplicaci�n.
 */
public class VistaImplementacion extends Application {

    /**
     * El m�todo {@code start} inicializa la interfaz de usuario del crucigrama.
     * 
     * @param primaryStage el escenario principal de la aplicaci�n.
     * @throws IOException si ocurre un error al cargar la vista principal.
     */
    @Override
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
        }
    }

    /**
     * El m�todo {@code main} es el punto de entrada de la aplicaci�n.
     * 
     * @param args los argumentos de la l�nea de comandos (no se utilizan en esta aplicaci�n).
     */
    public static void main(String[] args) {
        launch(args);
    }
}
