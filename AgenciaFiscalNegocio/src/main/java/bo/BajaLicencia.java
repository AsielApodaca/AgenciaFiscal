/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import daos.TramiteLicenciaDAO;
import daos.TramiteLicenciaDAO;
import entidades.TramiteLicencia;
import entidades.Estado;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import negocioDTO.TramiteLicenciaDTO;
import negocioDTO.PersonaDTO;
import negocioDTO.EstadoDTO;
import iBo.IBajaLicencia;


public class BajaLicencia implements IBajaLicencia {
    private static TramiteLicenciaDAO TramiteLicenciaDao;

    public BajaLicencia() {
        BajaLicencia.TramiteLicenciaDao = new TramiteLicenciaDAO();
    }

    @Override
    public TramiteLicenciaDTO obtenerLicencia(TramiteLicenciaDTO licencia) throws NegocioException {
        TramiteLicencia licenciaConsultada;
        try {
            licenciaConsultada = new TramiteLicencia();
            licenciaConsultada.setNumLicencia(licencia.getNumLicencia());
            licenciaConsultada = TramiteLicenciaDao.obtenerLicenciaVigente(licenciaConsultada);
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

        return licenciaDTO;
    }

    @Override
    public boolean darDeBajaLicencia(TramiteLicenciaDTO licencia) throws NegocioException {
        try {
            TramiteLicencia licenciaADarDeBaja = new TramiteLicencia();
            licenciaADarDeBaja.setNumLicencia(licencia.getNumLicencia());
            licenciaADarDeBaja.setEstado(Estado.CADUCO);
            TramiteLicenciaDao.actualizarEstadoTramite(licenciaADarDeBaja);
            return true;
        } catch (PersistenciaException pe) {
            throw new NegocioException(pe.getMessage());
        }
    }
}
