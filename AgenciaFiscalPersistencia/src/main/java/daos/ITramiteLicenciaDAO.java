package daos;

import entidades.Persona;
import entidades.TramiteLicencia;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author luiis
 */
public interface ITramiteLicenciaDAO extends ITramiteDAO{
    public List<TramiteLicencia> obtenerTramitesLicencia(Persona personaTramite)throws PersistenciaException;
    public TramiteLicencia obtenerLicenciaVigente(TramiteLicencia licencia)throws PersistenciaException;
    public TramiteLicencia obtenerLicencia(TramiteLicencia licencia)throws PersistenciaException;
    public boolean actualizarFechaVencimiento(TramiteLicencia licencia)throws PersistenciaException;
}
