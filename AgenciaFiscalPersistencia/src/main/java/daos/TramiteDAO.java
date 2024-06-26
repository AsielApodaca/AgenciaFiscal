package daos;

import entidades.Estado;
import entidades.Persona;
import entidades.Tramite;
import entidades.TramiteLicencia;
import entidades.TramitePlacas;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Esta clase implementa la interfaz ITramiteDAO y proporciona métodos para 
 * acceder a los datos de los trámites en la base de datos.
 * 
 * author luiis
 */
public class TramiteDAO implements ITramiteDAO{

    static EntityManager em;
    static CriteriaBuilder cb;
    protected final static Logger LOG= Logger.getLogger(TramiteDAO.class.getName());
    
    public TramiteDAO(){
        em=ClaseConexion.getEntityManager();
        cb=em.getCriteriaBuilder();
    }
    
    /**
     * Obtiene una lista de trámites de la base de datos asociados a una persona.
     * 
     * @param personaTramite La persona asociada a los trámites a buscar.
     * @return Una lista de trámites asociados a la persona proporcionada.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    @Override
    public List<Tramite> obtenerTramitesPorPersona(Persona personaTramite)throws PersistenciaException {
        CriteriaQuery<Tramite> criteria=cb.createQuery(Tramite.class);
        Root<Tramite> root=criteria.from(Tramite.class);
        
        Predicate predicate=cb.equal(root.get("persona").get("rfc"),personaTramite.getRfc());
        criteria.select(root).where(predicate);
        
        TypedQuery<Tramite> query=em.createQuery(criteria);
        List<Tramite> tramites;
        try{
            tramites=query.getResultList();
        }catch(Exception e){
            LOG.log(Level.SEVERE,e.getMessage() , e);
            throw new PersistenciaException("Ocurrio un error al obtener los tramites" );
        }
        if(!tramites.isEmpty()){
            return tramites;
        }
        throw new PersistenciaException("La persona no tiene tramites Registrados");
    }

    /**
     * Obtiene una lista de trámites de la base de datos según los parámetros proporcionados.
     * 
     * @param fechaDesde La fecha desde la cual buscar los trámites.
     * @param fechaHasta La fecha hasta la cual buscar los trámites.
     * @param tipoTramite El tipo de trámite a buscar.
     * @param personaTramite La persona asociada a los trámites a buscar.
     * @return Una lista de trámites que cumplen con los parámetros proporcionados.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    @Override
    public List<Tramite> obtenerTramites(Calendar fechaDesde, Calendar fechaHasta, String tipoTramite, Persona personaTramite) throws PersistenciaException {
        CriteriaQuery<Tramite> criteria = cb.createQuery(Tramite.class);
        Root<Tramite> root = criteria.from(Tramite.class);

        List<Predicate> predicates = new ArrayList<>();

        // Filtro por fecha desde, si se proporciona
        if (fechaDesde != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("fechaEmision"), fechaDesde));
        }

        // Filtro por fecha hasta, si se proporciona
        if (fechaHasta != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("fechaEmision"), fechaHasta));
        }

        // Filtro por tipo de trámite, si se proporciona
        if (tipoTramite != null && !tipoTramite.isEmpty()) {
            Predicate tipoPredicate = cb.equal(root.type(),
                    cb.literal(tipoTramite.equalsIgnoreCase("licencia") ? TramiteLicencia.class : TramitePlacas.class));
            predicates.add(tipoPredicate);
        }

        // Filtro por nombre de la persona, si se proporciona
        if (personaTramite != null) {
            predicates.add(cb.equal(root.get("persona").get("rfc"), personaTramite.getRfc()));
        }

        criteria.select(root).where(predicates.toArray(new Predicate[predicates.size()]));

        TypedQuery<Tramite> query = em.createQuery(criteria);
        List<Tramite> tramites;
        try {
            tramites = query.getResultList();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrió un error al obtener los trámites");
        }

        if (!tramites.isEmpty()) {
            return tramites;
        }

        return null;
    }

    /**
     * Obtiene una lista de trámites de la base de datos según los IDs proporcionados y el tipo de trámite.
     * 
     * @param ids Lista de IDs de trámites a buscar.
     * @param tipoTramite El tipo de trámite a buscar.
     * @return Una lista de trámites que cumplen con los IDs y el tipo de trámite proporcionados.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    private List<Tramite> obtenerTramitePorTipo(List<Long>ids,String tipoTramite)throws PersistenciaException{
        CriteriaQuery criteria;
        Root root;
        if(tipoTramite.equalsIgnoreCase("licencia")){
            criteria=cb.createQuery(TramiteLicencia.class);
            root=criteria.from(TramiteLicencia.class);
        }else{
            criteria=cb.createQuery(TramitePlacas.class);
            root=criteria.from(TramitePlacas.class);
        }
        
        Predicate predicate=root.get("id").in(ids);
        criteria.select(root).where(predicate);
        
        TypedQuery query=em.createQuery(criteria);
        List lista;
        try{
            lista=query.getResultList();
            return lista;
        }catch(Exception e){
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException( "Ocurrio un error al obtener los tramites");
        }
    }
    
    /**
     * Obtiene una lista de todos los trámites de la base de datos.
     * 
     * @return Una lista de todos los trámites registrados en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    @Override
    public List<Tramite> obtenerTramites() throws PersistenciaException {
        CriteriaQuery<Tramite> criteria=cb.createQuery(Tramite.class);
        Root root=criteria.from(Tramite.class);

        criteria.select(root);

        TypedQuery query = em.createQuery(criteria);
        List lista;
        try {
            lista = query.getResultList();
            return lista;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al obtener los tramites");
        }
    }

    /**
     * Registra un nuevo trámite en la base de datos.
     * 
     * @param tramite El trámite a registrar en la base de datos.
     * @return Verdadero si el trámite se registró correctamente, falso si ocurrió un error.
     * @throws PersistenciaException Si ocurre un error durante el registro en la base de datos.
     */
    @Override
    public boolean registrarTramite(Tramite tramite) throws PersistenciaException{
        Long id_persona=tramite.getPersona().getId();
        Persona p=em.find(Persona.class, id_persona);
        if(p!=null){
            try{
                em.getTransaction().begin();
                Calendar fecha=tramite.getFechaEmision();
                fecha.set(Calendar.MONTH, fecha.get(Calendar.MONTH)-1);
                tramite.setFechaEmision(fecha);
                em.persist(tramite);
                em.getTransaction().commit();
                return true;
            }catch(Exception e){
                em.getTransaction().rollback();
                LOG.log(Level.SEVERE, e.getMessage(), e);
                throw new PersistenciaException("Ocurrio un error al registrar el tramite");
            }
            
        }
        throw new PersistenciaException("La persona asociada al tramite no esta registrada");
    }

