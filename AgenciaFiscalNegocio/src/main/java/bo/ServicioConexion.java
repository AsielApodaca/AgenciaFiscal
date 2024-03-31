/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import daos.ClaseConexion;
import iBo.IServicioConexion;

/**
 *
 * @author luiis
 */
public class ServicioConexion implements IServicioConexion {

    @Override
    public void cerrarConexion() {
        ClaseConexion.cerrarConexion();
    }
    
}
