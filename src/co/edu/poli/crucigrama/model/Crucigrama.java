package co.edu.poli.crucigrama.model;

import java.util.ArrayList;
import java.util.Scanner;
import com.mysql.jdbc.Statement;

import co.edu.poli.crucigrama.conexionBD.CRUD;
import co.edu.poli.crucigrama.conexionBD.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crucigrama {
	private ArrayList<String> palabras = new ArrayList<String>();
	private ArrayList<String> pistas = new ArrayList<String>();
	private CRUD bd = new CRUD();
	Usuario usuario = new Usuario(1, "Andress", 0);

	public Crucigrama() {
		super();
	}

	public void obtenerPalabras() {
		palabras = bd.leerDatosBD("palabra");
		System.out.println(palabras);
	}

	public void obtenerPistas() {
		pistas = bd.leerDatosBD("pistas");
		System.out.println(pistas);
	}

	public String validarPalabras(ArrayList<String> listaFront, ArrayList<String> listaBaseDatos) {
		String palabra;
		String mensaje = "";
		for (int i = 0; i < listaFront.size(); i++) {
			palabra = listaFront.get(i);
			if (palabra == null | palabra.isEmpty() | !palabra.matches("[a-zA-Z]+")) {
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

	public void sumarPuntaje() {
		usuario.setPuntaje(usuario.getPuntaje() + 12.5);
	}

	public void imprimirPuntaje() {
		System.out.println(usuario.getPuntaje());
	}

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
