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
import excepciones.NegocioException;
import excepciones.PersistenciaException;
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
    public PersonaDTO consultarPersonaPorRfc(PersonaDTO persona)  throws NegocioException{
//        if(!validaciones.validarRfcPersona(persona.getRfc())){
//            throw new NegocioException("El RFC ingresado no cumple con el formato correcto.");
//        }
        Persona personaConsultada;
        try {
            personaConsultada=personaDao.obtenerPersona(new Persona(persona.getRfc()));
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
        System.out.println("id persona: " + personaConsultada.getId());
        PersonaDTO personaDto = new PersonaDTO(personaConsultada.getRfc(),
                personaConsultada.getNombreCompleto(),
                personaConsultada.getFechaNacimiento(),
                personaConsultada.getCurp(),
                personaConsultada.getTelefono(),
                personaConsultada.esDiscapacitado()
        );
        return personaDto;
    }

    @Override
    public TramiteLicenciaDTO registrarLicencia(TramiteLicenciaDTO tramiteLicencia) throws NegocioException{
        PersonaDTO personaEnviada=tramiteLicencia.getPersona();
        Persona persona;
        try {
            persona = personaDao.obtenerPersona(new Persona(personaEnviada.getRfc()));
        }catch(PersistenciaException e){
            throw new NegocioException(e.getMessage());
        }
        
        TramiteLicencia tramite=new TramiteLicencia(tramiteLicencia.getFechaEmision(), 
                tramiteLicencia.getCostoMxn(),
                Estado.VIGENTE,
                persona
        );
        tramite.setVigencia(tramiteLicencia.getVigencia());
        tramite.setNumLicencia();
        try{
            if(tramiteLicenciaDao.registrarTramite(tramite)) {
                TramiteLicenciaDTO licenciaDto = new TramiteLicenciaDTO();
                licenciaDto.setNumLicencia(tramite.getNumLicencia());
                return licenciaDto;
            }
            return null;
        }catch(PersistenciaException e){
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public PersonaDTO actualizarDiscapacidadPersona(PersonaDTO persona) throws NegocioException {
        Persona personaAModificar;
        try{
            personaAModificar=personaDao.obtenerPersona(new Persona(persona.getRfc()));
        }catch(PersistenciaException e){
            throw new NegocioException(e.getMessage());
        }
        Persona personaModificada;
        try {
            personaModificada=personaDao.actualizarPersona(personaAModificar);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
        return new PersonaDTO(
                personaModificada.getRfc(),
                personaModificada.getNombreCompleto(),
                personaModificada.getFechaNacimiento(),
                personaModificada.getCurp(),
                personaModificada.getTelefono(),
                personaModificada.esDiscapacitado()
        );
    }

    @Override
    public List<PersonaDTO> obtenerPersonasRegistradas()throws NegocioException {
        List<Persona> personas;
        try{
            personas=personaDao.agregarPersonas();
        }catch(PersistenciaException e){
            throw new NegocioException(e.getMessage());
        }
        List<PersonaDTO> personasDTO = new ArrayList<>();
        for (Persona p : personas) {
            PersonaDTO persona = new PersonaDTO(
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

    @Override
    public TramiteLicenciaDTO obtenerTramiteLicencia(PersonaDTO personaTramite) throws NegocioException{ 
        Persona persona;
        try {
            persona=personaDao.obtenerPersona(new Persona(personaTramite.getRfc()));
            Object tramite = tramiteLicenciaDao.obtenerTramite(persona, "licencia");
            if(tramite == null) return null;
            TramiteLicencia tramiteLicencia=(TramiteLicencia)tramite;
            TramiteLicenciaDTO t= new TramiteLicenciaDTO(tramiteLicencia.getVigencia(),tramiteLicencia.getFechaEmision(),
                    tramiteLicencia.getCostoMxn(), EstadoDTO.ACTIVO);
            t.setPersona(personaTramite);
            return t;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public boolean actualizarEstadoLicencia(TramiteLicenciaDTO tramiteLicencia) throws NegocioException {
        try{
            Persona persona = personaDao.obtenerPersona(new Persona(tramiteLicencia.getPersona().getRfc()));
            Object tramite = tramiteLicenciaDao.obtenerTramite(persona, "licencia");
            return tramiteLicenciaDao.actualizarEstadoTramite((TramiteLicencia) tramite);
        }catch(PersistenciaException e){
            throw new NegocioException(e.getMessage());
        }
    }

//    @Override
//    public boolean modificarFechaVencimientoLicencia(TramiteLicenciaDTO tramiteLicencia) throws NegocioException {
//        ITramiteLicenciaDAO t=new TramiteLicenciaDAO();
//        try{
//            Persona persona = personaDao.obtenerPersona(new Persona(tramiteLicencia.getPersona().getRfc()));
//            Object tramite = tramiteLicenciaDao.obtenerTramite(persona, "licencia");
//            return t.actualizarFechaVencimiento((TramiteLicencia)tramite);
//        }catch(PersistenciaException p){
//            throw new NegocioException(p.getMessage());
//        }
//    }
    
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
