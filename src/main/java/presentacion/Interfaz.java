package presentacion;

import biblioteca.Ciudad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Interfaz extends JFrame {

    JLabel labelNombreLugar;
    JLabel labelFechaHora;
    JLabel labelImagen;
    JTextArea areaTexto;
    List<JButton> botonesCiudades = new ArrayList<>();
    List<JButton> botonesVisitados = new ArrayList<>();
    Point startPoint;
    Point endPoint;
    Timer animationTimer;
    double currentPosition;

    LocalDateTime fechaHoraActual;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, h a");

    public Interfaz() {
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
        labelNombreLugar = new JLabel("Colonia del Sacramento", SwingConstants.CENTER);
        labelNombreLugar.setFont(new Font("Serif", Font.BOLD, 24));
        labelFechaHora = new JLabel(fechaHoraActual.format(formatter), SwingConstants.CENTER);
        labelFechaHora.setFont(new Font("Serif", Font.PLAIN, 18));
        panelSuperior.add(labelNombreLugar, BorderLayout.NORTH);
        panelSuperior.add(labelFechaHora, BorderLayout.SOUTH);

        // Crear panel central con GridLayout
        JPanel panelCentral = new JPanel(new GridLayout(1, 2));
        labelImagen = new JLabel(new ImageIcon("imagenes/Colsacra.png"), SwingConstants.CENTER);
        labelImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaTexto = new JTextArea("Información del Lugar Aquí");
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setEditable(false);
        panelCentral.add(labelImagen);
        panelCentral.add(new JScrollPane(areaTexto));

        // Crear panel inferior con FlowLayout
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton botonVisitar = new JButton(new ImageIcon("imagenes/botones/BuscarCiudades.jpg"));
        JButton botonMapa = new JButton(new ImageIcon("imagenes/botones/Avion.png"));
        JButton botonBuscarCriminal = new JButton(new ImageIcon("imagenes/botones/Criminal.jpg"));
        JButton botonCerrar = new JButton("Cerrar");
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

        // Añadir acción al botón "Mapa"
        botonMapa.addActionListener(e -> mostrarMapa());

        // Añadir paneles a la ventana
        setLayout(new BorderLayout());
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

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
        menuJuego.add(itemCreditos);
        menuJuego.add(itemRanking);
        menuJuego.add(itemNuevoJuego);
        menuBar.add(menuJuego);

        JMenu menuOpciones = new JMenu("Opciones");
        JCheckBoxMenuItem itemSonido = new JCheckBoxMenuItem("Sonido", true);
        itemSonido.addActionListener(e -> Sonidos.toggleSonido(itemSonido.isSelected()));
        menuOpciones.add(itemSonido);
        menuBar.add(menuOpciones);

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

    void mostrarCiudad(Ciudad ciudad) {
        labelNombreLugar.setText(ciudad.getNombre());
        labelImagen.setIcon(new ImageIcon(ciudad.getRutaImagen()));
        areaTexto.setText(ciudad.getDescripcion());

        // Cambiar color del botón a rojo
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
                    startPoint = endPoint; // Mover el punto de partida al punto final
                    Sonidos.reproducir("src/main/resources/avion2.wav");

                    // Detener el sonido después de 2 segundos y cerrar el mapa
                    Timer stopSoundTimer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Sonidos.detener();
                            JFrame mapaFrame = (JFrame) SwingUtilities.getWindowAncestor(Interfaz.this);
                            if (mapaFrame != null) {
                                mapaFrame.dispose();
                            }
                        }
                    });
                    stopSoundTimer.setRepeats(false);
                    stopSoundTimer.start();
                }
            }
        });
        animationTimer.start();

        // Simular el viaje avanzando 5 horas
        avanzarTiempo(5);
    }

    private void avanzarTiempo(int horas) {
        fechaHoraActual = fechaHoraActual.plusHours(horas);
        actualizarFechaHora();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interfaz());
    }
}
