package presentacion;

import Controllers.CriminalController;
<<<<<<< HEAD
import DAO.CriminalDAO;
<<<<<<< HEAD
=======
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
>>>>>>> parent of 5276f93... Actualizar hibernate.cfg.xml, CriminalController.java y 4 más archivos...

=======
>>>>>>> Joao
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarCriminalVista {
    private JFrame frame;
<<<<<<< HEAD
    private JButton botonMostrarTodos;
<<<<<<< HEAD
    private JButton botonFiltrar;
=======
    private JTextField campoBusqueda;
    private JButton botonBuscar;
>>>>>>> parent of 5276f93... Actualizar hibernate.cfg.xml, CriminalController.java y 4 más archivos...
=======
>>>>>>> Joao
    private JTextArea areaResultado;

    public BuscarCriminalVista() {
        // Configuración de la ventana principal
        frame = new JFrame("Buscar Criminal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);

<<<<<<< HEAD
        // Botón para mostrar todos los criminales
        botonMostrarTodos = new JButton("Mostrar Todos");
        botonMostrarTodos.setBounds(120, 10, 150, 25);
        frame.add(botonMostrarTodos);
=======
        // Campo de entrada para la búsqueda
        JLabel etiquetaBusqueda = new JLabel("Buscar por ID o Nombre:");
        etiquetaBusqueda.setBounds(10, 10, 150, 25);
        frame.add(etiquetaBusqueda);

        campoBusqueda = new JTextField();
        campoBusqueda.setBounds(170, 10, 200, 25);
        frame.add(campoBusqueda);

        // Botón para iniciar la búsqueda
        botonBuscar = new JButton("Buscar");
        botonBuscar.setBounds(120, 50, 150, 25);
        frame.add(botonBuscar);
>>>>>>> parent of 5276f93... Actualizar hibernate.cfg.xml, CriminalController.java y 4 más archivos...

        // Área de texto para mostrar los resultados
        areaResultado = new JTextArea();
<<<<<<< HEAD
<<<<<<< HEAD
        areaResultado.setBounds(10, 170, 560, 380);
=======
        areaResultado.setBounds(10, 90, 360, 250);
>>>>>>> parent of 5276f93... Actualizar hibernate.cfg.xml, CriminalController.java y 4 más archivos...
=======
        areaResultado.setBounds(10, 50, 360, 300);
>>>>>>> Joao
        frame.add(areaResultado);

        // Acción del botón de búsqueda
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia de ControladorCriminal
                CriminalController controller = new CriminalController();

<<<<<<< HEAD
                // Obtener todos los criminales
<<<<<<< HEAD
                List<CriminalDAO> criminales = controller.obtenerTodosLosCriminales();

                // Limpiar el área de resultados
                areaResultado.setText("");

                // Mostrar cada criminal en la lista
                for (CriminalDAO criminal : criminales) {
                    String infoCriminal = String.format("Nombre: %s\nSexo: %s\nOcupación: %s\nColor de pelo: %s\nVehículo: %s\nHobbie: %s\nCaracterísticas: %s\n\n",
                            criminal.getNombreCriminal(), criminal.getSexo(), criminal.getOcupacion(), criminal.getColorPelo(),
                            criminal.getVehiculo(), criminal.getHobbie(), criminal.getCaracteristica());
                    areaResultado.append(infoCriminal);
                }
            }
        });


        // Acción del botón de filtrar
        botonFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia de CriminalController
                CriminalController controller = new CriminalController();

                // Obtener los valores de los campos de texto
                String nombre = campoNombre.getText();
                String sexo = campoSexo.getText();
                String hobbie = campoHobbie.getText();
                String colorPelo = campoColorPelo.getText();
                String ocupacion = campoOcupacion.getText();
                String vehiculo = campoVehiculo.getText();
                String caracteristicas = campoCaracteristicas.getText();

                // Filtrar criminales
                List<CriminalDAO> resultado = controller.filtrarCriminales(null, nombre, hobbie, sexo, colorPelo, ocupacion, vehiculo, caracteristicas);
=======
                // Obtener el valor de búsqueda ingresado
                String valorBusqueda = campoBusqueda.getText();

                // Buscar el criminal por ID o Nombre
                String resultado = controller.buscarCriminal(valorBusqueda);
>>>>>>> parent of 5276f93... Actualizar hibernate.cfg.xml, CriminalController.java y 4 más archivos...
=======
                String resultado = controller.obtenerTodosLosCriminales();
>>>>>>> Joao

                // Mostrar el resultado en el área de texto
                areaResultado.setText(resultado);
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
