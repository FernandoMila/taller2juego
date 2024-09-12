package presentacion;

import biblioteca.Ciudad;
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

public class Interfaz extends JFrame {

    JLabel labelNombreLugar;
    JLabel labelFechaHora;
    JLabel labelImagen;
    JTextArea areaTexto;
    JLabel labelPuntos;
    JTextField campoNombreDetective;
    JButton botonConfirmarNombre;
    List<JButton> botonesCiudades = new ArrayList<>();
    List<JButton> botonesVisitados = new ArrayList<>();
    Point startPoint;
    Point endPoint;
    Timer animationTimer;
    double currentPosition;

    LocalDateTime fechaHoraActual;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, h a");
    private int puntos = 0;

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
        JPanel panelCentral = new JPanel(new GridLayout(1, 2));
        JPanel panelImagenDescripcion = new JPanel(new GridLayout(1, 2));
        labelImagen = new JLabel(new ImageIcon("imagenes/ciudades/Palacio.jpeg"), SwingConstants.CENTER);
        labelImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        areaTexto = new JTextArea("En una zona alta del barrio La Aguada, se destaca el edificio Palacio Legislativo, sede del poder legislativo del estado uruguayo. Este edificio emblemático e hito urbano por excelencia, se inaugura el 25 de agosto de 1925, coincidiendo con los festejos del centenario de la Declaratoria de la Independencia del Uruguay.");
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Serif", Font.PLAIN, 20));
        areaTexto.setForeground(Color.BLUE);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        panelImagenDescripcion.add(labelImagen);
        panelImagenDescripcion.add(scrollPane);
        panelCentral.add(panelImagenDescripcion);

        // Crear panel para el campo de nombre y botón
        JPanel panelNombreDetective = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelNombreDetective.setBorder(BorderFactory.createTitledBorder("Identificación del Detective"));
        campoNombreDetective = new JTextField(20);
        botonConfirmarNombre = new JButton("Confirmar");
        botonConfirmarNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreDetective = campoNombreDetective.getText().trim();
                if (!nombreDetective.isEmpty()) {
                    guardarNombreDetective(nombreDetective);
                }
            }
        });
        panelNombreDetective.add(new JLabel("Detective, por favor identifíquese:"));
        panelNombreDetective.add(campoNombreDetective);
        panelNombreDetective.add(botonConfirmarNombre);

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
        
        botonVisitar.addActionListener(e -> mostrarLugares());

        // Añadir paneles a la ventana
        setLayout(new BorderLayout());
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelNombreDetective, BorderLayout.SOUTH);
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

        // Añadir acción al botón "Ranking"
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
        // Crear y mostrar la ventana de ranking usando RankingVista
        SwingUtilities.invokeLater(() -> {
            RankingVista rankingVista = new RankingVista();
            rankingVista.setVisible(true);
        });
    }

    void mostrarCiudad(Ciudad ciudad) {
        labelNombreLugar.setText(ciudad.getNombre());
        areaTexto.setText(ciudad.getDescripcion());
        labelImagen.setIcon(new ImageIcon(ciudad.getRutaImagen())); // Cambia getImagenRuta() por getRutaImagen()

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
                if (currentPosition > 1) {
                    animationTimer.stop();
                    currentPosition = 1;
                }
                int x = (int) (startPoint.x + (endPoint.x - startPoint.x) * currentPosition);
                int y = (int) (startPoint.y + (endPoint.y - startPoint.y) * currentPosition);
                // Actualiza la posición del botón aquí
            }
        });
        animationTimer.start();
    }

    private void guardarNombreDetective(String nombre) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ranking.txt", true))) {
            writer.write(nombre + " - Puntaje: 0");
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Nombre del detective guardado.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar el nombre del detective.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interfaz());
    }

    private void mostrarLugares() {
        Lugares l = new Lugares(1);
        l.setVisible(true);  
    }
}
