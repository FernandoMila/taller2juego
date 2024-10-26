package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Controllers.CriminalController;
import DAO.CriminalDAO;

public class BuscarCriminalVista extends JFrame {
    private JPanel contentPane;
    private JTable table;

    public BuscarCriminalVista() {
        setTitle("Buscar Criminal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);  // Ajuste el tamaño de la ventana según sea necesario
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<CriminalDAO> criminales = new CriminalController().obtenerTodosLosCriminales();
                String[] columnNames = {"ID", "Nombre", "Características", "Color de Pelo", "Hobbie", "Ocupación", "Sexo", "Vehículo"};
                Object[][] data = new Object[criminales.size()][8];
                for (int i = 0; i < criminales.size(); i++) {
                    CriminalDAO c = criminales.get(i);
                    data[i][0] = c.getIdCriminal();
                    data[i][1] = c.getNombreCriminal();
                    data[i][2] = c.getCaracteristica();
                    data[i][3] = c.getColorPelo();
                    data[i][4] = c.getHobbie();
                    data[i][5] = c.getOcupacion();
                    data[i][6] = c.getSexo();
                    data[i][7] = c.getVehiculo();
                }

                table = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(table);
                contentPane.add(scrollPane, BorderLayout.CENTER);
                contentPane.revalidate();
            }
        });

        contentPane.add(btnBuscar, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BuscarCriminalVista frame = new BuscarCriminalVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
