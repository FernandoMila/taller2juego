package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego {
    
    private List<Criminal> listaCriminales;
    private Criminal criminalSeleccionado;
    private List<Ciudad> ciudadesRuta;
    private Ciudad ciudadManager;  // Instancia para acceder a las ciudades

    public Juego() {
        listaCriminales = new ArrayList<>();
        ciudadesRuta = new ArrayList<>();
        ciudadManager = new Ciudad(); // Instancia de Ciudad para acceder a obtenerTodasLasCiudades()
        generarListaCriminales();
        seleccionarCriminal();
        generarRutaEscape();
    }

    // Método para generar una lista de criminales con atributos básicos
    private void generarListaCriminales() {
        listaCriminales.add(new Criminal(1, "Juan Perez", "Masculino", "Doctor", "Negro", "Auto", "Ajedrez", "Alto"));
        listaCriminales.add(new Criminal(2, "Ana Garcia", "Femenino", "Ingeniera", "Rubio", "Moto", "Pintura", "Ojos verdes"));
        listaCriminales.add(new Criminal(3, "Carlos Lopez", "Masculino", "Piloto", "Castaño", "Avión", "Fútbol", "Cicatriz en la cara"));
        listaCriminales.add(new Criminal(4, "Maria Rodriguez", "Femenino", "Abogada", "Negro", "Bicicleta", "Lectura", "Tatuaje en el brazo"));
        listaCriminales.add(new Criminal(5, "Pedro Sanchez", "Masculino", "Programador", "Rubio", "Camioneta", "Videojuegos", "Lentes"));
    }

    // Método para seleccionar un criminal aleatorio
    private void seleccionarCriminal() {
        Random rand = new Random();
        int index = rand.nextInt(listaCriminales.size());
        criminalSeleccionado = listaCriminales.get(index);
        System.out.println("Criminal seleccionado: " + criminalSeleccionado.getNombreCriminal());
    }

    // Método para generar una ruta de escape aleatoria usando las ciudades definidas en Ciudad.java
    private void generarRutaEscape() {
        List<Ciudad> ciudadesDisponibles = ciudadManager.obtenerTodasLasCiudades(); // Obtener las ciudades
        Random rand = new Random();
        
        // Asegurarse de que la ruta de escape tenga 3 ciudades diferentes
        while (ciudadesRuta.size() < 3) {
            int index = rand.nextInt(ciudadesDisponibles.size());
            Ciudad ciudadSeleccionada = ciudadesDisponibles.get(index);
            if (!ciudadesRuta.contains(ciudadSeleccionada)) {
                ciudadesRuta.add(ciudadSeleccionada);
            }
        }

        // Mostrar las ciudades seleccionadas en la ruta
        System.out.print("Ruta de escape: ");
        for (Ciudad ciudad : ciudadesRuta) {
            System.out.print(ciudad.getNombre() + " -> ");
        }
        System.out.println();
    }

    public Criminal getCriminalSeleccionado() {
        return criminalSeleccionado;
    }

    public List<Ciudad> getCiudadesRuta() {
        return ciudadesRuta;
    }
}
