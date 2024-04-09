/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import daos.IPersonaDAO;
import daos.PersonaDAO;
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
    
    public ConsultasBO(){
        personaDAO=new PersonaDAO();
    }

    @Override
    public List<PersonaDTO> consultarPersonasPorNombre(PersonaDTO persona)throws NegocioException {
        Persona p=new Persona();
        p.setNombreCompleto(persona.getNombreCompleto());
        List<Persona> personas;
        try{
            personas=personaDAO.buscarPersonasPorNombre(p);
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
}
