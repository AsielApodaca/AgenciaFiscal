package dominio;

/**
 * Enumeración que representa los posibles estados de un trámite.
 * 
 * 
 * @author Asiel Apodaca Monge
 */
public enum Estado {
    /**
     * Para tramites de tipo licencia
     * La licencia todavía es válida para realizar trámites.
     */
    VIGENTE, // Licencia
    
    /**
     * Para tramites de tipo licencia
     * La licencia ya no es válida para realizar trámites.
     */
    CADUCO, // Licencia
    
    /**
     * Para tramites de tipo placa
     * La placa está activada.
     */
    ACTIVO, // Placa
    
    /**
     * Para tramites de tipo placa
     * La placa está desactivada.
     */
    INACTIVO // Placa
}
