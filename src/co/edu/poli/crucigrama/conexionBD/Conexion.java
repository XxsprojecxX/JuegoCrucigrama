/**
 * La clase Conexion proporciona métodos para establecer una conexión a una base de datos MySQL
 * utilizando JDBC.
 */
package co.edu.poli.crucigrama.conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // URL de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/crucigrama?useSSL=false";

    // Nombre de usuario y contraseña para la conexión a la base de datos
    private static final String USUARIO = "root";
    private static final String CLAVE = "Admin123*";

    // Controlador JDBC para MySQL
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";

    // Bloque estático para cargar el controlador JDBC
    static {
        try {
            Class.forName(CONTROLADOR);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();
        }
    }

    /**
     * Establece una conexión a la base de datos.
     *
     * @return La conexión establecida.
     */
    public Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexion exitosa!");
        } catch (SQLException e) {
            System.out.println("Error en la conexion");
        }
        return conexion;
    }
}
