/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

/**
 *
 * @author grabe
 */
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

    /**
     * @param idPista the idPista to set
     */
    public void setIdPista(int idPista) {
        this.idPista = idPista;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
