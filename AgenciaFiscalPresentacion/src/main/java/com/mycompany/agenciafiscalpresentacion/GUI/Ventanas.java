package com.mycompany.agenciafiscalpresentacion.GUI;

import bo.RegistrarLicenciaBO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import iBo.iRegistrarLicenciaBO;

public class Ventanas extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    protected static iRegistrarLicenciaBO registrar;
    
    public Ventanas() {
        setTitle("Agencia fiscal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 360);
        setLocationRelativeTo(null);
        setResizable(false);
        
        registrar=new RegistrarLicenciaBO();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // esto es para cerrar las conexiones con la bd cuando se cierre el programa
                if(registrar!=null)
                    registrar.cerrarConexiones();
            }
        });
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Se crean los paneles (ventanas) y se añaden los paneles al panel con CardLayout
        cardPanel.add(new MenuJpanel(), "MenuJpanel");
        cardPanel.add(new ModuloLicenciasJpanel(), "ModuloLicenciasJpanel");
        
        // Añadir el panel con CardLayout
        getContentPane().add(cardPanel, BorderLayout.CENTER);
    }
    
    public void mostrarVentana(String nombrePanel) {
        cardLayout.show(cardPanel, nombrePanel);
    }

    public RegistrarLicenciaBO getBO(){
        return (RegistrarLicenciaBO)registrar;
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
