/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.agenciafiscalpresentacion.GUI;

import bo.RegistrarPlacasBO;
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
    /**
     * Creates new form ModuloPlacasAutoNuevo
     */
    public ModuloPlacasAutoNuevo() {
        initComponents();
        iniciar();
        persona=null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        btnPagar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(640, 360));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(136, 62, 69));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel1.setText("Modulo de Placas");

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
                .addContainerGap(19, Short.MAX_VALUE))
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
                .addGap(0, 23, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, 80));

        jLabel2.setText("No. de serie:");

        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });

        jLabel3.setText("Marca:");

        jLabel4.setText("Linea:");

        jLabel5.setText("Color:");

        jLabel6.setText("Modelo:");

        lblAdvertenciaVehiculo.setForeground(new java.awt.Color(255, 51, 51));
        lblAdvertenciaVehiculo.setText("Ya hay un vehiculo registrado con ese numero de serie");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(txtLinea, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(txtMarca)
                            .addComponent(txtSerie))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblAdvertenciaVehiculo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdvertenciaVehiculo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 300, 180));

        jLabel7.setText("No. de licencia:");

        txtLicencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLicenciaKeyTyped(evt);
            }
        });

        btnBuscarLicencia.setText("buscar");
        btnBuscarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLicenciaActionPerformed(evt);
            }
        });

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
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                            .addComponent(btnBuscarLicencia))
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtLicencia)
                        .addComponent(txtTitularLicencia))
                    .addComponent(lblAdvertenciaLicencia))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscarLicencia)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTitularLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAdvertenciaLicencia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 250, 160));

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, -1, -1));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        regresarMenu();
    }//GEN-LAST:event_btnRegresarActionPerformed

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

    private void buscarLicencia(){
        TramiteLicenciaDTO licencia = new TramiteLicenciaDTO();
        licencia.setNumLicencia(txtLicencia.getText());
        TramiteLicenciaDTO licenciaObtenida = Ventanas.registrarPlacas.obtenerLicenciaVigente(licencia);
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
                    TramitePlacasDTO placas = Ventanas.registrarPlacas.obtenerPlacasPorSerieAuto(vehiculo);
                    if(placas==null){
                        System.out.println("placas nulas"); 
                        habilitarCamposVehiculo(true);
                        habilitarBotonPagar();
                    }else{
                        System.out.println("placas no nulas");
                        habilitarCamposVehiculo(false);
                        vehiculo=placas.getVehiculo();
                        txtMarca.setText(vehiculo.getMarca());
                        txtLinea.setText(vehiculo.getLinea());
                        txtColor.setText(vehiculo.getColor());
                        txtModelo.setText(vehiculo.getModelo());
                        habilitarBotonPagar();
                    }
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
        if(!txtSerie.getText().isBlank() && !txtMarca.getText().isBlank() &&
                !txtLinea.getText().isBlank() && !txtColor.getText().isBlank() && !txtModelo.getText().isBlank()){
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas registrar las placas?", "Advertencia", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                TramitePlacasDTO tramite= new TramitePlacasDTO(Calendar.getInstance(), 1500.0f, EstadoDTO.ACTIVO);
                tramite.setPersona(persona);
                VehiculoDTO vehiculo=new VehiculoDTO(
                        txtSerie.getText(), 
                        txtMarca.getText(), 
                        txtLinea.getText(), 
                        txtColor.getText(),
                        txtModelo.getText());
                tramite.setVehiculo(vehiculo);
                
                if(Ventanas.registrarPlacas.registrarPlacas(tramite)){
                    JOptionPane.showMessageDialog(null,
                            "Placas nuevas registradas con éxito."
                    );
                } else
                    JOptionPane.showMessageDialog(null, "No se han podido registrar las placas.");
                
                regresarMenu();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe ingresar toda la informacion del vehiculo.");
        }
    }
    
    private void habilitarBotonPagar(){
        if((!lblAdvertenciaVehiculo.isVisible() || !txtSerie.getText().isEmpty()) && 
                (!lblAdvertenciaLicencia.isVisible()) || !txtTitularLicencia.getText().isEmpty())
            btnPagar.setEnabled(true);
        else btnPagar.setEnabled(false);
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
    private javax.swing.JLabel lblAdvertenciaLicencia;
    private javax.swing.JLabel lblAdvertenciaVehiculo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLicencia;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtTitularLicencia;
    // End of variables declaration//GEN-END:variables
}
