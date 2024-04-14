package bo;

import daos.IPersonaDAO;
import daos.ITramiteLicenciaDAO;
import daos.ITramitePlacasDAO;
import daos.IVehiculoDAO;
import daos.PersonaDAO;
import daos.TramiteLicenciaDAO;
import daos.TramitePlacasDAO;
import daos.VehiculoDAO;
import entidades.Estado;
import entidades.Persona;
import entidades.TramiteLicencia;
import entidades.TramitePlacas;
import entidades.Vehiculo;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import iBo.IRegistrarPlacasBO;
import negocioDTO.EstadoDTO;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteDTO;
import negocioDTO.TramiteLicenciaDTO;
import negocioDTO.TramitePlacasDTO;
import negocioDTO.VehiculoDTO;

/**
 * Implementación de la interfaz IRegistrarPlacasBO para realizar operaciones relacionadas con el registro de placas.
 * Esta clase se encarga de realizar operaciones como registrar placas, obtener placas por serie de auto, obtener licencia vigente,
 * obtener placas por matrícula, actualizar estado de placas anteriores y renovar placas.
 * @author Luiis
 */
public class RegistrarPlacasBO implements IRegistrarPlacasBO {

    private static ITramitePlacasDAO tramitePlacasDAO;
    private static ITramiteLicenciaDAO tramiteLicenciaDAO;
    private static IPersonaDAO personaDAO;
    private static IVehiculoDAO vehiculoDAO;
    
    /**
     * Constructor por defecto que inicializa los objetos de acceso a datos para trámites de placas, trámites de licencia, personas y vehículos.
     */
    public RegistrarPlacasBO(){
        tramitePlacasDAO=new TramitePlacasDAO();
        tramiteLicenciaDAO=new TramiteLicenciaDAO();
        personaDAO=new PersonaDAO();
        vehiculoDAO=new VehiculoDAO();
    }
    