    /**
     * Actualiza el estado de un trámite en la base de datos.
     * 
     * @param tramite El trámite cuyo estado se actualizará.
     * @return Verdadero si el estado del trámite se actualizó correctamente, falso si ocurrió un error.
     * @throws PersistenciaException Si ocurre un error durante la actualización en la base de datos.
     */
    @Override
    public boolean actualizarEstadoTramite(Tramite tramite) throws PersistenciaException{
        em.getTransaction().begin();
        Estado estado=null;
        
        if(tramite.getClass()==TramiteLicencia.class){
            estado=Estado.CADUCO;
        }else if(tramite.getClass()==TramitePlacas.class)
            estado=Estado.INACTIVO;
        Tramite tr;
        try{
            tr=em.find(Tramite.class, tramite.getId());
            tr.setEstado(estado);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            em.getTransaction().rollback();
            LOG.log(Level.SEVERE, e.getMessage(), e);
            return false;
        }
    }

    /**
     * Obtiene un trámite de la base de datos según la persona asociada y el tipo de trámite.
     * 
     * @param personaTramite La persona asociada al trámite a buscar.
     * @param tipoTramite El tipo de trámite a buscar.
     * @return El trámite correspondiente a la persona y tipo proporcionados, o null si no se encontró.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    @Override
    public Tramite obtenerTramite(Persona personaTramite, String tipoTramite)throws PersistenciaException {
        CriteriaQuery<Tramite> criteria=cb.createQuery(Tramite.class);
        Root<Tramite> root=criteria.from(Tramite.class);
        Estado estado;
        if(tipoTramite.equals("licencia"))
            estado=Estado.VIGENTE;
        else
            estado=Estado.ACTIVO;
        
        Predicate equal=cb.equal(root.get("persona").get("rfc"),personaTramite.getRfc());
        Predicate predicado=cb.and(equal,cb.equal(root.<Estado>get("estado"), estado));
        criteria.select(root).where(predicado);
        
        TypedQuery<Tramite> query=em.createQuery(criteria);
        Tramite tramite;
        try{
            tramite=query.getSingleResult();
            return tramite;
        }catch(NoResultException nre){
            return null;
        }
        catch(Exception e){
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al obtener el tramite");
        }
    }

}
