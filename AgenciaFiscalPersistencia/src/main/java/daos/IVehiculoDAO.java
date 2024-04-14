package daos;

import entidades.Vehiculo;
import excepciones.PersistenciaException;

/**
 * Esta interfaz define el método que debe ser implementado por las clases que 
 * proporcionan acceso a los datos de los vehículos en la base de datos.
 * 
 * author luiis
 */
public interface IVehiculoDAO {
    
    /**
     * Obtiene un vehículo de la base de datos según los atributos del vehículo proporcionado.
     * 
     * @param vehiculo El vehículo cuyos atributos se utilizarán para buscar en la base de datos.
     * @return El vehículo encontrado en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public Vehiculo obtenerVehiculo(Vehiculo vehiculo) throws PersistenciaException;
}
