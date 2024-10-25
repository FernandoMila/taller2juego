package presentacion;

import biblioteca.Sonidos;
import biblioteca.Ciudad;
import biblioteca.Criminal;
import biblioteca.Juego;  
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;  // Añadir la importación
import java.io.FileWriter;      // Añadir la importación
import java.io.IOException;



public class Interfaz extends JFrame {

    // Atributos de la interfaz
    JLabel labelNombreLugar;
    JLabel labelFechaHora;
    JLabel labelImagen;
    JTextArea areaTexto;
    JLabel labelPuntos;
    JLabel labelMision; // Mostrar tiempo de misión
    JTextField campoNombreDetective;
    JButton botonConfirmarNombre;
    JTextArea areaMaquinaEscribir;
    List<JButton> botonesCiudades = new ArrayList<>();
    List<JButton> botonesVisitados = new ArrayList<>();
    Point startPoint;
    Point endPoint;
    Timer animationTimer;
    double currentPosition;

    LocalDateTime fechaHoraActual;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, h a");
    private int puntos = 0;
    private static final int TIEMPO_ESCRITURA = 50;
    private Juego juego;  // Instancia de Juego correctamente declarada
    private JLabel labelPasos;  // Definir la variable labelPasos
    private MoverPasos moverPasos; // Definir MoverPasos

    // Nuevos atributos para el constructor con parámetros
    private Criminal criminal;
    private List<String> lista;

    // Constructor con parámetros
    public Interfaz(Criminal criminal, List<String> lista) {
        this.criminal = criminal;
        this.lista = lista;
        this.juego = new Juego();  // Inicializa el objeto juego
        inicializarInterfaz();
    }

    // Constructor sin parámetros
    public Interfaz() {
        this(null, new ArrayList<>());
    }

