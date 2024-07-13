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
    private JButton botonFiltrar;
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

        // Botón para mostrar todos los criminales
        botonMostrarTodos = new JButton("Mostrar Todos");
        botonMostrarTodos.setBounds(10, 10, 150, 25);
        frame.add(botonMostrarTodos);

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
        areaResultado.setBounds(10, 170, 560, 380);
        frame.add(areaResultado);

        // Acción del botón de mostrar todos
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
