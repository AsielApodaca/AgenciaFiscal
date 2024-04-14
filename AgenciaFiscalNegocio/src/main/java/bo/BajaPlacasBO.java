package bo;

import daos.ITramitePlacasDAO;
import daos.TramitePlacasDAO;
import entidades.TramitePlacas;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import negocioDTO.EstadoDTO;
import negocioDTO.PersonaDTO;
import negocioDTO.TramitePlacasDTO;
import iBo.IBajaPlacasBO;

/**
 * Clase que implementa la interfaz IBajaPlacasBO y se encarga de la gestión de las bajas de placas.
 *
 * @author Asiel Apodaca Monge
 */
public class BajaPlacasBO implements IBajaPlacasBO{

    /**
     * Instancia de la clase TramitePlacasDAO que se utiliza para acceder a los datos de trámites de placas.
     */
    private static ITramitePlacasDAO tramitePlacasDao;

    /**
     * Constructor de la clase BajaPlacasBO.
     *
     * Inicializa la variable tramitePlacasDao con una nueva instancia de la clase TramitePlacasDAO.
     */
    public BajaPlacasBO() {
        this.tramitePlacasDao = new TramitePlacasDAO();
    }

    /**
     * Método que obtiene la información de un trámite de placas a partir de la matrícula.
     *
     * @param placas Objeto TramitePlacasDTO que contiene la matrícula del trámite a consultar.
     * @return Objeto TramitePlacasDTO con la información del trámite consultado o null si no se encuentra.
     * @throws NegocioException Si se produce un error al consultar el trámite.
     */
    @Override
    public TramitePlacasDTO obtenerPlacas(TramitePlacasDTO placas) throws NegocioException {
        TramitePlacas placasConsultada;

        try {
            placasConsultada = new TramitePlacas();
            placasConsultada.setMatricula(placas.getMatricula());
            placasConsultada = tramitePlacasDao.obtenerPlacasPorMatricula(placasConsultada);
        } catch (PersistenciaException pe) {
            throw new NegocioException(pe.getMessage());
        }

        if (placasConsultada == null) {
            return null;
        }

        TramitePlacasDTO placasDTO = new TramitePlacasDTO();

        PersonaDTO persona = new PersonaDTO();
        EstadoDTO estado;

        switch (placasConsultada.getEstado().toString()) {
            case "ACTIVO":
                estado = EstadoDTO.ACTIVO;
                break;
            case "INACTIVO":
                estado = EstadoDTO.INACTIVO;
                break;
            default:
                estado = null;
                break;
        }

        persona.setNombreCompleto(placasConsultada.getPersona().getNombreCompleto());
        persona.setRfc(placasConsultada.getPersona().getRfc());
        placasDTO.setMatricula(placasConsultada.getMatricula());
        placasDTO.setEstado(estado);
        placasDTO.setPersona(persona);

        return placasDTO;
    }

    /**
     * Método que da de baja un trámite de placas.
     *
     * @param placas Objeto TramitePlacasDTO que contiene la matrícula del trámite a dar de baja.
     * @return true si el trámite se dio de baja correctamente, false si no se encontró el trámite o hubo un error al actualizar el estado.
     * @throws NegocioException Si se produce un error al actualizar el estado del trámite.
     */
    @Override
    public boolean darDeBajaPlacas(TramitePlacasDTO placas) throws NegocioException {
        TramitePlacas tramite = new TramitePlacas();
        tramite.setMatricula(placas.getMatricula());

        try {
            tramite = tramitePlacasDao.obtenerPlacasPorMatricula(tramite);
            if (tramite == null) {
                return false;
            }
            return tramitePlacasDao.actualizarEstadoTramite(tramite);
        } catch (PersistenciaException pe) {
            throw new NegocioException(pe.getMessage());
        }
    }
}
