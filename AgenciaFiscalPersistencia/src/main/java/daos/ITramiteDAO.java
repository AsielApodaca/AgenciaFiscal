/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.Tramite;
import java.util.List;

/**
 *
 * @author luiis
 */
public interface ITramiteDAO {
    public List<Tramite> obtenerTramites(Persona personaTramite);
    public Object obtenerTramite(Persona personaTramite, String tipoTramite);
    public boolean registrarTramite(Tramite tramite);
    public boolean actualizarEstadoTramite(Tramite tramite);
    //public void cerrarConexion();
}
