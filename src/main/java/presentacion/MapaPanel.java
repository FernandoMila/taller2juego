package presentacion;

import biblioteca.Sonidos;
import biblioteca.Ciudad;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MapaPanel extends JPanel {
    private final Interfaz interfaz;
    private final JFrame mapaFrame; // Referencia al JFrame del mapa
    private Point startPoint;
    private Point endPoint;
    private double currentPosition;
    private Timer animationTimer;

    public MapaPanel(Interfaz interfaz, JFrame mapaFrame) {
        this.interfaz = interfaz;
        this.mapaFrame = mapaFrame; // Inicializar el JFrame del mapa
        setLayout(null);
        Ciudad ciudad = new Ciudad();
        List<Ciudad> ciudades = ciudad.obtenerTodasLasCiudades();

        for (Ciudad c : ciudades) { // Cambiar el nombre de la variable en el bucle
            JButton botonCiudad = new JButton();
            botonCiudad.setBounds(c.getX(), c.getY(), 10, 10); // Tamaño reducido a la cuarta parte
            botonCiudad.setBackground(Color.BLUE);
            botonCiudad.setOpaque(true);
            botonCiudad.setBorderPainted(false);
            botonCiudad.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            botonCiudad.setPreferredSize(new Dimension(10, 10)); // Tamaño reducido a la cuarta parte
            botonCiudad.setContentAreaFilled(false);
            botonCiudad.setOpaque(true);
            botonCiudad.setFocusPainted(false);
            botonCiudad.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            botonCiudad.setUI(new BasicButtonUI() {
                @Override
                public void installUI(JComponent c) {
                    super.installUI(c);
                    c.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                }

                @Override
                public Dimension getPreferredSize(JComponent c) {
                    return new Dimension(10, 10);
                }

                @Override
                public void paint(Graphics g, JComponent c) {
                    super.paint(g, c);
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    int diameter = Math.min(c.getWidth(), c.getHeight());
                    int x = (c.getWidth() - diameter) / 2;
                    int y = (c.getHeight() - diameter) / 2;
                    g2.fillOval(x, y, diameter, diameter);
                    g2.dispose();
                }
            });

            botonCiudad.addActionListener(e -> {
                startPoint = botonCiudad.getLocation();
                interfaz.mostrarCiudad(c);
                startAnimation(botonCiudad.getLocation());
            });
            add(botonCiudad);
            interfaz.botonesCiudades.add(botonCiudad);
        }
    }

    private void startAnimation(Point target) {
        endPoint = target;
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
                    interfaz.repaint(); // Repaint the main panel to clear the line

                    // Detener el sonido después de 2 segundos y cerrar el mapa
                    Timer stopSoundTimer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Sonidos.detener();
                            mapaFrame.dispose(); // Cerrar la ventana del mapa
                        }
                    });
                    stopSoundTimer.setRepeats(false);
                    stopSoundTimer.start();
                }
                repaint();
            }
        });
        animationTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon mapaImagen = new ImageIcon("imagenes/mapa.png");
        g.drawImage(mapaImagen.getImage(), 0, 0, getWidth(), getHeight(), null);

        // Dibujar línea de animación
        if (startPoint != null && endPoint != null && currentPosition < 1.0) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(2));
            int x1 = (int) (startPoint.x + (endPoint.x - startPoint.x) * currentPosition);
            int y1 = (int) (startPoint.y + (endPoint.y - startPoint.y) * currentPosition);
            g2d.drawLine(startPoint.x + 5, startPoint.y + 5, x1 + 5, y1 + 5);
        }
    }
}