    /**
     * Registra placas nuevas en el sistema.
     * @param tramite Datos del trámite de placas a registrar.
     * @return Los datos del trámite de placas registrado.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante el registro.
     */
    @Override
    public TramitePlacasDTO registrarPlacas(TramitePlacasDTO tramite) throws NegocioException{
        Persona p=new Persona(tramite.getPersona().getRfc());
        try {
            p=personaDAO.obtenerPersona(p);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }

        VehiculoDTO v = tramite.getVehiculo();
        Vehiculo vehiculo = new Vehiculo(
                v.getSerie(),
                v.getMarca(),
                v.getLinea(),
                v.getColor(),
                v.getModelo(),
                p);
        TramitePlacas placasNuevas = new TramitePlacas(
                vehiculo,
                tramite.getFechaEmision(),
                tramite.getCostoMxn(),
                Estado.ACTIVO,
                p);
        placasNuevas.setMatricula();
        try {
            if(tramitePlacasDAO.registrarTramite(placasNuevas)) {
                TramitePlacasDTO placasRegistradasDto = new TramitePlacasDTO();
                placasRegistradasDto.setMatricula(placasNuevas.getMatricula());
                return placasRegistradasDto;
            }
            return null;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Obtiene un trámite de placas por serie de auto.
     * @param vehiculoDTO Datos del vehículo para el cual se consultará el trámite de placas.
     * @return Los datos del trámite de placas asociado al vehículo, o null si no existe.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la consulta.
     */
    @Override
    public TramitePlacasDTO obtenerPlacasPorSerieAuto(VehiculoDTO vehiculoDTO) throws NegocioException{
        Vehiculo vehiculo=new Vehiculo();
        vehiculo.setSerie(vehiculoDTO.getSerie());
        TramitePlacas placasObtenidas=null;
        try {
            placasObtenidas=tramitePlacasDAO.obtenerPlacasPorSerieAuto(vehiculo);
            if(placasObtenidas == null) return null;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
        TramitePlacasDTO placasDTO = new TramitePlacasDTO(
                placasObtenidas.getMatricula(),
                placasObtenidas.getFechaEmision(),
                placasObtenidas.getCostoMxn(),
                EstadoDTO.ACTIVO);

        vehiculo = placasObtenidas.getVehiculo();
        VehiculoDTO vehiculoObt = new VehiculoDTO(
                vehiculo.getSerie(),
                vehiculo.getMarca(),
                vehiculo.getLinea(),
                vehiculo.getColor(),
                vehiculo.getModelo());
        placasDTO.setVehiculo(vehiculoObt);

        return placasDTO;
    }

    /**
     * Obtiene una licencia de conducir vigente.
     * @param tramite Datos del trámite de licencia para el cual se buscará la licencia vigente.
     * @return Los datos del trámite de licencia vigente asociado al trámite, o null si no existe.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la consulta.
     */
    @Override
    public TramiteLicenciaDTO obtenerLicenciaVigente(TramiteLicenciaDTO tramite)throws NegocioException {
        TramiteLicencia licenciaBuscada=new TramiteLicencia();
        licenciaBuscada.setNumLicencia(tramite.getNumLicencia());
        TramiteLicencia licencia=null;
        try {
            licencia=tramiteLicenciaDAO.obtenerLicenciaVigente(licenciaBuscada);
            if(licencia == null) return null;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
         TramiteDTO licenciaEncontrada = new TramiteLicenciaDTO(
                licencia.getVigencia(),
                licencia.getFechaEmision(),
                licencia.getCostoMxn(),
                EstadoDTO.ACTIVO);
        Persona personaObtenida = licencia.getPersona();
        PersonaDTO persona = new PersonaDTO();
        persona.setId(personaObtenida.getId());
        persona.setNombreCompleto(personaObtenida.getNombreCompleto());
        persona.setRfc(personaObtenida.getRfc());
        licenciaEncontrada.setPersona(persona);
        return (TramiteLicenciaDTO) licenciaEncontrada;
    }

    /**
     * Obtiene un trámite de placas por matrícula.
     * @param placasAnteriores Datos del trámite de placas para el cual se buscará la información.
     * @return Los datos del trámite de placas asociado a la matrícula, o null si no existe.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la consulta.
     */
    @Override
    public TramitePlacasDTO obtenerPlacasPorMatricula(TramitePlacasDTO placasAnteriores) throws NegocioException{
        TramitePlacas tramite=new TramitePlacas();
        tramite.setMatricula(placasAnteriores.getMatricula());
        try {
            tramite=tramitePlacasDAO.obtenerPlacasPorMatricula(tramite);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
        
        TramitePlacasDTO placasObtenidasDTO = new TramitePlacasDTO(
                tramite.getMatricula(),
                tramite.getFechaEmision(),
                tramite.getCostoMxn(),
                EstadoDTO.ACTIVO
        );
        Vehiculo v = tramite.getVehiculo();
        placasObtenidasDTO.setVehiculo(new VehiculoDTO(
                v.getSerie(),
                v.getMarca(),
                v.getLinea(),
                v.getColor(),
                v.getModelo()
        ));
        return placasObtenidasDTO;
    }

    /**
     * Actualiza el estado de trámites de placas anteriores.
     * @param placasAnteriores Datos del trámite de placas para el cual se actualizará el estado.
     * @return true si la actualización se realiza con éxito, false en caso contrario.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la actualización.
     */
    @Override
    public boolean actualizarEstadoPlacasAnteriores(TramitePlacasDTO placasAnteriores) throws NegocioException{
        TramitePlacas placas=new TramitePlacas();
        placas.setMatricula(placasAnteriores.getMatricula());
        TramitePlacas tramite;
        try{
            tramite=tramitePlacasDAO.obtenerPlacasPorMatricula(placas);
            return tramitePlacasDAO.actualizarEstadoTramite(tramite);
        }catch(PersistenciaException e){
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Renueva placas en el sistema.
     * @param placas Datos del trámite de placas a renovar.
     * @return Los datos del trámite de placas renovadas.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la renovación.
     */
    @Override
    public TramitePlacasDTO renovarPlacas(TramitePlacasDTO placas)throws NegocioException {
        PersonaDTO persona=placas.getPersona();
        Persona p;
        try {
            p=personaDAO.obtenerPersona(new Persona(persona.getRfc()));
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
        VehiculoDTO v=placas.getVehiculo();
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setSerie(v.getSerie());
        try{
            vehiculo=vehiculoDAO.obtenerVehiculo(vehiculo);
        }catch(PersistenciaException e){
            throw new NegocioException(e.getMessage());
        }
        
        TramitePlacas placasNuevas = new TramitePlacas(
                vehiculo,
                placas.getFechaEmision(),
                placas.getCostoMxn(),
                Estado.ACTIVO,
                p
        );
        placasNuevas.setMatricula();
        try{
            if(tramitePlacasDAO.renovarPlacas(placasNuevas)) {
                TramitePlacasDTO placasGeneradasDto = new TramitePlacasDTO();
                placasGeneradasDto.setMatricula(placasNuevas.getMatricula());
                return placasGeneradasDto;
            }
            return null;
        }catch(PersistenciaException e){
            throw new NegocioException(e.getMessage());
        }
    }
    
}
