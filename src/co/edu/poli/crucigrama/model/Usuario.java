package co.edu.poli.crucigrama.model;

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
