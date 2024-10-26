package presentacion;

import Controllers.CriminalController;
import java.awt.GridLayout;

import javax.swing.*;

// Modificar VistaCriminal para que permita la búsqueda de criminales
public class VistaCriminal extends JFrame {
    private JTextField txtHobby;
    private JTextField txtSexo;
    private JTextField txtColorPelo;
    private JTextField txtOcupacion;
    private JTextField txtVehiculo;
    private JTextField txtCaracteristica;
    private JButton btnBuscar;
    private JLabel lblResultado;

    public VistaCriminal() {
        setTitle("Buscar Criminal");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        // Añadir componentes para los datos
        add(new JLabel("Hobby:"));
        txtHobby = new JTextField();
        add(txtHobby);

        add(new JLabel("Sexo:"));
        txtSexo = new JTextField();
        add(txtSexo);

        add(new JLabel("Color de Pelo:"));
        txtColorPelo = new JTextField();
        add(txtColorPelo);

        add(new JLabel("Ocupación:"));
        txtOcupacion = new JTextField();
        add(txtOcupacion);

        add(new JLabel("Vehículo:"));
        txtVehiculo = new JTextField();
        add(txtVehiculo);

        add(new JLabel("Características:"));
        txtCaracteristica = new JTextField();
        add(txtCaracteristica);

        // Botón para buscar
        btnBuscar = new JButton("Buscar Criminal");
        add(btnBuscar);

        // Etiqueta para mostrar el resultado
        lblResultado = new JLabel("Resultado:");
        add(lblResultado);

        // Acción del botón buscar
        btnBuscar.addActionListener(e -> buscarCriminal());
    }

    // Método para buscar criminal
    private void buscarCriminal() {
        String hobby = txtHobby.getText();
        String sexo = txtSexo.getText();
        String colorPelo = txtColorPelo.getText();
        String ocupacion = txtOcupacion.getText();
        String vehiculo = txtVehiculo.getText();
        String caracteristica = txtCaracteristica.getText();

        // Aquí debes integrar la lógica de CriminalController para buscar al criminal
        CriminalController controller = new CriminalController();
        String nombreCriminal = controller.buscarCriminal(hobby, sexo, colorPelo, ocupacion, vehiculo, caracteristica);

        if (nombreCriminal != null) {
            lblResultado.setText("Criminal encontrado: " + nombreCriminal);
        } else {
            lblResultado.setText("No se encontró ningún criminal con esos datos.");
        }
    }
    
    public void mostrarVentana() {
        setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación
        SwingUtilities.invokeLater(() -> {
        VistaCriminal vista = new VistaCriminal();
        vista.mostrarVentana(); 
        });
    }
}
