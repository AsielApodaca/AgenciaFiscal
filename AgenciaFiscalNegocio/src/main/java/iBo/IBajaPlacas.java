
package iBo;

import negocioDTO.TramitePlacasDTO;

/**
 *
 * @author asielapodaca
 */
public interface IBajaPlacas {
    public TramitePlacasDTO obtenerPlacas(TramitePlacasDTO placas);
    
    public boolean darDeBajaPlacas(TramitePlacasDTO placas);
}