    private void inicializarInterfaz() {
        // Inicializar la fecha y hora actual
        fechaHoraActual = LocalDateTime.of(2024, Month.JULY, 1, 13, 0);

        // Configurar la ventana
        setTitle("Carmen Sandiego: Aventura en Uruguay");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear barra de menú
        JMenuBar menuBar = createMenuBar();
        setJMenuBar(menuBar);

        // Crear panel superior
        JPanel panelSuperior = new JPanel(new BorderLayout());
        labelNombreLugar = new JLabel("Palacio", SwingConstants.CENTER);
        labelNombreLugar.setFont(new Font("Serif", Font.BOLD, 24));
        labelFechaHora = new JLabel(fechaHoraActual.format(formatter), SwingConstants.CENTER);
        labelFechaHora.setFont(new Font("Serif", Font.PLAIN, 18));
        labelPuntos = new JLabel("Puntos: 0", SwingConstants.CENTER);
        labelPuntos.setFont(new Font("Serif", Font.BOLD, 18));

        // Etiqueta para mostrar el tiempo restante de la misión
        labelMision = new JLabel("Tiempo de misión: " + juego.getMision() + " horas", SwingConstants.CENTER);
        labelMision.setFont(new Font("Serif", Font.BOLD, 18));

        JPanel panelDatos = new JPanel(new GridLayout(1, 3));  // Añadimos el tiempo de la misión
        panelDatos.add(labelFechaHora);
        panelDatos.add(labelPuntos);
        panelDatos.add(labelMision);  // Añadir el tiempo de misión al panel

        panelSuperior.add(labelNombreLugar, BorderLayout.NORTH);
        panelSuperior.add(panelDatos, BorderLayout.CENTER);

        // Crear panel central con GridLayout
        JPanel panelCentral = new JPanel(new GridLayout(2, 1));  // Dividir en 2 filas, 1 columna
        JPanel panelImagenDescripcion = new JPanel(new GridLayout(1, 2));  // 1 fila, 2 columnas
        labelImagen = new JLabel(new ImageIcon("imagenes/ciudades/Palacio.jpeg"), SwingConstants.CENTER);
        labelImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaTexto = new JTextArea("En una zona alta del barrio La Aguada, se destaca el edificio Palacio Legislativo, sede del poder legislativo del estado uruguayo.");
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Serif", Font.PLAIN, 20));
        areaTexto.setForeground(Color.BLUE);

        JScrollPane scrollPaneTexto = new JScrollPane(areaTexto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panelImagenDescripcion.add(labelImagen);
        panelImagenDescripcion.add(scrollPaneTexto);

        // Crear panel para la máquina de escribir
        JPanel panelMaquinaEscribir = new JPanel(new BorderLayout());
        panelMaquinaEscribir.setBorder(BorderFactory.createTitledBorder("Computadora cuartel General"));

        // Aumentar el tamaño vertical del área de texto y habilitar el scroll
        areaMaquinaEscribir = new JTextArea(10, 40);  // Más alto y ancho
        areaMaquinaEscribir.setLineWrap(true);
        areaMaquinaEscribir.setWrapStyleWord(true);
        areaMaquinaEscribir.setEditable(false);
        areaMaquinaEscribir.setFont(new Font("Serif", Font.ITALIC, 18));
        areaMaquinaEscribir.setForeground(Color.black);
        JScrollPane scrollPaneMaquina = new JScrollPane(areaMaquinaEscribir, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panelMaquinaEscribir.add(scrollPaneMaquina, BorderLayout.CENTER);

        JPanel panelNombreDetective = new JPanel(new FlowLayout(FlowLayout.CENTER));
        campoNombreDetective = new JTextField(25);
        botonConfirmarNombre = new JButton("Confirmar");

    botonConfirmarNombre.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String nombreDetective = campoNombreDetective.getText().trim();
        if (!nombreDetective.isEmpty()) {
            guardarNombreDetective(nombreDetective);
            mostrarConEfectoMaquinaEscribir("Detective " + nombreDetective + " registrado.\n");

            // Deshabilitar el botón para evitar múltiples entradas
            botonConfirmarNombre.setEnabled(false);
            campoNombreDetective.setEnabled(false);

            // Temporizador para mostrar las pistas después de confirmar el nombre
            Timer esperaTimer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarConEfectoMaquinaEscribir("Tienes " + juego.getMision() + " horas para atrapar al criminal.\n");

                    Timer esperaTimer1 = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            List<Ciudad> ciudadesRuta = juego.getCiudadesRuta();
                            if (!ciudadesRuta.isEmpty()) {
                                Ciudad primeraCiudad = ciudadesRuta.get(0);
                                List<String> pistas = leerPistas(primeraCiudad.getNombre());

                                // Asegurarnos de que hay pistas y mostrarlas
                                if (!pistas.isEmpty()) {
                                    areaMaquinaEscribir.setText(""); // Limpiar antes de agregar pistas
                                    mostrarConEfectoMaquinaEscribir("¡Empiza a recorrer ciudades y visitar lugares!\n");
                                    for (String pista : pistas) {
                                        areaMaquinaEscribir.append(pista + "\n");
                                    }
                                } else {
                                    mostrarConEfectoMaquinaEscribir("Error: No se encontraron pistas para la primera ciudad.\n");
                                }
                            } else {
                                mostrarConEfectoMaquinaEscribir("Error: No se encontró la ruta de escape.\n");
                            }
                        }
                    });
                    esperaTimer1.setRepeats(false);
                    esperaTimer1.start();
                }
            });
            esperaTimer.setRepeats(false);
            esperaTimer.start();
        }
    }
});


        panelNombreDetective.add(new JLabel("Detective, por favor identifíquese:"));
        panelNombreDetective.add(campoNombreDetective);
        panelNombreDetective.add(botonConfirmarNombre);
        panelMaquinaEscribir.add(panelNombreDetective, BorderLayout.SOUTH);

        panelCentral.add(panelImagenDescripcion);
        panelCentral.add(panelMaquinaEscribir);

        // Crear panel inferior con FlowLayout
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton botonVisitar = new JButton(new ImageIcon("imagenes/botones/visitarciudades.jpeg"));
        JButton botonMapa = new JButton(new ImageIcon("imagenes/botones/avion.jpeg"));
        JButton botonBuscarCriminal = new JButton(new ImageIcon("imagenes/botones/criminal.jpeg"));
        JButton botonCerrar = new JButton(new ImageIcon("imagenes/botones/exit.jpeg"));
        Dimension buttonSize = new Dimension(50, 50);
        botonVisitar.setPreferredSize(buttonSize);
        botonMapa.setPreferredSize(buttonSize);
        botonBuscarCriminal.setPreferredSize(buttonSize);
        botonCerrar.setPreferredSize(buttonSize);
        panelInferior.add(botonVisitar);
        panelInferior.add(botonMapa);
        panelInferior.add(botonBuscarCriminal);
        panelInferior.add(botonCerrar);
        
        // Añadir acción al botón "Buscar Criminal"
        botonBuscarCriminal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Crear una instancia de Vista Criminal.
                VistaCriminal vista;
                vista = new VistaCriminal();
                vista.mostrarVentana();
            }
        });

        // Añadir acción al botón "Cerrar"
        botonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "¿Está seguro de que desea salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
  
botonVisitar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        manejarBotonVisitar(); // Ahora solo atrapa al criminal si completamos el recorrido
    }
});

        // Añadir acción al botón "Mapa"
        botonMapa.addActionListener(e -> mostrarMapa());

        // Añadir paneles a la ventana
        setLayout(new BorderLayout());
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Mostrar mensaje inicial
        mostrarConEfectoMaquinaEscribir("Detective, por favor identifíquese: \n");

        actualizarFechaHora();
        // Hacer visible la ventana
        setVisible(true);
    }
private void manejarViajeCiudad(Ciudad ciudadSeleccionada) {
    Ciudad ciudadSiguiente = juego.getSiguienteCiudad(); // Obtener la siguiente ciudad en la ruta de escape

    if (ciudadSeleccionada.equals(ciudadSiguiente)) {
        // Si es la ciudad correcta
        avanzarCiudad(); // Avanzar en la ruta de escape
        Ciudad nuevaCiudad = juego.getCiudadActual(); // Obtener la ciudad actual después de avanzar

        // Obtener las pistas de la nueva ciudad (la siguiente ciudad en la ruta)
        List<String> pistas = leerPistas(nuevaCiudad.getNombre());

        if (!pistas.isEmpty()) {
            // Mostrar las pistas de la nueva ciudad
            areaMaquinaEscribir.append("Has llegado a " + nuevaCiudad.getNombre() + ". Aquí tienes nuevas pistas:\n");
            for (String pista : pistas) {
                areaMaquinaEscribir.append(pista + "\n");
            }

            // Verificar si es la última ciudad en la ruta
            if (juego.esUltimaCiudad()) {
                atraparCriminal(); // Atrapar al criminal si es la última ciudad
            }
        }
    } else {
        // Si la ciudad es incorrecta
        areaMaquinaEscribir.append("No se ha visto al criminal en " + ciudadSeleccionada.getNombre() + ".\n");
    }
}

