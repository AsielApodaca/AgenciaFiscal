package com.mycompany.agenciafiscalpresentacion.validaciones;

/**
 *
 * @author Asiel Apodaca Monge
 */
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.BadLocationException;
import javax.swing.SwingUtilities;

public class Validaciones {

    public static void limitarCaracteres(JTextComponent textField, int limite) {
        Document doc = textField.getDocument();
        doc.addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                limitar(e);
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                limitar(e);
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                limitar(e);
            }

            private void limitar(javax.swing.event.DocumentEvent e) {
                Document doc = e.getDocument();
                if (doc.getLength() > limite) {
                    SwingUtilities.invokeLater(() -> {
                        try {
                            doc.remove(limite, doc.getLength() - limite);
                        } catch (BadLocationException ex) {
                            ex.printStackTrace();
                        }
                    });
                }
            }
        });
    }
    
    
    
    
}
