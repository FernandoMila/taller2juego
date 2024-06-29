/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import biblioteca.Ciudad;
import java.util.List;

/**
 *
 * @author grabe
 */
public class Movimientos {
    private List<Ciudad> recorrido;

    public Movimientos(List<Ciudad> recorrido) {
        this.recorrido = recorrido;
    }

    /**
     * @return the recorrido
     */
    public List<Ciudad> getRecorrido() {
        return recorrido;
    }

    /**
     * @param recorrido the recorrido to set
     */
    public void setRecorrido(List<Ciudad> recorrido) {
        this.recorrido = recorrido;
    }
    
}
