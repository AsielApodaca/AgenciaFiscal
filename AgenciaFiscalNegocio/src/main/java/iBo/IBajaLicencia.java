package iBo;

import negocioDTO.TramiteLicenciaDTO;
import excepciones.NegocioException;

public interface IBajaLicencia {
    TramiteLicenciaDTO obtenerLicencia(TramiteLicenciaDTO licencia) throws NegocioException;
    boolean darDeBajaLicencia(TramiteLicenciaDTO licencia) throws NegocioException;
}