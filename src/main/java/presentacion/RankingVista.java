package presentacion;

import biblioteca.Jugador;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RankingVista extends JFrame {
    private JPanel contentPane;
    private JTable table;

    public RankingVista() {
        setTitle("Ranking de Detectives");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 400);

        // Establecer un panel personalizado para el fondo
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Recargar la imagen en cada repaint
                ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("background.png"));
                if (icon.getImage() != null) {
                    g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    // Si la imagen no se encuentra, mantener el fondo negro
                    g.setColor(Color.BLACK);
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };

        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        // Botón para cerrar la ventana
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());

        // Tabla para mostrar los puntajes
        String[] columnNames = {"Nombre", "Puntaje"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Cargar datos del ranking desde el archivo
        cargarDatosRanking(tableModel);

        table = new JTable(tableModel);
        table.setFont(new Font("Pixelated", Font.PLAIN, 16));
        table.setForeground(Color.YELLOW); // Cambia el color del texto de la tabla
        table.setBackground(new Color(0, 0, 0, 0)); // Fondo transparente para la tabla
        table.setShowGrid(false); // Oculta las líneas de la cuadrícula

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false); 
        scrollPane.getViewport().setOpaque(false); 
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.add(btnCerrar);
        contentPane.add(panelBotones, BorderLayout.SOUTH);
    }

    private void cargarDatosRanking(DefaultTableModel tableModel) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream("ranking.txt")))) {
            List<Jugador> jugadores = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String nombre = data[0].trim();
                    int puntaje = Integer.parseInt(data[1].trim());
                    jugadores.add(new Jugador(nombre, puntaje));
                }
            }
            // Ordenar y limitar a los 10 mejores puntajes
            jugadores.sort((j1, j2) -> Integer.compare(j2.getPuntaje(), j1.getPuntaje()));
            jugadores.stream().limit(10).forEach(j -> tableModel.addRow(new Object[]{j.getNombre(), j.getPuntaje()}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RankingVista frame = new RankingVista();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
