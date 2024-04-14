package bo;

import daos.TramiteLicenciaDAO;
import entidades.TramiteLicencia;
import entidades.Estado;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import negocioDTO.TramiteLicenciaDTO;
import negocioDTO.PersonaDTO;
import negocioDTO.EstadoDTO;
import iBo.IBajaLicencia;

/**
 * Clase que implementa la interfaz IBajaLicencia para gestionar la baja de licencias de conducir.
 * 
 * <p>Esta clase proporciona métodos para obtener y dar de baja licencias de conducir en el sistema.</p>
 * 
 * <p>Utiliza un objeto TramiteLicenciaDAO para interactuar con la capa de acceso a datos y realizar las operaciones necesarias.</p>
 * 
 * <p>Los métodos de esta clase pueden lanzar una excepción del tipo {@link NegocioException} si ocurre algún error durante su ejecución.</p>
 * 
 * @author Asiel Apodaca Monge
 */
public class BajaLicencia implements IBajaLicencia {
    private static TramiteLicenciaDAO TramiteLicenciaDao;

    /**
     * Constructor de la clase BajaLicencia.
     * 
     * <p>Inicializa el objeto TramiteLicenciaDAO utilizado para interactuar con la capa de acceso a datos.</p>
     */
    public BajaLicencia() {
        BajaLicencia.TramiteLicenciaDao = new TramiteLicenciaDAO();
    }

    /**
     * Obtiene información sobre una licencia de conducir.
     * 
     * @param licencia El objeto de tipo {@link TramiteLicenciaDTO} que contiene la información de la licencia a consultar.
     * @return El objeto {@link TramiteLicenciaDTO} que representa la licencia consultada.
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    @Override
    public TramiteLicenciaDTO obtenerLicencia(TramiteLicenciaDTO licencia) throws NegocioException {
        TramiteLicencia licenciaConsultada;
        try {
            licenciaConsultada = new TramiteLicencia();
            licenciaConsultada.setNumLicencia(licencia.getNumLicencia());
            licenciaConsultada = TramiteLicenciaDao.obtenerLicencia(licenciaConsultada);
        } catch (PersistenciaException pe) {
            throw new NegocioException(pe.getMessage());
        }

        
        TramiteLicenciaDTO licenciaDTO = new TramiteLicenciaDTO();
        PersonaDTO persona = new PersonaDTO();
        EstadoDTO estado;

        estado = switch (licenciaConsultada.getEstado().toString()) {
            case "VIGENTE" -> EstadoDTO.VIGENTE;
            case "CADUCO" -> EstadoDTO.CADUCO;
            default -> null;
        };

        persona.setNombreCompleto(licenciaConsultada.getPersona().getNombreCompleto());
        licenciaDTO.setNumLicencia(licenciaConsultada.getNumLicencia());
        licenciaDTO.setEstado(estado);
        licenciaDTO.setPersona(persona);
        licenciaDTO.setId(licenciaConsultada.getId());
        
        System.out.println(licenciaDTO.getId());

        return licenciaDTO;
    }

    /**
     * Realiza la baja de una licencia de conducir.
     * 
     * @param licencia El objeto de tipo {@link TramiteLicenciaDTO} que representa la licencia a dar de baja.
     * @return `true` si la baja se realiza correctamente, `false` en caso contrario.
     * @throws NegocioException Si ocurre un error durante la baja.
     */
    @Override
    public boolean darDeBajaLicencia(TramiteLicenciaDTO licencia) throws NegocioException {
        try {
            TramiteLicencia licenciaADarDeBaja = new TramiteLicencia();
            licenciaADarDeBaja.setNumLicencia(licencia.getNumLicencia());
            licenciaADarDeBaja.setEstado(Estado.CADUCO);
            licenciaADarDeBaja.setId(licencia.getId());
            return TramiteLicenciaDao.actualizarEstadoTramite(licenciaADarDeBaja);
        } catch (PersistenciaException pe) {
            throw new NegocioException(pe.getMessage());
        }
    }
}