// Método para avanzar a la siguiente ciudad en la ruta
private void avanzarCiudad() {
    if (juego.avanzarCiudad()) {  // Avanzar en la ruta de escape
        if (juego.esUltimaCiudad()) {
            // Solo atrapar al criminal cuando estamos en la última ciudad
            areaMaquinaEscribir.append("¡Has llegado a la última ciudad! Ahora puedes atrapar al criminal.\n");
          
        }
    }
}
// Método para manejar la visita a una ciudad
private void manejarVisitaCiudad(JFrame ventanaVisitar, MoverPasos moverPasos, String lugar, int x, int y) {
    SonidoPasos.reproducirPasos();  // Reproducir sonido al hacer clic
    moverPasos.setDestino(x, y);    // Mueve los pasos hacia el lugar

    // Espera 3 segundos antes de mostrar el mensaje
    Timer timer = new Timer(3000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            SonidoPasos.detenerPasos();  // Detener el sonido antes de mostrar el mensaje

            // Obtener la siguiente ciudad en la ruta
            Ciudad siguienteCiudad = juego.getSiguienteCiudad();
            if (siguienteCiudad != null) {
                // El jugador aún no ha atrapado al criminal
                JOptionPane.showMessageDialog(ventanaVisitar, "Has visitado " + lugar + ". La próxima ciudad es " + siguienteCiudad.getNombre() + ".");
                juego.avanzarCiudad();  // Avanzar a la siguiente ciudad en la ruta de escape
            } else if (juego.esUltimaCiudad()) {
             
                 mostrarVentanaCriminalAtrapado(juego.getCriminalSeleccionado());
            }

            // Avanzar 2 horas y añadir 100 puntos por la visita
            avanzarTiempo(2);
            actualizarPuntos(100);
        }
    });
    timer.setRepeats(false);  // Solo se ejecuta una vez
    timer.start();
}


 private void manejarVisitaLugar(String lugar, JFrame ventanaVisitar) {
    Ciudad ciudadActual = juego.getCiudadActual();  // Obtener la ciudad actual

    if (ciudadActual != null) {
        // Obtener las pistas de la ciudad actual
        List<String> pistas = leerPistas(ciudadActual.getNombre());

        // Si hay pistas disponibles, mostrar el diálogo con el testigo
        if (!pistas.isEmpty()) {
            String pista = "";
            switch (lugar) {
                case "Biblioteca":
                    pista = pistas.size() > 0 ? pistas.get(0) : "No hay pista disponible en la Biblioteca.";
                    break;
                case "Club Deportivo":
                    pista = pistas.size() > 1 ? pistas.get(1) : "No hay pista disponible en el Club Deportivo.";
                    break;
                case "Almacén":
                    pista = pistas.size() > 2 ? pistas.get(2) : "No hay pista disponible en el Almacén.";
                    break;
            }

            abrirDialogoTestigo(lugar, ciudadActual, pista);  // Mostrar el diálogo con la pista
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron pistas en esta ciudad.");
        }
    }

    avanzarTiempo(2);  // Avanzar el tiempo al visitar un lugar
    actualizarPuntos(100);  // Aumentar puntos al visitar un lugar
}

    // Método para abrir el diálogo con un testigo
