/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Clase que representa la entidad 'ciudad' en la base de datos
@Entity
@Table(name = "ciudad")
public class CiudadDAO {
    
    // Identificador único del ciudad en la base de datos
    @Id
    @Column(name="idPista")
    private int idCiudad;
    
    //Nombre de la ciudad
    @Column(name="nombre")
    private String nombreCiudad;
    
    //Descripción de la ciudad.
    @Column(name="descripcion")
    private String descripcionCiudad;
    
    //dirección en la que se encuentra la imagen
    @Column(name="imagen")
    private String imagenCiudad;
    
    // Constructor para inicializar los atributos de la Ciudad
    public CiudadDAO(int idCiudad, String nombreCiudad, String descripcionCiudad, String imagenCiudad){
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.descripcionCiudad = descripcionCiudad;
        this.imagenCiudad = imagenCiudad;
    }
    
        // Constructor sin argumentos
    public CiudadDAO() {
    }
    
     // Métodos getter y setter para acceder y modificar los atributos privados
    
    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCriminal) {
        this.nombreCiudad = nombreCriminal;
    }

    public String getDescripcionCiudad() {
        return descripcionCiudad;
    }

    public void setDescripcionCiudad(String descripcionCiudad) {
        this.descripcionCiudad = descripcionCiudad;
    }

    public String getImagenCiudad() {
        return imagenCiudad;
    }

    public void setImagenCiudad(String imagenCiudad) {
        this.imagenCiudad = imagenCiudad;
    }
    
    // Método toString para obtener una representación en cadena del objeto
    @Override
    public String toString() {
        return "CiudadDAO{" +
                "nombreCiudad='" + nombreCiudad + '\'' +
                ", descripcionCiudad='" + descripcionCiudad + '\'' +
                ", imagenCiudad='" + imagenCiudad + '\'' +
                '}';
    }

}
