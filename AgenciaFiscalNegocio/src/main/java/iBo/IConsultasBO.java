package iBo;

import excepciones.NegocioException;
import java.util.List;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteDTO;

/**
 *
 * @author luiis
 */
public interface IConsultasBO {
    public List<PersonaDTO> consultarPersonasPorCriterio(PersonaDTO persona, String criterioBusqueda)throws NegocioException;
    public List<TramiteDTO> consultarTramitesPorPersona(PersonaDTO persona)throws NegocioException;
}
