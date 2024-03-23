package bo;

import daos.IPersonaDAO;
import daos.ITramiteLicenciaDAO;
import daos.PersonaDAO;
import daos.TramiteLicenciaDAO;
import negocioDTO.EstadoDTO;
import entidades.Persona;
import entidades.Estado;
import entidades.TramiteLicencia;
import iBo.iRegistrarLicenciaBO;
import java.util.ArrayList;
import java.util.List;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteLicenciaDTO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class RegistrarLicenciaBO implements iRegistrarLicenciaBO{

    private static IPersonaDAO personaDao;
    private static ITramiteLicenciaDAO tramiteLicenciaDao;
    
    public RegistrarLicenciaBO() {
        personaDao=new PersonaDAO();
        tramiteLicenciaDao=new TramiteLicenciaDAO();
    }

    
    @Override
    public PersonaDTO consultarPersonaPorRfc(String Rfc) {
        Persona personaConsultada=personaDao.obtenerPersona(new Persona(Rfc));
        if(personaConsultada!=null){
            System.out.println("id persona: "+personaConsultada.getId());
            PersonaDTO persona = new PersonaDTO(personaConsultada.getRfc(),
                    personaConsultada.getNombreCompleto(),
                    personaConsultada.getFechaNacimiento(),
                    personaConsultada.getCurp(),
                    personaConsultada.getTelefono(),
                    personaConsultada.esDiscapacitado()
            );
            return persona;
        }
        return null;
    }

    @Override
    public boolean registrarLicencia(TramiteLicenciaDTO tramiteLicencia) {
        PersonaDTO personaEnviada=tramiteLicencia.getPersona();
        Persona persona=personaDao.obtenerPersona(new Persona(personaEnviada.getRfc()));
        
        TramiteLicencia tramite=new TramiteLicencia(tramiteLicencia.getVigencia(),
                tramiteLicencia.getFechaCaducidad(), 
                tramiteLicencia.getFechaEmision(), 
                tramiteLicencia.getCostoMxn(),
                Estado.VIGENTE,
                persona
        );
        
        return tramiteLicenciaDao.agregarTramiteLicencia(tramite)!=null;
    }

    @Override
    public void cerrarConexiones() {
        personaDao.cerrarConexion();
        tramiteLicenciaDao.cerrarConexion();
    }

    @Override
    public PersonaDTO actualizarDiscapacidadPersona(PersonaDTO persona) {
        Persona personaAModificar=personaDao.obtenerPersona(new Persona(persona.getRfc()));
        Persona personaModificada=personaDao.actualizarPersona(personaAModificar);
        if(personaModificada!=null){
            return new PersonaDTO(
                    personaModificada.getRfc(), 
                    personaModificada.getNombreCompleto(), 
                    personaModificada.getFechaNacimiento(),
                    personaModificada.getCurp(),
                    personaModificada.getTelefono(),
                    personaModificada.esDiscapacitado()
            );
        }
        return null;
    }

    @Override
    public List<PersonaDTO> obtenerPersonasRegistradas() {
        List<Persona> personas=personaDao.agregarPersonas();
        
        if(personas!=null){
            List<PersonaDTO> personasDTO=new ArrayList<>();
            for(Persona p:personas){
                PersonaDTO persona=new PersonaDTO(
                        p.getRfc(),
                        p.getNombreCompleto(), 
                        p.getFechaNacimiento(), 
                        p.getCurp(), 
                        p.getTelefono(), 
                        p.esDiscapacitado());
                personasDTO.add(persona);
            }
            return personasDTO;
        }
        return null;
    }
    
    
}
