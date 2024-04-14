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
 *
 * @author luiis
 */
public class PersonaDAO implements IPersonaDAO{

//    private EntityManagerFactory emf;
    private final EntityManager em;
    private final CriteriaBuilder cb;
    private final static Logger LOG= Logger.getLogger(PersonaDAO.class.getName());
    
    public PersonaDAO(){
        em=ClaseConexion.getEntityManager();
        cb=em.getCriteriaBuilder();
    }
    
    @Override
    public Persona obtenerPersona(Persona persona)throws PersistenciaException {
        CriteriaQuery<Persona> criteria=cb.createQuery(Persona.class);
        Root<Persona> root=criteria.from(Persona.class);
        
        Predicate predicate=cb.equal(root.get("rfc"), persona.getRfc());
        criteria.select(root).where(predicate);
        
        TypedQuery<Persona> query=em.createQuery(criteria);
        try {
            Persona personaConsultada=query.getSingleResult();
            return personaConsultada;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage() , e);
            throw new PersistenciaException("Ocurrio un error al buscar el registro de la persona");
        }
    }

    @Override
    public List<Persona> agregarPersonas()throws PersistenciaException {
        StoredProcedureQuery spc=em.createStoredProcedureQuery("sp_insertar_personas",Persona.class);
        em.getTransaction().begin();
        try {
            if (spc.execute()) {
                List<Persona> personasAgregadas = spc.getResultList();
                em.getTransaction().commit();
                return personasAgregadas;
            }
        }catch(Exception e){
            em.getTransaction().rollback();
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        throw new PersistenciaException("Ocurrio un error al registrar a las personas");
    }
    
    @Override
    public Persona actualizarPersona(Persona persona) throws PersistenciaException{
        Persona personaBuscada=em.find(Persona.class, persona.getId());
        if(personaBuscada!=null){
            try{
                em.getTransaction().begin();
                personaBuscada.setTieneDiscapacidad(true);
                em.getTransaction().commit();
                return personaBuscada; 
            }catch(Exception e){
                em.getTransaction().rollback();
                LOG.log(Level.SEVERE, e.getMessage(), e);
                throw new PersistenciaException("Ocurrio un error al actualizar a la persona");
            }
        }
        throw new PersistenciaException("No se encontro el registro de la persona");
    }

    @Override
    public List<Persona> buscarPersonasPorNombre(Persona persona)throws PersistenciaException {
        System.out.println("consulta personas por nombre");
        StoredProcedureQuery spc=em.createStoredProcedureQuery("sp_buscar_personas_nombre",Persona.class);
        spc.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        spc.setParameter("nombre", persona.getNombreCompleto());
        try{
            if (spc.execute()) {
                List<Persona> personasObtenidas = spc.getResultList();
                //System.out.println("exito");
                return personasObtenidas;
            }//System.out.println("no se ejecuto");
        }catch(Exception e){
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        throw new PersistenciaException("Ocurrio un error al realizar la consulta");
    }

    @Override
    public List<Persona> buscarPersonasPorCURP(Persona persona) throws PersistenciaException {
        System.out.println("consulta personas por curp");
        StoredProcedureQuery spc=em.createStoredProcedureQuery("sp_buscar_personas_curp",Persona.class);
        spc.registerStoredProcedureParameter("curpB", String.class, ParameterMode.IN);
        spc.setParameter("curpB", persona.getCurp());
        try{
            if (spc.execute()) {
                List<Persona> personasObtenidas = spc.getResultList();
                //System.out.println("exito");
                return personasObtenidas;
            }//System.out.println("no se ejecuto");
        }catch(Exception e){
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        throw new PersistenciaException("Ocurrio un error al realizar la consulta");
    }

    @Override
    public List<Persona> buscarPersonasPorAnioNac(Persona persona) throws PersistenciaException {
        System.out.println("consulta personas por año nacimiento");
        StoredProcedureQuery spc=em.createStoredProcedureQuery("sp_buscar_personas_anio",Persona.class);
        spc.registerStoredProcedureParameter("anioNacimiento", Integer.class, ParameterMode.IN);
        Calendar f=persona.getFechaNacimiento();
        int anio=f.get(Calendar.YEAR);
        spc.setParameter("anioNacimiento", anio);
        try{
            if (spc.execute()) {
                List<Persona> personasObtenidas = spc.getResultList();
                //System.out.println("exito");
                return personasObtenidas;
            }//System.out.println("no se ejecuto");
        }catch(Exception e){
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        throw new PersistenciaException("Ocurrio un error al realizar la consulta");
    }
    
    @Override
    public boolean tablaPersonasEstaVacia() throws PersistenciaException{
        Query query = em.createQuery("SELECT COUNT(p) FROM Persona p");
        Long count = (Long) query.getSingleResult();
        return count == 0;
    }

}
