package co.edu.poli.crucigrama.conexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class CRUD {

	private ArrayList<String> datos = new ArrayList<String>();

	public ArrayList<String> leerDatosBD(String tabla) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		String descripcionSql = null;

		try {
			cn = conexion.conectar();
			stm = (Statement) cn.createStatement();
			switch (tabla) {
			case "palabra": {
				rs = stm.executeQuery("SELECT * FROM palabra");
				while (rs.next()) {
					descripcionSql = rs.getString(2);
					datos.add(descripcionSql);
				}
				break;
			}
			case "pistas": {
				rs = stm.executeQuery("SELECT * FROM pista");
				while (rs.next()) {
					descripcionSql = rs.getString(2);
					datos.add(descripcionSql);
				}
				break;
			}
			case "usuario": {
				rs = stm.executeQuery("SELECT * FROM usuario");
				while (rs.next()) {
					descripcionSql = rs.getString(2);
					datos.add(descripcionSql);
				}
				break;
			}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datos;

	}

}
