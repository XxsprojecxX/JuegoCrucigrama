package co.edu.poli.crucigrama.model;

public class Pista {
	
	private int idPista;
	private String[] DescripcionPista;
	
	public Pista(int idPista, String[] descripcionPista) {
		super();
		this.idPista = idPista;
		DescripcionPista = descripcionPista;
	}

	public void imprimirPista(int idPista, String descripcion) {
		
	}
	
	public int getIdPista() {
		return idPista;
	}
	public void setIdPista(int idPista) {
		this.idPista = idPista;
	}
	public String[] getDescripcionPista() {
		return DescripcionPista;
	}
	public void setDescripcionPista(String[] descripcionPista) {
		DescripcionPista = descripcionPista;
	}
	
	
}
