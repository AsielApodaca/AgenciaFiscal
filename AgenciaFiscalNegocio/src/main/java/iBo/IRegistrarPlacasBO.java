package iBo;

import excepciones.NegocioException;
import negocioDTO.TramiteLicenciaDTO;
import negocioDTO.TramitePlacasDTO;
import negocioDTO.VehiculoDTO;

/**
 * Interfaz que define métodos para el registro y gestión de trámites relacionados con placas de vehículos en el sistema.
 * 
 * <p>Esta interfaz proporciona métodos para registrar, renovar y obtener información sobre trámites de placas de vehículos, así como para gestionar el estado de placas anteriores.</p>
 * 
 * <p>Los métodos de esta interfaz pueden lanzar una excepción de tipo NegocioException en caso de errores durante su ejecución.</p>
 * 
 * @author luiis
 */
public interface IRegistrarPlacasBO {
    /**
     * Registra nuevas placas de vehículo en el sistema.
     * 
     * @param placas El trámite de placas que se desea registrar.
     * @return El trámite de placas registrado.
     * @throws NegocioException Si ocurre un error durante el registro de las placas.
     */
    public TramitePlacasDTO registrarPlacas(TramitePlacasDTO placas) throws NegocioException;
    
    /**
     * Renueva las placas de vehículo en el sistema.
     * 
     * @param placas Las placas que se desean renovar.
     * @return El trámite de placas renovadas.
     * @throws NegocioException Si ocurre un error durante la renovación de las placas.
     */
    public TramitePlacasDTO renovarPlacas(TramitePlacasDTO placas)throws NegocioException;
    
    /**
     * Obtiene las placas de un vehículo específico por su serie.
     * 
     * @param vehiculo El vehículo del cual se desean obtener las placas.
     * @return El trámite de placas asociado al vehículo.
     * @throws NegocioException Si ocurre un error durante la obtención de las placas.
     */
    public TramitePlacasDTO obtenerPlacasPorSerieAuto(VehiculoDTO vehiculo)throws NegocioException;
    
    /**
     * Obtiene las placas de vehículo por su matrícula.
     * 
     * @param placasAnteriores Las placas anteriores de las cuales se desea obtener la información.
     * @return El trámite de placas asociado a la matrícula especificada.
     * @throws NegocioException Si ocurre un error durante la obtención de las placas.
     */
    public TramitePlacasDTO obtenerPlacasPorMatricula(TramitePlacasDTO placasAnteriores)throws NegocioException;
    
    /**
     * Obtiene la licencia de conducir vigente asociada a un trámite de licencia.
     * 
     * @param licencia La licencia de la cual se desea obtener la versión vigente.
     * @return La licencia de conducir vigente.
     * @throws NegocioException Si ocurre un error durante la obtención de la licencia vigente.
     */
    public TramiteLicenciaDTO obtenerLicenciaVigente(TramiteLicenciaDTO licencia)throws NegocioException;
    
    /**
     * Actualiza el estado de las placas anteriores en el sistema.
     * 
     * @param placasAnteriores Las placas anteriores cuyo estado se desea actualizar.
     * @return true si se actualizó correctamente el estado de las placas anteriores, false en caso contrario.
     * @throws NegocioException Si ocurre un error durante la actualización del estado de las placas anteriores.
     */
    public boolean actualizarEstadoPlacasAnteriores(TramitePlacasDTO placasAnteriores)throws NegocioException;
}
