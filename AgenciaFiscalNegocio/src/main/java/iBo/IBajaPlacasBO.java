package iBo;

import excepciones.NegocioException;
import negocioDTO.TramitePlacasDTO;

/**
 * Interfaz que define métodos para la baja de placas en el sistema.
 * 
 * <p>Esta interfaz proporciona métodos para obtener detalles de placas y dar de baja placas en el sistema.</p>
 * 
 * @author asielapodaca
 */
public interface IBajaPlacasBO {
    /**
     * Obtiene los detalles de unas placas.
     * 
     * @param placas Las placas de las cuales se desean obtener los detalles.
     * @return Los detalles de las placas.
     * @throws NegocioException Si ocurre un error durante la obtención de los detalles de las placas.
     */
    public TramitePlacasDTO obtenerPlacas(TramitePlacasDTO placas) throws NegocioException;
    
    /**
     * Da de baja unas placas en el sistema.
     * 
     * @param placas Las placas que se desean dar de baja.
     * @return true si las placas se dieron de baja correctamente, false en caso contrario.
     * @throws NegocioException Si ocurre un error durante el proceso de dar de baja las placas.
     */
    public boolean darDeBajaPlacas(TramitePlacasDTO placas) throws NegocioException;
}
