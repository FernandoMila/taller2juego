
package DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Clase que representa la entidad 'pista' en la base de datos
@Entity
@Table(name = "pista")
public class PistaDAO {
    
    // Identificador único del pista en la base de datos
    @Id
    @Column(name="idPista")
    private int idPista;
    
    //Descripción de la pista del criminal o a la ciudad que se dirige
    @Column(name="descripcion")
    private String descripcionPista;
    
    // Constructor para inicializar los atributos de la Pista
    public PistaDAO(int idPista, String descripcionPista){
        this.idPista = idPista;
        this.descripcionPista = descripcionPista;
    }
    
        // Constructor sin argumentos
    public PistaDAO() {
    }
    
     // Métodos getter y setter para acceder y modificar los atributos privados
    
    public int getIdPista() {
        return idPista;
    }

    public void setIdPista(int idPista) {
        this.idPista = idPista;
    }

    public String getDescripcionPista() {
        return descripcionPista;
    }

    public void setDescripcionPista(String descripcionPista) {
        this.descripcionPista = descripcionPista;
    }

    
    // Método toString para obtener una representación en cadena del objeto
    @Override
    public String toString() {
        return "PistaDAO{" +
                ", descripcionPista='" + descripcionPista + '\'' +
                '}';
    }
}
