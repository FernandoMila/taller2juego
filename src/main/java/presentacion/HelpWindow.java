package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpWindow extends JFrame {
    private JLabel imageLabel;
    private int imageIndex = 0;
    private final String[] helpImages = {
        "imagenes/help1.png",
        "imagenes/help2.png",
        "imagenes/help3.png"
    };

    public HelpWindow() {
        // Configurar la ventana
        setTitle("Ayuda");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el JLabel para la imagen
        imageLabel = new JLabel();
        updateImage();

        // Crear botones
        JButton previousButton = new JButton("Anterior");
        JButton nextButton = new JButton("Siguiente");
        JButton closeButton = new JButton("Cerrar");

        // Añadir listeners a los botones
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imageIndex > 0) {
                    imageIndex--;
                    updateImage();
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imageIndex < helpImages.length - 1) {
                    imageIndex++;
                    updateImage();
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Crear un panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(closeButton);

        // Añadir los componentes a la ventana
        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void updateImage() {
        ImageIcon icon = new ImageIcon(helpImages[imageIndex]);
        imageLabel.setIcon(icon);
    }
}

