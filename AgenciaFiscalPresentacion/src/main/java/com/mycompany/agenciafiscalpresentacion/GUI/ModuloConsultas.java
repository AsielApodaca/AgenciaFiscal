/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.agenciafiscalpresentacion.GUI;

import javax.swing.SwingUtilities;

/**
 *
 * @author luiis
 */
public class ModuloConsultas extends javax.swing.JPanel {

    /**
     * Creates new form ModuloConsultas
     */
    public ModuloConsultas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        CampoDeInformacion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jrbCurp = new javax.swing.JRadioButton();
        jrbNacimiento = new javax.swing.JRadioButton();
        jrbNombre = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        txtDato = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        ContenedorDeTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(138, 47, 47));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 640, 40));

        jPanel4.setBackground(new java.awt.Color(35, 26, 26));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        jPanel5.setBackground(new java.awt.Color(98, 76, 76));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 60));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Módulo de consultas");
        jPanel5.add(jLabel6, new java.awt.GridBagConstraints());

        jPanel4.add(jPanel5);

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 220, 80));

        jPanel3.setBackground(new java.awt.Color(138, 47, 47));

        btnRegresar.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addContainerGap(543, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        CampoDeInformacion.setBackground(new java.awt.Color(255, 255, 255));
        CampoDeInformacion.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingrese informacion solicitada");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 24;
        CampoDeInformacion.add(jLabel1, gridBagConstraints);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(jrbCurp);
        jrbCurp.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        jrbCurp.setForeground(new java.awt.Color(0, 0, 0));
        jrbCurp.setText("CURP");
        jrbCurp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jrbCurp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jrbCurp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCurpActionPerformed(evt);
            }
        });
        jPanel7.add(jrbCurp);

        buttonGroup1.add(jrbNacimiento);
        jrbNacimiento.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        jrbNacimiento.setForeground(new java.awt.Color(0, 0, 0));
        jrbNacimiento.setText("Año de nacimiento");
        jrbNacimiento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jrbNacimiento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jrbNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbNacimientoActionPerformed(evt);
            }
        });
        jPanel7.add(jrbNacimiento);

        buttonGroup1.add(jrbNombre);
        jrbNombre.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        jrbNombre.setForeground(new java.awt.Color(0, 0, 0));
        jrbNombre.setText("Nombre de persona");
        jrbNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jrbNombre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel7.add(jrbNombre);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        CampoDeInformacion.add(jPanel7, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        txtDato.setText(" ");

        btnBuscar.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscar)
                    .addComponent(txtDato, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(txtDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        CampoDeInformacion.add(jPanel1, gridBagConstraints);

        jPanel8.add(CampoDeInformacion);

        ContenedorDeTabla.setBackground(new java.awt.Color(255, 255, 255));
        ContenedorDeTabla.setPreferredSize(new java.awt.Dimension(330, 0));
        ContenedorDeTabla.setLayout(new java.awt.BorderLayout());

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Trámite", "Costo (mxn)", "Estado", "Fecha emisión"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPersonas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tblPersonas);

        ContenedorDeTabla.add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        jPanel8.add(ContenedorDeTabla);

        add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 640, 220));
    }// </editor-fold>//GEN-END:initComponents

    private void jrbCurpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCurpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbCurpActionPerformed

    private void jrbNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbNacimientoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        regresarMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed
    
    private void regresarMenu() {
        reiniciarPanel();
        ((Ventanas) SwingUtilities.getWindowAncestor(this)).mostrarVentana("MenuJpanel");
    }

    public void reiniciarPanel() {
        limpiarDatos();
        
    }
    
    public void limpiarDatos() {
        buttonGroup1.clearSelection();
        txtDato.setText("");
        tblPersonas.removeAll();
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CampoDeInformacion;
    private javax.swing.JPanel ContenedorDeTabla;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbCurp;
    private javax.swing.JRadioButton jrbNacimiento;
    private javax.swing.JRadioButton jrbNombre;
    private javax.swing.JTable tblPersonas;
    private javax.swing.JTextField txtDato;
    // End of variables declaration//GEN-END:variables
}
