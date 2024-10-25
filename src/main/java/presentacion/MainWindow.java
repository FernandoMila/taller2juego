package presentacion;

import biblioteca.Juego;
import biblioteca.Ciudad;
import biblioteca.Criminal;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainWindow extends JFrame {

    private Clip clip;
    private Juego juego;

    public MainWindow() {
        // Configurar la ventana
        setTitle("Carmen Sandiego: Aventura en Uruguay");
        setSize(800, 600); // Ancho x Alto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear un JLabel para el título
        JLabel titleLabel = new JLabel("Carmen Sandiego Aventura en Uruguay", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32)); // Cambiar tamaño y estilo de fuente

        // Crear un panel para el título
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Añadir márgenes
        titlePanel.add(titleLabel, BorderLayout.NORTH);

        // Crear un panel para la imagen
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("imagenes/imagen2.png"); // Asegúrate de que esta ruta sea correcta
        imageLabel.setIcon(icon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        // Crear los botones
        JButton boton1 = new JButton("Jugar");
        JButton boton2 = new JButton("Ayuda");

        // Ajustar el tamaño de los botones
        Dimension buttonSize = new Dimension(120, 40);
        boton1.setPreferredSize(buttonSize);
        boton2.setPreferredSize(buttonSize);

        // Añadir listener para el botón de ayuda
        boton2.addActionListener(e -> {
            HelpWindow helpWindow = new HelpWindow();
            helpWindow.setVisible(true);
        });

        // Añadir listener para el botón de "Jugar"
       boton1.addActionListener(e -> {
             // Detener el sonido de inicio
    if (clip != null && clip.isRunning()) {
        clip.stop();
    }
    // Iniciar el juego
    juego = new Juego();  // Inicializar el juego
    Criminal criminalSeleccionado = juego.getCriminalSeleccionado();
    java.util.List<Ciudad> ciudadesRuta = juego.getCiudadesRuta();

    // Convertir la lista de ciudades a una lista de nombres de ciudades
    java.util.List<String> nombresCiudadesRuta = ciudadesRuta.stream()
        .map(Ciudad::getNombre) // Suponiendo que Ciudad tiene un método getNombre()
        .toList();

    // Mostrar detalles del criminal seleccionado y la ruta
    //System.out.println("Criminal seleccionado2: " + criminalSeleccionado.getNombreCriminal());
   // System.out.println("Ruta de escape2: " + nombresCiudadesRuta);

    // Abrir la interfaz del juego
    Interfaz interfaz = new Interfaz(criminalSeleccionado, nombresCiudadesRuta);
    interfaz.setVisible(true);
});


        // Crear un panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(boton1);
        buttonPanel.add(boton2);

        // Añadir los paneles a la ventana principal
        setLayout(new BorderLayout());
        add(titlePanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Reproducir el sonido de inicio con volumen al 15%
        playSound("src/main/resources/inicio.wav");

        // Hacer visible la ventana
        setVisible(true);
    }

    private void playSound(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);  // Asegúrate de que la ruta sea correcta
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Configurar el volumen al 15%
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float volume = 0.15f;  // Volumen entre 0.0 y 1.0
            float dB = (float)(Math.log10(volume) * 20); // Conversión a decibelios
            volumeControl.setValue(dB);

            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Repetir el sonido
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Ejecutar en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(() -> new MainWindow());
    }
}
