<<<<<<< HEAD:src/main/java/com/mycompany/taller2juego/Ciudad.java
package com.mycompany.taller2juego;

import java.awt.Image;
import java.util.List;

public class Ciudad {
    private int idCiudad;
    private String nombre;
    private List<Lugar> lugares;
    private String descripcion;
    private String rutaImagen;
    private List<Ciudad> proximidad;
    private int x; // Coordenada X
    private int y; // Coordenada Y

    public Ciudad(int idCiudad, String nombre, List<Lugar> lugares, String descripcion, String rutaImagen, List<Ciudad> proximidad, int x, int y) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.lugares = lugares;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.proximidad = proximidad;
        this.x = x;
        this.y = y;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public List<Ciudad> getProximidad() {
        return proximidad;
    }

    public void setProximidad(List<Ciudad> proximidad) {
        this.proximidad = proximidad;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
=======
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
>>>>>>> master:src/main/java/biblioteca/Ciudad.java
