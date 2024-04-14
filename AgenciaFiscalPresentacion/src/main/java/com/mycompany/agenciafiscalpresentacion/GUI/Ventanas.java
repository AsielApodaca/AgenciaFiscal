package com.mycompany.agenciafiscalpresentacion.GUI;

import bo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import iBo.*;

/**
 * Clase Ventanas: Representa la ventana principal de la aplicación de la Agencia Fiscal.
 * Extiende JFrame para crear la interfaz gráfica de usuario.
 */
public class Ventanas extends JFrame {

    private final CardLayout cardLayout;
    private final JPanel cardPanel;
    protected static iRegistrarLicenciaBO registrarLicencia;
    protected static IRegistrarPlacasBO registrarPlacas;
    protected static IConsultasBO consultas;
    protected static IBajaPlacasBO bajaPlacas;
    protected static IGenerarReporteBO generarReporte;
    protected static IMenuBO menu;
    private IServicioConexion servicio;

    /**
     * Constructor de la clase Ventanas.
     * Configura la ventana principal y agrega los paneles con CardLayout.
     */
    public Ventanas() {
        setTitle("Agencia fiscal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        servicio=new ServicioConexion();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Esto es para cerrar las conexiones con la base de datos cuando se cierra el programa
                servicio.cerrarConexion();
            }
        });

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Se crean los paneles (ventanas) y se añaden los paneles al panel con CardLayout
        cardPanel.add(new MenuJpanel(), "MenuJpanel");
        cardPanel.add(new ModuloLicenciasJpanel(), "ModuloLicenciasJpanel");
        cardPanel.add(new ModuloPlacasAutoNuevo(), "ModuloPlacasAutoNuevo");
        cardPanel.add(new ModuloPlacasAutoUsado(), "ModuloPlacasAutoUsado");
        cardPanel.add(new ModuloConsultas(), "ModuloConsultas");
        cardPanel.add(new ModuloReportes(), "ModuloReportes");
        cardPanel.add(new ModuloBajaPlacas(), "ModuloBajaPlacas");
        cardPanel.add(new ModuloBajaLicencia(), "ModuloBajaLicencia");

        // Añadir el panel con CardLayout
        getContentPane().add(cardPanel, BorderLayout.CENTER);
    }

    /**
     * Método para mostrar un panel específico.
     * @param nombrePanel El nombre del panel que se mostrará.
     */
    public void mostrarVentana(String nombrePanel) {
        cardLayout.show(cardPanel, nombrePanel);
    }

    /**
     * Método principal. Inicia la aplicación creando una instancia de Ventanas y haciéndola visible.
     */
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
