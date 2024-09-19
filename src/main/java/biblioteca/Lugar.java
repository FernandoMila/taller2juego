/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.awt.Image;

/**
 *
 * @author grabe
 */
public class Lugar {

    private int idLugar;
    private String nombre;
    private int idCiudad;
    private String descripcion;
    private Image imagen;

    public Lugar(int idLugar, String nombre, int idCiudad, String descripcion, Image imagen) {
        this.idLugar = idLugar;
        this.nombre = nombre;
        this.idCiudad = idCiudad;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    /**
     * @return the idLugar
     */
    public int getIdLugar() {
        return idLugar;
    }

    /**
     * @param idLugar the idLugar to set
     */
    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public int getIdCiudad() {
        return idCiudad;
    }

  
    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

   
    public String getDescripcion() {
        return descripcion;
    }

    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Image getImagen() {
        return imagen;
    }

   
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

}
