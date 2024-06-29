package presentacion;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainWindow extends JFrame {

    public MainWindow() {
        // Configurar la ventana
        setTitle("Carmen Sandiego: Aventura en Uruguay");
        setSize(800, 600); // Ancho x Alto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Reproducir el sonido de inicio
        //playSound("src/main/resources/inicio.wav");

        // Crear un JLabel para el título
        JLabel titleLabel = new JLabel("Carmen Sandiego: Aventura en Uruguay", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32)); // Cambiar tamaño y estilo de fuente

        // Crear un panel para el título
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Añadir márgenes
        titlePanel.add(titleLabel, BorderLayout.NORTH);

        // Crear un panel para la imagen
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("imagenes/imagen2.png");
        imageLabel.setIcon(icon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        // Crear los botones
        JButton boton1 = new JButton("Jugar");
        JButton boton2 = new JButton("Ayuda");
        //JButton boton3 = new JButton("Ranking");

        // Ajustar el tamaño de los botones
        Dimension buttonSize = new Dimension(120, 40);
        boton1.setPreferredSize(buttonSize);
        boton2.setPreferredSize(buttonSize);
        //boton3.setPreferredSize(buttonSize);

        // Añadir listener para el botón de ayuda
        boton2.addActionListener(e -> {
            HelpWindow helpWindow = new HelpWindow();
            helpWindow.setVisible(true);
        });
        
        // Añadir listener para el botón de ayuda
        boton1.addActionListener(e -> {
            Interfaz interfaz = new Interfaz();
            interfaz.setVisible(true);
        });
        // Crear un panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(boton1);
        buttonPanel.add(boton2);
        //buttonPanel.add(boton3);

        // Añadir los paneles a la ventana principal
        setLayout(new BorderLayout());
        add(titlePanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Hacer visible la ventana
        setVisible(true);
    }

    private void playSound(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Ejecutar en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(() -> new MainWindow());
    }
}
