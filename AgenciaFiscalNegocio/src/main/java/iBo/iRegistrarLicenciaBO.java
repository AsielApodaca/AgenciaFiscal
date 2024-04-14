package iBo;

import excepciones.NegocioException;
import java.util.List;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteLicenciaDTO;

/**
 * Interfaz que define métodos para el registro y gestión de licencias de conducir.
 * 
 * <p>Esta interfaz proporciona métodos para consultar, registrar y gestionar licencias de conducir en el sistema.</p>
 * 
 * <p>Es responsabilidad de las clases que implementan esta interfaz proporcionar la lógica necesaria para realizar estas operaciones.</p>
 * 
 * <p>Los métodos definidos en esta interfaz permiten consultar personas por su RFC, registrar nuevas licencias, actualizar la discapacidad de una persona,
 * obtener la lista de personas registradas, obtener información sobre un trámite de licencia, actualizar el estado de una licencia y modificar la fecha de vencimiento de una licencia.</p>
 * 
 * <p>Estos métodos pueden lanzar una excepción del tipo {@link NegocioException} si ocurre algún error durante su ejecución.</p>
 * 
 * @author Asiel Apodaca Monge
 */
public interface iRegistrarLicenciaBO {
    /**
     * Consulta una persona por su RFC.
     * 
     * @param persona El objeto de tipo {@link PersonaDTO} que contiene el RFC de la persona a consultar.
     * @return El objeto {@link PersonaDTO} que representa a la persona consultada.
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    public PersonaDTO consultarPersonaPorRfc(PersonaDTO persona) throws NegocioException;
    
    /**
     * Registra una nueva licencia de conducir.
     * 
     * @param tramiteLicencia El objeto de tipo {@link TramiteLicenciaDTO} que representa la nueva licencia a registrar.
     * @return El objeto {@link TramiteLicenciaDTO} que representa la licencia recién registrada.
     * @throws NegocioException Si ocurre un error durante el registro.
     */
    public TramiteLicenciaDTO registrarLicencia(TramiteLicenciaDTO tramiteLicencia) throws NegocioException;
    
    /**
     * Actualiza la discapacidad de una persona.
     * 
     * @param persona El objeto de tipo {@link PersonaDTO} que contiene la información actualizada de la persona.
     * @return El objeto {@link PersonaDTO} que representa a la persona con la discapacidad actualizada.
     * @throws NegocioException Si ocurre un error durante la actualización.
     */
    public PersonaDTO actualizarDiscapacidadPersona(PersonaDTO persona) throws NegocioException;
    
    /**
     * Obtiene la lista de todas las personas registradas en el sistema.
     * 
     * @return Una lista de objetos {@link PersonaDTO} que representan a todas las personas registradas.
     * @throws NegocioException Si ocurre un error durante la obtención de la lista.
     */
    public List<PersonaDTO> obtenerPersonasRegistradas() throws NegocioException;
    
    /**
     * Obtiene información sobre un trámite de licencia de conducir asociado a una persona.
     * 
     * @param personaTramite El objeto de tipo {@link PersonaDTO} que contiene la información de la persona asociada al trámite.
     * @return El objeto {@link TramiteLicenciaDTO} que representa el trámite de licencia de conducir asociado a la persona.
     * @throws NegocioException Si ocurre un error durante la obtención de la información del trámite.
     */
    public TramiteLicenciaDTO obtenerTramiteLicencia(PersonaDTO personaTramite) throws NegocioException;
    
    /**
     * Actualiza el estado de una licencia de conducir.
     * 
     * @param tramiteLicencia El objeto de tipo {@link TramiteLicenciaDTO} que representa la licencia de conducir a actualizar.
     * @return `true` si la actualización se realiza correctamente, `false` en caso contrario.
     * @throws NegocioException Si ocurre un error durante la actualización del estado.
     */
    public boolean actualizarEstadoLicencia(TramiteLicenciaDTO tramiteLicencia) throws NegocioException;
    
    /**
     * Modifica la fecha de vencimiento de una licencia de conducir.
     * 
     * @param tramiteLicencia El objeto de tipo {@link TramiteLicenciaDTO} que representa la licencia de conducir cuya fecha de vencimiento se va a modificar.
     * @return `true` si la modificación se realiza correctamente, `false` en caso contrario.
     * @throws NegocioException Si ocurre un error durante la modificación de la fecha de vencimiento.
     */
    public boolean modificarFechaVencimientoLicencia(TramiteLicenciaDTO tramiteLicencia) throws NegocioException;
}
