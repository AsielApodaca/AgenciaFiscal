package bo;

import daos.IPersonaDAO;
import daos.ITramiteDAO;
import daos.PersonaDAO;
import daos.TramiteLicenciaDAO;
import entidades.Estado;
import entidades.Persona;
import entidades.Tramite;
import entidades.TramiteLicencia;
import entidades.TramitePlacas;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import iBo.IConsultasBO;
import java.util.ArrayList;
import java.util.List;
import negocioDTO.EstadoDTO;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteDTO;
import negocioDTO.TramiteLicenciaDTO;
import negocioDTO.TramitePlacasDTO;

/**
 * Implementación de la interfaz IConsultasBO que proporciona métodos para realizar consultas relacionadas con personas y trámites.
 * Esta clase se encarga de manejar las operaciones de negocio relacionadas con la consulta de personas y trámites.
 * @author luiis
 */
public class ConsultasBO implements IConsultasBO {
    private static IPersonaDAO personaDAO;
    private static ITramiteDAO tramiteDAO;

    /**
     * Constructor por defecto que inicializa los objetos de acceso a datos para persona y trámite.
     */
    public ConsultasBO(){
        personaDAO=new PersonaDAO();
        tramiteDAO=new TramiteLicenciaDAO();
    }

    /**
     * Consulta personas según un criterio especificado y un objeto de tipo PersonaDTO.
     * @param persona Objeto de tipo PersonaDTO que contiene los datos de la persona a consultar.
     * @param criterio Criterio de búsqueda utilizado para filtrar la consulta ("nombre", "curp" o "anioNacimiento").
     * @return Una lista de objetos de tipo PersonaDTO que coinciden con el criterio de búsqueda especificado.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la consulta.
     */
    @Override
    public List<PersonaDTO> consultarPersonasPorCriterio(PersonaDTO persona, String criterio)throws NegocioException {
        Persona p=new Persona();
        
        p.setNombreCompleto(persona.getNombreCompleto());
        List<Persona> personas=new ArrayList<>();
        try{
            switch (criterio) {
                case "nombre" -> {
                    p.setNombreCompleto(persona.getNombreCompleto());
                    personas=personaDAO.buscarPersonasPorNombre(p);
                }
                case "curp" -> {
                    p.setCurp(persona.getCurp());
                    personas=personaDAO.buscarPersonasPorCURP(p);
                }
                case "anioNacimiento" -> {
                    p.setFechaNacimiento(persona.getFechaNacimiento());
                    personas=personaDAO.buscarPersonasPorAnioNac(p);
                }
            }
        }catch(PersistenciaException e){
            throw new NegocioException(e.getMessage());
        }
                
        if (!personas.isEmpty()) {
            return personasBOToDTO(personas);
        }
        return null;
    }
    
    /**
     * Convierte una lista de objetos de tipo Persona a una lista de objetos de tipo PersonaDTO.
     * @param personas Lista de objetos de tipo Persona a convertir.
     * @return Una lista de objetos de tipo PersonaDTO.
     */
    private List<PersonaDTO> personasBOToDTO(List<Persona> personas){
        PersonaDTO personaDTO;
        List<PersonaDTO> personasDTO=new ArrayList<>();
        for(Persona persona:personas){
            personaDTO = new PersonaDTO(
                    persona.getRfc(),
                    persona.getNombreCompleto(),
                    persona.getFechaNacimiento(),
                    persona.getCurp(),
                    persona.getTelefono(),
                    persona.esDiscapacitado()
            );
            personaDTO.setTramites(tramiteBoToDTO(persona.getTramites()));
            personasDTO.add(personaDTO);
        }
     return personasDTO;   
    }
    
    /**
     * Convierte una lista de objetos de tipo Tramite a una lista de objetos de tipo TramiteDTO.
     * @param tramites Lista de objetos de tipo Tramite a convertir.
     * @return Una lista de objetos de tipo TramiteDTO.
     */
    private List<TramiteDTO> tramiteBoToDTO(List<Tramite> tramites){
        TramiteDTO tramiteDTO= null;
        EstadoDTO estado;
        List<TramiteDTO> tramitesDTO=new ArrayList<>();
        for(Tramite tramite:tramites){
            if (tramite.getClass().equals(TramiteLicencia.class)) {
                if (!tramite.getEstado().equals(Estado.VIGENTE)) {
                    estado = EstadoDTO.VIGENTE;
                } else {
                    estado = EstadoDTO.CADUCO;
                }
                tramiteDTO = new TramiteLicenciaDTO(
                        tramite.getFechaEmision(),
                        tramite.getCostoMxn(),
                        estado
                );
            } else if (tramite.getClass().equals(TramitePlacas.class)) {
                if (!tramite.getEstado().equals(Estado.ACTIVO)) {
                    estado = EstadoDTO.ACTIVO;
                } else {
                    estado = EstadoDTO.INACTIVO;
                }
                tramiteDTO = new TramitePlacasDTO(
                        tramite.getFechaEmision(),
                        tramite.getCostoMxn(),
                        estado
                );
            } 
            tramitesDTO.add(tramiteDTO);
        }
        
        return tramitesDTO;
    }

    /**
     * Consulta trámites realizados por una persona específica.
     * @param persona Objeto de tipo PersonaDTO que contiene los datos de la persona cuyos trámites se desean consultar.
     * @return Una lista de objetos de tipo TramiteDTO que representan los trámites realizados por la persona especificada.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la consulta.
     */
    @Override
    public List<TramiteDTO> consultarTramitesPorPersona(PersonaDTO persona) throws NegocioException {
        Persona personaBO=new Persona();
        personaBO.setNombreCompleto(persona.getNombreCompleto());
        personaBO.setRfc(persona.getRfc());
        try{
            List<Tramite> tramites=tramiteDAO.obtenerTramitesPorPersona(personaBO);
            if(!tramites.isEmpty()){
                return tramiteBoToDTO(tramites);
            }
            return null;
        }catch(PersistenciaException e){
            throw new NegocioException(e.getMessage());
        }
    }
}
