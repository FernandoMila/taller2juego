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
        ciudades.add(new Ciudad(1, "Colonia del Sacramento", "Descripción de Colonia del Sacramento", "imagenes/Ciudades/Colonia.png", 158, 480));
        ciudades.add(new Ciudad(2, "Montevideo", "Descripción de Montevideo", "imagenes/Ciudades/Montevideo.png",360, 515));
        ciudades.add(new Ciudad(3, "Juan Lacaze", "Descripción de Canelones", "imagenes/Ciudades/Juan Lacaze.png", 198, 474));
        ciudades.add(new Ciudad(4, "Punta del Este", "Descripción de Maldonado", "imagenes/Ciudades/Punta del Este.png", 509, 522));
        ciudades.add(new Ciudad(5, "Maldonado", "Descripción de Rivera", "imagenes/Ciudades/Maldonado.png", 512, 511));
        ciudades.add(new Ciudad(6, "Las Piedras", "Descripción de Las Piedras", "imagenes/Ciudades/Salto.png", 349, 501));
        ciudades.add(new Ciudad(7, "Paysandú", "Descripción de Paysandú", "imagenes/Ciudades/Paysandu.png", 114, 257));
        ciudades.add(new Ciudad(8, "Artigas", "Descripción de Artigas", "imagenes/Ciudades/Artigas.png", 305, 55));
        ciudades.add(new Ciudad(9, "San Jose de Mayo", "Descripción de San José", "imagenes/Ciudades/San Jose de Mayo.png", 293, 468));
        ciudades.add(new Ciudad(10, "Tacuarembó", "Descripción de Tacuarembó", "imagenes/Ciudades/Tacuarembo.png", 359, 183));
        ciudades.add(new Ciudad(11, "Florida", "Descripción de Florida", "imagenes/Ciudades/Florida.png", 351, 434));
        ciudades.add(new Ciudad(12, "Durazno", "Descripción de Durazno", "imagenes/Ciudades/Durazno.png", 310, 360));
        ciudades.add(new Ciudad(13, "Melo", "Melo es historia, es cultura, en un escenario con hermosos espacios verdes, junto a sencillos pero cómodos servicios, como hotelería y gastronomía, entre otros, pero todos ligados a una remarcada característica de los melenses; su calor humano, sin dudas toda una tradición.", "imagenes/Ciudades/Melo.png", 598, 250));
        ciudades.add(new Ciudad(14, "Punta del Diablo", "Descripción de Rocha", "imagenes/Ciudades/Punta del Diablo.png", 674, 422));
        ciudades.add(new Ciudad(15, "Treinta y Tres", "Descripción de Treinta y Tres", "imagenes/Ciudades/TreintayTres.png", 582, 341));
        ciudades.add(new Ciudad(16, "Minas", "Descripción de Lavalleja", "imagenes/Ciudades/Minas.png", 470, 465));
        ciudades.add(new Ciudad(17, "Salto", "Descripción de Flores", "imagenes/Ciudades/Salto.png", 128, 160));
        ciudades.add(new Ciudad(18, "Fray Bentos", "Descripción de Río Negro", "imagenes/Ciudades/Fray Bentos.png", 85, 350));
        ciudades.add(new Ciudad(19, "Mercedes", "Descripción de Soriano", "imagenes/Ciudades/Mercedes.png", 118, 357));
        ciudades.add(new Ciudad(20, "Rivera", "Descripción de Rivera", "imagenes/Ciudades/Rivera.png", 425, 105));
        ciudades.add(new Ciudad(21, "Trinidad", "Descripción de Trinidad", "imagenes/Ciudades/Trinidad.png", 266, 379));
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
