package daos;

import entidades.Persona;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Esta clase implementa la interfaz IPersonaDAO y proporciona métodos para 
 * acceder a los datos de las personas en la base de datos.
 * 
 * author luiis
 */
public class PersonaDAO implements IPersonaDAO {

    private final EntityManager em;
    private final CriteriaBuilder cb;
    private final static Logger LOG = Logger.getLogger(PersonaDAO.class.getName());
    
    public PersonaDAO(){
        em = ClaseConexion.getEntityManager();
        cb = em.getCriteriaBuilder();
    }
    
    /**
     * Obtiene una persona de la base de datos según los atributos de la persona proporcionada.
     * 
     * @param persona La persona cuyos atributos se utilizarán para buscar en la base de datos.
     * @return La persona encontrada en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    @Override
    public Persona obtenerPersona(Persona persona) throws PersistenciaException {
        CriteriaQuery<Persona> criteria = cb.createQuery(Persona.class);
        Root<Persona> root = criteria.from(Persona.class);
        
        Predicate predicate = cb.equal(root.get("rfc"), persona.getRfc());
        criteria.select(root).where(predicate);
        
        TypedQuery<Persona> query = em.createQuery(criteria);
        try {
            Persona personaConsultada = query.getSingleResult();
            return personaConsultada;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrió un error al buscar el registro de la persona");
        }
    }

    /**
     * Agrega personas a la base de datos mediante un procedimiento almacenado.
     * 
     * @return Una lista de las personas agregadas a la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la inserción en la base de datos.
     */
    @Override
    public List<Persona> agregarPersonas() throws PersistenciaException {
        StoredProcedureQuery spc = em.createStoredProcedureQuery("sp_insertar_personas", Persona.class);
        em.getTransaction().begin();
        try {
            if (spc.execute()) {
                List<Persona> personasAgregadas = spc.getResultList();
                em.getTransaction().commit();
                return personasAgregadas;
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        throw new PersistenciaException("Ocurrió un error al registrar a las personas");
    }
    
    /**
     * Actualiza una persona en la base de datos.
     * 
     * @param persona La persona cuya información se actualizará en la base de datos.
     * @return La persona actualizada en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la actualización en la base de datos.
     */
    @Override
    public Persona actualizarPersona(Persona persona) throws PersistenciaException {
        Persona personaBuscada = em.find(Persona.class, persona.getId());
        if (personaBuscada != null) {
            try {
                em.getTransaction().begin();
                personaBuscada.setTieneDiscapacidad(true);
                em.getTransaction().commit();
                return personaBuscada; 
            } catch (Exception e) {
                em.getTransaction().rollback();
                LOG.log(Level.SEVERE, e.getMessage(), e);
                throw new PersistenciaException("Ocurrió un error al actualizar a la persona");
            }
        }
        throw new PersistenciaException("No se encontró el registro de la persona");
    }

    /**
     * Obtiene una lista de personas de la base de datos cuyo nombre coincide con el proporcionado.
     * 
     * @param persona La persona con el nombre a buscar en la base de datos.
     * @return Una lista de personas cuyos nombres coinciden con el proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    @Override
    public List<Persona> buscarPersonasPorNombre(Persona persona) throws PersistenciaException {
        System.out.println("consulta personas por nombre");
        StoredProcedureQuery spc = em.createStoredProcedureQuery("sp_buscar_personas_nombre", Persona.class);
        spc.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        spc.setParameter("nombre", persona.getNombreCompleto());
        try {
            if (spc.execute()) {
                List<Persona> personasObtenidas = spc.getResultList();
                return personasObtenidas;
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        throw new PersistenciaException("Ocurrió un error al realizar la consulta");
    }

    /**
     * Obtiene una lista de personas de la base de datos cuya CURP coincide con la proporcionada.
     * 
     * @param persona La persona con la CURP a buscar en la base de datos.
     * @return Una lista de personas cuyas CURPs coinciden con la proporcionada.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    @Override
    public List<Persona> buscarPersonasPorCURP(Persona persona) throws PersistenciaException {
        System.out.println("consulta personas por CURP");
        StoredProcedureQuery spc = em.createStoredProcedureQuery("sp_buscar_personas_curp", Persona.class);
        spc.registerStoredProcedureParameter("curpB", String.class, ParameterMode.IN);
        spc.setParameter("curpB", persona.getCurp());
        try {
            if (spc.execute()) {
                List<Persona> personasObtenidas = spc.getResultList();
                return personasObtenidas;
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        throw new PersistenciaException("Ocurrió un error al realizar la consulta");
    }

    /**
     * Obtiene una lista de personas de la base de datos cuyo año de nacimiento coincide con el proporcionado.
     * 
     * @param persona La persona con el año de nacimiento a buscar en la base de datos.
     * @return Una lista de personas cuyos años de nacimiento coinciden con el proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    @Override
    public List<Persona> buscarPersonasPorAnioNac(Persona persona) throws PersistenciaException {
        System.out.println("consulta personas por año de nacimiento");
        StoredProcedureQuery spc = em.createStoredProcedureQuery("sp_buscar_personas_anio", Persona.class);
        spc.registerStoredProcedureParameter("anioNacimiento", Integer.class, ParameterMode.IN);
        Calendar f = persona.getFechaNacimiento();
        int anio = f.get(Calendar.YEAR);
        spc.setParameter("anioNacimiento", anio);
        try {
            if (spc.execute()) {
                List<Persona> personasObtenidas = spc.getResultList();
                return personasObtenidas;
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        throw new PersistenciaException("Ocurrió un error al realizar la consulta");
    }
    
    /**
     * Verifica si la tabla de personas está vacía en la base de datos.
     * 
     * @return true si la tabla de personas está vacía, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error durante la verificación en la base de datos.
     */
    @Override
    public boolean tablaPersonasEstaVacia() throws PersistenciaException {
        Query query = em.createQuery("SELECT COUNT(p) FROM Persona p");
        Long count = (Long) query.getSingleResult();
        return count == 0;
    }
}
