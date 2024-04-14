package excepciones;

/**
 * Esta clase representa una excepción específica de negocio.
 * Se utiliza para indicar errores relacionados con la lógica de negocio de la aplicación.
 * 
 * @author luiis
 */
public class NegocioException extends Exception {

    /**
     * Constructor por defecto.
     */
    public NegocioException() {
    }

    /**
     * Constructor que inicializa la excepción con un mensaje de error.
     * 
     * @param message El mensaje de error que describe la excepción.
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * Constructor que inicializa la excepción con un mensaje de error y una causa subyacente.
     * 
     * @param message El mensaje de error que describe la excepción.
     * @param cause La causa subyacente de la excepción.
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que inicializa la excepción con una causa subyacente.
     * 
     * @param cause La causa subyacente de la excepción.
     */
    public NegocioException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que inicializa la excepción con un mensaje de error, una causa subyacente, y opciones adicionales de supresión y rastreo.
     * 
     * @param message El mensaje de error que describe la excepción.
     * @param cause La causa subyacente de la excepción.
     * @param enableSuppression Indica si la supresión de la excepción está habilitada o no.
     * @param writableStackTrace Indica si el rastreo de la excepción es escribible o no.
     */
    public NegocioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
