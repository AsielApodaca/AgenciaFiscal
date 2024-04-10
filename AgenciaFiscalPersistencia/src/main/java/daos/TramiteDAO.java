/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Estado;
import entidades.Persona;
import entidades.Tramite;
import entidades.TramiteLicencia;
import entidades.TramitePlacas;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author luiis
 */
public class TramiteDAO implements ITramiteDAO{

//    protected static EntityManagerFactory emf;
    static EntityManager em;
    static CriteriaBuilder cb;
    protected final static Logger LOG= Logger.getLogger(TramiteDAO.class.getName());
    
    public TramiteDAO(){
//        emf=Persistence.createEntityManagerFactory("conexionPU");
        em=ClaseConexion.getEntityManager();
        cb=em.getCriteriaBuilder();
    }
    
    @Override
    public List<Tramite> obtenerTramites(Persona personaTramite)throws PersistenciaException {
        CriteriaQuery<Tramite> criteria=cb.createQuery(Tramite.class);
        Root<Tramite> root=criteria.from(Tramite.class);
        
        Predicate predicate=cb.equal(root.get("persona").get("rfc"),personaTramite.getRfc());
        criteria.select(root).where(predicate);
        
        TypedQuery<Tramite> query=em.createQuery(criteria);
        List<Tramite> tramites;
        try{
            tramites=query.getResultList();
        }catch(Exception e){
            //System.out.println(e.getMessage());
            LOG.log(Level.SEVERE,e.getMessage() , e);
            throw new PersistenciaException("Ocurrio un error al obtener los tramites" );
        }
        if(!tramites.isEmpty()){
            List<Long> ids=new ArrayList<>();
            for(Tramite t:tramites){
                ids.add(t.getId());
            }
            List<Tramite> tramitesObtenidos=new ArrayList<>();
            for(Tramite t:obtenerTramitePorTipo(ids, "licencia")){
                tramitesObtenidos.add(t);
            }
            for(Tramite t:obtenerTramitePorTipo(ids, "placas")){
                tramitesObtenidos.add(t);
            }
            return tramitesObtenidos;
        }
        throw new PersistenciaException("La persona no tiene tramites Registrados");
    }

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
    
    @Override
    public boolean registrarTramite(Tramite tramite) throws PersistenciaException{
        Long id_persona=tramite.getPersona().getId();
        Persona p=em.find(Persona.class, id_persona);
        if(p!=null){
            try{
                em.getTransaction().begin();
                em.persist(tramite);
                //p.agregarTramite(tramite);
                em.getTransaction().commit();
                return true;
            }catch(Exception e){
                System.out.println("error al registrar el tramite");
                System.out.println(e.getCause());
                em.getTransaction().rollback();
                LOG.log(Level.SEVERE, e.getMessage(), e);
                throw new PersistenciaException("Ocurrio un error al registrar el tramite");
            }
            
        }
        throw new PersistenciaException("La persona asociada al tramite no esta registrada");
    }

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
            System.out.println("error :");
            System.out.println(e.getCause());
            em.getTransaction().rollback();
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al actualizar el tramite");
        }
    }

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
        }catch(NoResultException ex){
            System.out.println(ex.getMessage());
            return null;
        }catch(Exception e){
            System.out.println("error:");
            System.out.println(e.fillInStackTrace());
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al obtener el tramite");
        }
    }
}
