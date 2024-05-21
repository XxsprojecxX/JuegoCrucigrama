package co.edu.poli.crucigrama.controller;

import java.io.IOException;
import co.edu.poli.crucigrama.conexionBD.CRUD;
import co.edu.poli.crucigrama.model.Crucigrama;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

/**
 * Controlador para la vista principal del crucigrama.
 */
public class ControladorVistaPrincipal {

    private Stage stage;

    @FXML
    private TextField txtUsuario;

    /**
     * Maneja el evento de mostrar el crucigrama.
     * 
     * @param event el evento de clic en el botón para mostrar el crucigrama
     * @throws IOException si hay un error al cargar la vista del crucigrama
     */
    @FXML
    void ShowCrucigrama(ActionEvent event) throws IOException {
        // Crear una nueva instancia de Crucigrama y CRUD
        Crucigrama crucigrama = new Crucigrama();
        CRUD crud = new CRUD();
        
        // Cargar la vista del crucigrama
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/poli/crucigrama/view/Crucigrama.fxml"));
        Parent root = loader.load();
        ControladorCrucigrama controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        
        // Inicializar el controlador del crucigrama y mostrar la ventana
        controller.init(stage, this);
        controller.mostrarPistas(crucigrama.obtenerPistas());
        crud.insertarNuevoUsuario(txtUsuario.getText());
        controller.actualizarUsuario(txtUsuario.getText());
        stage.show();
        
        // Cerrar la ventana actual
        this.stage.close();
    }

    /**
     * Establece la instancia de la ventana principal.
     * 
     * @param primaryStage la instancia de la ventana principal
     */
    public void setStage(Stage primaryStage) {
        stage = primaryStage;
    }
}
