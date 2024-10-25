
package biblioteca;


public class Pista {

    private int idPista;
    private String descripcion;

    public Pista(int idPista, String descripcion) {
        this.idPista = idPista;
        this.descripcion = descripcion;
    }

    /**
     * @return the idPista
     */
    public int getIdPista() {
        return idPista;
    }

    public void setIdPista(int idPista) {
        this.idPista = idPista;
    }

   
    public String getDescripcion() {
        return descripcion;
    }

   
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
