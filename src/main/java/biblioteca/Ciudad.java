package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    private int id;
    private String nombre;
    private String descripcion;
    private String rutaImagen;
    private int x;
    private int y;

    public Ciudad(int id, String nombre, String descripcion, String rutaImagen, int x, int y) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.x = x;
        this.y = y;
    }
    
    // Constructor sin argumentos
    public Ciudad(){
    }
    
    public List<Ciudad> obtenerTodasLasCiudades() {
        List<Ciudad> ciudades = new ArrayList<>();
        //ciudades con coordenadas 
        ciudades.add(new Ciudad(1, "Colonia del Sacramento", "Descripción de Colonia", "imagenes/Colonia.png", 160, 480));
        ciudades.add(new Ciudad(2, "Montevideo", "Descripción de Montevideo", "imagenes/Montevideo.png",360, 515));
        ciudades.add(new Ciudad(3, "Juan Lacaze", "Descripción de Canelones", "imagenes/Canelones.png", 150, 400));
        ciudades.add(new Ciudad(4, "Punta del Este", "Descripción de Maldonado", "imagenes/Maldonado.png", 510, 520));
        ciudades.add(new Ciudad(5, "Maldonado", "Descripción de Rivera", "imagenes/Maldonado.png", 400, 100));
        ciudades.add(new Ciudad(6, "Las Piedras", "Descripción de Salto", "imagenes/Salto.png", 350, 50));
        ciudades.add(new Ciudad(7, "Paysandú", "Descripción de Paysandú", "imagenes/Paysandu.png", 300, 100));
        ciudades.add(new Ciudad(8, "Artigas", "Descripción de Artigas", "imagenes/Artigas.png", 450, 50));
        ciudades.add(new Ciudad(9, "San José de Mayo", "Descripción de San José", "imagenes/SanJose.png", 250, 500));
        ciudades.add(new Ciudad(10, "Tacuarembó", "Descripción de Tacuarembó", "imagenes/Tacuarembo.png", 400, 300));
        ciudades.add(new Ciudad(11, "Florida", "Descripción de Florida", "imagenes/Florida.png", 300, 350));
        ciudades.add(new Ciudad(12, "Durazno", "Descripción de Durazno", "imagenes/Durazno.png", 350, 400));
        ciudades.add(new Ciudad(13, "Melo", "Descripción de Cerro Largo", "imagenes/CerroLargo.png", 500, 450));
        ciudades.add(new Ciudad(14, "Punta del Diablo", "Descripción de Rocha", "imagenes/Rocha.png", 550, 500));
        ciudades.add(new Ciudad(15, "Treinta y Tres", "Descripción de Treinta y Tres", "imagenes/TreintayTres.png", 600, 450));
        ciudades.add(new Ciudad(16, "Minas", "Descripción de Lavalleja", "imagenes/Lavalleja.png", 650, 400));
        ciudades.add(new Ciudad(17, "Salto", "Descripción de Flores", "imagenes/Flores.png", 130, 165));
        ciudades.add(new Ciudad(18, "Fray Bentos", "Descripción de Río Negro", "imagenes/RioNegro.png", 250, 100));
        ciudades.add(new Ciudad(19, "Mercedes", "Descripción de Soriano", "imagenes/Soriano.png", 250, 180));
        ciudades.add(new Ciudad(20, "Rivera", "Descripción de Rivera", "imagenes/FrayBentos.png", 100, 100));
        ciudades.add(new Ciudad(21, "Trinidad", "Descripción de Melo", "imagenes/Melo.png", 600, 200));
      
        return ciudades;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getRutaImagen() { return rutaImagen; }
    public void setRutaImagen(String rutaImagen) { this.rutaImagen = rutaImagen; }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
}
