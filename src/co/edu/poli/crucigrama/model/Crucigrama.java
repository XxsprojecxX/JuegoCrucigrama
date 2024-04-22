package co.edu.poli.crucigrama.model;

import java.util.ArrayList;
import java.util.Scanner;
import com.mysql.jdbc.Statement;
import co.edu.poli.crucigrama.conexionBD.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crucigrama {
	private ArrayList<String> palabras = new ArrayList<String>();
	private ArrayList<String> pistas = new ArrayList<String>();
	private ArrayList<Integer> palabrasMostrar = new ArrayList<Integer>();
	Scanner teclado = new Scanner(System.in);
	Usuario usuario = new Usuario(1, "Andres", 0);

	public void obtenerPalabras() {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = (Statement) cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM palabra");

			while (rs.next()) {
				String descripcionSql = rs.getString(2);
				palabras.add(descripcionSql);
			}
			System.out.println(palabras);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void obtenerPistas() {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = (Statement) cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM pista");

			while (rs.next()) {
				String descripcionPistaSql = rs.getString(2);
				pistas.add(descripcionPistaSql);
			}
			System.out.println(pistas);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void mostrarCrucigrama() {
		System.out.println("HORIZONTALES");
		for (int i = 0; i < palabras.size(); i++) {
			char letras[] = palabras.get(i).toCharArray();
			if (i == 4) {
				System.out.println("\n\nVERTICALES");
			}
			System.out.println();
			for (int j = 0; j < letras.length; j++) {
				if (palabrasMostrar.size() > 0) {
					for (int k = 0; k < palabrasMostrar.size(); k++) {
						if (i == palabrasMostrar.get(k)) {
							if (j == 0) {
								System.out.print(i + 1 + "  " + letras[j] + " ");
							} else {
								System.out.print("  " + letras[j] + " ");
							}
						}
					}
				} else {
					if (j == 0) {
						System.out.print(i + 1 + "  _ ");
					} else {
						System.out.print(" _ ");
					}
				}
			}
		}

	}

	public void imprimirRespuestas() {
		System.out.println("\n\n");
		System.out.println("HORIZONTALES");
		for (int i = 0; i < palabras.size(); i++) {
			if (i == 4) {
				System.out.println("VERTICALES");
				System.out.print(i + 1 + " " + palabras.get(i) + "\n");
			} else {
				System.out.print(i + 1 + " " + palabras.get(i) + "\n");
			}

		}

	}

	public void validarPalabra(int idPalabra) {
		String palabra = null;
		for (int i = 0; i < palabras.size(); i++) {
			if (idPalabra - 1 == i) {
				System.out.println("Ingrese la palabra: ");
				palabra = teclado.next();
				while (palabra == null | palabra.isEmpty() | !palabra.matches("[a-zA-Z]+")) {
					System.err.println("No se pueden ingresar espacios, carácteres especiales ni números.");
					System.out.println("Ingrese nuevamente la palabra: ");
					palabra = teclado.next();
				}
				if (palabra.equalsIgnoreCase(palabras.get(i))) {
					System.out.println("Correcto!");
					mostrarPalabras(i);
					sumarPuntaje();
				} else {
					System.err.println("Palabra Incorrecta!");
				}
			}
		}
	}

	public void mostrarPalabras(int idPalabra) {
		palabrasMostrar.add(idPalabra);
	}

	public void sumarPuntaje() {
		usuario.setPuntaje(usuario.getPuntaje() + 10);
		System.out.println("Su Score es: " + usuario.getPuntaje());
	}

	public void imprimirPuntaje() {
		System.out.println(usuario.getPuntaje());
	}

	public ArrayList<Integer> getPalabrasMostrar() {
		return palabrasMostrar;
	}

	public void setPalabrasMostrar(ArrayList<Integer> palabrasMostrar) {
		this.palabrasMostrar = palabrasMostrar;
	}

}
