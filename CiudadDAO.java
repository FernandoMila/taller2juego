package com.mycompany.taller2juego;

import java.util.ArrayList;
import java.util.List;

public class CiudadDAO {
    public List<Ciudad> obtenerTodasLasCiudades() {
        List<Ciudad> ciudades = new ArrayList<>();
        // Suponiendo que las coordenadas x e y están definidas para cada ciudad.
        ciudades.add(new Ciudad(1, "Colonia del Sacramento", null, "Descripción de Colonia", "imagenes/Colsacra.png", null, 50, 500));
        ciudades.add(new Ciudad(2, "Montevideo", null, "Descripción de Montevideo", "imagenes/Montevideo.png", null, 200, 400));
        // Agrega más ciudades según sea necesario
        return ciudades;
    }
}
