package com.mycompany.agenciafiscalpresentacion.validaciones;

import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.BadLocationException;
import javax.swing.SwingUtilities;

/**
 * Clase que contiene métodos de validación para componentes de texto.
 * Permite limitar la cantidad de caracteres que se pueden ingresar en un JTextComponent.
 * @author Asiel Apodaca Monge
 */
public class Validaciones {

    /**
     * Limita la cantidad de caracteres que se pueden ingresar en un JTextComponent.
     * @param textField El componente de texto al que se le aplicará la limitación.
     * @param limite La cantidad máxima de caracteres permitidos.
     */
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
