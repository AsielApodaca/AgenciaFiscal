/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.TramitePlacas;

/**
 *
 * @author luiis
 */
public interface ITramitePlacas {
    public TramitePlacas obtenerTramitePlacas(Persona personaTramite);
    public TramitePlacas agregarTramitePlacas(TramitePlacas tramite);
    public boolean actualizarEstadoPlacas(TramitePlacas tramite);
    public void cerrarConexion();
}
