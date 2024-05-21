package co.edu.poli.crucigrama.model;

/**
 * Representa una pista en un crucigrama.
 */
public class Pista {
    private int idPista;
    private String[] DescripcionPista;

    /**
     * Constructor de la clase Pista.
     * 
     * @param idPista el identificador de la pista
     * @param descripcionPista el arreglo de descripciones de la pista
     */
    public Pista(int idPista, String[] descripcionPista) {
        super();
        this.idPista = idPista;
        DescripcionPista = descripcionPista;
    }

    /**
     * Obtiene el identificador de la pista.
     * 
     * @return el identificador de la pista
     */
    public int getIdPista() {
        return idPista;
    }

    /**
     * Establece el identificador de la pista.
     * 
     * @param idPista el identificador de la pista
     */
    public void setIdPista(int idPista) {
        this.idPista = idPista;
    }

    /**
     * Obtiene la descripción de la pista.
     * 
     * @return el arreglo de descripciones de la pista
     */
    public String[] getDescripcionPista() {
        return DescripcionPista;
    }

    /**
     * Establece la descripción de la pista.
     * 
     * @param descripcionPista el arreglo de descripciones de la pista
     */
    public void setDescripcionPista(String[] descripcionPista) {
        DescripcionPista = descripcionPista;
    }
}
