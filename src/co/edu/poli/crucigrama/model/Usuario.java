package co.edu.poli.crucigrama.model;


import java.util.ArrayList;
import co.edu.poli.crucigrama.conexionBD.CRUD;


public class Usuario {

	private int idUsuario;
	private String nombre;
	private double puntaje;
	private ArrayList<String> usuarios = new ArrayList<String>();
	private CRUD bd = new CRUD();

	public Usuario(int idUsuario, String nombre, double puntaje) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.puntaje = puntaje;
	}

	public ArrayList<String> obtenerUsuarios(int id) {
		usuarios = bd.leerDatosBD("usuario");
		return usuarios;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}

}
