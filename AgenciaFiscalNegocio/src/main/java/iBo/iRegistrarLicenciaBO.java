package iBo;

import excepciones.NegocioException;
import java.util.List;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteLicenciaDTO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public interface iRegistrarLicenciaBO {
    public PersonaDTO consultarPersonaPorRfc(PersonaDTO persona) throws NegocioException;
    public TramiteLicenciaDTO registrarLicencia(TramiteLicenciaDTO tramiteLicencia) throws NegocioException;
    public PersonaDTO actualizarDiscapacidadPersona(PersonaDTO persona) throws NegocioException;
    public List<PersonaDTO> obtenerPersonasRegistradas() throws NegocioException;
    public TramiteLicenciaDTO obtenerTramiteLicencia(PersonaDTO personaTramite) throws NegocioException;
    public boolean actualizarEstadoLicencia(TramiteLicenciaDTO tramiteLicencia) throws NegocioException;
}
