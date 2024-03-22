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
        Estado estado=null;
        if(tramiteLicencia.getEstado().equals(EstadoDTO.CADUCO))
            estado=Estado.CADUCO;
        else if(tramiteLicencia.getEstado().equals(EstadoDTO.VIGENTE))
            estado=Estado.VIGENTE;
        
        PersonaDTO personaEnviada=tramiteLicencia.getPersona();
        Persona persona=personaDao.obtenerPersona(new Persona(personaEnviada.getRfc()));
        
        TramiteLicencia tramite=new TramiteLicencia(tramiteLicencia.getVigencia(),
                tramiteLicencia.getFechaCaducidad(), 
                tramiteLicencia.getFechaEmision(), 
                tramiteLicencia.getCostoMxn(),
                estado,
                persona
        );
        
        return tramiteLicenciaDao.agregarTramiteLicencia(tramite)!=null;
    }

    @Override
    public void cerrarConexiones() {
        personaDao.cerrarConexion();
        tramiteLicenciaDao.cerrarConexion();
    }
    
    
}
