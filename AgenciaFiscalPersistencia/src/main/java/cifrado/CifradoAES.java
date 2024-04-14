package cifrado;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Esta clase proporciona métodos para cifrar y descifrar texto utilizando el algoritmo AES (Advanced Encryption Standard).
 * La clave para el cifrado se deriva de una contraseña proporcionada por el usuario.
 * 
 * @author Asiel Apodaca Monge
 */
public class CifradoAES implements Serializable {

    private static final String password = "12345678";
    private static byte[] keyBytes;
    private static SecretKey secretKey;
    
    static {
        iniciar();
    }

    /**
     * Inicializa la clase derivando una clave de longitud fija a partir de la contraseña proporcionada.
     */
    private static void iniciar() {
        try {
            // Derivar una clave de longitud fija a partir de la entrada del usuario
            keyBytes = generateKey(password);
            // Convertir la clave derivada en una instancia de SecretKey
            secretKey = new SecretKeySpec(keyBytes, 0, keyBytes.length, "AES");
        } catch (Exception ex) {
            Logger.getLogger(CifradoAES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cifra un texto utilizando el algoritmo AES.
     * 
     * @param plaintext El texto a cifrar.
     * @return El texto cifrado como una cadena Base64.
     * @throws Exception Si ocurre un error durante el cifrado.
     */
    public static String encrypt(String plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(ciphertext);
    }

    /**
     * Descifra un texto cifrado utilizando el algoritmo AES.
     * 
     * @param ciphertext El texto cifrado como una cadena Base64.
     * @return El texto descifrado.
     * @throws Exception Si ocurre un error durante el descifrado.
     */
    public static String decrypt(String ciphertext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decryptedBytes);
    }

    /**
     * Deriva una clave de longitud fija a partir de una cadena de caracteres utilizando el algoritmo de hash SHA-256.
     * 
     * @param password La contraseña de la que se va a derivar la clave.
     * @return La clave derivada como un arreglo de bytes.
     * @throws Exception Si ocurre un error durante la derivación de la clave.
     */
    private static byte[] generateKey(String password) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] keyBytes = sha.digest(password.getBytes());
        return keyBytes;
    }
}
