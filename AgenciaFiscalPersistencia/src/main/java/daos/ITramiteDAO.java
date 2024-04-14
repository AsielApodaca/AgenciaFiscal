package daos;

import entidades.Persona;
import entidades.Tramite;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author luiis
 */
public interface ITramiteDAO {
    public List<Tramite> obtenerTramites(Calendar fechaDesde, Calendar fechaHasta, 
            String tipoTramite, Persona personaTramite) throws PersistenciaException;

    public List<Tramite> obtenerTramitesPorPersona(Persona personaTramite)throws PersistenciaException;

    public Tramite obtenerTramite(Persona personaTramite, String tipoTramite)throws PersistenciaException;
    public List<Tramite> obtenerTramites() throws PersistenciaException;
    public boolean registrarTramite(Tramite tramite)throws PersistenciaException;
    public boolean actualizarEstadoTramite(Tramite tramite)throws PersistenciaException;
}
