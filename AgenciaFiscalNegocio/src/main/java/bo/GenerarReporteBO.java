package bo;

import daos.ITramiteDAO;
import daos.TramiteDAO;
import negocioDTO.PersonaDTO;
import entidades.Persona;
import entidades.Tramite;
import entidades.Estado;
import entidades.TramiteLicencia;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import iBo.IGenerarReporteBO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import negocioDTO.TramiteDTO;
import negocioDTO.TramiteLicenciaDTO;
import negocioDTO.TramitePlacasDTO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class GenerarReporteBO implements IGenerarReporteBO{

    private static ITramiteDAO tramiteDAO;
    
    public GenerarReporteBO() {
        this.tramiteDAO = new TramiteDAO();
    }
    
    @Override
    public List<TramiteDTO> obtenerTramites(Calendar fechaDesde, Calendar fechaHasta, String tipoTramite, PersonaDTO personaTramiteDTO) throws NegocioException {
        try {
            Persona personaTramite = null;
            if(personaTramiteDTO != null){
                personaTramite = new Persona(personaTramiteDTO.getRfc());
            }
            List<Tramite> tramites = tramiteDAO.obtenerTramites(fechaDesde, fechaHasta, tipoTramite, personaTramite);
            
            List<TramiteDTO> tramitesDTO = new ArrayList<>();
            
            // Entidad tramite a Dto tramite
            for (Tramite tramite : tramites) {
                TramiteDTO tramiteDTO;
                if (tramite instanceof TramiteLicencia) {
                    tramiteDTO = new TramiteLicenciaDTO();
                } else {
                    tramiteDTO = new TramitePlacasDTO();
                }
                
                PersonaDTO personaDTO = new PersonaDTO();
                Persona persona = tramite.getPersona();
                personaDTO.setRfc(persona.getRfc());
                personaDTO.setNombreCompleto(persona.getNombreCompleto());
                
                
                tramiteDTO.setPersona(personaDTO);
                tramiteDTO.setFechaEmision(tramite.getFechaEmision());
                tramiteDTO.setCostoMxn(tramite.getCostoMxn());
                
                tramitesDTO.add(tramiteDTO);
            }
            
            return tramitesDTO;
            
        } catch (PersistenciaException pe) {
            throw new NegocioException(pe.getMessage());
        }
        
    }

}
