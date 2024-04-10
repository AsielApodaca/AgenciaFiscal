package bo;

import daos.ITramitePlacasDAO;
import daos.TramitePlacasDAO;
import entidades.Tramite;
import entidades.Estado;
import entidades.TramitePlacas;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import negocioDTO.EstadoDTO;
import negocioDTO.PersonaDTO;
import negocioDTO.TramitePlacasDTO;
import iBo.IBajaPlacasBO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class BajaPlacasBO implements IBajaPlacasBO{

    private static ITramitePlacasDAO tramitePlacasDao;
    
    public BajaPlacasBO() {
        this.tramitePlacasDao = new TramitePlacasDAO();
    }
    
    @Override
    public TramitePlacasDTO obtenerPlacas(TramitePlacasDTO placas) throws NegocioException{
        
        TramitePlacas placasConsultada;
        try {
            placasConsultada = new TramitePlacas();
            placasConsultada.setMatricula(placas.getMatricula());
            placasConsultada = tramitePlacasDao.obtenerPlacasPorMatricula(placasConsultada);
        } catch (PersistenciaException pe) {
            throw new NegocioException(pe.getMessage());
        }
        
        TramitePlacasDTO placasDTO = new TramitePlacasDTO();
        
        
        
        PersonaDTO persona = new PersonaDTO();
        EstadoDTO estado;
        switch(placasConsultada.getEstado().toString()){
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
        placasDTO.setMatricula(placasConsultada.getMatricula());
        placasDTO.setEstado(estado);
        placasDTO.setPersona(persona);
        
        return placasDTO;
    }

    @Override
    public boolean darDeBajaPlacas(TramitePlacasDTO placas) throws NegocioException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
