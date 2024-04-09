/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.TramitePlacas;
import entidades.Vehiculo;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author luiis
 */
public interface ITramitePlacasDAO extends ITramiteDAO{
    public List<TramitePlacas> obtenerTramitesPlacas(Persona personaTramite)throws PersistenciaException;
    public boolean renovarPlacas(TramitePlacas tramite)throws PersistenciaException;
    public TramitePlacas obtenerPlacasPorSerieAuto(Vehiculo vechiculo)throws PersistenciaException;
    public TramitePlacas obtenerPlacasPorMatricula(TramitePlacas placas)throws PersistenciaException;
    
}
