/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author luiis
 */
public class ConsultasBO implements IConsultasBO {
    private static IPersonaDAO personaDAO;
    private static ITramiteDAO tramiteDAO;

    public ConsultasBO(){
        personaDAO=new PersonaDAO();
        tramiteDAO=new TramiteLicenciaDAO();
    }

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
                case "fechaNacimiento" -> {
                    p.setFechaNacimiento(persona.getFechaNacimiento());
                    personas=personaDAO.buscarPersonasPorFechaNac(p);
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
