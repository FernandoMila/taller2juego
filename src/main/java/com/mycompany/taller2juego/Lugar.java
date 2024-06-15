/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller2juego;

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
    public Image getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
}
