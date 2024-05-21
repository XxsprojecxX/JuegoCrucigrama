package co.edu.poli.crucigrama.model;

import java.util.ArrayList;

import co.edu.poli.crucigrama.conexionBD.CRUD;

/**
 * La clase {@code Usuario} representa un usuario en el sistema de crucigramas, con un ID, nombre y puntaje.
 */
public class Usuario {

    private int idUsuario;
    private String nombre;
    private double puntaje;
    private ArrayList<String> usuarios = new ArrayList<String>();
    private CRUD bd = new CRUD();

    /**
     * Construye una nueva instancia de {@code Usuario} con el ID, nombre y puntaje especificados.
     * 
     * @param idUsuario el ID del usuario.
     * @param nombre el nombre del usuario.
     * @param puntaje el puntaje del usuario.
     */
    public Usuario(int idUsuario, String nombre, double puntaje) {
        super();
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    /**
     * Obtiene los datos del usuario con el ID especificado desde la base de datos.
     * 
     * @param id el ID del usuario.
     * @return una lista de usuarios obtenidos de la base de datos.
     */
    public ArrayList<String> obtenerUsuario(int id) {
        usuarios = bd.leerDatosBD("usuario");
        System.out.println(usuarios);
        return usuarios;
    }

    /**
     * Obtiene el ID del usuario.
     * 
     * @return el ID del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el ID del usuario.
     * 
     * @param idUsuario el nuevo ID del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return el nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre el nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el puntaje del usuario.
     * 
     * @return el puntaje del usuario.
     */
    public double getPuntaje() {
        return puntaje;
    }

    /**
     * Establece el puntaje del usuario.
     * 
     * @param puntaje el nuevo puntaje del usuario.
     */
    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
}