private void abrirDialogoTestigo(String lugar, Ciudad siguienteCiudad, String pista) {
    // Crear la ventana de diálogo
    JDialog dialogoTestigo = new JDialog(this, "Diálogo con el Testigo", true);
    dialogoTestigo.setSize(400, 300);
    dialogoTestigo.setLocationRelativeTo(null); // Centrar la ventana

    // Crear un área de texto para el diálogo
    JTextArea areaDialogo = new JTextArea();
    areaDialogo.setEditable(false); // Hacer que no sea editable
    areaDialogo.setLineWrap(true);
    areaDialogo.setWrapStyleWord(true);

    // Crear el texto del diálogo entre el detective y el testigo con la pista
    String dialogoTexto = "Detective: Estoy investigando el paradero del criminal. ¿Tienes alguna pista?\n" + 
            "Testigo: Sí, vi a alguien sospechoso en el " + lugar + ".\n" +
            "Detective: ¿Hacia dónde crees que se dirigió?\n" +
            "Testigo: " + pista + "\n";

    areaDialogo.setText(dialogoTexto);

    // Añadir el área de texto a la ventana de diálogo
    JScrollPane scrollPaneDialogo = new JScrollPane(areaDialogo);
    dialogoTestigo.add(scrollPaneDialogo, BorderLayout.CENTER);

    // Botón para cerrar el diálogo
    JButton botonCerrar = new JButton("Cerrar");
    botonCerrar.addActionListener(e -> dialogoTestigo.dispose());

    // Añadir el botón en la parte inferior
    dialogoTestigo.add(botonCerrar, BorderLayout.SOUTH);

    // Hacer visible el diálogo
    dialogoTestigo.setVisible(true);
}


    private void actualizarFechaHora() {
        labelFechaHora.setText(fechaHoraActual.format(formatter));
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuJuego = new JMenu("Juego");
        JMenuItem itemCreditos = new JMenuItem("Creditos");
        JMenuItem itemRanking = new JMenuItem("Ranking");
        JMenuItem itemNuevoJuego = new JMenuItem("Nuevo Juego");
        
         itemCreditos.addActionListener(e -> mostrarCreditos());
         itemRanking.addActionListener(e -> mostrarRanking());
         
        // Añadir la acción para el botón "Nuevo Juego"
        itemNuevoJuego.addActionListener(e -> {
            int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Estás seguro de que quieres iniciar un nuevo juego? Perderás el progreso actual.",
                    "Confirmar nuevo juego",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                dispose();
                new Interfaz();  // Crear una nueva ventana del juego
            }
        });

        menuJuego.add(itemCreditos);
        menuJuego.add(itemRanking);
        menuJuego.add(itemNuevoJuego);
        menuBar.add(menuJuego);

        JMenu menuOpciones = new JMenu("Opciones");
        JCheckBoxMenuItem itemSonido = new JCheckBoxMenuItem("Sonido", true);
        itemSonido.addActionListener(e -> Sonidos.toggleSonido(itemSonido.isSelected()));
        menuOpciones.add(itemSonido);
        menuBar.add(menuOpciones);

        // Crear el nuevo menú de "Ayuda"
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itemAyuda = new JMenuItem("Mostrar Ayuda");

        // Añadir la acción para el botón "Ayuda"
        itemAyuda.addActionListener(e -> {
            HelpWindow helpWindow = new HelpWindow();
            helpWindow.setVisible(true);
        });

        menuAyuda.add(itemAyuda);
        menuBar.add(menuAyuda);

        JMenu menuSalir = new JMenu("Salir");
        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(e -> {
            int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Está seguro de que desea salir?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        menuSalir.add(itemSalir);
        menuBar.add(menuSalir);

        return menuBar;
    }
    
    private void mostrarMapa() {
        JFrame mapaFrame = new JFrame("Mapa de Uruguay");
        mapaFrame.setSize(800, 600);
        mapaFrame.setLocationRelativeTo(null);

        MapaPanel mapaPanel = new MapaPanel(this, mapaFrame);
        mapaFrame.add(mapaPanel);
        mapaFrame.setVisible(true);
    }
   private void mostrarVentanaVisitar() {
    // Crea una nueva ventana para los lugares a visitar
    JFrame ventanaVisitar = new JFrame("Visitar lugares");
    ventanaVisitar.setSize(652, 620);  // Tamaño ajustado de la ventana (igual al tamaño de la imagen)
    ventanaVisitar.setLocationRelativeTo(null);  // Centrar la ventana
    ventanaVisitar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Cerrar solo esta ventana

    // Carga la imagen de fondo
    ImageIcon fondoImagen = new ImageIcon("imagenes/visitar.jpg");
    JLabel fondoLabel = new JLabel(fondoImagen);
    fondoLabel.setLayout(null); // Cambiamos a "null" para controlar posiciones de los botones manualmente

    // Carga el GIF de los pasos
    ImageIcon pasosGif = new ImageIcon("imagenes/pasos.gif");
    JLabel labelPasos = new JLabel(pasosGif);
    labelPasos.setBounds(0, 550, 80, 80);  // Posición inicial fuera de los lugares
    fondoLabel.add(labelPasos);

    // Instancia de MoverPasos para controlar el movimiento
    Interfaz.MoverPasos moverPasos = new MoverPasos(labelPasos);  // Instancia creada aquí

    // Crea los botones con imágenes para la Biblioteca, Club Deportivo y Almacén
    JButton botonBiblioteca = new JButton();
    JButton botonClubDeportivo = new JButton();
    JButton botonAlmacen = new JButton();

    // Hace que los botones no muestren borde ni fondo
    botonBiblioteca.setContentAreaFilled(false);
    botonBiblioteca.setBorderPainted(false);

    botonClubDeportivo.setContentAreaFilled(false);
    botonClubDeportivo.setBorderPainted(false);

    botonAlmacen.setContentAreaFilled(false);
    botonAlmacen.setBorderPainted(false);

    // Establece posiciones y tamaños de los botones manualmente (200x200)
    botonBiblioteca.setBounds(20, 200, 200, 200);  // Biblioteca
    botonClubDeportivo.setBounds(226, 200, 200, 200);  // Club Deportivo
    botonAlmacen.setBounds(432, 200, 200, 200);  // Almacén
    // En el botón de la Biblioteca
    botonBiblioteca.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        manejarVisitaLugar("Biblioteca", ventanaVisitar);
    }
});

