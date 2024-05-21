package co.edu.poli.crucigrama.model;

/**
 * La clase {@code Pista} representa una pista en un crucigrama, que incluye un ID y una descripci�n.
 */
public class Pista {

    private int idPista;
    private String[] DescripcionPista;

    /**
     * Construye una nueva instancia de {@code Pista} con el ID y la descripci�n especificados.
     * 
     * @param idPista el ID de la pista.
     * @param descripcionPista una matriz de cadenas que describe la pista.
     */
    public Pista(int idPista, String[] descripcionPista) {
        super();
        this.idPista = idPista;
        DescripcionPista = descripcionPista;
    }

    /**
     * Imprime la pista con el ID y la descripci�n especificados.
     * 
     * @param idPista el ID de la pista.
     * @param descripcion la descripci�n de la pista.
     */
    public void imprimirPista(int idPista, String descripcion) {
        // L�gica para imprimir la pista
    }

    /**
     * Obtiene el ID de la pista.
     * 
     * @return el ID de la pista.
     */
    public int getIdPista() {
        return idPista;
    }

    /**
     * Establece el ID de la pista.
     * 
     * @param idPista el nuevo ID de la pista.
     */
    public void setIdPista(int idPista) {
        this.idPista = idPista;
    }

    /**
     * Obtiene la descripci�n de la pista.
     * 
     * @return una matriz de cadenas que describe la pista.
     */
    public String[] getDescripcionPista() {
        return DescripcionPista;
    }

    /**
     * Establece la descripci�n de la pista.
     * 
     * @param descripcionPista una nueva matriz de cadenas que describe la pista.
     */
    public void setDescripcionPista(String[] descripcionPista) {
        DescripcionPista = descripcionPista;
    }
}
