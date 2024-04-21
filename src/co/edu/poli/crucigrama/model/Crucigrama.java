package co.edu.poli.crucigrama.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Crucigrama {
	
	private String[] palabras;
	private String pistas;
	ArrayList<Integer> palabrasMostrar = new ArrayList<Integer>();
	Usuario usuario = new Usuario();

	public void obtenerPalabras() {
		palabras = new String[] { "SOPA", "ARROZ", "PAPA", "YUCA", "MANZANA", "PERA", "PIÑA", "GUANABANA" };
	}

	public void obtenerPistas() {
		pistas = "Archivo de pistas";
	}

	public void mostrarCrucigrama() {
		obtenerPalabras();
		System.out.println("HORIZONTALES");
		for (int i = 0; i < palabras.length; i++) {
			char letras[] = palabras[i].toCharArray();
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
		for (int i = 0; i < palabras.length; i++) {
			if (i == 4) {
				System.out.println("VERTICALES");
				System.out.print(i + 1 + " " + palabras[i] + "\n");
			} else {
				System.out.print(i + 1 + " " + palabras[i] + "\n");
			}

		}

	}

	public void validarLetra(int idPalabra) {
		try (Scanner teclado = new Scanner(System.in)) {
			String palabra = null;
			for (int i = 0; i < palabras.length; i++) {
				if (idPalabra - 1 == i) {
					System.out.println("Ingrese la palabra: ");
					palabra = teclado.next();
					while (palabra == null | palabra.isEmpty() | !palabra.matches("[a-zA-Z]+")) {
						System.err.println("No se pueden ingresar espacios, carácteres especiales ni números.");
						System.out.println("Ingrese nuevamente la palabra: ");
						palabra = teclado.next();
					}
					if (palabra.equalsIgnoreCase(palabras[i])) {
						System.out.println("Correcto!");
						mostrarPalabras(i);
						sumarScore();
					} else {
						System.err.println("Palabra Incorrecta!");
					}

				}
			}
		}
	}

	public void mostrarPalabras(int idPalabra) {
		palabrasMostrar.add(idPalabra);
	}

	public void sumarScore() {
		usuario.setPuntaje(usuario.getPuntaje()+10);
		System.out.println("Su Score es: " + usuario.getPuntaje());
	}
	
	public void imprimirPuntaje() {
		System.out.println(usuario.getPuntaje());
	}

	public String[] getPalabras() {
		return palabras;
	}

	public void setPalabras(String[] palabras) {
		this.palabras = palabras;
	}

	public String getPistas() {
		return pistas;
	}

	public void setPistas(String pistas) {
		this.pistas = pistas;
	}

	public ArrayList<Integer> getPalabrasMostrar() {
		return palabrasMostrar;
	}

	public void setPalabrasMostrar(ArrayList<Integer> palabrasMostrar) {
		this.palabrasMostrar = palabrasMostrar;
	}

}
