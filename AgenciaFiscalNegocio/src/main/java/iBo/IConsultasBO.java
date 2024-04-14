package iBo;

import excepciones.NegocioException;
import java.util.List;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteDTO;

/**
 * Interfaz que define métodos para realizar consultas en el sistema.
 * 
 * <p>Esta interfaz proporciona métodos para consultar personas y tramites en el sistema.</p>
 * 
 * @author luiis
 */
public interface IConsultasBO {
    /**
     * Consulta personas por criterio de búsqueda.
     * 
     * @param persona El objeto persona que contiene los criterios de búsqueda.
     * @param criterioBusqueda El criterio de búsqueda utilizado para filtrar las personas.
     * @return Una lista de personas que coinciden con el criterio de búsqueda.
     * @throws NegocioException Si ocurre un error durante la consulta de personas.
     */
    public List<PersonaDTO> consultarPersonasPorCriterio(PersonaDTO persona, String criterioBusqueda)throws NegocioException;
    
    /**
     * Consulta tramites asociados a una persona.
     * 
     * @param persona La persona de la cual se desean consultar los tramites.
     * @return Una lista de tramites asociados a la persona.
     * @throws NegocioException Si ocurre un error durante la consulta de tramites.
     */
    public List<TramiteDTO> consultarTramitesPorPersona(PersonaDTO persona)throws NegocioException;
}
