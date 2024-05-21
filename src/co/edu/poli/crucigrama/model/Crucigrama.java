package co.edu.poli.crucigrama.model;

import java.util.ArrayList;
import com.mysql.jdbc.Statement;

import co.edu.poli.crucigrama.conexionBD.CRUD;
import co.edu.poli.crucigrama.conexionBD.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * La clase {@code Crucigrama} gestiona la lógica de un juego de crucigramas, 
 * incluyendo palabras y pistas, validación de palabras y el manejo del puntaje del usuario.
 */
public class Crucigrama {
	private ArrayList<String> palabras = new ArrayList<String>();
	private ArrayList<String> pistas = new ArrayList<String>();
	private CRUD bd = new CRUD();
	Usuario usuario = new Usuario(1, "Andress", 0);

	/**
	 * Constructor por defecto de la clase {@code Crucigrama}.
	 */
	public Crucigrama() {
		super();
	}

	/**
	 * Obtiene las palabras desde la base de datos y las almacena en la lista de palabras.
	 */
	public void obtenerPalabras() {
		palabras = bd.leerDatosBD("palabra");
		System.out.println(palabras);
	}

	/**
	 * Obtiene las pistas desde la base de datos y las almacena en la lista de pistas.
	 */
	public void obtenerPistas() {
		pistas = bd.leerDatosBD("pistas");
		System.out.println(pistas);
	}

	/**
	 * Valida las palabras ingresadas por el usuario con las palabras almacenadas en la base de datos.
	 * 
	 * @param listaFront la lista de palabras ingresadas por el usuario.
	 * @param listaBaseDatos la lista de palabras almacenadas en la base de datos.
	 * @return un mensaje indicando los resultados de la validación y el puntaje obtenido.
	 */
	public String validarPalabras(ArrayList<String> listaFront, ArrayList<String> listaBaseDatos) {
		String palabra;
		String mensaje = "";
		for (int i = 0; i < listaFront.size(); i++) {
			palabra = listaFront.get(i);
			if (palabra == null || palabra.isEmpty() || !palabra.matches("[a-zA-Z]+")) {
				mensaje += "No se pueden ingresar espacios en blanco, carácteres especiales ni números. ID: " + (i + 1) + "\n\n";
			} else if (palabra.equalsIgnoreCase(listaBaseDatos.get(i))) {
				mensaje += "La palabra ingresada para el ID: " + (i + 1) + " ¡Es Correcta!\n\n";
				sumarPuntaje();
			} else {
				mensaje += "¡Palabra Incorrecta! ID: " + (i + 1) + "\n\n\n";
			}
		}
		mensaje += "\nSu Score es: " + usuario.getPuntaje() + "\n";
		usuario.setPuntaje(0);
		return mensaje;
	}

	/**
	 * Suma puntos al puntaje del usuario.
	 */
	public void sumarPuntaje() {
		usuario.setPuntaje(usuario.getPuntaje() + 12.5);
	}

	/**
	 * Imprime el puntaje actual del usuario en la consola.
	 */
	public void imprimirPuntaje() {
		System.out.println(usuario.getPuntaje());
	}

	/**
	 * Obtiene la lista de palabras.
	 * 
	 * @return la lista de palabras.
	 */
	public ArrayList<String> getPalabras() {
		return palabras;
	}

	/**
	 * Establece la lista de palabras.
	 * 
	 * @param palabras la nueva lista de palabras.
	 */
	public void setPalabras(ArrayList<String> palabras) {
		this.palabras = palabras;
	}

	/**
	 * Obtiene la lista de pistas.
	 * 
	 * @return la lista de pistas.
	 */
	public ArrayList<String> getPistas() {
		return pistas;
	}

	/**
	 * Establece la lista de pistas.
	 * 
	 * @param pistas la nueva lista de pistas.
	 */
	public void setPistas(ArrayList<String> pistas) {
		this.pistas = pistas;
	}

	/**
	 * Obtiene el objeto {@code CRUD} utilizado para interactuar con la base de datos.
	 * 
	 * @return el objeto {@code CRUD}.
	 */
	public CRUD getBd() {
		return bd;
	}

	/**
	 * Establece el objeto {@code CRUD} utilizado para interactuar con la base de datos.
	 * 
	 * @param bd el nuevo objeto {@code CRUD}.
	 */
	public void setBd(CRUD bd) {
		this.bd = bd;
	}

	/**
	 * Obtiene el usuario actual.
	 * 
	 * @return el usuario actual.
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Establece el usuario actual.
	 * 
	 * @param usuario el nuevo usuario.
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
