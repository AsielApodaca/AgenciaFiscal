package iBo;

import excepciones.NegocioException;
import negocioDTO.TramitePlacasDTO;

/**
 *
 * @author asielapodaca
 */
public interface IBajaPlacasBO {
    public TramitePlacasDTO obtenerPlacas(TramitePlacasDTO placas) throws NegocioException;
    
    public boolean darDeBajaPlacas(TramitePlacasDTO placas) throws NegocioException;
}
