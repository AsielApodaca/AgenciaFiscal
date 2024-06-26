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
import negocioDTO.VehiculoDTO;

/**
 *
 * @author luiis
 */
public class ModuloPlacasAutoNuevo extends javax.swing.JPanel {

    private PersonaDTO persona;
    private final Float precioTramite;
    
    /**
     * Creates new form ModuloPlacasAutoNuevo
     */
    public ModuloPlacasAutoNuevo() {
        initComponents();
        this.persona = null;
        this.precioTramite = 1500.0F;
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

        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnPagar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        lblAdvertenciaVehiculo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtLicencia = new javax.swing.JTextField();
        btnBuscarLicencia = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTitularLicencia = new javax.swing.JTextField();
        lblAdvertenciaLicencia = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(640, 360));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(35, 26, 26));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        jPanel7.setBackground(new java.awt.Color(98, 76, 76));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 60));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel9.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Módulo de Placas");
        jPanel7.add(jLabel9, new java.awt.GridBagConstraints());

        jLabel11.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("para automóvil");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel7.add(jLabel11, gridBagConstraints);

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
                .addContainerGap(14, Short.MAX_VALUE))
        );

        add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        jPanel2.setBackground(new java.awt.Color(138, 47, 47));

        btnPagar.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(0, 0, 0));
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Avenir Next", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total a pagar: $");

        lblPrecio.setFont(new java.awt.Font("Avenir Next", 3, 18)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecio.setText("00.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
                .addComponent(btnPagar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagar)
                    .addComponent(jLabel10)
                    .addComponent(lblPrecio))
                .addContainerGap())
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 640, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("No. de serie:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 1, 0);
        jPanel4.add(jLabel2, gridBagConstraints);

        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = -6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 5, 0);
        jPanel4.add(txtSerie, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Marca:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 1, 0);
        jPanel4.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = -6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 5, 0);
        jPanel4.add(txtMarca, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Linea:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 1, 0);
        jPanel4.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = -6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 5, 0);
        jPanel4.add(txtLinea, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Color:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 1, 0);
        jPanel4.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = -6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 5, 0);
        jPanel4.add(txtColor, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Modelo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 1, 0);
        jPanel4.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = -6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 5, 0);
        jPanel4.add(txtModelo, gridBagConstraints);

        lblAdvertenciaVehiculo.setForeground(new java.awt.Color(255, 51, 51));
        lblAdvertenciaVehiculo.setText("Ya se registró un vehículo con ese numero de serie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 6, 3, 26);
        jPanel4.add(lblAdvertenciaVehiculo, gridBagConstraints);

        jPanel1.add(jPanel4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("No. de licencia:");

        txtLicencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLicenciaKeyTyped(evt);
            }
        });

        btnBuscarLicencia.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        btnBuscarLicencia.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarLicencia.setText("buscar");
        btnBuscarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLicenciaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Avenir", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Titular de licencia:");

        txtTitularLicencia.setEditable(false);
        txtTitularLicencia.setToolTipText("");

        lblAdvertenciaLicencia.setForeground(new java.awt.Color(255, 51, 51));
        lblAdvertenciaLicencia.setText("No se encontró la licencia");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnBuscarLicencia)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(127, 127, 127))
                        .addComponent(txtTitularLicencia))
                    .addComponent(lblAdvertenciaLicencia))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarLicencia)
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitularLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAdvertenciaLicencia)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 640, 230));
    }// </editor-fold>//GEN-END:initComponents

    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        // TODO add your handling code here:
        if(txtSerie.getText().length()==17)
            evt.consume();
    }//GEN-LAST:event_txtSerieKeyTyped

    private void btnBuscarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLicenciaActionPerformed
        // TODO add your handling code here:
        buscarLicencia();
    }//GEN-LAST:event_btnBuscarLicenciaActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:
        pagarTramite();
    }//GEN-LAST:event_btnPagarActionPerformed

    private void txtLicenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLicenciaKeyTyped
        // TODO add your handling code here:
        if(txtLicencia.getText().length()==9)
            evt.consume();
    }//GEN-LAST:event_txtLicenciaKeyTyped

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        reiniciarPanel();
        ((Ventanas) SwingUtilities.getWindowAncestor(this)).mostrarVentana("MenuJpanel");
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void buscarLicencia(){
        TramiteLicenciaDTO licencia = new TramiteLicenciaDTO();
        licencia.setNumLicencia(txtLicencia.getText());
        TramiteLicenciaDTO licenciaObtenida;
        try{
            licenciaObtenida= Ventanas.registrarPlacas.obtenerLicenciaVigente(licencia);
        }catch(NegocioException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }
        if (licenciaObtenida != null) {//si se encuentra la licencia
            //se despliega el nombre del titular en el txtTitularLicencia
            txtTitularLicencia.setText(licenciaObtenida.getPersona().getNombreCompleto());
            persona=licenciaObtenida.getPersona();
            habilitarBotonPagar();
        } else {
            //si no, se muestra la advertencia de que no se encontro
            lblAdvertenciaLicencia.setVisible(true);
            persona=null;
        }
    }
    
    private void iniciar(){
        Ventanas.registrarPlacas=new RegistrarPlacasBO();
        validarSerie();
        validarLicencia();
        btnPagar.setEnabled(false);
        txtMarca.setEnabled(false);
        txtColor.setEnabled(false);
        txtModelo.setEnabled(false);
        txtLinea.setEnabled(false);
        lblAdvertenciaLicencia.setVisible(false);
        lblAdvertenciaVehiculo.setVisible(false);
        btnPagar.setEnabled(false);
        btnBuscarLicencia.setEnabled(false);
        lblPrecio.setText(precioTramite.toString());
    }
    
    private void validarSerie(){
        Document doc = txtSerie.getDocument();
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
                if (doc.getLength() == 17) {
                    
                    VehiculoDTO vehiculo=new VehiculoDTO();
                    vehiculo.setSerie(txtSerie.getText());
                    TramitePlacasDTO placas=null;
                    try{
                        placas= Ventanas.registrarPlacas.obtenerPlacasPorSerieAuto(vehiculo);
                    }catch(NegocioException ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    if(placas==null){
                        System.out.println("placas nulas"); 
                        habilitarCamposVehiculo(true);
                    }else{
                        System.out.println("placas no nulas");
                        habilitarCamposVehiculo(false);
                        vehiculo=placas.getVehiculo();
                        txtMarca.setText(vehiculo.getMarca());
                        txtLinea.setText(vehiculo.getLinea());
                        txtColor.setText(vehiculo.getColor());
                        txtModelo.setText(vehiculo.getModelo());
                        lblAdvertenciaVehiculo.setVisible(true);
                    }
                    habilitarBotonPagar();
                } else {
                    habilitarCamposVehiculo(false);
                    limpiarDatos();
                }
            }
        });
    }
    
    private void habilitarCamposVehiculo(boolean flag){
        txtMarca.setEnabled(flag);
        txtLinea.setEnabled(flag);
        txtColor.setEnabled(flag);
        txtModelo.setEnabled(flag);
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
                    btnBuscarLicencia.setEnabled(false);
                    limpiarDatos();
                    persona=null;
                }
            }
        });
    }
    
    private void pagarTramite(){
        String msj;
        if(!txtSerie.getText().isBlank() && !txtMarca.getText().isBlank() &&
                !txtLinea.getText().isBlank() && !txtColor.getText().isBlank() && !txtModelo.getText().isBlank()){
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas registrar las placas?", "Advertencia", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                TramitePlacasDTO tramite= new TramitePlacasDTO(Calendar.getInstance(), precioTramite, EstadoDTO.ACTIVO);
                tramite.setPersona(persona);
                VehiculoDTO vehiculo=new VehiculoDTO(
                        txtSerie.getText(), 
                        txtMarca.getText(), 
                        txtLinea.getText(), 
                        txtColor.getText(),
                        txtModelo.getText());
                tramite.setVehiculo(vehiculo);
                try{
                    TramitePlacasDTO placas = Ventanas.registrarPlacas.registrarPlacas(tramite);
                    if(placas != null)
                    msj = """
                          Placas nuevas registradas con \u00e9xito.
                          Matr\u00edcula: '""" + placas.getMatricula() + "'";
                    else msj = "No se pudieron registrar las placas";
                }catch(NegocioException e){
                    msj = "Hubo un error al registrar las placas";
                }
                JOptionPane.showMessageDialog(null, msj);
                regresarMenu();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe ingresar toda la informacion del vehiculo.");
        }
    }
    
    private void habilitarBotonPagar(){
        if((lblAdvertenciaVehiculo.isVisible() || txtSerie.getText().isEmpty())
                || (lblAdvertenciaLicencia.isVisible() || txtLicencia.getText().isEmpty()))
            btnPagar.setEnabled(false);
        else btnPagar.setEnabled(true);
    }
    private void limpiarDatos() {
        txtMarca.setText("");
        txtLinea.setText((""));
        txtColor.setText("");
        txtModelo.setText("");
        txtTitularLicencia.setText("");
        lblAdvertenciaLicencia.setVisible(false);
        lblAdvertenciaVehiculo.setVisible(false);
        btnPagar.setEnabled(false);
    }

    public void reiniciarPanel(){
        txtSerie.setText("");
        txtLicencia.setText("");
        persona=null;
        limpiarDatos();
        
    }

    private void regresarMenu(){
        reiniciarPanel();
        ((Ventanas) SwingUtilities.getWindowAncestor(ModuloPlacasAutoNuevo.this)).mostrarVentana("MenuJpanel");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarLicencia;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblAdvertenciaLicencia;
    private javax.swing.JLabel lblAdvertenciaVehiculo;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLicencia;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtTitularLicencia;
    // End of variables declaration//GEN-END:variables
}
