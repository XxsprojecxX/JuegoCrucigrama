package co.edu.poli.crucigrama.view;

import java.io.IOException;
import co.edu.poli.crucigrama.controller.ControladorVistaPrincipal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

/**
 * Clase que implementa la vista principal del crucigrama.
 */
public class VistaImplementacion extends Application {

    /**
     * Método principal para iniciar la aplicación.
     * 
     * @param primaryStage el escenario principal de la aplicación
     * @throws IOException si ocurre un error de entrada/salida
     */
    public void start(Stage primaryStage) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaPrincipal.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setTitle("CRUCIGRAMA");
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image("/co/edu/poli/crucigrama/view/icono.PNG"));
            ControladorVistaPrincipal controladorVistaPrincipal = loader.getController();
            controladorVistaPrincipal.setStage(primaryStage);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método principal de la aplicación.
     * 
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }
}