// En el botón del Club Deportivo
        botonClubDeportivo.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        //manejarVisitaCiudad(moverPasos,"Club Deportivo", 226, 200, ventanaVisitar);
       
    }
});

// En el botón del Almacén
botonAlmacen.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        manejarVisitaLugar("Almacén", ventanaVisitar);
    }
});

// Añadir los botones al fondo (que actúa como panel)
    fondoLabel.add(botonBiblioteca);
    fondoLabel.add(botonClubDeportivo);
    fondoLabel.add(botonAlmacen);

    // Añadir el fondo con los botones a la ventana
    ventanaVisitar.add(fondoLabel);

    // Mostrar la ventana
    ventanaVisitar.setVisible(true);
}
 private void manejarBotonVisitar() {
    Ciudad ciudadActual = juego.getCiudadActual();  // Obtener la ciudad actual

    if (ciudadActual != null) {
        if (juego.esUltimaCiudad()) {
            // Si el jugador está en la última ciudad, atrapar al criminal
            atraparCriminal();
        } else {
            // Si no está en la última ciudad, mostrar la ventana para visitar lugares
            avanzarCiudad();  // Avanzar a la siguiente ciudad
            mostrarVentanaVisitar();
        }
    } else {
        // Si la ciudad es incorrecta o no se encontró
        areaMaquinaEscribir.append("El criminal no está en esta ciudad. Sigue buscando.\n");
    }
}
  
   

// Método para atrapar al criminal en la última ciudad
private void atraparCriminal() {
    areaMaquinaEscribir.append("¡Has atrapado al criminal!\n");
    mostrarVentanaCriminalAtrapado(juego.getCriminalSeleccionado()); // Muestra la ventana del criminal atrapado
    //actualizarPuntos(1000); // Aumenta los puntos al capturar al criminal

    // Verificar si hay más criminales para continuar el juego
    if (juego.hayMasCriminales()) {
        juego.seleccionarCriminal(); // Seleccionamos un nuevo criminal
        juego.generarRutaEscape(); // Generamos una nueva ruta de escape
        areaMaquinaEscribir.append("Un nuevo criminal está en fuga.\n");
    } else {
        areaMaquinaEscribir.append("¡Has atrapado a todos los criminales! Has ganado el juego.\n");
    }
}



// Método actualizado para leer las pistas de la ciudad desde el archivo
private List<String> leerPistas(String nombreCiudad) {
    List<String> pistas = new ArrayList<>();
    String rutaArchivo = "Pistas/" + nombreCiudad + ".txt";

    try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            if (linea.toLowerCase().startsWith("pista1:")) {
                pistas.add(linea.replace("Pista1: ", "").trim());
                } else if (linea.toLowerCase().startsWith("pista2:")) {
                pistas.add(linea.replace("Pista2: ", "").trim());
                } else if (linea.toLowerCase().startsWith("pista3:")) {
                 pistas.add(linea.replace("Pista3: ", "").trim());
        }

        }
    } catch (IOException e) {
        e.printStackTrace();
        mostrarConEfectoMaquinaEscribir("Error al cargar las pistas de " + nombreCiudad + ".\n");
    }
    return pistas;
}


// Clase MoverPasos dentro de Interfaz
class MoverPasos {
    private int xPos;
    private int yPos;
    private final JLabel labelPasos;
    private int destinoX;
    private int destinoY;
    private Timer timer;

    public MoverPasos(JLabel labelPasos) {
        this.labelPasos = labelPasos;
        this.xPos = labelPasos.getX();
        this.yPos = labelPasos.getY();
    }

    public void setDestino(int x, int y) {
        this.destinoX = x;
        this.destinoY = y;
        if (timer != null && timer.isRunning()) {
            timer.stop();  // Detiene cualquier animación en curso
        }
        iniciarAnimacion();
    }

    private void iniciarAnimacion() {
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean haLlegado = true;
                
                // Movimiento hacia el destino en X
                if (xPos < destinoX) {
                    xPos += 5;  // Ajusta la velocidad del movimiento
                    haLlegado = false;
                } else if (xPos > destinoX) {
                    xPos -= 5;
                    haLlegado = false;
                }

                // Movimiento hacia el destino en Y
                if (yPos < destinoY) {
                    yPos += 5;
                    haLlegado = false;
                } else if (yPos > destinoY) {
                    yPos -= 5;
                    haLlegado = false;
                }

                // Actualiza la posición del GIF
                labelPasos.setLocation(xPos, yPos);

                // Detener la animación cuando llega al destino
                if (haLlegado) {
                    timer.stop();
                }
            }
        });
        timer.start();
    }
}


public class SonidoPasos {

    private static Clip clip;

