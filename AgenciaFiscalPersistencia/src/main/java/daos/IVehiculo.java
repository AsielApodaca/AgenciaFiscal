/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.Vehiculo;

/**
 *
 * @author luiis
 */
public interface IVehiculo {
    public boolean agregarVehiculo(Vehiculo vehiculo);
    public Vehiculo obtenerVehiculo(Vehiculo vehiculo);
    public void cerrarConexion();
}