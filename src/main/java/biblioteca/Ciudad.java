/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.awt.Image;
import java.util.List;

/**
 *
 * @author grabe
 */
public class Ciudad {
    private int idCiudad;
    private String nombre;
    private List<Lugar> lugares;
    private String descripcion;
    private String imagen;
    private List<Ciudad> proximidad;

    public Ciudad() {
    }

    public Ciudad(int idCiudad, String nombre, List<Lugar> lugares, String descripcion, String imagen, List<Ciudad> proximidad) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.lugares = lugares;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.proximidad = proximidad;
    }

    /**
     * @return the idCiudad
     */
    public int getIdCiudad() {
        return idCiudad;
    }

    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
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

    /**
     * @return the lugares
     */
    public List<Lugar> getLugares() {
        return lugares;
    }

    /**
     * @param lugares the lugares to set
     */
    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
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

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    

    /**
     * @return the proximidad
     */
    public List<Ciudad> getProximidad() {
        return proximidad;
    }

    /**
     * @param proximidad the proximidad to set
     */
    public void setProximidad(List<Ciudad> proximidad) {
        this.proximidad = proximidad;
    }
    
    
    
}
