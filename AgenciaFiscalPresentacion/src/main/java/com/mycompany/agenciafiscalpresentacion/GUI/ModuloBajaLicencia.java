/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.agenciafiscalpresentacion.GUI;

/**
 *
 * @author caarl
 */

import bo.BajaLicencia;
import entidades.TramiteLicencia;
import excepciones.NegocioException;
import iBo.IBajaLicencia;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import negocioDTO.EstadoDTO;
import negocioDTO.TramiteLicenciaDTO;

public class ModuloBajaLicencia extends javax.swing.JPanel {

    private TramiteLicenciaDTO TramiteLicenciaDTO;
    private static final Logger LOG = Logger.getLogger(ModuloBajaLicencia.class.getName());
    private static IBajaLicencia bajaLicencia;
     
    
    public ModuloBajaLicencia() {
        initComponents();
        this.TramiteLicenciaDTO = null;
        bajaLicencia = new BajaLicencia();
        iniciar();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtLicencia = new javax.swing.JTextField();
        btnBuscarLicencia = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtTitular = new javax.swing.JTextField();
        lblAdvertencia = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnDarDeBaja = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel9.setText("No. de licencia:");

        txtLicencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLicenciaKeyTyped(evt);
            }
        });

        btnBuscarLicencia.setFont(new java.awt.Font("Avenir Next", 1, 13)); // NOI18N
        btnBuscarLicencia.setText("Buscar");
        btnBuscarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLicenciaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel10.setText("Titular de licencia:");

        txtTitular.setToolTipText("");

        lblAdvertencia.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        lblAdvertencia.setForeground(new java.awt.Color(255, 51, 51));
        lblAdvertencia.setText("No se encontró la licencia");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                            .addComponent(btnBuscarLicencia))
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtLicencia)
                        .addComponent(txtTitular))
                    .addComponent(lblAdvertencia))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscarLicencia)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAdvertencia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 250, 190));

        jLabel3.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        jLabel3.setText("Ingrese su licencia vigente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        jPanel6.setBackground(new java.awt.Color(35, 26, 26));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        jPanel7.setBackground(new java.awt.Color(98, 76, 76));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 60));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel11.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Módulo de Baja");
        jPanel7.add(jLabel11, new java.awt.GridBagConstraints());

        jLabel12.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("para Licencias");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel7.add(jLabel12, gridBagConstraints);

        jPanel6.add(jPanel7);

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 220, 80));

        jPanel9.setBackground(new java.awt.Color(138, 47, 47));

        btnRegresar.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addContainerGap(540, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        jPanel2.setBackground(new java.awt.Color(138, 47, 47));

        btnDarDeBaja.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        btnDarDeBaja.setText("Dar baja");
        btnDarDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarDeBajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(272, Short.MAX_VALUE)
                .addComponent(btnDarDeBaja)
                .addGap(281, 281, 281))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDarDeBaja)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 640, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

     private void buscarLicencia() {
        TramiteLicenciaDTO licenciaDTO = new TramiteLicenciaDTO();
        licenciaDTO.setNumLicencia(txtLicencia.getText());

        try {
            licenciaDTO = bajaLicencia.obtenerLicencia(licenciaDTO);
            txtTitular.setText(licenciaDTO.getPersona().getNombreCompleto());
            if (licenciaDTO.getEstado() == EstadoDTO.CADUCO) {
                btnDarDeBaja.setEnabled(false);
                lblAdvertencia.setText("La licencia ya está caducada.");
                lblAdvertencia.setVisible(true);
            } else {
                btnDarDeBaja.setEnabled(true);
                lblAdvertencia.setVisible(false);
            }
            this.TramiteLicenciaDTO = licenciaDTO;
        } catch (NegocioException ne) {
            LOG.log(Level.WARNING, ne.getMessage());
            txtTitular.setText("");
            lblAdvertencia.setText("Licencia no encontrada.");
            lblAdvertencia.setVisible(true);
            this.TramiteLicenciaDTO = null;
        }
    }

    private void darDeBajaLicencia() {
        if (this.TramiteLicenciaDTO != null) {
            try {
                System.out.println(TramiteLicenciaDTO.getId());
                if (bajaLicencia.darDeBajaLicencia(this.TramiteLicenciaDTO)) {
                    JOptionPane.showMessageDialog(this, "La licencia se dio de baja exitosamente.");
                    reiniciarPanel();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo dar de baja.");
                }
            } catch (NegocioException ne) {
                LOG.log(Level.WARNING, ne.getMessage());
                JOptionPane.showMessageDialog(this, "Error al dar de baja la licencia.");
            }
        }
    }

    private void reiniciarPanel() {
        txtLicencia.setText("");
        txtTitular.setText("");
        btnDarDeBaja.setEnabled(false);
        lblAdvertencia.setVisible(false);
    }

    private void regresarMenu() {
        reiniciarPanel();
        ((Ventanas) SwingUtilities.getWindowAncestor(ModuloBajaLicencia.this)).mostrarVentana("MenuJpanel");
    }

    private void iniciar() {
        lblAdvertencia.setVisible(false);
    }
    
    
    private void btnDarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarDeBajaActionPerformed
        // TODO add your handling code here:
       darDeBajaLicencia();
    }//GEN-LAST:event_btnDarDeBajaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        regresarMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLicenciaActionPerformed
        // TODO add your handling code here:
        buscarLicencia();
    }//GEN-LAST:event_btnBuscarLicenciaActionPerformed

    private void txtLicenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLicenciaKeyTyped
       if (txtLicencia.getText().length() == 10) {
        evt.consume();
    }
    }//GEN-LAST:event_txtLicenciaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarLicencia;
    private javax.swing.JButton btnDarDeBaja;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblAdvertencia;
    private javax.swing.JTextField txtLicencia;
    private javax.swing.JTextField txtTitular;
    // End of variables declaration//GEN-END:variables
}
