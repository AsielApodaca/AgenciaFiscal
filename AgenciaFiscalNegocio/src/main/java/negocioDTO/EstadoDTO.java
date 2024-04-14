package negocioDTO;

/**
 * Enumeración que representa los diferentes estados de los trámites en el sistema.
 * 
 * <p>Los estados pueden ser utilizados para indicar el estado actual de un trámite, como si está vigente o caducado.</p>
 * 
 * <p>Los valores posibles son: VIGENTE, CADUCO, ACTIVO e INACTIVO.</p>
 * 
 * <p>Esta enumeración es utilizada para representar el estado de los trámites de licencia y placas en el sistema.</p>
 * 
 * <p>Por ejemplo, un trámite de licencia puede estar en estado VIGENTE si la licencia aún es válida, o en estado CADUCO si ya no lo es.</p>
 * 
 * <p>De manera similar, un trámite de placas puede estar en estado ACTIVO si las placas están activadas, o en estado INACTIVO si están desactivadas.</p>
 * 
 * <p>Los valores de esta enumeración se utilizan en conjunto con los trámites correspondientes en el sistema.</p>
 * 
 * <p>No se espera que esta enumeración sea instanciada directamente, sino que se debe acceder a sus valores a través de sus constantes.</p>
 * 
 * <p>Tenga en cuenta que esta enumeración es específica del dominio de negocio y se utiliza para representar estados relacionados con trámites.</p>
 * 
 * @author Asiel Apodaca Monge
 */
public enum EstadoDTO {
    /**
     * Estado que indica que el trámite está vigente y aún es válido para realizar trámites.
     * Este estado se utiliza principalmente para trámites de licencia.
     */
    VIGENTE, // Licencia
    
    /**
     * Estado que indica que el trámite ha caducado y ya no es válido para realizar trámites.
     * Este estado se utiliza principalmente para trámites de licencia.
     */
    CADUCO, // Licencia
    
    /**
     * Estado que indica que el trámite está activo y en uso.
     * Este estado se utiliza principalmente para trámites de placas.
     */
    ACTIVO, // Placa
    
    /**
     * Estado que indica que el trámite está inactivo y no está en uso.
     * Este estado se utiliza principalmente para trámites de placas.
     */
    INACTIVO // Placa
}
