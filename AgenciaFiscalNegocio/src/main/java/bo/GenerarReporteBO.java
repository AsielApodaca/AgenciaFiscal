package bo;

import daos.ITramiteDAO;
import daos.TramiteDAO;
import negocioDTO.PersonaDTO;
import entidades.Persona;
import entidades.Tramite;
import entidades.Estado;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import iBo.IGenerarReporteBO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import negocioDTO.EstadoDTO;
import negocioDTO.TramiteDTO;

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
            Persona personaTramite = new Persona();
            if(personaTramiteDTO != null)
                personaTramite.setRfc(personaTramiteDTO.getRfc());
            List<Tramite> tramites = tramiteDAO.obtenerTramites(fechaDesde, fechaHasta, tipoTramite, personaTramite);
            
            List<TramiteDTO> tramitesDTO = new ArrayList<>();
            
            // Entidad tramite a Dto tramite
            for(Tramite tramite : tramites) {
                
                
                TramiteDTO tramiteDTO = new TramiteDTO() {};
                
                PersonaDTO personaDTO = new PersonaDTO();
                Persona persona = new Persona();
                personaDTO.setRfc(persona.getRfc());
                personaDTO.setNombreCompleto(persona.getNombreCompleto());
                ;
                EstadoDTO estadoDTO = null;
                switch(tramite.getEstado().toString()) {
                    case "ACTIVO":
                        estadoDTO = EstadoDTO.ACTIVO;
                    case "CADUCO":
                        estadoDTO = EstadoDTO.CADUCO;
                        break;
                    case "INACTIVO":
                        estadoDTO = EstadoDTO.INACTIVO;
                        break;
                    case "VIGENTE":
                        estadoDTO = EstadoDTO.VIGENTE;
                        break;
                    default:
                        break;
                }
                
                tramiteDTO.setPersona(personaDTO);
                tramiteDTO.setEstado(estadoDTO);
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
