package co.edu.poli.crucigrama.controller;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
	public void ValidarCrucigrama(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/poli/crucigrama/view/Resultados.fxml"));
		Parent root = loader.load();
		ControladorResultado controladorResultado = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		controladorResultado.init(crucigrama.validarPalabras(obtenerListaPalabrasFront(), listaPalabrasbd.leerDatosBD("palabra")));
		stage.show();
	}

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

		programar = PG_1.getText() + PG_2.getText() + PG_3.getText() + cruz_PG_BD.getText() + PG_5.getText()
				+ cruz_algoritmo_PG.getText() + PG_6.getText() + PG_7.getText() + PG_8.getText();

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

	public void init(Stage stage2, ControladorVistaPrincipal controladorVistaPrincipal) {
		this.controladorVistaPrincipal = controladorVistaPrincipal;
		this.stage = stage2;
	}
}
