/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Estado;
import entidades.Persona;
import entidades.TramiteLicencia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author luiis
 */
public class TramiteLicenciaDAO implements ITramiteLicenciaDAO{

    
    private EntityManagerFactory emf;
    private EntityManager em;
    private CriteriaBuilder cb;

    public TramiteLicenciaDAO() {
        emf = Persistence.createEntityManagerFactory("conexionPU");
        em = emf.createEntityManager();
        cb=em.getCriteriaBuilder();
    }

    @Override
    public TramiteLicencia obtenerTramiteLicencia(Persona personaTramite) {
        CriteriaQuery<TramiteLicencia> criteria=cb.createQuery(TramiteLicencia.class);
        Root<TramiteLicencia> root=criteria.from(TramiteLicencia.class);
        
        
        Predicate equal=cb.equal(root.get("persona").get("rfc"), 
                personaTramite.getRfc());
        Predicate predicado=cb.and(equal,cb.equal(root.<Estado>get("estado"), Estado.VIGENTE));
        criteria.select(root).where(predicado);
        
        TypedQuery<TramiteLicencia> query=em.createQuery(criteria);
        TramiteLicencia tramite;
        try{
            tramite=query.getSingleResult();
            return tramite;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public TramiteLicencia agregarTramiteLicencia(TramiteLicencia tramite) {
        Long id_persona=tramite.getPersona().getId();
        Persona p=em.find(Persona.class, id_persona);
        if(p!=null){
            em.getTransaction().begin();
            em.persist(tramite);
            p.agregarTramite(tramite);
            em.getTransaction().commit();
            return tramite;
        }
        System.out.println("la persona asignada al tramite no se encuentra registrada");
        return null;
    }

    @Override
    public void cerrarConexion() {
        em.close();
        emf.close();
    }

    @Override
    public boolean actualizarEstadoLicencia(TramiteLicencia tramite) {
        em.getTransaction().begin();
        CriteriaUpdate<TramiteLicencia> criteria=cb.createCriteriaUpdate(TramiteLicencia.class);
        Root<TramiteLicencia> root=criteria.from(TramiteLicencia.class);
        
        Predicate predicate=cb.equal(root.get("id"), tramite.getId());
        criteria.set(root.<Estado>get("estado"), Estado.CADUCO).
                where(predicate);
        
        int resultado=em.createQuery(criteria).executeUpdate();
        em.getTransaction().commit();
        return resultado>0;
    }
    
}
