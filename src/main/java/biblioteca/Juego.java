package biblioteca;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.GridLayout;  // Importación añadida
import java.util.Random;

public class Juego {
    private List<Criminal> listaCriminales;
    private Criminal criminalSeleccionado;
    private List<Ciudad> ciudadesRuta;
    private Ciudad ciudadManager;  // Instancia para acceder a las ciudades
    private int indexCriminalActual = 0; // Para ir seleccionando los criminales uno a uno
    private int mision = 0;  // Variable para almacenar el tiempo de la misión
    private int ciudadActualIndex = 0; // Índice para la ciudad actual en la ruta de escape

    public Juego() {
        listaCriminales = new ArrayList<>();
        ciudadesRuta = new ArrayList<>();
        ciudadManager = new Ciudad(); // Instancia de Ciudad para acceder a obtenerTodasLasCiudades()
        generarListaCriminales();
        seleccionarCriminal();  // Selecciona el primer criminal
        generarRutaEscape(); // Generar la ruta para el primer criminal
    }

    // Método para generar una lista de criminales con atributos básicos
    private void generarListaCriminales() {
        listaCriminales.add(new Criminal(1, "Juan Perez", "Masculino", "Doctor", "Negro", "Auto", "Ajedrez", "Alto"));
        listaCriminales.add(new Criminal(2, "Ana Garcia", "Femenino", "Ingeniera", "Rubio", "Moto", "Pintura", "Ojos verdes"));
        listaCriminales.add(new Criminal(3, "Carlos Lopez", "Masculino", "Piloto", "Castaño", "Avión", "Fútbol", "Cicatriz en la cara"));
        listaCriminales.add(new Criminal(4, "Maria Rodriguez", "Femenino", "Abogada", "Negro", "Bicicleta", "Lectura", "Tatuaje en el brazo"));
        listaCriminales.add(new Criminal(5, "Pedro Sanchez", "Masculino", "Programador", "Rubio", "Camioneta", "Videojuegos", "Lentes"));
    }

    // Método para verificar si hay más criminales en la lista
    public boolean hayMasCriminales() {
        return indexCriminalActual < listaCriminales.size(); // Si el índice es menor al tamaño de la lista, hay más criminales
    }

    // Método para seleccionar criminales uno a uno en orden
    public void seleccionarCriminal() {
        if (indexCriminalActual < listaCriminales.size()) {
            criminalSeleccionado = listaCriminales.get(indexCriminalActual);

            // Asignar tiempo de misión basado en el número del criminal
            switch (indexCriminalActual) {
                case 0:
                    mision = 72;  // Primer criminal: 72 horas
                    break;
                case 1:
                    mision = 60;  // Segundo criminal: 60 horas
                    break;
                case 2:
                    mision = 48;  // Tercer criminal: 48 horas
                    break;
                case 3:
                    mision = 36;  // Cuarto criminal: 36 horas
                    break;
                case 4:
                    mision = 24;  // Quinto criminal: 24 horas
                    break;
                default:
                    System.out.println("Error: No quedan más criminales por seleccionar.");
            }

            System.out.println("Criminal seleccionado: " + criminalSeleccionado.getNombreCriminal());
            indexCriminalActual++;
        } else {
            System.out.println("Todos los criminales han sido atrapados. ¡Ganaste!");
        }
    }

    // Método para generar una ruta de escape aleatoria usando las ciudades definidas en Ciudad.java
    // Cambiamos este método a public para que pueda ser accedido desde otras clases
    public void generarRutaEscape() {
        List<Ciudad> ciudadesDisponibles = ciudadManager.obtenerTodasLasCiudades(); // Obtener las ciudades

        ciudadesRuta.clear(); // Limpiar la ruta anterior
        while (ciudadesRuta.size() < 3) {
            int index = (int) (Math.random() * ciudadesDisponibles.size());
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

    // Método para avanzar a la siguiente ciudad en la ruta de escape
   public boolean avanzarCiudad() {
    if (ciudadActualIndex < ciudadesRuta.size() - 1) {
        ciudadActualIndex++;
        return true;
    }
    return false; // No hay más ciudades
}
    // Obtener la ciudad actual en la ruta de escape
    public Ciudad getCiudadActual() {
        return ciudadesRuta.get(ciudadActualIndex);
    }
    
    // Obtener la siguiente ciudad en la ruta de escape
    public Ciudad getSiguienteCiudad() {
        if (ciudadActualIndex < ciudadesRuta.size() - 1) {
            return ciudadesRuta.get(ciudadActualIndex + 1);
        }
        return null; // Si ya estamos en la última ciudad
    }

   // Verificar si se llegó a la última ciudad de la ruta de escape
public boolean esUltimaCiudad() {
    return ciudadActualIndex == ciudadesRuta.size() - 1;
}

    // Método para descontar tiempo de la misión
    public void descontarTiempoMision(int horas) {
        if (mision > 0) {
            mision -= horas;
            if (mision < 0) {
                mision = 0; // Evitar que el tiempo de la misión sea negativo
            }
        }
    }

    // Obtener el tiempo restante de la misión
    public int getMision() {
        return mision;
    }

    // Establecer el tiempo de la misión
    public void setMision(int mision) {
        this.mision = mision;
    }

    // Obtener la lista de ciudades de la ruta de escape
    public List<Ciudad> getCiudadesRuta() {
        return ciudadesRuta;
    }

    // Obtener el criminal seleccionado
    public Criminal getCriminalSeleccionado() {
        return criminalSeleccionado;
    }

    // Método para abrir una ventana con tres botones que mostrarán las pistas
    public void abrirVentanaPistas(JFrame ventanaPrincipal) {
        // Crear una nueva ventana
        JFrame ventanaPistas = new JFrame("Buscar Pistas");
        ventanaPistas.setSize(400, 300);
        ventanaPistas.setLocationRelativeTo(null); // Centrar la ventana

        // Crear un panel para contener los botones
        JPanel panelPistas = new JPanel(new GridLayout(3, 1, 10, 10));  // 3 botones con espacio entre ellos

        // Crear los tres botones
        JButton botonPista1 = new JButton("Buscar en la Biblioteca");
        JButton botonPista2 = new JButton("Buscar en el Club Deportivo");
        JButton botonPista3 = new JButton("Buscar en el Puerto");

        // Añadir los botones al panel
        panelPistas.add(botonPista1);
        panelPistas.add(botonPista2);
        panelPistas.add(botonPista3);

        // Añadir el panel a la ventana
        ventanaPistas.add(panelPistas);

        // Hacer visible la ventana
        ventanaPistas.setVisible(true);
    }

  
}
