/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import biblioteca.*;
import persistencia.*;

/**
 *
 * @author grabe
 */
public class Controlador {

    public Controlador() {
    }

    public Ciudad seleccionarCiudad(int idCiudad) {
        Conexion con = new Conexion();
        return con.obtenerCiudad(idCiudad);

    }

}
