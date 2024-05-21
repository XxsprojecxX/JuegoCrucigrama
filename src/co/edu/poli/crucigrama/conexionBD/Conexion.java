package co.edu.poli.crucigrama.conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * La clase {@code Conexion} se encarga de establecer una conexión con la base de datos MySQL.
 */
public class Conexion {

    /**
     * El controlador JDBC de MySQL.
     */
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    
    /**
     * La URL de la base de datos.
     */
    private static final String URL = "jdbc:mysql://localhost:3306/crucigrama?useSSL=false";
    
    /**
     * El nombre de usuario para la base de datos.
     */
    private static final String USUARIO = "root";
    
    /**
     * La contraseña para la base de datos.
     */
    private static final String CLAVE = "Admin123*";
    
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
     * Establece una conexión con la base de datos.
     * 
     * @return un objeto {@code Connection} que representa la conexión a la base de datos, 
     *         o {@code null} si ocurre un error durante la conexión.
     */
    public Connection conectar() {
        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexion exitosa!");
        } catch (SQLException e) {
            System.out.println("Error en la conexion");
            e.printStackTrace();
        }
        
        return conexion;
    }
}

