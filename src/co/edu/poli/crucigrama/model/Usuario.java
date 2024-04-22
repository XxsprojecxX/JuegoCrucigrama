package co.edu.poli.crucigrama.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import co.edu.poli.crucigrama.conexionBD.Conexion;

public class Usuario {

	private int idUsuario;
	private String nombre;
	private double puntaje;

	public Usuario(int idUsuario, String nombre, double puntaje) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.puntaje = puntaje;
	}
	
	public void obtenerUsuario(int id){
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = (Statement) cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuario WHERE idUsuario = " + id);

			while (rs.next()) {
				int idUsuarioSql = rs.getInt(1);
				String usuarioSql = rs.getString(2);
				double puntajeSql = rs.getDouble(3);
				idUsuario = idUsuarioSql;
				nombre = usuarioSql;
				puntaje = puntajeSql;
				System.out.println(idUsuarioSql + "-" + usuarioSql + "-" + puntajeSql);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