    public static void reproducirPasos() {
        try {
            File archivoSonido = new File("src/main/resources/pasos.wav");  // Cambia la ruta si es necesario
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();  // Reproducir el sonido
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void detenerPasos() {
        if (clip != null && clip.isRunning()) {
            clip.stop();  // Detener el sonido
        }
    }
}
private void mostrarVentanaCriminalAtrapado(Criminal criminal) {
    // Crear una nueva ventana para indicar que se atrapó al criminal
    JFrame ventanaCriminalAtrapado = new JFrame("¡Criminal Atrapado!");
    ventanaCriminalAtrapado.setSize(450, 450);
    ventanaCriminalAtrapado.setLocationRelativeTo(null);  // Centrar la ventana
    ventanaCriminalAtrapado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Cerrar solo esta ventana

    // Crear un panel para agregar los componentes
    JPanel panelCriminalAtrapado = new JPanel(new BorderLayout());

    // Cargar la imagen del criminal atrapado
    ImageIcon imagenCriminal = new ImageIcon("imagenes/criminalatra.png");
    JLabel labelImagen = new JLabel(imagenCriminal);

    // Crear el JLabel para los mensajes (criminal atrapado y puntaje)
    JPanel panelMensajes = new JPanel(new GridLayout(2, 1));  // Para mostrar los dos mensajes uno debajo del otro
    JLabel labelMensaje = new JLabel("¡Has atrapado al criminal " + criminal.getNombreCriminal() + "!", SwingConstants.CENTER);
    labelMensaje.setFont(new Font("Serif", Font.BOLD, 18));
    labelMensaje.setForeground(Color.YELLOW);  // Color amarillo

    JLabel labelPuntaje = new JLabel("Ganaste 1000 puntos.", SwingConstants.CENTER);
    labelPuntaje.setFont(new Font("Serif", Font.BOLD, 16));
    labelPuntaje.setForeground(Color.GREEN);  // Mensaje de puntos en verde

    // Añadir los mensajes al panel de mensajes
    panelMensajes.add(labelMensaje);
    panelMensajes.add(labelPuntaje);

    // Sumar los puntos al puntaje total
    actualizarPuntos(1000);  // Añadir 1000 puntos al puntaje total

    // Crear un efecto de destello (blink) para el mensaje del criminal atrapado
    Timer timerBlink = new Timer(500, new ActionListener() {
        private boolean visible = true;

        @Override
        public void actionPerformed(ActionEvent e) {
            // Alternar la visibilidad del mensaje para crear el efecto de destello
            visible = !visible;
            labelMensaje.setForeground(visible ? Color.YELLOW : Color.BLACK);  // Alternar entre amarillo y negro
        }
    });
    timerBlink.start();  // Iniciar el efecto de destello

    // Agregar un botón "Siguiente"
    JButton botonSiguiente = new JButton("Siguiente");
    
   botonSiguiente.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        ventanaCriminalAtrapado.dispose(); // Cerrar la ventana de criminal atrapado

        // Verificar si hay más criminales
        if (juego.hayMasCriminales()) {
            // Seleccionar el siguiente criminal
            juego.seleccionarCriminal();

            // Obtener el nuevo criminal y mostrarlo en el área de texto directamente
            Criminal nuevoCriminal = juego.getCriminalSeleccionado();
            areaMaquinaEscribir.append("¡Un nuevo criminal está en fuga.\n");
            
            // Mostrar el mensaje con las horas de misión directamente
            areaMaquinaEscribir.append("En tu nueva misión tienes " + juego.getMision() + " horas para atrapar al criminal.\n");

            // Generar una nueva ruta de escape para el nuevo criminal
            juego.generarRutaEscape();
              // Actualizar el label que muestra el tiempo restante de la misión
            labelMision.setText("Tiempo de misión: " + juego.getMision() + " horas");
            // Mostrar las pistas de la primera ciudad en la ruta directamente
            List<Ciudad> ciudadesRuta = juego.getCiudadesRuta();
            if (!ciudadesRuta.isEmpty()) {
                Ciudad primeraCiudad = ciudadesRuta.get(0);

                // Leer y mostrar las pistas de la primera ciudad directamente
                List<String> pistas = leerPistas(primeraCiudad.getNombre());
                for (String pista : pistas) {
                    areaMaquinaEscribir.append(pista + "\n");
                }
            }
        } else {
            // No quedan más criminales, mostrar un mensaje de victoria
            JOptionPane.showMessageDialog(null, "¡Felicidades! Has atrapado a todos los criminales.");
        }
    }
});


    // Añadir los componentes al panel
    panelCriminalAtrapado.add(panelMensajes, BorderLayout.NORTH);  // Colocar los mensajes en la parte superior
    panelCriminalAtrapado.add(labelImagen, BorderLayout.CENTER);  // Colocar la imagen en el centro
    panelCriminalAtrapado.add(botonSiguiente, BorderLayout.PAGE_END);  // Colocar el botón al final

    // Añadir el panel a la ventana
    ventanaCriminalAtrapado.add(panelCriminalAtrapado);

    // Reproducir el sonido de victoria
    reproducirSonidoVictoria();

    // Hacer visible la ventana
    ventanaCriminalAtrapado.setVisible(true);
}
  
 
private void reproducirSonidoVictoria() {
    try {
        // Ruta del archivo win.wav
        File archivoSonido = new File("src/main/resources/win.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();  // Reproducir el sonido
    } catch (Exception e) {
        e.printStackTrace();
    }
}
        private void mostrarRanking() {
        SwingUtilities.invokeLater(() -> {
            RankingVista rankingVista = new RankingVista();
            rankingVista.setVisible(true);
        });
    }

    void mostrarCiudad(Ciudad ciudad) {
        labelNombreLugar.setText(ciudad.getNombre());
        labelImagen.setIcon(new ImageIcon(ciudad.getRutaImagen()));
        areaTexto.setText(ciudad.getDescripcion());

        for (JButton boton : botonesCiudades) {  
            if (boton.getLocation().equals(startPoint)) {
                boton.setBackground(Color.RED);
                botonesVisitados.add(boton);
            }
        }

        endPoint = new Point(ciudad.getX(), ciudad.getY());
        currentPosition = 0.0;
        if (animationTimer != null) {
            animationTimer.stop();
        }
        animationTimer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPosition += 0.02;
                if (currentPosition >= 1.0) {
                    animationTimer.stop();
                    startPoint = endPoint;
                    Sonidos.reproducir("src/main/resources/avion2.wav");

                    Timer stopSoundTimer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Sonidos.detener();
                            JFrame mapaFrame = (JFrame) SwingUtilities.getWindowAncestor(Interfaz.this);
                            if (mapaFrame != null) {
                                mapaFrame.dispose();
                            }

                            actualizarPuntos(100);
                            guardarNombreDetective(campoNombreDetective.getText());
                        }
                    });
                    stopSoundTimer.setRepeats(false);
                    stopSoundTimer.start();
                }
            }
        });
        animationTimer.start();

        avanzarTiempo(10);
    }

   private void avanzarTiempo(int horas) {
    // Avanzar las horas en el juego
    fechaHoraActual = fechaHoraActual.plusHours(horas);

    // Descontar las horas de la misión desde la clase Juego
    juego.descontarTiempoMision(horas);
    
    // Actualizar el label que muestra el tiempo restante de la misión
    labelMision.setText("Tiempo de misión: " + juego.getMision() + " horas");

    // Verificar si la hora actual es después de las 22:00
    int currentHour = fechaHoraActual.getHour();
    if (currentHour >= 22 || currentHour < 7) {
        // Si es después de las 22:00, avanzar al día siguiente a las 7:00 AM
        fechaHoraActual = fechaHoraActual.plusDays(1).withHour(7).withMinute(0);
    }

    // Verificar si el tiempo de la misión ha llegado a 0
    if (juego.getMision() <= 0) {
        mostrarPantallaPerdida();  // Llamar a la función para mostrar que el jugador ha perdido
    }

    // Actualizar la interfaz con la nueva fecha y tiempo de misión
    actualizarFechaHora();
}
private void mostrarPistas(JFrame ventanaVisitar, String lugar) {
    Ciudad ciudadActual = juego.getCiudadActual(); // Obtener la ciudad actual

    if (ciudadActual != null) {
        // Obtener las pistas de la ciudad actual
        List<String> pistas = leerPistas(ciudadActual.getNombre());

        // Si hay pistas disponibles, mostrar el diálogo con el testigo
        if (!pistas.isEmpty()) {
            String pista = "";
            switch (lugar) {
                case "Biblioteca":
                    pista = pistas.size() > 0 ? pistas.get(0) : "No hay pista disponible en la Biblioteca.";
                    break;
                case "Club Deportivo":
                    pista = pistas.size() > 1 ? pistas.get(1) : "No hay pista disponible en el Club Deportivo.";
                    break;
                case "Puerto":
                    pista = pistas.size() > 2 ? pistas.get(2) : "No hay pista disponible en el Puerto.";
                    break;
            }

            abrirDialogoTestigo(lugar, ciudadActual, pista);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron pistas en esta ciudad.");
        }
    }

    avanzarTiempo(2);
    actualizarPuntos(100);
}

 
private void mostrarPantallaPerdida() {
    // Reproducir sonido de perder
    reproducirSonido("src/main/resources/perder.wav");

    // Cargar la imagen de "perdido" como fondo
    ImageIcon icon = new ImageIcon("imagenes/perdio.jpg");

    // Crear un panel con la imagen como fondo
    JLabel fondo = new JLabel(icon);
    fondo.setLayout(null); // Usar un layout nulo para controlar posiciones manualmente

    // Crear el mensaje de "¡Se te agotó el tiempo!"
    JLabel labelMensaje = new JLabel("¡Se te agotó el tiempo para atrapar al criminal!", SwingConstants.CENTER);
    labelMensaje.setFont(new Font("Serif", Font.BOLD, 22));
    labelMensaje.setForeground(Color.RED); // Resaltarlo en rojo
    labelMensaje.setBounds(0, 10, icon.getIconWidth(), 50); // Posicionarlo arriba de la imagen
    fondo.add(labelMensaje);

    // Crear el texto "GAME OVER"
    JLabel labelGameOver = new JLabel("GAME OVER", SwingConstants.CENTER);
    labelGameOver.setFont(new Font("Serif", Font.BOLD, 80));
    labelGameOver.setForeground(Color.YELLOW); // Resaltarlo en amarillo
    labelGameOver.setBounds(0, 150, icon.getIconWidth(), 100); // Centrar el texto "GAME OVER"
    fondo.add(labelGameOver);

    // Crear el botón "OK" para cerrar el diálogo
    JButton botonOk = new JButton("OK");
    botonOk.setBounds(icon.getIconWidth() / 2 - 50, 450, 100, 40); // Centrar el botón en la parte inferior
    fondo.add(botonOk);

    // Añadir el panel con el fondo en un JOptionPane
    JOptionPane pane = new JOptionPane(fondo, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
    JDialog dialog = pane.createDialog(this, "Fin del juego");

    // Crear el efecto de movimiento (rebote)
    Timer timer = new Timer(50, new ActionListener() {
        int deltaY = 5;
        int posY = labelGameOver.getY();
        boolean movingDown = true; // Inicialmente movemos hacia abajo

        @Override
        public void actionPerformed(ActionEvent e) {
            if (movingDown) {
                posY += deltaY;
                if (posY >= 300) { // Limite inferior de la imagen
                    movingDown = false; // Cambiar dirección cuando alcanza el límite inferior
                }
            } else {
                posY -= deltaY;
                if (posY <= 150) { // Limite superior de la imagen
                    movingDown = true; // Cambiar dirección cuando alcanza el límite superior
                }
            }
            labelGameOver.setLocation(labelGameOver.getX(), posY); // Actualizar la posición del texto
        }
    });
    timer.start();

    // Añadir el listener para el botón "OK"
    botonOk.addActionListener(e -> {
        dialog.dispose(); // Cerrar el diálogo cuando se presiona "OK"
        timer.stop(); // Detener la animación

        // Opción para cerrar el juego o reiniciar después de "OK"
        int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres intentar de nuevo?", "Juego terminado", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            dispose();  // Cerrar la ventana actual
            new Interfaz();  // Crear una nueva instancia de la interfaz para reiniciar
        } else {
            System.exit(0);  // Cerrar el juego si el jugador no quiere continuar
        }
    });

    // Mostrar el diálogo y la animación
    dialog.setVisible(true);
}

