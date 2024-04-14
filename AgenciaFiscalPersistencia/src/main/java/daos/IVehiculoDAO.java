package daos;

import entidades.Vehiculo;
import excepciones.PersistenciaException;

/**
 *
 * @author luiis
 */
public interface IVehiculoDAO {
    public Vehiculo obtenerVehiculo(Vehiculo vehiculo)throws PersistenciaException;
}
