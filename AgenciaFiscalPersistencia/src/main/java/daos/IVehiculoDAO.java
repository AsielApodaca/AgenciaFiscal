/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.Vehiculo;
import excepciones.PersistenciaException;

/**
 *
 * @author luiis
 */
public interface IVehiculoDAO {
    public Vehiculo obtenerVehiculo(Vehiculo vehiculo)throws PersistenciaException;
    //public void cerrarConexion()throws PersistenciaException;
}
