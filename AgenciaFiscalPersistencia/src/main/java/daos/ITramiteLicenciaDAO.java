/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.TramiteLicencia;

/**
 *
 * @author luiis
 */
public interface ITramiteLicenciaDAO {
    public TramiteLicencia obtenerTramiteLicencia(TramiteLicencia tramite);
    public void agregarTramiteLicencia(TramiteLicencia tramite);
}
