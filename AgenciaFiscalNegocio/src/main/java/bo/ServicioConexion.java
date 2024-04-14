package bo;

import daos.ClaseConexion;
import iBo.IServicioConexion;

/**
 * Implementación de la interfaz IServicioConexion para cerrar la conexión con la base de datos.
 * Esta clase se encarga de cerrar la conexión utilizando la clase ClaseConexion.
 * @author Luiis
 */
public class ServicioConexion implements IServicioConexion {

    /**
     * Cierra la conexión con la base de datos.
     */
    @Override
    public void cerrarConexion() {
        ClaseConexion.cerrarConexion();
    }
    
}
