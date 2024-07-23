package presentacion;

import Controllers.CriminalController;
import DAO.CriminalDAO;
<<<<<<< HEAD
=======
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
>>>>>>> parent of 5276f93... Actualizar hibernate.cfg.xml, CriminalController.java y 4 más archivos...

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BuscarCriminalVista {
    private JFrame frame;
<<<<<<< HEAD
    private JButton botonMostrarTodos;
    private JButton botonFiltrar;
=======
    private JTextField campoBusqueda;
    private JButton botonBuscar;
>>>>>>> parent of 5276f93... Actualizar hibernate.cfg.xml, CriminalController.java y 4 más archivos...
    private JTextArea areaResultado;
    private JTextField campoNombre;
    private JTextField campoSexo;
    private JTextField campoHobbie;
    private JTextField campoColorPelo;
    private JTextField campoOcupacion;
    private JTextField campoVehiculo;
    private JTextField campoCaracteristicas;

    public BuscarCriminalVista() {
        // Configuración de la ventana principal
        frame = new JFrame("Buscar Criminal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);

<<<<<<< HEAD
        // Botón para mostrar todos los criminales
        botonMostrarTodos = new JButton("Mostrar Todos");
        botonMostrarTodos.setBounds(10, 10, 150, 25);
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

        // Botón para filtrar criminales
        botonFiltrar = new JButton("Filtrar");
        botonFiltrar.setBounds(180, 10, 150, 25);
        frame.add(botonFiltrar);

        // Campos de texto para los filtros
        campoNombre = new JTextField();
        campoNombre.setBounds(10, 50, 150, 25);
        campoNombre.setBorder(BorderFactory.createTitledBorder("Nombre"));
        frame.add(campoNombre);

        campoSexo = new JTextField();
        campoSexo.setBounds(180, 50, 150, 25);
        campoSexo.setBorder(BorderFactory.createTitledBorder("Sexo"));
        frame.add(campoSexo);

        campoHobbie = new JTextField();
        campoHobbie.setBounds(350, 50, 150, 25);
        campoHobbie.setBorder(BorderFactory.createTitledBorder("Hobbie"));
        frame.add(campoHobbie);

        campoColorPelo = new JTextField();
        campoColorPelo.setBounds(10, 90, 150, 25);
        campoColorPelo.setBorder(BorderFactory.createTitledBorder("Color de Pelo"));
        frame.add(campoColorPelo);

        campoOcupacion = new JTextField();
        campoOcupacion.setBounds(180, 90, 150, 25);
        campoOcupacion.setBorder(BorderFactory.createTitledBorder("Ocupación"));
        frame.add(campoOcupacion);

        campoVehiculo = new JTextField();
        campoVehiculo.setBounds(350, 90, 150, 25);
        campoVehiculo.setBorder(BorderFactory.createTitledBorder("Vehículo"));
        frame.add(campoVehiculo);

        campoCaracteristicas = new JTextField();
        campoCaracteristicas.setBounds(10, 130, 490, 25);
        campoCaracteristicas.setBorder(BorderFactory.createTitledBorder("Características"));
        frame.add(campoCaracteristicas);

        // Área de texto para mostrar los resultados
        areaResultado = new JTextArea();
<<<<<<< HEAD
        areaResultado.setBounds(10, 170, 560, 380);
=======
        areaResultado.setBounds(10, 90, 360, 250);
>>>>>>> parent of 5276f93... Actualizar hibernate.cfg.xml, CriminalController.java y 4 más archivos...
        frame.add(areaResultado);

        // Acción del botón de búsqueda
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia de ControladorCriminal
                CriminalController controller = new CriminalController();

<<<<<<< HEAD
                // Obtener todos los criminales
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

                // Mostrar el resultado en el área de texto
                areaResultado.setText(convertirListaAString(resultado));
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    // Método para convertir una lista de CriminalDAO a un String
    private String convertirListaAString(List<CriminalDAO> lista) {
        StringBuilder resultado = new StringBuilder();
        for (CriminalDAO criminal : lista) {
            resultado.append(criminal.toString()).append("\n");
        }
        return resultado.toString();
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
