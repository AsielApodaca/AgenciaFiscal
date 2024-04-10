package com.mycompany.agenciafiscalpresentacion.GUI;

import bo.RegistrarLicenciaBO;
import excepciones.NegocioException;
import iBo.iRegistrarLicenciaBO;
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
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

    private PersonaDTO persona;
    
    /**
     * Creates new form ModuloLicenciasJpanel
     */
    public ModuloLicenciasJpanel() {
        initComponents();
        
        persona = null;
        iniciar();
    }
    
    public void iniciar(){
        validarRfc();
        Ventanas.registrarLicencia=new RegistrarLicenciaBO();
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
                    PersonaDTO p=new PersonaDTO();
                    p.setRfc(txtRfc.getText());
                    try{
                        persona = Ventanas.registrarLicencia.consultarPersonaPorRfc(p);
                    }catch(NegocioException ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    if(persona == null){ // No se encontró
                        limpiarDatos();
                        mostrarAdvertenciaRfc();
                    } else { // Se encontró
                        System.out.println(persona.toString());
                        btnPagar.setEnabled(true);
                        mostrarDatos();
                    }
                    
                } else {
                    persona=null;
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
            lblPrecioVigencia1.setText("$ 200");
            lblPrecioVigencia2.setText("$ 500");
            lblPrecioVigencia3.setText("$ 700");
            cbxDiscapacidad.setEnabled(false);
            cbxDiscapacidad.setSelected(true);
        }else{
            cbxDiscapacidad.setEnabled(true);
            cbxDiscapacidad.setSelected(false);
        }
        
        actualizarVistaPrecios();
    }
    
    public void actualizarVistaPrecios() {
        if(cbxDiscapacidad.isSelected()){
            lblPrecioVigencia1.setText("$ 200");
            lblPrecioVigencia2.setText("$ 500");
            lblPrecioVigencia3.setText("$ 700");
        } else {
            lblPrecioVigencia1.setText("$ 600");
            lblPrecioVigencia2.setText("$ 900");
            lblPrecioVigencia3.setText("$ 1100");
        }    
    }
    
    public void registrarLicencia() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas registrar la licencia?", "Advertencia", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            // El usuario ha hecho clic en "Sí" o "Continuar"
            // Aquí puedes poner tu lógica para registrar la licencia
            String msj;
            if(!persona.getDiscapaciad() && cbxDiscapacidad.isSelected()){
                try{
                    persona=Ventanas.registrarLicencia.actualizarDiscapacidadPersona(persona);
                }catch(NegocioException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            try {
                TramiteLicenciaDTO licenciaVieja = Ventanas.registrarLicencia.obtenerTramiteLicencia(persona);
                if(licenciaVieja != null) {
                    if (Ventanas.registrarLicencia.actualizarEstadoLicencia(licenciaVieja)) {
                        System.out.println("se actualizo el estado de la licencia");
                    }
                }
                
                TramiteLicenciaDTO licencia = setTramiteLicencia();
                licencia = Ventanas.registrarLicencia.registrarLicencia(licencia);
                msj="""
                    Licencia nueva registrada con \u00e9xito.
                    No. Licencia: '""" + licencia.getNumLicencia() + "'";
            } catch (NegocioException e) {
                msj=e.getMessage();
            }
            JOptionPane.showMessageDialog(null, msj);
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
        TramiteDTO tramite=new TramiteLicenciaDTO(Calendar.getInstance(), costo, EstadoDTO.VIGENTE);
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
        
    }

    private void regresarMenu(){
        reiniciarPanel();
        ((Ventanas) SwingUtilities.getWindowAncestor(this)).mostrarVentana("MenuJpanel");
    }

    private void desplegarTablaPersonasRegistradas(){
        JDialog dialogo = new JDialog((Ventanas)SwingUtilities.getWindowAncestor(ModuloLicenciasJpanel.this), "Personas registradas", false);
        dialogo.setLayout(new BorderLayout());
        dialogo.setSize(400, 200);
        
        List<PersonaDTO> personas;
        try{
            personas=Ventanas.registrarLicencia.obtenerPersonasRegistradas();
        }catch(NegocioException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            regresarMenu();
            return;
        }
        Object[][] filas =new Object[20][2];
        int contador=0;
        for(PersonaDTO p:personas){
            filas[contador][0]=p.getNombreCompleto();
            filas[contador][1]=p.getRfc();
            contador++;
        }
        List<String> columnas = new ArrayList<>();
        columnas.add("nombre");
        columnas.add("RFC");
        
        
        DefaultTableModel modeloTabla = new DefaultTableModel(filas,columnas.toArray());
        JTable tabla = new JTable(modeloTabla);
        
        JScrollPane scrollPane = new JScrollPane(tabla);
        dialogo.add(scrollPane, BorderLayout.CENTER);

        dialogo.setLocationRelativeTo((Ventanas)SwingUtilities.getWindowAncestor(ModuloLicenciasJpanel.this));

        dialogo.setVisible(true);
        
        setPersonaSeleccionada(tabla, personas);
    }
    
    
    private void setPersonaSeleccionada(JTable tabla,List<PersonaDTO> lista){
        tabla.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            System.out.println("cambio el valor: " + event.toString());
            if (!event.getValueIsAdjusting()) {
                int fila =tabla.getSelectedRow();
                if(fila>=0){
                    txtRfc.setText(lista.get(fila).getRfc());
                }else
                    limpiarDatos();
            }
        });
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
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnPersonasRegistradas = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
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
        jPanel1 = new javax.swing.JPanel();
        cbxDiscapacidad = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        Vigencia1 = new javax.swing.JPanel();
        rbnVigencia1 = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblPrecioVigencia1 = new javax.swing.JLabel();
        Vigencia2 = new javax.swing.JPanel();
        rbnVigencia2 = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblPrecioVigencia2 = new javax.swing.JLabel();
        Vigencia3 = new javax.swing.JPanel();
        rbnVigencia3 = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblPrecioVigencia3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnPagar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(640, 360));
        setPreferredSize(new java.awt.Dimension(640, 360));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(35, 26, 26));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        jPanel7.setBackground(new java.awt.Color(98, 76, 76));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 60));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Avenir Next", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Módulo de Licencias");
        jPanel7.add(jLabel6, new java.awt.GridBagConstraints());

        jPanel6.add(jPanel7);

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 220, 80));

        jPanel3.setBackground(new java.awt.Color(138, 47, 47));

        btnRegresar.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnPersonasRegistradas.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        btnPersonasRegistradas.setForeground(new java.awt.Color(0, 0, 0));
        btnPersonasRegistradas.setText("personas registradas");
        btnPersonasRegistradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonasRegistradasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
                .addComponent(btnPersonasRegistradas)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnPersonasRegistradas))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel9.setFont(new java.awt.Font("Avenir Next Condensed", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Ingrese la información solicitada");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        jPanel5.add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Avenir Next Condensed", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Seleccione el tipo de licencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 19, 0, 0);
        jPanel5.add(jLabel10, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("RFC:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel4.add(jLabel2, gridBagConstraints);

        txtRfc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRfcKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = -6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 6, 0);
        jPanel4.add(txtRfc, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre Completo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel4.add(jLabel3, gridBagConstraints);

        txtNombreCompleto.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = -6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 6, 0);
        jPanel4.add(txtNombreCompleto, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha de nacimiento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel4.add(jLabel4, gridBagConstraints);

        txtFechaNacimiento.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = -6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 6, 0);
        jPanel4.add(txtFechaNacimiento, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Telefono:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel4.add(jLabel5, gridBagConstraints);

        txtTelefono.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = -6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 6, 0);
        jPanel4.add(txtTelefono, gridBagConstraints);

        txtAdvertencia.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        txtAdvertencia.setForeground(new java.awt.Color(255, 51, 51));
        txtAdvertencia.setText("No coincide con ninguna persona.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel4.add(txtAdvertencia, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 8, 0);
        jPanel5.add(jPanel4, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cbxDiscapacidad.setFont(new java.awt.Font("Avenir Next", 0, 13)); // NOI18N
        cbxDiscapacidad.setForeground(new java.awt.Color(0, 0, 0));
        cbxDiscapacidad.setText("Discapacidad");
        cbxDiscapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDiscapacidadActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        Vigencia1.setBackground(new java.awt.Color(98, 76, 76));

        buttonGroup1.add(rbnVigencia1);

        jPanel9.setBackground(new java.awt.Color(98, 76, 76));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vigencia de 1 año");
        jPanel9.add(jLabel1, java.awt.BorderLayout.CENTER);

        lblPrecioVigencia1.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        lblPrecioVigencia1.setForeground(new java.awt.Color(204, 204, 204));
        lblPrecioVigencia1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecioVigencia1.setText("$600");
        jPanel9.add(lblPrecioVigencia1, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout Vigencia1Layout = new javax.swing.GroupLayout(Vigencia1);
        Vigencia1.setLayout(Vigencia1Layout);
        Vigencia1Layout.setHorizontalGroup(
            Vigencia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vigencia1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbnVigencia1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Vigencia1Layout.setVerticalGroup(
            Vigencia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vigencia1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Vigencia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbnVigencia1)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 128;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 20, 3, 20);
        jPanel2.add(Vigencia1, gridBagConstraints);

        Vigencia2.setBackground(new java.awt.Color(98, 76, 76));

        buttonGroup1.add(rbnVigencia2);

        jPanel11.setBackground(new java.awt.Color(98, 76, 76));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Vigencia de 2 años");
        jPanel11.add(jLabel7, java.awt.BorderLayout.CENTER);

        lblPrecioVigencia2.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        lblPrecioVigencia2.setForeground(new java.awt.Color(204, 204, 204));
        lblPrecioVigencia2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecioVigencia2.setText("$900");
        jPanel11.add(lblPrecioVigencia2, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout Vigencia2Layout = new javax.swing.GroupLayout(Vigencia2);
        Vigencia2.setLayout(Vigencia2Layout);
        Vigencia2Layout.setHorizontalGroup(
            Vigencia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vigencia2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbnVigencia2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );
        Vigencia2Layout.setVerticalGroup(
            Vigencia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vigencia2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Vigencia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbnVigencia2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 121;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 20, 3, 20);
        jPanel2.add(Vigencia2, gridBagConstraints);

        Vigencia3.setBackground(new java.awt.Color(98, 76, 76));

        buttonGroup1.add(rbnVigencia3);

        jPanel12.setBackground(new java.awt.Color(98, 76, 76));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Vigencia de 3 años");
        jPanel12.add(jLabel8, java.awt.BorderLayout.CENTER);

        lblPrecioVigencia3.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        lblPrecioVigencia3.setForeground(new java.awt.Color(204, 204, 204));
        lblPrecioVigencia3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecioVigencia3.setText("$1100");
        jPanel12.add(lblPrecioVigencia3, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout Vigencia3Layout = new javax.swing.GroupLayout(Vigencia3);
        Vigencia3.setLayout(Vigencia3Layout);
        Vigencia3Layout.setHorizontalGroup(
            Vigencia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vigencia3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbnVigencia3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );
        Vigencia3Layout.setVerticalGroup(
            Vigencia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Vigencia3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Vigencia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbnVigencia3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 121;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 20, 3, 20);
        jPanel2.add(Vigencia3, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxDiscapacidad)
                .addContainerGap(200, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxDiscapacidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 194;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 19, 8, 8);
        jPanel5.add(jPanel1, gridBagConstraints);

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 640, 240));

        jPanel8.setBackground(new java.awt.Color(138, 47, 47));

        btnPagar.setFont(new java.awt.Font("Avenir Next", 1, 14)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(0, 0, 0));
        btnPagar.setText("Pagar");
        btnPagar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnPagarStateChanged(evt);
            }
        });
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(562, Short.MAX_VALUE)
                .addComponent(btnPagar)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(btnPagar)
                .addContainerGap())
        );

        add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 640, 40));
    }// </editor-fold>//GEN-END:initComponents

    
    
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

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:
        if(persona!=null){
            if(rbnVigencia1.isSelected() || rbnVigencia2.isSelected() || rbnVigencia3.isSelected()){
                registrarLicencia();
            }else
                JOptionPane.showMessageDialog(null, "Debe seleccionar una vigencia");
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnPagarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnPagarStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagarStateChanged

    private void btnPersonasRegistradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonasRegistradasActionPerformed
        // TODO add your handling code here:
        desplegarTablaPersonasRegistradas();
    }//GEN-LAST:event_btnPersonasRegistradasActionPerformed

    private void cbxDiscapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDiscapacidadActionPerformed
        actualizarVistaPrecios();      
    }//GEN-LAST:event_cbxDiscapacidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Vigencia1;
    private javax.swing.JPanel Vigencia2;
    private javax.swing.JPanel Vigencia3;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnPersonasRegistradas;
    private javax.swing.JButton btnRegresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbxDiscapacidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
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
                  
