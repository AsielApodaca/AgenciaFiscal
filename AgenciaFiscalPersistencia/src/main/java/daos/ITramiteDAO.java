package daos;

import entidades.Persona;
import entidades.Tramite;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.List;

/**
 * Esta interfaz define los métodos que deben ser implementados por las clases que 
 * proporcionan acceso a los datos de los trámites en la base de datos.
 * 
 * author luiis
 */
public interface ITramiteDAO {
    
    /**
     * Obtiene una lista de trámites de la base de datos dentro del rango de fechas especificado,
     * filtrados por tipo de trámite y persona asociada.
     * 
     * @param fechaDesde La fecha de inicio del rango de búsqueda.
     * @param fechaHasta La fecha de fin del rango de búsqueda.
     * @param tipoTramite El tipo de trámite a buscar.
     * @param personaTramite La persona asociada a los trámites a buscar.
     * @return Una lista de trámites encontrados que cumplen con los criterios de búsqueda.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public List<Tramite> obtenerTramites(Calendar fechaDesde, Calendar fechaHasta, 
            String tipoTramite, Persona personaTramite) throws PersistenciaException;

    /**
     * Obtiene una lista de trámites de la base de datos asociados a una persona específica.
     * 
     * @param personaTramite La persona asociada a los trámites a buscar.
     * @return Una lista de trámites asociados a la persona proporcionada.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public List<Tramite> obtenerTramitesPorPersona(Persona personaTramite) throws PersistenciaException;

    /**
     * Obtiene un trámite de la base de datos asociado a una persona y a un tipo de trámite específicos.
     * 
     * @param personaTramite La persona asociada al trámite a buscar.
     * @param tipoTramite El tipo de trámite a buscar.
     * @return El trámite encontrado que coincide con la persona y el tipo de trámite proporcionados.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public Tramite obtenerTramite(Persona personaTramite, String tipoTramite) throws PersistenciaException;

    /**
     * Obtiene una lista de todos los trámites almacenados en la base de datos.
     * 
     * @return Una lista de todos los trámites almacenados en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public List<Tramite> obtenerTramites() throws PersistenciaException;

    /**
     * Registra un nuevo trámite en la base de datos.
     * 
     * @param tramite El trámite a registrar en la base de datos.
     * @return true si el trámite se registró correctamente, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error durante el registro en la base de datos.
     */
    public boolean registrarTramite(Tramite tramite) throws PersistenciaException;

    /**
     * Actualiza el estado de un trámite en la base de datos.
     * 
     * @param tramite El trámite cuyo estado se actualizará en la base de datos.
     * @return true si el estado del trámite se actualizó correctamente, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error durante la actualización en la base de datos.
     */
    public boolean actualizarEstadoTramite(Tramite tramite) throws PersistenciaException;
}
