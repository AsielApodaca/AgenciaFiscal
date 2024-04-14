package daos;

import entidades.Persona;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Esta interfaz define los métodos que deben ser implementados por las clases que 
 * proporcionan acceso a los datos de las entidades Persona en la base de datos.
 * 
 * author luiis
 */
public interface IPersonaDAO {
    
    /**
     * Obtiene una persona de la base de datos según los atributos de la persona proporcionada.
     * 
     * @param persona La persona cuyos atributos se utilizarán para buscar en la base de datos.
     * @return La persona encontrada en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public Persona obtenerPersona(Persona persona) throws PersistenciaException;
    
    /**
     * Agrega personas a la base de datos.
     * 
     * @return Una lista de personas agregadas a la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la inserción en la base de datos.
     */
    public List<Persona> agregarPersonas() throws PersistenciaException;
    
    /**
     * Busca personas en la base de datos por su nombre.
     * 
     * @param persona La persona cuyo nombre se utilizará para buscar en la base de datos.
     * @return Una lista de personas encontradas en la base de datos que coinciden con el nombre proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public List<Persona> buscarPersonasPorNombre(Persona persona) throws PersistenciaException;
    
    /**
     * Busca personas en la base de datos por su CURP (Clave Única de Registro de Población).
     * 
     * @param persona La persona cuyo CURP se utilizará para buscar en la base de datos.
     * @return Una lista de personas encontradas en la base de datos que coinciden con el CURP proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public List<Persona> buscarPersonasPorCURP(Persona persona) throws PersistenciaException;
    
    /**
     * Busca personas en la base de datos por su año de nacimiento.
     * 
     * @param persona La persona cuyo año de nacimiento se utilizará para buscar en la base de datos.
     * @return Una lista de personas encontradas en la base de datos que nacieron en el año proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    public List<Persona> buscarPersonasPorAnioNac(Persona persona) throws PersistenciaException;
    
    /**
     * Actualiza la información de una persona en la base de datos.
     * 
     * @param persona La persona cuya información se actualizará en la base de datos.
     * @return La persona actualizada.
     * @throws PersistenciaException Si ocurre un error durante la actualización en la base de datos.
     */
    public Persona actualizarPersona(Persona persona) throws PersistenciaException;
    
    /**
     * Verifica si la tabla de personas en la base de datos está vacía.
     * 
     * @return true si la tabla de personas está vacía, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error durante la verificación en la base de datos.
     */
    public boolean tablaPersonasEstaVacia() throws PersistenciaException;
}
