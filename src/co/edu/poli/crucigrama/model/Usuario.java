package co.edu.poli.crucigrama.model;

import java.util.ArrayList;
import co.edu.poli.crucigrama.conexionBD.CRUD;

/**
 * Representa un usuario del crucigrama.
 */
public class Usuario {

    private int idUsuario;
    private String nombre;
    private double puntaje;
    private ArrayList<String> usuarios = new ArrayList<String>();
    private CRUD bd = new CRUD();

    /**
     * Constructor de la clase Usuario.
     * 
     * @param idUsuario el identificador del usuario
     * @param nombre el nombre del usuario
     * @param puntaje el puntaje del usuario
     */
    public Usuario(int idUsuario, String nombre, double puntaje) {
        super();
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    /**
     * Obtiene la lista de usuarios.
     * 
     * @param id el identificador del usuario
     * @return la lista de usuarios
     */
    public ArrayList<String> obtenerUsuarios(int id) {
        usuarios = bd.leerDatosBD("usuario");
        return usuarios;
    }

    /**
     * Obtiene el identificador del usuario.
     * 
     * @return el identificador del usuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario.
     * 
     * @param idUsuario el identificador del usuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre el nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el puntaje del usuario.
     * 
     * @return el puntaje del usuario
     */
    public double getPuntaje() {
        return puntaje;
    }

    /**
     * Establece el puntaje del usuario.
     * 
     * @param puntaje el puntaje del usuario
     */
    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

}
