/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.Tramite;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author luiis
 */
public interface ITramiteDAO {
    public List<Tramite> obtenerTramites(Persona personaTramite)throws PersistenciaException;
    public Tramite obtenerTramite(Persona personaTramite, String tipoTramite)throws PersistenciaException;
    public List<Tramite> obtenerTramitePorTipo(String tipoTramite) throws PersistenciaException;
    public boolean registrarTramite(Tramite tramite)throws PersistenciaException;
    public boolean actualizarEstadoTramite(Tramite tramite)throws PersistenciaException;
    //public void cerrarConexion();
}
