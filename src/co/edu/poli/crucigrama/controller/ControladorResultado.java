package co.edu.poli.crucigrama.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * La clase {@code ControladorResultado} gestiona la visualización de los resultados
 * del crucigrama en la interfaz de usuario.
 */
public class ControladorResultado {

    @FXML
    private Text Resultados;

    /**
     * Inicializa la vista de resultados con el texto proporcionado.
     * 
     * @param validarPalabras el texto que contiene los resultados de la validación de palabras.
     */
    public void init(String validarPalabras) {
        Resultados.setText(validarPalabras);
    }
}
