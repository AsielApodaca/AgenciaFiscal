package com.mycompany.agenciafiscalpresentacion.GUI;

import iBo.iRegistrarLicenciaBO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import negocioDTO.PersonaDTO;

/**
 *
 * @author caarl
 */
public class MenuJpanel extends javax.swing.JPanel {

    protected static List<PersonaDTO> personasRegistradas;
    /**
     * Creates new form PrincipalJpanel
     */
    public MenuJpanel() {
        initComponents();
        personasRegistradas=new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnModuloLicencias = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnInsertarUsuarios = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Gobierno del estado de sonora");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, 20));

        jLabel3.setText("Control de placas y licencias automovílisticas");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        jLabel1.setText("Modulos de Informacion");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 143, -1));

        btnModuloLicencias.setText("Licencias");
        btnModuloLicencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModuloLicenciasActionPerformed(evt);
            }
        });
        add(btnModuloLicencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 200, -1));

        jButton2.setText("Placas para automovil");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 200, -1));

        jButton3.setText("Consultas");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 200, -1));

        jButton4.setText("Reportes");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 200, -1));

        btnInsertarUsuarios.setText("Insertar registros usuarios");
        btnInsertarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarUsuariosActionPerformed(evt);
            }
        });
        add(btnInsertarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 230, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnModuloLicenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuloLicenciasActionPerformed
        ((Ventanas) SwingUtilities.getWindowAncestor(MenuJpanel.this)).mostrarVentana("ModuloLicenciasJpanel");
    }//GEN-LAST:event_btnModuloLicenciasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnInsertarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarUsuariosActionPerformed
        // TODO add your handling code here:
        obtenerPersonasAgregadas();
    }//GEN-LAST:event_btnInsertarUsuariosActionPerformed

    private void obtenerPersonasAgregadas(){
        personasRegistradas=Ventanas.registrar.obtenerPersonasRegistradas();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertarUsuarios;
    private javax.swing.JButton btnModuloLicencias;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
