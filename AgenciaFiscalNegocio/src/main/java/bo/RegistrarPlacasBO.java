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
import daos.IVehiculoDAO;
import daos.PersonaDAO;
import daos.TramiteDAO;
import daos.TramiteLicenciaDAO;
import daos.TramitePlacasDAO;
import daos.VehiculoDAO;
import entidades.Estado;
import entidades.Persona;
import entidades.Tramite;
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
    private static IVehiculoDAO vehiculoDAO;
    
    public RegistrarPlacasBO(){
        tramitePlacasDAO=new TramitePlacasDAO();
        tramiteLicenciaDAO=new TramiteLicenciaDAO();
        personaDAO=new PersonaDAO();
        vehiculoDAO=new VehiculoDAO();
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
            placasNuevas.setMatricula();
            return tramitePlacasDAO.registrarTramite(placasNuevas);
        }
        System.out.println("error al registrar las placas");
        return false;
    }

    @Override
    public TramitePlacasDTO obtenerPlacasPorSerieAuto(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo=new Vehiculo();
        vehiculo.setSerie(vehiculoDTO.getSerie());
        TramitePlacas placasObtenidas=tramitePlacasDAO.obtenerPlacasPorSerieAuto(vehiculo);
        
        if(placasObtenidas!=null){
            TramitePlacasDTO placasDTO=new TramitePlacasDTO(
                    placasObtenidas.getMatricula(),
                    placasObtenidas.getFechaEmision(),
                    placasObtenidas.getCostoMxn(),
                    EstadoDTO.ACTIVO);
            
            vehiculo=placasObtenidas.getVehiculo();
            VehiculoDTO vehiculoObt=new VehiculoDTO(
                    vehiculo.getSerie(),
                    vehiculo.getMarca(),
                    vehiculo.getLinea(),
                    vehiculo.getColor(),
                    vehiculo.getModelo());
            placasDTO.setVehiculo(vehiculoObt);
            
            return placasDTO;
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
            Persona personaObtenida=licencia.getPersona();
            PersonaDTO persona=new PersonaDTO();
            persona.setId(personaObtenida.getId());
            persona.setNombreCompleto(personaObtenida.getNombreCompleto());
            persona.setRfc(personaObtenida.getRfc());
            licenciaEncontrada.setPersona(persona);
            return (TramiteLicenciaDTO)licenciaEncontrada;
        }
        return null;
    }

    @Override
    public TramitePlacasDTO obtenerPlacasPorMatricula(TramitePlacasDTO placasAnteriores) {
        TramitePlacas tramite=new TramitePlacas();
        tramite.setMatricula(placasAnteriores.getMatricula());
        
        tramite=tramitePlacasDAO.obtenerPlacasPorMatricula(tramite);
        if(tramite!=null){
            TramitePlacasDTO placasObtenidasDTO=new TramitePlacasDTO(
                    tramite.getMatricula(),
                    tramite.getFechaEmision(),
                    tramite.getCostoMxn(),
                    EstadoDTO.ACTIVO
            );
            Vehiculo v=tramite.getVehiculo();
            placasObtenidasDTO.setVehiculo(new VehiculoDTO(
                    v.getSerie(),
                    v.getMarca(),
                    v.getLinea(),
                    v.getColor(),
                    v.getModelo()
            ));
            return placasObtenidasDTO;
        }
        return null;
    }

    @Override
    public boolean actualizarEstadoPlacasAnteriores(TramitePlacasDTO placasAnteriores) {
        //Persona personaTramite=new Persona(placasAnteriores.getPersona().getRfc());
        TramitePlacas placas=new TramitePlacas();
        placas.setMatricula(placasAnteriores.getMatricula());
        TramitePlacas tramite=tramitePlacasDAO.obtenerPlacasPorMatricula(placas);
        System.out.println(tramite.toString());
        return tramitePlacasDAO.actualizarEstadoTramite(tramite);
    }

    @Override
    public boolean renovarPlacas(TramitePlacasDTO placas) {
        PersonaDTO persona=placas.getPersona();
        Persona p=personaDAO.obtenerPersona(new Persona(persona.getRfc()));
        VehiculoDTO v=placas.getVehiculo();
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setSerie(v.getSerie());
        vehiculo=vehiculoDAO.obtenerVehiculo(vehiculo);
        TramitePlacas placasNuevas = new TramitePlacas(
                vehiculo,
                placas.getFechaEmision(),
                placas.getCostoMxn(),
                Estado.ACTIVO,
                p
        );
        placasNuevas.setMatricula();
        //placasViejas=tramitePlacasDAO.obtenerPlacasPorMatricula(placasViejas);
        return tramitePlacasDAO.renovarPlacas(placasNuevas);
    }
    
}