private void reproducirSonido(String rutaSonido) {
    try {
        File sonido = new File(rutaSonido);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(sonido);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void actualizarPuntos(int nuevosPuntos) {
        puntos += nuevosPuntos;
        labelPuntos.setText("Puntos: " + puntos);
    }

    public void guardarNombreDetective(String nombreDetective) {
        String rutaArchivo = getClass().getClassLoader().getResource("ranking.txt").getPath();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(nombreDetective + ", " + puntos);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

private void mostrarConEfectoMaquinaEscribir(String mensaje) {
    Timer timer = new Timer(TIEMPO_ESCRITURA, new ActionListener() {
        private int index = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (index < mensaje.length()) {
                // Añadir carácter por carácter al área de texto
                char caracterActual = mensaje.charAt(index);
                
                // Evitar caracteres no válidos o codificados erróneamente
                if (Character.isDefined(caracterActual)) {
                    areaMaquinaEscribir.append(String.valueOf(caracterActual));
                    areaMaquinaEscribir.setCaretPosition(areaMaquinaEscribir.getDocument().getLength());
                }

                index++;
            } else {
                // Detener el temporizador cuando termina la animación
                ((Timer) e.getSource()).stop();
                detenerSonidoMaquinaEscribir(); // Detener el sonido al final
            }
        }
    });

    // Reproducir el sonido mientras se muestra el texto
    reproducirSonidoMaquinaEscribir();
    timer.start();
}

// Asegurarse de detener el sonido cuando se termine de escribir
private void detenerSonidoMaquinaEscribir() {
    if (clip != null && clip.isRunning()) {
        clip.stop();
        clip.close();  // Asegurarse de liberar el clip de sonido
    }
}


    private Clip clip;

    private void reproducirSonidoMaquinaEscribir() {
        try {
            InputStream audioSrc = getClass().getResourceAsStream("/teclas.wav");
            if (audioSrc == null) {
                throw new IOException("El archivo de sonido no se encuentra en la ruta especificada.");
            }

            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    

   
    private void mostrarCreditos() {
    // Crear una nueva ventana para los créditos
    JFrame creditosFrame = new JFrame("Créditos");
    creditosFrame.setSize(600, 400);  // Tamaño de la ventana de créditos
    creditosFrame.setLocationRelativeTo(null);  // Centrar la ventana en la pantalla

    // Crear un panel para mostrar la imagen
    JPanel panelCreditos = new JPanel(new BorderLayout());

    // Cargar la imagen y escalarla al tamaño de la ventana
    ImageIcon icono = new ImageIcon("imagenes/creditos.jpg");
    Image imagen = icono.getImage(); // Extraer la imagen del ImageIcon
    Image imagenEscalada = imagen.getScaledInstance(600, 400, Image.SCALE_SMOOTH); // Escalar la imagen
    ImageIcon iconoEscalado = new ImageIcon(imagenEscalada); // Crear un nuevo ImageIcon con la imagen escalada

    JLabel labelCreditos = new JLabel(iconoEscalado, SwingConstants.CENTER);
    panelCreditos.add(labelCreditos, BorderLayout.CENTER);

    // Añadir el panel a la ventana
    creditosFrame.add(panelCreditos);

    // Hacer visible la ventana
    creditosFrame.setVisible(true);
}

    public static void main(String[] args) {
        new Interfaz();
    }
}
