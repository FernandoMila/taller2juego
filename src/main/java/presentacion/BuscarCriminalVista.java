package presentacion;

import Controllers.CriminalController;
import DAO.CriminalDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BuscarCriminalVista {
    private JFrame frame;
    private JButton botonMostrarTodos;
    private JTextArea areaResultado;

    public BuscarCriminalVista() {
        // Configuración de la ventana principal
        frame = new JFrame("Buscar Criminal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);

        // Botón para mostrar todos los criminales
        botonMostrarTodos = new JButton("Mostrar Todos");
        botonMostrarTodos.setBounds(120, 10, 150, 25);
        frame.add(botonMostrarTodos);

        // Área de texto para mostrar los resultados
        areaResultado = new JTextArea();
        areaResultado.setBounds(10, 50, 360, 300);
        frame.add(areaResultado);

        // Acción del botón de mostrar todos los criminales
        botonMostrarTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia de CriminalController
                CriminalController controller = new CriminalController();

                // Obtener todos los criminales
                List<CriminalDAO> criminales = controller.obtenerTodosLosCriminales();

                // Limpiar el área de resultados
                areaResultado.setText("");

                // Mostrar cada criminal en la lista
                for (CriminalDAO criminal : criminales) {
                    String infoCriminal = String.format("ID: %d\nNombre: %s\nSexo: %s\nOcupación: %s\nColor de pelo: %s\nVehículo: %s\nHobby: %s\nCaracterísticas: %s\n\n",
                            criminal.getIdCriminal(), criminal.getNombreCriminal(), criminal.getSexo(), criminal.getOcupacion(), criminal.getColorPelo(),
                            criminal.getVehiculo(), criminal.getHobbie(), criminal.getCaracteristica());
                    areaResultado.append(infoCriminal);
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BuscarCriminalVista();
            }
        });
    }
}
