package presentacion;

import Controllers.CriminalController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaCriminal {
    private JFrame frame;
    private JTextField campoId;
    private JTextField campoNombre;
    private JTextField campoHobbie;
    private JTextField campoSexo;
    private JTextField campoColorPelo;
    private JTextField campoOcupacion;
    private JTextField campoVehiculo;
    private JTextField campoCaracteristicas;
    private JButton botonEnviar;

    public VistaCriminal() {
        // Configuración de la ventana principal
        frame = new JFrame("Ingreso de Criminal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);

        // Campos de entrada de datos
        JLabel etiquetaId = new JLabel("ID Criminal:");
        etiquetaId.setBounds(10, 10, 100, 25);
        frame.add(etiquetaId);

        campoId = new JTextField();
        campoId.setBounds(120, 10, 200, 25);
        frame.add(campoId);

        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setBounds(10, 40, 100, 25);
        frame.add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(120, 40, 200, 25);
        frame.add(campoNombre);

        JLabel etiquetaHobbie = new JLabel("Hobbie:");
        etiquetaHobbie.setBounds(10, 70, 100, 25);
        frame.add(etiquetaHobbie);

        campoHobbie = new JTextField();
        campoHobbie.setBounds(120, 70, 200, 25);
        frame.add(campoHobbie);

        JLabel etiquetaSexo = new JLabel("Sexo:");
        etiquetaSexo.setBounds(10, 100, 100, 25);
        frame.add(etiquetaSexo);

        campoSexo = new JTextField();
        campoSexo.setBounds(120, 100, 200, 25);
        frame.add(campoSexo);

        JLabel etiquetaColorPelo = new JLabel("Color de Pelo:");
        etiquetaColorPelo.setBounds(10, 130, 100, 25);
        frame.add(etiquetaColorPelo);

        campoColorPelo = new JTextField();
        campoColorPelo.setBounds(120, 130, 200, 25);
        frame.add(campoColorPelo);

        JLabel etiquetaOcupacion = new JLabel("Ocupación:");
        etiquetaOcupacion.setBounds(10, 160, 100, 25);
        frame.add(etiquetaOcupacion);

        campoOcupacion = new JTextField();
        campoOcupacion.setBounds(120, 160, 200, 25);
        frame.add(campoOcupacion);

        JLabel etiquetaVehiculo = new JLabel("Vehículo:");
        etiquetaVehiculo.setBounds(10, 190, 100, 25);
        frame.add(etiquetaVehiculo);

        campoVehiculo = new JTextField();
        campoVehiculo.setBounds(120, 190, 200, 25);
        frame.add(campoVehiculo);

        JLabel etiquetaCaracteristicas = new JLabel("Características:");
        etiquetaCaracteristicas.setBounds(10, 220, 100, 25);
        frame.add(etiquetaCaracteristicas);

        campoCaracteristicas = new JTextField();
        campoCaracteristicas.setBounds(120, 220, 200, 25);
        frame.add(campoCaracteristicas);

        // Botón para enviar los datos
        botonEnviar = new JButton("Crear Criminal");
        botonEnviar.setBounds(120, 260, 150, 25);
        frame.add(botonEnviar);

        // Acción del botón
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia de CriminalController
                CriminalController controller = new CriminalController();

                // Obtener los datos ingresados
                int id = Integer.parseInt(campoId.getText());
                String nombre = campoNombre.getText();
                String hobbie = campoHobbie.getText();
                String sexo = campoSexo.getText();
                String colorPelo = campoColorPelo.getText();
                String ocupacion = campoOcupacion.getText();
                String vehiculo = campoVehiculo.getText();
                String caracteristicas = campoCaracteristicas.getText();

                // Llamar al método para crear un criminal
                String resultado = controller.crearCriminal(id, nombre, hobbie, sexo, colorPelo, ocupacion, vehiculo, caracteristicas);

                // Mostrar el resultado
                JOptionPane.showMessageDialog(frame, resultado);
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
                new VistaCriminal();
            }
        });
    }
}
