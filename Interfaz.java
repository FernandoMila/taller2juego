<<<<<<< HEAD:src/main/java/com/mycompany/taller2juego/Interfaz.java
package com.mycompany.taller2juego;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Interfaz extends JFrame {

    private JLabel labelNombreLugar;
    private JLabel labelFechaHora;
    private JLabel labelImagen;
    private JTextArea areaTexto;
    private Clip clip;
    private boolean sonidoActivo = true;
    private List<JButton> botonesCiudades = new ArrayList<>();
    private List<JButton> botonesVisitados = new ArrayList<>();
    private Timer animationTimer;
    private Point startPoint;
    private Point endPoint;
    private double currentPosition;

    public Interfaz() {
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
        labelFechaHora = new JLabel("Lunes, 4 p.m.", SwingConstants.CENTER);
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
        Dimension buttonSize = new Dimension(100, 50);
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

        // Hacer visible la ventana
        setVisible(true);
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
        itemSonido.addActionListener(e -> toggleSonido(itemSonido.isSelected()));
        menuOpciones.add(itemSonido);
        menuBar.add(menuOpciones);

        JMenu menuSalir = new JMenu("Salir");
        menuBar.add(menuSalir);

        return menuBar;
    }

    private void mostrarMapa() {
        JFrame mapaFrame = new JFrame("Mapa de Uruguay");
        mapaFrame.setSize(800, 600);
        mapaFrame.setLocationRelativeTo(null);

        JPanel mapaPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon mapaImagen = new ImageIcon("imagenes/mapa.png");
                g.drawImage(mapaImagen.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        mapaPanel.setLayout(null);

        List<Ciudad> ciudades = obtenerTodasLasCiudades();

        for (Ciudad ciudad : ciudades) {
            JButton botonCiudad = new JButton();
            botonCiudad.setBounds(ciudad.getX(), ciudad.getY(), 20, 20);
            botonCiudad.setBackground(Color.BLUE);
            botonCiudad.setOpaque(true);
            botonCiudad.setBorderPainted(false);
            botonCiudad.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            botonCiudad.addActionListener(e -> {
                startPoint = botonCiudad.getLocation();
                mostrarCiudad(ciudad);
            });
            mapaPanel.add(botonCiudad);
            botonesCiudades.add(botonCiudad);
        }

        mapaFrame.add(mapaPanel);
        mapaFrame.setVisible(true);
    }

    private List<Ciudad> obtenerTodasLasCiudades() {
        List<Ciudad> ciudades = new ArrayList<>();
        // Definir las coordenadas x e y para cada ciudad
        ciudades.add(new Ciudad(1, "Colonia del Sacramento", null, "Descripción de Colonia", "imagenes/Colsacra.png", null, 50, 500));
        ciudades.add(new Ciudad(2, "Montevideo", null, "Descripción de Montevideo", "imagenes/Montevideo.png", null, 200, 400));
        // Añadir más ciudades según sea necesario
        return ciudades;
    }

    private void mostrarCiudad(Ciudad ciudad) {
        labelNombreLugar.setText(ciudad.getNombre());
        labelFechaHora.setText("Fecha y Hora Actualizada");
        labelImagen.setIcon(new ImageIcon(ciudad.getRutaImagen()));
        areaTexto.setText(ciudad.getDescripcion());

        // Cambiar color del botón a rojo
        for (JButton boton : botonesCiudades) {
            if (boton.getLocation().equals(startPoint)) {
                boton.setBackground(Color.RED);
                botonesVisitados.add(boton);
            }
        }

        // Simular el viaje
        avanzarTiempo(5);
    }

    private void avanzarTiempo(int horas) {
        // Implementar la lógica para avanzar el tiempo y actualizar el labelFechaHora
        // Esto podría incluir sumar horas a un objeto Date y formatearlo como cadena
    }

    private void playSound(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    private void toggleSonido(boolean activar) {
        if (activar) {
            clip.start();
        } else {
            stopSound();
        }
        sonidoActivo = activar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interfaz());
    }
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import biblioteca.Ciudad;
import javax.swing.ImageIcon;
import logica.Controlador;

/**
 *
 * @author grabe
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelCiudad = new javax.swing.JPanel();
        ciudadActual = new javax.swing.JLabel();
        imagenCiudad = new javax.swing.JLabel();
        panelAcciones = new javax.swing.JPanel();
        pistaLugar = new javax.swing.JLabel();
        viajarCiudades = new javax.swing.JButton();
        listaCiudadesProx = new javax.swing.JButton();
        buscarLugar = new javax.swing.JButton();
        acusarCriminal = new javax.swing.JButton();
        barraNavegacion = new javax.swing.JMenuBar();
        barraJuego = new javax.swing.JMenu();
        creditosJuego = new javax.swing.JMenuItem();
        juegoNuevo = new javax.swing.JMenuItem();
        salirJuego = new javax.swing.JMenuItem();
        barraOpciones = new javax.swing.JMenu();
        sonidoActivacion = new javax.swing.JCheckBoxMenuItem();
        barraCriminales = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout panelCiudadLayout = new javax.swing.GroupLayout(panelCiudad);
        panelCiudad.setLayout(panelCiudadLayout);
        panelCiudadLayout.setHorizontalGroup(
            panelCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCiudadLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ciudadActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imagenCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
        );
        panelCiudadLayout.setVerticalGroup(
            panelCiudadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCiudadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ciudadActual, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagenCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viajarCiudades.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        viajarCiudades.setIcon(new javax.swing.ImageIcon("C:\\Users\\grabe\\OneDrive\\Documentos\\GitHub\\taller2juego\\imagenes\\Botones\\Avion.png")); // NOI18N
        viajarCiudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viajarCiudadesActionPerformed(evt);
            }
        });

        listaCiudadesProx.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        listaCiudadesProx.setIcon(new javax.swing.ImageIcon("C:\\Users\\grabe\\OneDrive\\Documentos\\GitHub\\taller2juego\\imagenes\\Botones\\Ciudades.jpg")); // NOI18N
        listaCiudadesProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaCiudadesProxActionPerformed(evt);
            }
        });

        buscarLugar.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        buscarLugar.setIcon(new javax.swing.ImageIcon("C:\\Users\\grabe\\OneDrive\\Documentos\\GitHub\\taller2juego\\imagenes\\Botones\\BuscarCiudades.jpg")); // NOI18N

        acusarCriminal.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        acusarCriminal.setIcon(new javax.swing.ImageIcon("C:\\Users\\grabe\\OneDrive\\Documentos\\GitHub\\taller2juego\\imagenes\\Botones\\Criminal.jpg")); // NOI18N

        javax.swing.GroupLayout panelAccionesLayout = new javax.swing.GroupLayout(panelAcciones);
        panelAcciones.setLayout(panelAccionesLayout);
        panelAccionesLayout.setHorizontalGroup(
            panelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccionesLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(listaCiudadesProx, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viajarCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acusarCriminal, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pistaLugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAccionesLayout.setVerticalGroup(
            panelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccionesLayout.createSequentialGroup()
                .addComponent(pistaLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(listaCiudadesProx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viajarCiudades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscarLugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(acusarCriminal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelAcciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        barraJuego.setText("Juego");

        creditosJuego.setText("Creditos");
        barraJuego.add(creditosJuego);

        juegoNuevo.setText("Nuevo Juego");
        juegoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juegoNuevoActionPerformed(evt);
            }
        });
        barraJuego.add(juegoNuevo);

        salirJuego.setText("Salir");
        barraJuego.add(salirJuego);

        barraNavegacion.add(barraJuego);

        barraOpciones.setText("Opciones");

        sonidoActivacion.setSelected(true);
        sonidoActivacion.setText("Sonido");
        barraOpciones.add(sonidoActivacion);

        barraNavegacion.add(barraOpciones);

        barraCriminales.setText("Criminales");
        barraCriminales.setEnabled(false);
        barraNavegacion.add(barraCriminales);

        setJMenuBar(barraNavegacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viajarCiudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viajarCiudadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viajarCiudadesActionPerformed

    private void listaCiudadesProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaCiudadesProxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaCiudadesProxActionPerformed

    private void juegoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juegoNuevoActionPerformed
        Ciudad c = new Ciudad();
        c = new Controlador().seleccionarCiudad(1);
        ciudadActual.setText(c.getNombre());
        pistaLugar.setText(c.getDescripcion());
        ImageIcon icon = new ImageIcon("imagenes/"+ c.getImagen());
        imagenCiudad.setIcon(icon);
        // TODO add your handling code here:
    }//GEN-LAST:event_juegoNuevoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acusarCriminal;
    private javax.swing.JMenu barraCriminales;
    private javax.swing.JMenu barraJuego;
    private javax.swing.JMenuBar barraNavegacion;
    private javax.swing.JMenu barraOpciones;
    private javax.swing.JButton buscarLugar;
    private javax.swing.JLabel ciudadActual;
    private javax.swing.JMenuItem creditosJuego;
    private javax.swing.JLabel imagenCiudad;
    private javax.swing.JMenuItem juegoNuevo;
    private javax.swing.JButton listaCiudadesProx;
    private javax.swing.JPanel panelAcciones;
    private javax.swing.JPanel panelCiudad;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel pistaLugar;
    private javax.swing.JMenuItem salirJuego;
    private javax.swing.JCheckBoxMenuItem sonidoActivacion;
    private javax.swing.JButton viajarCiudades;
    // End of variables declaration//GEN-END:variables
}
>>>>>>> master:src/main/java/presentacion/Interfaz.java
