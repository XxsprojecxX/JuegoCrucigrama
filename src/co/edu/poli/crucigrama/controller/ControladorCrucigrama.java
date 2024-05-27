package co.edu.poli.crucigrama.controller;

import javafx.scene.control.Button;
import java.io.IOException;
import java.util.ArrayList;
import co.edu.poli.crucigrama.conexionBD.CRUD;
import co.edu.poli.crucigrama.model.Crucigrama;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Controlador para la vista del crucigrama.
 */

public class ControladorCrucigrama {

	private ControladorVistaPrincipal controladorVistaPrincipal;
	private Stage stage;
	private Crucigrama crucigrama = new Crucigrama();
	private CRUD listaPalabrasbd = new CRUD();
	private String algoritmo;
	private String bd;
	private String html;
	private String swtch;
	private String programar;
	private String bug;
	private String booleano;
	private String bucle;

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
	private TextField PG_4;

	@FXML
	private TextField PG_5;

	@FXML
	private TextField PG_6;

	@FXML
	private TextField PG_7;

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
	private Text pistas;

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
	private Text txt_usuario;

	@FXML
	private Button Instrucciones;

	// Método para manejar el evento del botón de instrucciones
	@FXML
	void BotonInstrucciones(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/poli/crucigrama/view/Instrucciones.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.getIcons().add(new Image("/co/edu/poli/crucigrama/view/icono.PNG"));
		stage.show();
	}

	// Método para validar el crucigrama y mostrar resultados
	@FXML
	public void ValidarCrucigrama(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/poli/crucigrama/view/Resultados.fxml"));
		Parent root = loader.load();
		ControladorResultado controladorResultado = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.getIcons().add(new Image("/co/edu/poli/crucigrama/view/icono.PNG"));
		controladorResultado
				.init(crucigrama.validarPalabras(obtenerListaPalabrasFront(), listaPalabrasbd.leerDatosBD("palabra")));
		stage.show();
	}

	// Método para restringir la entrada de texto en los campos del crucigrama
	@FXML
	private void checkInput(KeyEvent event) {

		TextField[] campos = { BD_10, BD_2, BD_3, BD_5, BD_6, BD_7, BD_8, BD_9, BUCLE_1, BUCLE_2, BUCLE_4, BUG_1, BUG_2,
				HTML_1, HTML_2, HTML_3, PG_1, PG_2, PG_3, PG_4, PG_5, PG_6, PG_7, cruz_algoritmo_PG, algoritmo_2,
				algoritmo_3, algoritmo_4, algoritmo_5, algoritmo_7, algoritmo_8, algotirmo_6, boolean_1, boolean_2,
				boolean_4, boolean_5, boolean_6, cruz_BD_BUCLE, cruz_BD_BUG, cruz_PG_BD, cruz_algoritmo_boolean,
				cruz_boolean_HTML, cruz_switch_BUCLE, switch_1, switch_2, switch_3, switch_4, switch_5 };

		for (int i = 0; i < campos.length; i++) {
			if (campos[i].getText().length() >= 1) {
				char texto = campos[i].getCharacters().charAt(0);
				campos[i].setText(String.valueOf(texto));
				if (!campos[i].getText().matches("[a-zA-Z]+")) {
					campos[i].setStyle("-fx-border-color: red");
				} else {
					campos[i].setStyle("-fx-border-color: blue");
				}
			}
		}
	}

	public void mostrarPistas(String pistasBD) {
		pistas.setText(pistasBD);
	}

	// Método para obtener las palabras ingresadas por el usuario desde la interfaz
	// de usuario
	public ArrayList<String> obtenerListaPalabrasFront() {
		ArrayList<String> listaPalabrasFront = new ArrayList<String>();
		algoritmo = cruz_algoritmo_PG.getText() + algoritmo_2.getText() + algoritmo_3.getText() + algoritmo_4.getText()
				+ algoritmo_5.getText() + algotirmo_6.getText() + algoritmo_7.getText() + algoritmo_8.getText()
				+ cruz_algoritmo_boolean.getText();

		bd = cruz_BD_BUG.getText() + BD_2.getText() + BD_3.getText() + cruz_BD_BUCLE.getText() + BD_5.getText()
				+ BD_6.getText() + BD_7.getText() + cruz_PG_BD.getText() + BD_8.getText() + BD_9.getText()
				+ BD_10.getText();

		html = HTML_1.getText() + HTML_2.getText() + HTML_3.getText() + cruz_boolean_HTML.getText();

		swtch = switch_1.getText() + switch_2.getText() + switch_3.getText() + switch_4.getText()
				+ cruz_switch_BUCLE.getText() + switch_5.getText();

		programar = PG_1.getText() + PG_2.getText() + PG_3.getText() + PG_4.getText() + PG_5.getText()
				+ cruz_PG_BD.getText() + PG_6.getText() + cruz_algoritmo_PG.getText() + PG_7.getText();

		bug = cruz_BD_BUG.getText() + BUG_1.getText() + BUG_2.getText();

		booleano = boolean_1.getText() + cruz_algoritmo_boolean.getText() + boolean_2.getText()
				+ cruz_boolean_HTML.getText() + boolean_4.getText() + boolean_5.getText() + boolean_6.getText();

		bucle = BUCLE_1.getText() + BUCLE_2.getText() + cruz_switch_BUCLE.getText() + BUCLE_4.getText()
				+ cruz_BD_BUCLE.getText();

		listaPalabrasFront.add(algoritmo);
		listaPalabrasFront.add(bd);
		listaPalabrasFront.add(html);
		listaPalabrasFront.add(swtch);
		listaPalabrasFront.add(programar);
		listaPalabrasFront.add(bug);
		listaPalabrasFront.add(booleano);
		listaPalabrasFront.add(bucle);

		return listaPalabrasFront;
	}

	// Método para actualizar el texto del campo de usuario en la interfaz de
	// usuario
	public void actualizarUsuario(String usuario) {
		txt_usuario.setText(usuario);
	}

	// Método para inicializar el controlador con la instancia de la ventana
	// principal y el controlador asociado
	public void init(Stage stage2, ControladorVistaPrincipal controladorVistaPrincipal) {
		this.controladorVistaPrincipal = controladorVistaPrincipal;
		this.stage = stage2;
	}
}
