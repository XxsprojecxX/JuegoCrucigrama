package co.edu.poli.crucigrama.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import co.edu.poli.crucigrama.conexionBD.CRUD;
import co.edu.poli.crucigrama.conexionBD.Conexion;

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

	public ArrayList<String> obtenerUsuario(int id) {
		usuarios = bd.leerDatosBD("usuario");
		System.out.println(usuarios);
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
