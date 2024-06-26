package bo;

import daos.IPersonaDAO;
import daos.ITramiteDAO;
import daos.ITramiteLicenciaDAO;
import daos.PersonaDAO;
import daos.TramiteLicenciaDAO;
import negocioDTO.EstadoDTO;
import entidades.Persona;
import entidades.Estado;
import entidades.TramiteLicencia;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import iBo.iRegistrarLicenciaBO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteLicenciaDTO;

/**
 * Implementación de la interfaz iRegistrarLicenciaBO para realizar operaciones relacionadas con el registro de licencias.
 * Esta clase se encarga de realizar operaciones como consultar personas por RFC, registrar licencias, actualizar discapacidad de persona, obtener personas registradas,
 * obtener trámite de licencia, actualizar estado de licencia y modificar fecha de vencimiento de licencia.
 * Además, contiene una clase interna para realizar validaciones relacionadas con el registro de licencias.
 * @author Asiel Apodaca Monge
 */
public class RegistrarLicenciaBO implements iRegistrarLicenciaBO{

    private static IPersonaDAO personaDao;
    private static ITramiteDAO tramiteLicenciaDao;
    
    /**
     * Constructor por defecto que inicializa los objetos de acceso a datos para personas y trámites de licencia.
     */
    public RegistrarLicenciaBO() {
        personaDao=new PersonaDAO();
        tramiteLicenciaDao=new TramiteLicenciaDAO();
    }
    
    /**
     * Consulta una persona por su RFC.
     * @param persona Datos de la persona a consultar, con el RFC especificado.
     * @return Los datos de la persona consultada.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la consulta.
     */
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

    /**
     * Registra una licencia en el sistema.
     * @param tramiteLicencia Datos del trámite de licencia a registrar.
     * @return Los datos del trámite de licencia registrado.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante el registro.
     */
    @Override
    public TramiteLicenciaDTO registrarLicencia(TramiteLicenciaDTO tramiteLicencia) throws NegocioException{
        PersonaDTO personaEnviada=tramiteLicencia.getPersona();
        Persona persona;
        try {
            persona = personaDao.obtenerPersona(new Persona(personaEnviada.getRfc()));
        }catch(PersistenciaException e){
            throw new NegocioException(e.getMessage());
        }
        Calendar fecha=tramiteLicencia.getFechaEmision();
        fecha.set(Calendar.MONTH, fecha.get(Calendar.MONTH) - 1);
        TramiteLicencia tramite=new TramiteLicencia(fecha, 
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

    /**
     * Actualiza la discapacidad de una persona en el sistema.
     * @param persona Datos de la persona cuya discapacidad se actualizará.
     * @return Los datos de la persona actualizada.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la actualización.
     */
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

    /**
     * Obtiene una lista de personas registradas en el sistema.
     * @return Una lista de personas registradas.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la consulta.
     */
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

    /**
     * Obtiene el trámite de licencia asociado a una persona.
     * @param personaTramite Datos de la persona para la cual se consultará el trámite de licencia.
     * @return Los datos del trámite de licencia asociado a la persona, o null si no existe.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la consulta.
     */
    @Override
    public TramiteLicenciaDTO obtenerTramiteLicencia(PersonaDTO personaTramite) throws NegocioException{ 
        Persona persona;
        try {
            persona=personaDao.obtenerPersona(new Persona(personaTramite.getRfc()));
            Object tramite = tramiteLicenciaDao.obtenerTramite(persona, "licencia");
            if(tramite == null) return null;
            TramiteLicencia tramiteLicencia = (TramiteLicencia) tramite;
            //System.out.println(tramiteLicencia.toString());
            //tramiteLicencia.setFechaCaducidad(((TramiteLicencia)tramiteLicencia).getFechaCaducidad());
            TramiteLicenciaDTO t = new TramiteLicenciaDTO(tramiteLicencia.getVigencia(), tramiteLicencia.getFechaEmision(),
                    tramiteLicencia.getCostoMxn(), EstadoDTO.ACTIVO);
            t.setPersona(personaTramite);
            t.setFechaCaducidad(tramiteLicencia.getFechaCaducidad());
            t.setNumLicencia(tramiteLicencia.getNumLicencia());
            return t;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Actualiza el estado de una licencia en el sistema.
     * @param tramiteLicencia Datos del trámite de licencia cuyo estado se actualizará.
     * @return true si la actualización se realiza con éxito, false en caso contrario.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la actualización.
     */
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

    /**
     * Modifica la fecha de vencimiento de una licencia en el sistema.
     * @param tramiteLicencia Datos del trámite de licencia cuya fecha de vencimiento se modificará.
     * @return true si la modificación se realiza con éxito, false en caso contrario.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la modificación.
     */
    @Override
    public boolean modificarFechaVencimientoLicencia(TramiteLicenciaDTO tramiteLicencia) throws NegocioException {
        ITramiteLicenciaDAO t=new TramiteLicenciaDAO();
        try{
            Persona persona = personaDao.obtenerPersona(new Persona(tramiteLicencia.getPersona().getRfc()));
            Object tramite = tramiteLicenciaDao.obtenerTramite(persona, "licencia");
            TramiteLicencia tramiteL=(TramiteLicencia)tramite;
            tramiteL.setFechaCaducidad(tramiteLicencia.getFechaCaducidad());
            return t.actualizarFechaVencimiento(tramiteL);
        }catch(PersistenciaException p){
            throw new NegocioException(p.getMessage());
        }
    }
    
    /**
     * Clase interna para realizar validaciones relacionadas con el registro de licencias.
     */
    class ValidacionesRegistrarLicencia{
        /**
         * Valida el RFC de una persona según ciertos criterios.
         * @param rfc El RFC a validar.
         * @return true si el RFC cumple con los criterios de validación, false en caso contrario.
         */
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
