package com.mycompany.agenciafiscalpresentacion.GUI;

import bo.RegistrarLicenciaBO;
import com.mycompany.agenciafiscalpresentacion.validaciones.Validaciones;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import negocioDTO.EstadoDTO;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteDTO;
import negocioDTO.TramiteLicenciaDTO;

/**
 *
 * @author caarl
 */
public class ModuloLicenciasJpanel extends javax.swing.JPanel {

    private static RegistrarLicenciaBO registrarLicenciaBO;
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
        //Validaciones.limitarCaracteres(txtRfc, 13);
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
                if (doc.getLength() == 13) {
                    
                    // Lógica para validar rfc
                    persona = registrarLicenciaBO.consultarPersonaPorRfc(txtRfc.getText());
                    if(persona == null){ // No se encontró
                        limpiarDatos();
                        mostrarAdvertenciaRfc();
                        limpiarDatos();
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
        txtAdvertencia.setVisible(false);
        txtNombreCompleto.setText(persona.getNombreCompleto());
        txtFechaNacimiento.setText(persona.getFechaNacimiento().getTime().toString());
        txtTelefono.setText(persona.getTelefono());
        if(persona.getDiscapaciad()){
            cbxDiscapacidad.setSelected(true);
            cbxDiscapacidad.setEnabled(false);
            lblPrecioVigencia1.setText("200$");
            lblPrecioVigencia2.setText("500$");
            lblPrecioVigencia3.setText("700$");
        }else{
            cbxDiscapacidad.setEnabled(false);
            lblPrecioVigencia1.setText("600$");
            lblPrecioVigencia2.setText("900$");
            lblPrecioVigencia3.setText("1100$");
        }
    }
    
    public void registrarLicencia() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas registrar la licencia?", "Advertencia", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            // El usuario ha hecho clic en "Sí" o "Continuar"
            // Aquí puedes poner tu lógica para registrar la licencia
            persona.setDiscapaciad(cbxDiscapacidad.isSelected());
            
            TramiteLicenciaDTO licencia =setTramiteLicencia();
            if (licencia != null) {
                if(registrarLicenciaBO.registrarLicencia(licencia))
                    JOptionPane.showMessageDialog(null,
                            "Licencia nueva registrada con éxito."
                            + "\n Licencia: " + licencia
                    );
                else
                    JOptionPane.showMessageDialog(null, "No se ha podido registrar la licencia.");
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una vigencia");
            }
            // Se cambia a la ventana principal
            regresarMenu();
        }
    }
    
    private TramiteLicenciaDTO setTramiteLicencia(){
        Integer vigencia=0;
        Float costo=0.0f;
        JRadioButton[] radioBtns={rbnVigencia1,rbnVigencia2,rbnVigencia3};
        Float[][] costos={
            {600.00f,200.00f},//costos para vigencia de 1 año
            {900.00f,500.00f},//costos para vigencia de 2 años
            {1100.00f,700.00f}//costos para vigencia de 3 años
        };
        for (int i = 0; i < 3; i++) {
            if(radioBtns[i].isSelected()){
                vigencia=i+1;
                if(persona.getDiscapaciad()){
                    costo=costos[i][1];
                }else
                    costo=costos[i][0];
            }
        }
        
        if(costo==0.0f){
            return null;
        }
        TramiteDTO tramite=new TramiteLicenciaDTO(Calendar.getInstance(), costo, EstadoDTO.ACTIVO);
        tramite.setPersona(persona);
        persona.addTramite(tramite);
        ((TramiteLicenciaDTO)tramite).setVigencia(vigencia);
        return (TramiteLicenciaDTO)tramite;
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
        Ventanas.setRegistrarLicenciaBO(registrarLicenciaBO);
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
        btnVerPersonasRegistradas = new javax.swing.JButton();
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
        txtAdvertencia = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rbnVigencia1 = new javax.swing.JRadioButton();
        rbnVigencia2 = new javax.swing.JRadioButton();
        rbnVigencia3 = new javax.swing.JRadioButton();
        lblPrecioVigencia1 = new javax.swing.JLabel();
        lblPrecioVigencia2 = new javax.swing.JLabel();
        lblPrecioVigencia3 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        cbxDiscapacidad = new javax.swing.JCheckBox();

        setMinimumSize(new java.awt.Dimension(640, 360));
        setPreferredSize(new java.awt.Dimension(640, 360));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVerPersonasRegistradas.setText("ver personas registradas");
        btnVerPersonasRegistradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPersonasRegistradasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVerPersonasRegistradas)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVerPersonasRegistradas)
                .addContainerGap(8, Short.MAX_VALUE))
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
        txtRfc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRfcKeyTyped(evt);
            }
        });

        jLabel3.setText("Nombre Completo:");

        txtNombreCompleto.setEditable(false);

        jLabel4.setText("Fecha de nacimiento:");

        txtFechaNacimiento.setEditable(false);

        jLabel5.setText("Telefono:");

        txtTelefono.setEditable(false);

        txtAdvertencia.setForeground(new java.awt.Color(255, 51, 51));
        txtAdvertencia.setText("No coincide con ninguna persona.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(txtRfc, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                        .addComponent(txtNombreCompleto)
                        .addComponent(txtFechaNacimiento)
                        .addComponent(txtTelefono))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtAdvertencia)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAdvertencia))
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

        lblPrecioVigencia1.setText("600$");

        lblPrecioVigencia2.setText("900$");

        lblPrecioVigencia3.setText("1100$");

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
                    .addComponent(lblPrecioVigencia1)
                    .addComponent(lblPrecioVigencia2)
                    .addComponent(lblPrecioVigencia3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbnVigencia1)
                .addGap(2, 2, 2)
                .addComponent(lblPrecioVigencia1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbnVigencia2)
                .addGap(1, 1, 1)
                .addComponent(lblPrecioVigencia2)
                .addGap(1, 1, 1)
                .addComponent(rbnVigencia3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPrecioVigencia3)
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

        cbxDiscapacidad.setText("Discapacidad");
        add(cbxDiscapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void txtRfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRfcActionPerformed
        registrarLicencia();
    }//GEN-LAST:event_txtRfcActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        regresarMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnVerPersonasRegistradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPersonasRegistradasActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnVerPersonasRegistradasActionPerformed

    private void txtRfcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRfcKeyTyped
        // TODO add your handling code here:
        if(txtRfc.getText().length()==13)
            evt.consume();
    }//GEN-LAST:event_txtRfcKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerPersonasRegistradas;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbxDiscapacidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblPrecioVigencia1;
    private javax.swing.JLabel lblPrecioVigencia2;
    private javax.swing.JLabel lblPrecioVigencia3;
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
