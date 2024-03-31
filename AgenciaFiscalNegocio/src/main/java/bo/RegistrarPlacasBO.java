/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import daos.ClaseConexion;
import daos.IPersonaDAO;
import daos.ITramiteDAO;
import daos.ITramiteLicenciaDAO;
import daos.ITramitePlacasDAO;
import daos.PersonaDAO;
import daos.TramiteDAO;
import daos.TramiteLicenciaDAO;
import daos.TramitePlacasDAO;
import entidades.Estado;
import entidades.Persona;
import entidades.TramiteLicencia;
import entidades.TramitePlacas;
import entidades.Vehiculo;
import iBo.IRegistrarPlacasBO;
import negocioDTO.EstadoDTO;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteDTO;
import negocioDTO.TramiteLicenciaDTO;
import negocioDTO.TramitePlacasDTO;
import negocioDTO.VehiculoDTO;

/**
 *
 * @author luiis
 */
public class RegistrarPlacasBO implements IRegistrarPlacasBO {

    private static ITramitePlacasDAO tramitePlacasDAO;
    private static ITramiteLicenciaDAO tramiteLicenciaDAO;
    private static IPersonaDAO personaDAO;
    
    public RegistrarPlacasBO(){
        tramitePlacasDAO=new TramitePlacasDAO();
        tramiteLicenciaDAO=new TramiteLicenciaDAO();
        personaDAO=new PersonaDAO();
    }
    
    @Override
    public boolean registrarPlacas(TramitePlacasDTO tramite) {
        Persona p=new Persona(tramite.getPersona().getRfc());
        p=personaDAO.obtenerPersona(p);
        if(p!=null){
            VehiculoDTO v=tramite.getVehiculo();
            Vehiculo vehiculo = new Vehiculo(
                    v.getSerie(),
                    v.getMarca(),
                    v.getLinea(),
                    v.getColor(),
                    v.getModelo(),
                    p);
            TramitePlacas placasNuevas=new TramitePlacas(
                    vehiculo,
                    tramite.getFechaEmision(), 
                    tramite.getCostoMxn(),
                    Estado.ACTIVO, 
                    p);
            return tramitePlacasDAO.registrarTramite(placasNuevas);
        }
        System.out.println("error al registrar las placas");
        return false;
    }

    @Override
    public TramitePlacasDTO obtenerPlacas(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo=new Vehiculo();
        vehiculo.setSerie(vehiculoDTO.getSerie());
        TramitePlacas placas=tramitePlacasDAO.obtenerPlacas(vehiculo);
        
        if(placas!=null){
            return new TramitePlacasDTO(
                    placas.getMatricula(),
                    placas.getFechaEmision(), 
                    placas.getCostoMxn(), 
                    EstadoDTO.ACTIVO);
        }
        return null;
    }

    @Override
    public TramiteLicenciaDTO obtenerLicenciaVigente(TramiteLicenciaDTO tramite) {
        TramiteLicencia licenciaBuscada=new TramiteLicencia();
        licenciaBuscada.setNumLicencia(tramite.getNumLicencia());
        TramiteLicencia licencia=tramiteLicenciaDAO.obtenerLicenciaVigente(licenciaBuscada);
        
        if(licencia!=null){
            TramiteDTO licenciaEncontrada=new TramiteLicenciaDTO(
                    licencia.getVigencia(),
                    licencia.getFechaEmision(),
                    licencia.getCostoMxn(),
                    EstadoDTO.ACTIVO);
            PersonaDTO persona=new PersonaDTO();
            persona.setNombreCompleto(licencia.getPersona().getNombreCompleto());
            persona.setRfc(licencia.getPersona().getRfc());
            licenciaEncontrada.setPersona(persona);
            return (TramiteLicenciaDTO)licenciaEncontrada;
        }
        return null;
    }
    
}
