/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import biblioteca.*;
import javax.swing.ImageIcon;

/**
 *
 * @author grabe
 */
public class Conexion {

    public Conexion() {
    }

    public Ciudad obtenerCiudad(int idCiudad) {
        Ciudad c = new Ciudad();
        c.setIdCiudad(idCiudad);
        c.setImagen("CV_Montevideo.jpg");
        c.setDescripcion("El barrio histórico de Montevideo, con calles adoquinadas y arquitectura colonial...");
        c.setNombre(" Montevideo...");
        
        return c;
    }

}
