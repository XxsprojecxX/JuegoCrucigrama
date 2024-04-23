package co.edu.poli.crucigrama.controller;

import co.edu.poli.crucigrama.model.Crucigrama;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControladorCrucigrama {

	private ControladorVistaPrincipal controladorVistaPrincipal;
	private Stage stage;
	private String algoritmo;

	@FXML
	private TextField BD_10;

	@FXML
	private TextField BD_2;

	@FXML
	private TextField BD_3;

	@FXML
	private TextField BD_5;

	@FXML
	private TextField BD_6;

	@FXML
	private TextField BD_7;

	@FXML
	private TextField BD_8;

	@FXML
	private TextField BD_9;

	@FXML
	private TextField BUCLE_1;

	@FXML
	private TextField BUCLE_2;

	@FXML
	private TextField BUCLE_4;

	@FXML
	private TextField BUG_1;

	@FXML
	private TextField BUG_2;

	@FXML
	private TextField HTML_1;

	@FXML
	private TextField HTML_2;

	@FXML
	private TextField HTML_3;

	@FXML
	private TextField PG_1;

	@FXML
	private TextField PG_2;

	@FXML
	private TextField PG_3;

	@FXML
	private TextField PG_5;

	@FXML
	private TextField PG_6;

	@FXML
	private TextField PG_7;

	@FXML
	private TextField PG_8;

	@FXML
	private TextField cruz_algoritmo_PG;

	@FXML
	private TextField algoritmo_2;

	@FXML
	private TextField algoritmo_3;

	@FXML
	private TextField algoritmo_4;

	@FXML
	private TextField algoritmo_5;

	@FXML
	private TextField algoritmo_7;

	@FXML
	private TextField algoritmo_8;

	@FXML
	private TextField algotirmo_6;

	@FXML
	private TextField boolean_1;

	@FXML
	private TextField boolean_2;

	@FXML
	private TextField boolean_4;

	@FXML
	private TextField boolean_5;

	@FXML
	private TextField boolean_6;

	@FXML
	private TextField cruz_BD_BUCLE;

	@FXML
	private TextField cruz_BD_BUG;

	@FXML
	private TextField cruz_PG_BD;

	@FXML
	private TextField cruz_algoritmo_boolean;

	@FXML
	private TextField cruz_boolean_HTML;

	@FXML
	private TextField cruz_switch_BUCLE;

	@FXML
	private Text pista_1;

	@FXML
	private Text pista_2;

	@FXML
	private Text pista_4;

	@FXML
	private Text pista_7;

	@FXML
	private Text pista_8;

	@FXML
	private Text písta_3;

	@FXML
	private Text písta_5;

	@FXML
	private Text písta_6;

	@FXML
	private TextField switch_1;

	@FXML
	private TextField switch_2;

	@FXML
	private TextField switch_3;

	@FXML
	private TextField switch_4;

	@FXML
	private TextField switch_5;

	@FXML
	public void ValidarCrucigrama(ActionEvent event) {
		Crucigrama crucigrama = new Crucigrama();
		crucigrama.obtenerPalabras();
		crucigrama.validarPalabra(validarPalabras());
	}

	public String validarPalabras() {
		algoritmo = cruz_algoritmo_PG.getText() + algoritmo_2.getText() + algoritmo_3.getText() + algoritmo_4.getText()
				+ algoritmo_5.getText() + algotirmo_6.getText() + algoritmo_7.getText() + algoritmo_8.getText()
				+ cruz_algoritmo_boolean.getText();
		System.out.println(algoritmo);
		return algoritmo;
	}

	public void init(Stage stage2, ControladorVistaPrincipal controladorVistaPrincipal) {
		this.controladorVistaPrincipal = controladorVistaPrincipal;
		this.stage = stage2;
	}
}
