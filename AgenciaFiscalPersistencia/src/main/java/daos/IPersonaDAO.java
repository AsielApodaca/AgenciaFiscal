/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.Persona;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author luiis
 */
public interface IPersonaDAO {
    public Persona obtenerPersona(Persona persona)throws PersistenciaException;
    public List<Persona> agregarPersonas()throws PersistenciaException;
    public List<Persona> buscarPersonasPorNombre(Persona persona)throws PersistenciaException;
    public List<Persona> buscarPersonasPorCURP(Persona persona)throws PersistenciaException;
    public List<Persona> buscarPersonasPorAnioNac(Persona persona)throws PersistenciaException;
    public Persona actualizarPersona(Persona persona)throws PersistenciaException;
    public boolean tablaPersonasEstaVacia() throws PersistenciaException;
}
