package com.mycompany.agenciafiscalpresentacion.GUI;

import javax.swing.*;
import java.awt.*;

public class Ventanas extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public Ventanas() {
        setTitle("Agencia fiscal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640 + getInsets().top, 360);
        setLocationRelativeTo(null);
        setResizable(false);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Crear los paneles (ventanas)
        MenuJpanel panelMenu = new MenuJpanel();
        ModuloLicenciasJpanel panelModuloLicencias = new ModuloLicenciasJpanel();

        // Añadir los paneles al panel con CardLayout
        cardPanel.add(panelMenu, "MenuJpanel");
        cardPanel.add(panelModuloLicencias, "ModuloLicenciasJpanel");
        
        // Añadir el panel con CardLayout
        getContentPane().add(cardPanel, BorderLayout.CENTER);
    }
    
    public void mostrarVentana(String nombrePanel) {
        cardLayout.show(cardPanel, nombrePanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventanas ventana = new Ventanas();
                ventana.setVisible(true);
            }
        });
    }
}
