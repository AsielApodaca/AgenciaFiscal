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
 *
 * author Asiel Apodaca Monge
 */
public class CifradoAES implements Serializable{

    private static final String password =  "12345678";
    private static byte[] keyBytes;
    private static SecretKey secretKey;
    
    static {
        iniciar();
    }

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

    // Método para cifrar un texto usando AES
    public static String encrypt(String plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(ciphertext);
    }

    // Método para descifrar un texto cifrado usando AES
    public static String decrypt(String ciphertext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decryptedBytes);
    }

    // Función para derivar una clave de longitud fija a partir de una cadena de caracteres
    private static byte[] generateKey(String password) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] keyBytes = sha.digest(password.getBytes());
        return keyBytes;
    }
}
