package iBo;

import negocioDTO.TramiteLicenciaDTO;
import excepciones.NegocioException;

/**
 * Interfaz que define métodos para la baja de licencias en el sistema.
 */
public interface IBajaLicencia {
    /**
     * Obtiene los detalles de una licencia.
     * 
     * @param licencia La licencia de la cual se desean obtener los detalles.
     * @return Los detalles de la licencia.
     * @throws NegocioException Si ocurre un error durante la obtención de los detalles de la licencia.
     */
    TramiteLicenciaDTO obtenerLicencia(TramiteLicenciaDTO licencia) throws NegocioException;
    
    /**
     * Da de baja una licencia en el sistema.
     * 
     * @param licencia La licencia que se desea dar de baja.
     * @return true si la licencia se dio de baja correctamente, false en caso contrario.
     * @throws NegocioException Si ocurre un error durante el proceso de dar de baja la licencia.
     */
    boolean darDeBajaLicencia(TramiteLicenciaDTO licencia) throws NegocioException;
}
