/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.Tramite;
import entidades.TramiteLicencia;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author luiis
 */
public interface ITramiteLicenciaDAO extends ITramiteDAO{
    public List<TramiteLicencia> obtenerTramitesLicencia(Persona personaTramite)throws PersistenciaException;
    public TramiteLicencia obtenerLicenciaVigente(TramiteLicencia licencia)throws PersistenciaException;
    public TramiteLicencia obtenerLicencia(TramiteLicencia licencia)throws PersistenciaException;
    public boolean actualizarFechaVencimiento(TramiteLicencia licencia)throws PersistenciaException;
}
