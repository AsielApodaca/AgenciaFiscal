/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.TramiteLicencia;

/**
 *
 * @author luiis
 */
public interface ITramiteLicenciaDAO {
    public TramiteLicencia obtenerTramiteLicencia(Persona personaTramite);
    public TramiteLicencia agregarTramiteLicencia(TramiteLicencia tramite);
    public boolean actualizarEstadoLicencia(TramiteLicencia tramite);
    public void cerrarConexion();
}
