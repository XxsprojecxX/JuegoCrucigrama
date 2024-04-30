package co.edu.poli.crucigrama.controller;

	import javafx.fxml.FXML;
	import javafx.scene.text.Text;

	public class ControladorResultado {

	    @FXML
	    private Text Resultados;

		public void init(String validarPalabras) {
			Resultados.setText(validarPalabras);
		}

	}



