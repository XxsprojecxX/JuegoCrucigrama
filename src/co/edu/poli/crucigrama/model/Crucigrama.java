package co.edu.poli.crucigrama.model;

import java.util.ArrayList;
import co.edu.poli.crucigrama.conexionBD.CRUD;

/**
 * Representa un crucigrama con palabras y pistas.
 */
public class Crucigrama {
	private ArrayList<String> palabras = new ArrayList<String>();
	private ArrayList<String> pistas = new ArrayList<String>();
	private CRUD bd = new CRUD();
	private Usuario usuario = new Usuario(0, "", 0);

	/**
	 * Constructor por defecto de la clase Crucigrama.
	 */
	public Crucigrama() {
		super();
	}

	/**
	 * Obtiene las palabras del crucigrama desde la base de datos.
	 * 
	 * @return las palabras del crucigrama
	 */
	public String obtenerPalabras() {
		String palabrasBD = "";
		palabras = bd.leerDatosBD("palabra");
		for (int i = 0; i < pistas.size(); i++) {
			palabrasBD += pistas.get(i).toString() + "\n";
		}
		return palabrasBD;
	}

	/**
	 * Obtiene las pistas del crucigrama desde la base de datos.
	 * 
	 * @return las pistas del crucigrama
	 */
	public String obtenerPistas() {
		String pistasBD = "";
		pistas = bd.leerDatosBD("pistas");
		for (int i = 0; i < pistas.size(); i++) {
			pistasBD += (i + 1) + ". " + pistas.get(i).toString() + "\n";
			if (i == 3) {
				pistasBD += "\n\n\n";
			}
		}
		return pistasBD;
	}

	/**
	 * Valida las palabras ingresadas por el usuario.
	 * 
	 * @param listaFront     la lista de palabras ingresadas por el usuario
	 * @param listaBaseDatos la lista de palabras obtenidas de la base de datos
	 * @return un mensaje indicando el resultado de la validación
	 */
	public String validarPalabras(ArrayList<String> listaFront, ArrayList<String> listaBaseDatos) {
		String palabra;
		String mensaje = "";

		for (int i = 0; i < listaFront.size(); i++) {
			palabra = listaFront.get(i);
			if (palabra == null || palabra.isEmpty() || !palabra.matches("[a-zA-Z]+")) {
				mensaje += "No se pueden ingresar espacios en blanco, caracteres especiales ni números. ID: " + (i + 1)
						+ "\n\n";
			} else if (palabra.equalsIgnoreCase(listaBaseDatos.get(i))) {
				mensaje += "La palabra ingresada para el ID: " + (i + 1) + " ¡Es CORRECTA!\n\n";
				sumarPuntaje();
			} else {
				mensaje += "¡La palabra ingresada para el ID: " + (i + 1) + " es Incorrecta\n\n";
			}
		}
		mensaje += "\nSu Score es: " + usuario.getPuntaje() + "\n";
		usuario.setPuntaje(0);
		return mensaje;
	}

	/**
	 * Suma puntaje al usuario.
	 */
	public void sumarPuntaje() {
		usuario.setPuntaje(usuario.getPuntaje() + 12.5);
	}

	/**
	 * Imprime el puntaje del usuario.
	 */
	public void imprimirPuntaje() {
		System.out.println(usuario.getPuntaje());
	}

	// Getters y setters

	public ArrayList<String> getPalabras() {
		return palabras;
	}

	public void setPalabras(ArrayList<String> palabras) {
		this.palabras = palabras;
	}

	public ArrayList<String> getPistas() {
		return pistas;
	}

	public void setPistas(ArrayList<String> pistas) {
		this.pistas = pistas;
	}

	public CRUD getBd() {
		return bd;
	}

	public void setBd(CRUD bd) {
		this.bd = bd;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
