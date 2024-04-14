package bo;

import daos.ClaseConexion;
import iBo.IServicioConexion;

/**
 *
 * @author luiis
 */
public class ServicioConexion implements IServicioConexion {

    @Override
    public void cerrarConexion() {
        ClaseConexion.cerrarConexion();
    }
    
}
