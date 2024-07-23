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
<<<<<<< HEAD
        c.setImagen("Cv_Montevideo.jpg");
        c.setDescripcion("Montevideo, descripción de la ciudad...");
        c.setNombre(" Montevideo");

=======
        c.setImagen("CV_Montevideo.jpg");
        c.setDescripcion("El barrio histórico de Montevideo, con calles adoquinadas y arquitectura colonial...");
        c.setNombre(" Montevideo...");
        
>>>>>>> d8d8646f557bea175a8248e0d82492552da37a3e
        return c;
    }

}
