package com.mycompany.agenciafiscalpresentacion.GUI;

import bo.RegistrarPlacasBO;
import excepciones.NegocioException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import negocioDTO.EstadoDTO;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteLicenciaDTO;
import negocioDTO.TramitePlacasDTO;

/**
 *
 * @author luiis
 */
public class ModuloPlacasAutoUsado extends javax.swing.JPanel {
    
    private PersonaDTO persona;
    private TramitePlacasDTO tramitePlacasAnteriores;
    private final Float precioTramite;
    /**
     * Creates new form ModuloPlacasAutoUsado
     */
    public ModuloPlacasAutoUsado() {
        initComponents();
        persona=null;
        this.precioTramite = 1000.0F;
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

        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtPlacas = new javax.swing.JTextField();
        btnBuscarPlacas = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtSerieVehiculo = new javax.swing.JTextField();
        lblAdvertenciaPlacas = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtLicencia = new javax.swing.JTextField();
        btnBuscarLicencia = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtTitularLicencia = new javax.swing.JTextField();
        lblAdvertenciaLicencia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(640, 360));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Matricula de placas:");

        txtPlacas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlacasKeyTyped(evt);
            }
        });

        btnBuscarPlacas.setFont(new java.awt.Font("Avenir Next", 1, 13)); // NOI18N
        btnBuscarPlacas.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarPlacas.setText("Buscar");
        btnBuscarPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPlacasActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Serie del vehiculo:");

        txtSerieVehiculo.setToolTipText("");

        lblAdvertenciaPlacas.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        lblAdvertenciaPlacas.setForeground(new java.awt.Color(255, 51, 51));
        lblAdvertenciaPlacas.setText("No se encontró el registro de las placas ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                            .addComponent(btnBuscarPlacas))
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPlacas)
                        .addComponent(txtSerieVehiculo))
                    .addComponent(lblAdvertenciaPlacas))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscarPlacas)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSerieVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAdvertenciaPlacas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 250, 180));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("No. de licencia:");

        txtLicencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLicenciaKeyTyped(evt);
            }
        });

        btnBuscarLicencia.setFont(new java.awt.Font("Avenir Next", 1, 13)); // NOI18N
        btnBuscarLicencia.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarLicencia.setText("Buscar");
        btnBuscarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLicenciaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Titular de licencia:");

        txtTitularLicencia.setToolTipText("");

        lblAdvertenciaLicencia.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        lblAdvertenciaLicencia.setForeground(new java.awt.Color(255, 51, 51));
        lblAdvertenciaLicencia.setText("No se encontró la licencia");

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
                        .addComponent(txtTitularLicencia))
                    .addComponent(lblAdvertenciaLicencia))
                .addContainerGap(10, Short.MAX_VALUE))
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
                .addComponent(txtTitularLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAdvertenciaLicencia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 250, 180));

        jLabel2.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ingrese las placas anteriores");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Ingrese su licencia vigente");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        jPanel6.setBackground(new java.awt.Color(35, 26, 26));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        jPanel7.setBackground(new java.awt.Color(98, 76, 76));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 60));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel11.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Módulo de Placas");
        jPanel7.add(jLabel11, new java.awt.GridBagConstraints());

        jLabel12.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("para automóvil");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel7.add(jLabel12, gridBagConstraints);

        jPanel6.add(jPanel7);

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 220, 80));

        jPanel9.setBackground(new java.awt.Color(138, 47, 47));

        btnRegresar.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
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
                .addContainerGap(543, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        jPanel2.setBackground(new java.awt.Color(138, 47, 47));

        jLabel13.setFont(new java.awt.Font("Avenir Next", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total a pagar: $");

        lblPrecio.setFont(new java.awt.Font("Avenir Next", 3, 18)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecio.setText("00.00");

        btnPagar.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(0, 0, 0));
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
                .addComponent(btnPagar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblPrecio))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPagar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 640, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        regresarMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtPlacasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacasKeyTyped
        // TODO add your handling code here:
        if (txtPlacas.getText().length() == 9)
            evt.consume();
    }//GEN-LAST:event_txtPlacasKeyTyped

    private void btnBuscarPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPlacasActionPerformed
        // TODO add your handling code here:
        buscarPlacasAnteriores();
    }//GEN-LAST:event_btnBuscarPlacasActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:
        if(pagarTramite())
            regresarMenu();
    }//GEN-LAST:event_btnPagarActionPerformed

    private void txtLicenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLicenciaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLicenciaKeyTyped

    private void btnBuscarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLicenciaActionPerformed
        // TODO add your handling code here:
        buscarLicencia();
    }//GEN-LAST:event_btnBuscarLicenciaActionPerformed

    private boolean pagarTramite(){
        String msj;
         int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas registrar las placas?", "Advertencia", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            TramitePlacasDTO placas = new TramitePlacasDTO(Calendar.getInstance(), precioTramite, EstadoDTO.ACTIVO);
            placas.setPersona(persona);
            placas.setVehiculo(tramitePlacasAnteriores.getVehiculo());

            try{
                Ventanas.registrarPlacas.actualizarEstadoPlacasAnteriores(tramitePlacasAnteriores);
                TramitePlacasDTO placasGeneradas = Ventanas.registrarPlacas.renovarPlacas(placas);
                if(placasGeneradas != null){
                    msj = """
                          Placas nuevas registradas con \u00e9xito.
                          Matr\u00edcula: '""" + placasGeneradas.getMatricula() + "'";
                }
                else msj = "No se pudieron registrar las placas";
            }catch(NegocioException e){
                JOptionPane.showConfirmDialog(null, 
                        e.getMessage());
                return false;
            }
            JOptionPane.showMessageDialog(null, msj);
            return true;
        }
        return false;
    }
    
    private void iniciar(){
        Ventanas.registrarPlacas=new RegistrarPlacasBO();
        validarLicencia();
        validarSerie();
        lblAdvertenciaLicencia.setVisible(false);
        lblAdvertenciaPlacas.setVisible(false);
        txtSerieVehiculo.setEnabled(false);
        txtTitularLicencia.setEnabled(false);
        btnBuscarPlacas.setEnabled(false);
        btnBuscarLicencia.setEnabled(false);
        txtPlacas.setEnabled(false);
        btnPagar.setEnabled(false);
        lblPrecio.setText(precioTramite.toString());
    }
    
    private void buscarLicencia() {
        TramiteLicenciaDTO licencia = new TramiteLicenciaDTO();
        licencia.setNumLicencia(txtLicencia.getText());
        TramiteLicenciaDTO licenciaObtenida;
        try{
            licenciaObtenida= Ventanas.registrarPlacas.obtenerLicenciaVigente(licencia);
            //si se encuentra la licencia se despliega el nombre del titular en el txtTitularLicencia
            txtTitularLicencia.setText(licenciaObtenida.getPersona().getNombreCompleto());
            persona = licenciaObtenida.getPersona();
            lblAdvertenciaLicencia.setVisible(false);
            txtPlacas.setEnabled(true);
            habilitarBotonPagar();
        }catch(NegocioException e){
            //si no, se muestra la advertencia de que no se encontro
            JOptionPane.showConfirmDialog(null, e.getMessage());
            lblAdvertenciaLicencia.setVisible(true);
            persona = null;
        }
    }
    
    private void buscarPlacasAnteriores(){
        TramitePlacasDTO placas=new TramitePlacasDTO();
        placas.setMatricula(txtPlacas.getText());
        try{
            placas=Ventanas.registrarPlacas.obtenerPlacasPorMatricula(placas);
            placas.setPersona(persona);
            tramitePlacasAnteriores=placas;
            txtSerieVehiculo.setText(placas.getVehiculo().getSerie());
            lblAdvertenciaPlacas.setVisible(false);
            habilitarBotonPagar();
        }catch(NegocioException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            tramitePlacasAnteriores=null;
            lblAdvertenciaPlacas.setVisible(true);
            txtSerieVehiculo.setText("");
        }
    }
    
    private void habilitarBotonPagar(){
        if(!txtSerieVehiculo.getText().isEmpty() && !txtTitularLicencia.getText().isEmpty())
            btnPagar.setEnabled(true);
        else btnPagar.setEnabled(false);
    }
    
    private void validarSerie(){
        Document doc = txtPlacas.getDocument();
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
                if (doc.getLength() == 7) {
                    btnBuscarPlacas.setEnabled(true);
                } else {
                    btnBuscarPlacas.setEnabled(false);
                    txtSerieVehiculo.setText("");
                    habilitarBotonPagar();
                    tramitePlacasAnteriores=null;
                }
            }
        });
    }
    
    private void validarLicencia(){
        Document doc = txtLicencia.getDocument();
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
                if (doc.getLength() == 9) {
                    btnBuscarLicencia.setEnabled(true);
                } else {
                    limpiarDatosLicencia();
                    reiniciarPanelPlacas();
                    habilitarBotonPagar();
                }
            }
        });
    }
    
     private void limpiarDatosLicencia() {
        txtTitularLicencia.setText("");
        lblAdvertenciaLicencia.setVisible(false);
        persona=null;
        btnBuscarLicencia.setEnabled(false);
    }

     
     private void reiniciarPanelPlacas(){
         txtPlacas.setText("");
         txtPlacas.setEnabled(false);
         txtSerieVehiculo.setText("");
         btnBuscarPlacas.setEnabled(false);
         lblAdvertenciaPlacas.setVisible(false);
         tramitePlacasAnteriores=null;
     }
     
    public void reiniciarPanel(){
        reiniciarPanelPlacas();
        limpiarDatosLicencia();
        txtLicencia.setText("");
    }
    
    private void regresarMenu(){
        reiniciarPanel();
        ((Ventanas) SwingUtilities.getWindowAncestor(ModuloPlacasAutoUsado.this)).mostrarVentana("MenuJpanel");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarLicencia;
    private javax.swing.JButton btnBuscarPlacas;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblAdvertenciaLicencia;
    private javax.swing.JLabel lblAdvertenciaPlacas;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JTextField txtLicencia;
    private javax.swing.JTextField txtPlacas;
    private javax.swing.JTextField txtSerieVehiculo;
    private javax.swing.JTextField txtTitularLicencia;
    // End of variables declaration//GEN-END:variables
}
