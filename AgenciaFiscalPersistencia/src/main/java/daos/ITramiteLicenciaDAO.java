package daos;

import entidades.Persona;
import entidades.TramiteLicencia;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Esta interfaz extiende la interfaz ITramiteDAO y define métodos adicionales para 
 * el acceso a los datos de los trámites de licencia en la base de datos.
 * 
 * author luiis
 */
public interface ITramiteLicenciaDAO extends ITramiteDAO {
    
    /**
     * Obtiene una lista de trámites de licencia asociados a una persona específica.
     * 
     * @param personaTramite La persona asociada a los trámites de licencia a buscar.
     * @return Una lista de trámites de licencia asociados a la persona proporcionada.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public List<TramiteLicencia> obtenerTramitesLicencia(Persona personaTramite) throws PersistenciaException;
    
    /**
     * Obtiene la licencia vigente asociada a un trámite de licencia específico.
     * 
     * @param licencia El trámite de licencia del que se desea obtener la licencia vigente.
     * @return La licencia vigente asociada al trámite de licencia proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public TramiteLicencia obtenerLicenciaVigente(TramiteLicencia licencia) throws PersistenciaException;
    
    /**
     * Obtiene una licencia asociada a un trámite de licencia específico.
     * 
     * @param licencia El trámite de licencia del que se desea obtener la licencia.
     * @return La licencia asociada al trámite de licencia proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public TramiteLicencia obtenerLicencia(TramiteLicencia licencia) throws PersistenciaException;
    
    /**
     * Actualiza la fecha de vencimiento de una licencia en la base de datos.
     * 
     * @param licencia La licencia cuya fecha de vencimiento se actualizará en la base de datos.
     * @return true si la fecha de vencimiento se actualizó correctamente, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error durante la actualización en la base de datos.
     */
    public boolean actualizarFechaVencimiento(TramiteLicencia licencia) throws PersistenciaException;
}
