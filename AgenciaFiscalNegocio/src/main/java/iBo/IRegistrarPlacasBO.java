package iBo;

import excepciones.NegocioException;
import negocioDTO.TramiteLicenciaDTO;
import negocioDTO.TramitePlacasDTO;
import negocioDTO.VehiculoDTO;

/**
 *
 * @author luiis
 */
public interface IRegistrarPlacasBO {
    public TramitePlacasDTO registrarPlacas(TramitePlacasDTO placas) throws NegocioException;
    public TramitePlacasDTO renovarPlacas(TramitePlacasDTO placas)throws NegocioException;
    public TramitePlacasDTO obtenerPlacasPorSerieAuto(VehiculoDTO vehiculo)throws NegocioException;
    public TramitePlacasDTO obtenerPlacasPorMatricula(TramitePlacasDTO placasAnteriores)throws NegocioException;
    public TramiteLicenciaDTO obtenerLicenciaVigente(TramiteLicenciaDTO licencia)throws NegocioException;
    public boolean actualizarEstadoPlacasAnteriores(TramitePlacasDTO placasAnteriores)throws NegocioException;
}
