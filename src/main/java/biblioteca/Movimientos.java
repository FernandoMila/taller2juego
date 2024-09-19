
package biblioteca;

import biblioteca.Ciudad;
import java.util.List;


public class Movimientos {

    private List<Ciudad> recorrido;

    public Movimientos(List<Ciudad> recorrido) {
        this.recorrido = recorrido;
    }

    
    public List<Ciudad> getRecorrido() {
        return recorrido;
    }

    
    public void setRecorrido(List<Ciudad> recorrido) {
        this.recorrido = recorrido;
    }

}
