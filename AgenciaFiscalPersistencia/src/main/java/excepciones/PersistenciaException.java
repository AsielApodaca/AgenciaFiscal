package excepciones;

/**
 * Excepción personalizada para errores relacionados con la persistencia de datos.
 * Esta excepción puede ser lanzada cuando ocurren problemas durante operaciones de persistencia en la base de datos.
 * 
 * @author luiis
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor por defecto de la excepción.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor que acepta un mensaje descriptivo del error.
     * @param message Mensaje descriptivo del error.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que acepta un mensaje descriptivo del error y una causa subyacente.
     * @param message Mensaje descriptivo del error.
     * @param cause Causa subyacente del error.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que acepta una causa subyacente del error.
     * @param cause Causa subyacente del error.
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que acepta un mensaje descriptivo del error, una causa subyacente, 
     * y especifica si se debe habilitar la supresión de excepciones y si el stack trace es escribible.
     * @param message Mensaje descriptivo del error.
     * @param cause Causa subyacente del error.
     * @param enableSuppression Indica si se debe habilitar la supresión de excepciones.
     * @param writableStackTrace Indica si el stack trace es escribible.
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
