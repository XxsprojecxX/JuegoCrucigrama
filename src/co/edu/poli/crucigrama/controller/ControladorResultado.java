package co.edu.poli.crucigrama.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * Controlador para la vista de resultados del crucigrama.
 */
public class ControladorResultado {

    @FXML
    private Text Resultados;

    /**
     * Inicializa la vista de resultados con el texto proporcionado.
     * 
     * @param validarPalabras el texto a mostrar en la vista de resultados
     */
    public void init(String validarPalabras) {
        Resultados.setText(validarPalabras);
    }
}
