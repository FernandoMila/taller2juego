package presentacion;

import biblioteca.Ciudad;
import biblioteca.Criminal;
import biblioteca.Juego;  // Importa correctamente la clase Juego
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Interfaz extends JFrame {

    // Atributos de la interfaz
    JLabel labelNombreLugar;
    JLabel labelFechaHora;
    JLabel labelImagen;
    JTextArea areaTexto;
    JLabel labelPuntos;
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
    private static final int TIEMPO_ESCRITURA = 50; // Tiempo en milisegundos entre caracteres
    private int diasParaAtraparCriminal = 2; // Definir el número de días para la misión

    private Juego juego;  // Instancia de Juego correctamente declarada

    // Nuevos atributos para el constructor con parámetros
    private Criminal criminal;
    private List<String> lista;
    private Ciudad ciudadActual;

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
        JPanel panelDatos = new JPanel(new GridLayout(1, 2));
        panelDatos.add(labelFechaHora);
        panelDatos.add(labelPuntos);
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

            Timer esperaTimer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarConEfectoMaquinaEscribir("Tienes 24 horas para atrapar al criminal.\n");

                    Timer esperaTimer1 = new Timer(4000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            List<Ciudad> ciudadesRuta = juego.getCiudadesRuta();
                            if (!ciudadesRuta.isEmpty()) {
                                ciudadActual = ciudadesRuta.get(0);
                                List<String> pistas = leerPistas(ciudadActual.getNombre());

                                // Mostrar las pistas directamente sin efecto de máquina de escribir
                                for (String pista : pistas) {
                                    areaMaquinaEscribir.append(pista + "\n");
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
        JButton botonVisitar = new JButton(new ImageIcon("imagenes/botones/BuscarCiudades.jpg"));
        JButton botonMapa = new JButton(new ImageIcon("imagenes/botones/Avion.png"));
        JButton botonBuscarCriminal = new JButton(new ImageIcon("imagenes/botones/Criminal.jpg"));
        JButton botonCerrar = new JButton(new ImageIcon("imagenes/botones/Cerrar.jpg"));
        Dimension buttonSize = new Dimension(50, 50);
        botonVisitar.setPreferredSize(buttonSize);
        botonMapa.setPreferredSize(buttonSize);
        botonBuscarCriminal.setPreferredSize(buttonSize);
        botonCerrar.setPreferredSize(buttonSize);
        panelInferior.add(botonVisitar);
        panelInferior.add(botonMapa);
        panelInferior.add(botonBuscarCriminal);
        panelInferior.add(botonCerrar);

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
        
        botonVisitar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MostrarLugar m = new MostrarLugar(ciudadActual);
                m.setVisible(true);
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

    private void actualizarFechaHora() {
        labelFechaHora.setText(fechaHoraActual.format(formatter));
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuJuego = new JMenu("Juego");
        JMenuItem itemCreditos = new JMenuItem("Créditos");
        JMenuItem itemRanking = new JMenuItem("Ranking");
        JMenuItem itemNuevoJuego = new JMenuItem("Nuevo Juego");

        // Añadir la acción para el botón "Nuevo Juego"
        itemNuevoJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "¿Estás seguro de que quieres iniciar un nuevo juego? Perderás el progreso actual.",
                        "Confirmar nuevo juego",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (respuesta == JOptionPane.YES_OPTION) {
                    dispose();
                    new Interfaz(); // Crear una nueva ventana del juego
                }
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
        
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itemAyuda = new JMenuItem("Ver ayuda");
        itemAyuda.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                HelpWindow h = new HelpWindow();
                h.setVisible(true);
            }
        });
        menuAyuda.add(itemAyuda);
        menuBar.add(menuAyuda);


        JMenu menuSalir = new JMenu("Salir");
        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(new ActionListener() {
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
        menuSalir.add(itemSalir);
        menuBar.add(menuSalir);

        itemRanking.addActionListener(e -> mostrarRanking());

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

        avanzarTiempo(5);
    }

    private void avanzarTiempo(int horas) {
        fechaHoraActual = fechaHoraActual.plusHours(horas);
        actualizarFechaHora();
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

    

    private List<String> leerPistas(String nombreCiudad) {
        List<String> pistas = new ArrayList<>();
        String rutaArchivo = "Pistas/" + nombreCiudad + ".txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                pistas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
            mostrarConEfectoMaquinaEscribir("Error al cargar las pistas de " + nombreCiudad + ".\n");
        }
        return pistas;
    }

    public static void main(String[] args) {
        new Interfaz();
    }
}

