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
public interface IPersonaDAO {
    public Persona obtenerPersona(Persona persona);
    public List<Persona> agregarPersonas();
    public void agregarTramite(Persona persona, Tramite tramite);
}
