package com.mycompany.agenciafiscalpresentacion.GUI;

import bo.RegistrarLicenciaBO;
import com.mycompany.agenciafiscalpresentacion.validaciones.Validaciones;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import negocioDTO.PersonaDTO;

/**
 *
 * @author caarl
 */
public class ModuloLicenciasJpanel extends javax.swing.JPanel {

    private RegistrarLicenciaBO registrarLicenciaBO;
    private PersonaDTO persona;
    
    /**
     * Creates new form ModuloLicenciasJpanel
     */
    public ModuloLicenciasJpanel() {
        initComponents();
        
        registrarLicenciaBO = new RegistrarLicenciaBO();
        persona = null;
        
        iniciar();
    }
    
    public void iniciar(){
        Validaciones.limitarCaracteres(txtRfc, 13);
        validarRfc();
        btnPagar.setEnabled(false);
        txtAdvertencia.setVisible(false);
        
        rbnVigencia1.addActionListener(e -> actualizarEstadoBtnPagar());
        rbnVigencia2.addActionListener(e -> actualizarEstadoBtnPagar());
        rbnVigencia3.addActionListener(e -> actualizarEstadoBtnPagar());
    }
    
    public void actualizarEstadoBtnPagar() {
        if (rbnVigencia1.isSelected() || rbnVigencia2.isSelected() || rbnVigencia3.isSelected()) {
            if(persona != null)btnPagar.setEnabled(true);
        } else {
            btnPagar.setEnabled(false);
        }
    }
    
    public void validarRfc() {
        Document doc = txtRfc.getDocument();
        doc.addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                validar(e);
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                validar(e);
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                validar(e);
            }

            private void validar(javax.swing.event.DocumentEvent e) {
                Document doc = e.getDocument();
                if (doc.getLength() >= 12) {
                    
                    // Lógica para validar rfc
                    persona = registrarLicenciaBO.consultarPersonaPorRfc(txtRfc.getText());
                    if(persona == null){ // No se encontró
                        mostrarAdvertenciaRfc();
                    } else { // Se encontró
                        btnPagar.setEnabled(true);
                        mostrarDatos();
                    }
                    
                } else {
                    limpiarDatos();
                }
            }
        });
    }
    
    public void limpiarDatos() {
        txtNombreCompleto.setText("");
        txtFechaNacimiento.setText((""));
        txtTelefono.setText("");
        txtAdvertencia.setVisible(false);
        persona = null;
        btnPagar.setEnabled(false);
        cbxDiscapacidad.setSelected(false);
        cbxDiscapacidad.setEnabled(false);
    }
    
    public void mostrarAdvertenciaRfc(){
        txtAdvertencia.setVisible(true);
        btnPagar.setEnabled(false);
    }
    
    public void mostrarDatos(){
        txtNombreCompleto.setText(persona.getNombreCompleto());
        txtFechaNacimiento.setText(persona.getFechaNacimiento().getTime().toString());
        txtTelefono.setText(persona.getTelefono());
        if(persona.getDiscapaciad()){
            cbxDiscapacidad.setSelected(true);
            cbxDiscapacidad.setEnabled(false);
        }else{
            cbxDiscapacidad.setEnabled(false);
        }
    }
    
    public void registrarLicencia() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas registrar la licencia?", "Advertencia", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            // El usuario ha hecho clic en "Sí" o "Continuar"
            // Aquí puedes poner tu lógica para registrar la licencia
            persona.setDiscapaciad(cbxDiscapacidad.isSelected());
            String licencia = registrarLicenciaBO.registrarLicencia();
            if (licencia == null) {
                JOptionPane.showMessageDialog(null,
                        "Licencia nueva registrada con éxito."
                        + "\n Licencia: " + licencia
                );
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido registrar la licencia.");
            }
            // Se cambia a la ventana principal
            regresarMenu();
        }
    }
    
    public void reiniciarPanel(){
        txtRfc.setText("");
        buttonGroup1.clearSelection();
        cbxDiscapacidad.setSelected(false);
        limpiarDatos();
        System.out.println("hola");
        
    }

    private void regresarMenu(){
        reiniciarPanel();
        ((Ventanas) SwingUtilities.getWindowAncestor(ModuloLicenciasJpanel.this)).mostrarVentana("MenuJpanel");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtRfc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombreCompleto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        rbnVigencia1 = new javax.swing.JRadioButton();
        rbnVigencia2 = new javax.swing.JRadioButton();
        rbnVigencia3 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        txtAdvertencia = new javax.swing.JLabel();
        cbxDiscapacidad = new javax.swing.JCheckBox();

        setMinimumSize(new java.awt.Dimension(640, 360));
        setPreferredSize(new java.awt.Dimension(640, 360));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 6, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(136, 62, 69));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel1.setText("Modulo de licencias");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 6, -1, 90));

        jLabel2.setText("RFC:");

        txtRfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRfcActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre Completo:");

        txtNombreCompleto.setEditable(false);

        jLabel4.setText("Fecha de nacimiento:");

        txtFechaNacimiento.setEditable(false);

        jLabel5.setText("Telefono:");

        txtTelefono.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtRfc, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txtNombreCompleto)
                    .addComponent(txtFechaNacimiento)
                    .addComponent(txtTelefono))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        buttonGroup1.add(rbnVigencia1);
        rbnVigencia1.setText("Vigencia de 1 año");

        buttonGroup1.add(rbnVigencia2);
        rbnVigencia2.setText("Vigencia de 2 años");

        buttonGroup1.add(rbnVigencia3);
        rbnVigencia3.setText("Vigencia de 3 años");

        jLabel6.setText("600$");

        jLabel7.setText("900$");

        jLabel8.setText("1100$");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbnVigencia1)
                    .addComponent(rbnVigencia2)
                    .addComponent(rbnVigencia3))
                .addGap(0, 28, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbnVigencia1)
                .addGap(2, 2, 2)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbnVigencia2)
                .addGap(1, 1, 1)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(rbnVigencia3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 147, -1, -1));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        btnPagar.setText("Pagar");
        add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, -1, -1));

        txtAdvertencia.setForeground(new java.awt.Color(255, 51, 51));
        txtAdvertencia.setText("No coincide con ninguna persona.");
        add(txtAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, -1));

        cbxDiscapacidad.setText("Discapacidad");
        add(cbxDiscapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void txtRfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRfcActionPerformed
        registrarLicencia();
    }//GEN-LAST:event_txtRfcActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        regresarMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbxDiscapacidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton rbnVigencia1;
    private javax.swing.JRadioButton rbnVigencia2;
    private javax.swing.JRadioButton rbnVigencia3;
    private javax.swing.JLabel txtAdvertencia;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombreCompleto;
    private javax.swing.JTextField txtRfc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
