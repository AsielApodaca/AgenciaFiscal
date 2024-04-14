package daos;

import entidades.Persona;
import entidades.TramitePlacas;
import entidades.Vehiculo;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Esta interfaz extiende la interfaz ITramiteDAO y define métodos adicionales para 
 * el acceso a los datos de los trámites de placas de vehículos en la base de datos.
 * 
 * author luiis
 */
public interface ITramitePlacasDAO extends ITramiteDAO {
    
    /**
     * Obtiene una lista de trámites de placas de vehículos asociados a una persona específica.
     * 
     * @param personaTramite La persona asociada a los trámites de placas de vehículos a buscar.
     * @return Una lista de trámites de placas de vehículos asociados a la persona proporcionada.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public List<TramitePlacas> obtenerTramitesPlacas(Persona personaTramite) throws PersistenciaException;
    
    /**
     * Renueva las placas de un vehículo en la base de datos.
     * 
     * @param tramite El trámite de placas de vehículo que contiene la información de las placas a renovar.
     * @return true si las placas se renovaron correctamente, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error durante la renovación en la base de datos.
     */
    public boolean renovarPlacas(TramitePlacas tramite) throws PersistenciaException;
    
    /**
     * Obtiene las placas de un vehículo a partir de su serie.
     * 
     * @param vehiculo El vehículo del que se desea obtener las placas.
     * @return Las placas del vehículo especificado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public TramitePlacas obtenerPlacasPorSerieAuto(Vehiculo vehiculo) throws PersistenciaException;
    
    /**
     * Obtiene las placas de un vehículo a partir de su matrícula.
     * 
     * @param placas El trámite de placas que contiene la matrícula del vehículo.
     * @return Las placas del vehículo especificado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public TramitePlacas obtenerPlacasPorMatricula(TramitePlacas placas) throws PersistenciaException;
}
