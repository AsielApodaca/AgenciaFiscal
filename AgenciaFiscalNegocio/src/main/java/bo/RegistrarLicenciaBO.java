package bo;

import daos.ClaseConexion;
import daos.IPersonaDAO;
import daos.ITramiteDAO;
import daos.ITramiteLicenciaDAO;
import daos.PersonaDAO;
import daos.TramiteLicenciaDAO;
import negocioDTO.EstadoDTO;
import entidades.Persona;
import entidades.Estado;
import entidades.Tramite;
import entidades.TramiteLicencia;
import iBo.iRegistrarLicenciaBO;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteLicenciaDTO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class RegistrarLicenciaBO implements iRegistrarLicenciaBO{

    private static IPersonaDAO personaDao;
    private static ITramiteDAO tramiteLicenciaDao;
    private ValidacionesRegistrarLicencia validaciones;
    public RegistrarLicenciaBO() {
        personaDao=new PersonaDAO();
        tramiteLicenciaDao=new TramiteLicenciaDAO();
        validaciones=new ValidacionesRegistrarLicencia();
    }
    
    @Override
    public PersonaDTO consultarPersonaPorRfc(PersonaDTO persona) throws IllegalArgumentException{
        if(!validaciones.validarRfcPersona(persona.getRfc())){
            throw new IllegalArgumentException("El RFC ingresado no cumple con el formato correcto.");
        }
        Persona personaConsultada=personaDao.obtenerPersona(new Persona(persona.getRfc()));
        if(personaConsultada!=null){
            System.out.println("id persona: "+personaConsultada.getId());
            PersonaDTO personaDto = new PersonaDTO(personaConsultada.getRfc(),
                    personaConsultada.getNombreCompleto(),
                    personaConsultada.getFechaNacimiento(),
                    personaConsultada.getCurp(),
                    personaConsultada.getTelefono(),
                    personaConsultada.esDiscapacitado()
            );
            return personaDto;
        }
        return null;
    }

    @Override
    public boolean registrarLicencia(TramiteLicenciaDTO tramiteLicencia) {
        PersonaDTO personaEnviada=tramiteLicencia.getPersona();
        Persona persona=personaDao.obtenerPersona(new Persona(personaEnviada.getRfc()));
        
        TramiteLicencia tramite=new TramiteLicencia(tramiteLicencia.getFechaEmision(), 
                tramiteLicencia.getCostoMxn(),
                Estado.VIGENTE,
                persona
        );
        tramite.setVigencia(tramiteLicencia.getVigencia());
        tramite.setNumLicencia();
        return tramiteLicenciaDao.registrarTramite(tramite);
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

    @Override
    public TramiteLicenciaDTO obtenerTramiteLicencia(PersonaDTO personaTramite) { 
        Persona persona=personaDao.obtenerPersona(new Persona(personaTramite.getRfc()));
        Object tramite=tramiteLicenciaDao.obtenerTramite(persona,"licencia");
        if(tramite!=null){
            TramiteLicencia tramiteLicencia=(TramiteLicencia)tramite;
            TramiteLicenciaDTO t= new TramiteLicenciaDTO(tramiteLicencia.getVigencia(),tramiteLicencia.getFechaEmision(),
                    tramiteLicencia.getCostoMxn(), EstadoDTO.ACTIVO);
            t.setPersona(personaTramite);
            return t;
        }
        return null;
    }

    @Override
    public boolean actualizarEstadoLicencia(TramiteLicenciaDTO tramiteLicencia) {
        Persona persona=personaDao.obtenerPersona(new Persona(tramiteLicencia.getPersona().getRfc()));
        Object tramite=tramiteLicenciaDao.obtenerTramite(persona,"licencia");
        return tramiteLicenciaDao.actualizarEstadoTramite((TramiteLicencia)tramite);
    }
    
    class ValidacionesRegistrarLicencia{
        public boolean validarRfcPersona(String rfc){
            String nombre=rfc.substring(0, 4);
            String fechaN=rfc.substring(4, 10);
            String clave=rfc.substring(10);
            String regexFecha="^([4-9][0-9]|0[0-6])-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
            String regexNombre="^[A-Z][AEIOU]([A-Z]{2})$";
            String regexClave="^([A-Z]|[0-9]){3}$";
            Pattern p1=Pattern.compile(regexFecha);
            Pattern p2=Pattern.compile(regexNombre);
            Pattern p3=Pattern.compile(regexClave);
            return (p1.matcher(fechaN).matches()) && (p2.matcher(nombre).matches()) && 
                    (p3.matcher(clave).matches());
        }
    }
}
