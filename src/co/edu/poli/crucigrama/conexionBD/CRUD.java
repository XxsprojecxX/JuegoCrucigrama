package co.edu.poli.crucigrama.conexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * La clase CRUD proporciona métodos para realizar operaciones básicas de
 * creación, lectura, actualización y eliminación (CRUD) en una base de datos.
 */
public class CRUD {

    private ArrayList<String> datos = new ArrayList<String>();

    /**
     * Lee los datos de una tabla específica en la base de datos.
     * 
     * @param tabla el nombre de la tabla de la que se leerán los datos
     * @return una lista de cadenas que representan los datos leídos de la tabla
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
                case "palabra":
                    rs = stm.executeQuery("SELECT * FROM palabra");
                    while (rs.next()) {
                        descripcionSql = rs.getString(2);
                        datos.add(descripcionSql);
                    }
                    break;
                case "pistas":
                    rs = stm.executeQuery("SELECT * FROM pista");
                    while (rs.next()) {
                        descripcionSql = rs.getString(2);
                        datos.add(descripcionSql);
                    }
                    break;
                case "usuario":
                    rs = stm.executeQuery("SELECT * FROM usuario");
                    while (rs.next()) {
                        descripcionSql = rs.getString(2);
                        datos.add(descripcionSql);
                    }
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datos;
    }

    /**
     * Inserta un nuevo usuario en la tabla de usuarios de la base de datos.
     * 
     * @param usuario el nombre del usuario que se va a insertar
     */
    public void insertarNuevoUsuario(String usuario) {
        Conexion conexion = new Conexion();
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;
        String idBD = "";

        cn = conexion.conectar();
        try {
            stm = (Statement) cn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs = stm.executeQuery("SELECT * FROM crucigrama.usuario order by idUsuario desc limit 1;");
            while (rs.next()) {
                idBD = rs.getString(1);
            }
            
            PreparedStatement ps;
            String insertSql;
            cn = conexion.conectar();
            
            insertSql = "INSERT INTO crucigrama.usuario(idUsuario, nombre, puntaje) values(?,?,?)";
            ps = (PreparedStatement) cn.prepareStatement(insertSql);
            ps.setInt(1, Integer.valueOf(idBD)+1);
            ps.setString(2, usuario);
            ps.setInt(3, 0);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
