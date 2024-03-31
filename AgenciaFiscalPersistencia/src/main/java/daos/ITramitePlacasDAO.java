/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.TramitePlacas;
import entidades.Vehiculo;
import java.util.List;

/**
 *
 * @author luiis
 */
public interface ITramitePlacasDAO extends ITramiteDAO{
    public List<TramitePlacas> obtenerTramitesPlacas(Persona personaTramite);
    public TramitePlacas obtenerPlacas(Vehiculo vehiculo);
}
