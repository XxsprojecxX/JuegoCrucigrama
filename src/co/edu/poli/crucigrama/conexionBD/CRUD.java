package co.edu.poli.crucigrama.conexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

/**
 * La clase {@code CRUD} proporciona métodos para realizar operaciones de lectura 
 * en la base de datos MySQL.
 */
public class CRUD {

    /**
     * Lista de datos leídos de la base de datos.
     */
    private ArrayList<String> datos = new ArrayList<String>();

    /**
     * Lee datos de la base de datos según la tabla especificada.
     * 
     * @param tabla el nombre de la tabla de la que se desean leer los datos.
     * @return una lista de cadenas que contienen los datos leídos de la base de datos.
     */
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

