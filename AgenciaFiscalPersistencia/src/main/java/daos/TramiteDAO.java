/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.Tramite;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author luiis
 */
public class TramiteDAO implements ITramiteDAO{

    private EntityManagerFactory emf;
    private EntityManager em;
    
    public TramiteDAO(){
        emf=Persistence.createEntityManagerFactory("conexionPU");
        em=emf.createEntityManager();
    }
    
    @Override
    public Tramite obtenerTramite(Tramite tramite) {
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteria=cb.createQuery(Tramite.class);
        Root<Tramite> root=criteria.from(Tramite.class);
        
        
        Predicate predicate=cb.equal(root.get("id"), tramite.getId());
        criteria.select(root).where(predicate);
        
        return em.createQuery(criteria).getSingleResult();
    }

    @Override
    public Tramite registrarTramite(Tramite tramite) {
        Long id_persona=tramite.getPersona().getId();
        Persona p=em.find(Persona.class, id_persona);
        if(p!=null){
            em.getTransaction().begin();
            em.persist(tramite);
            em.getTransaction().commit();
            return tramite;
        }else
            System.out.println("la persona asignada al tramite no se encuentra registrada");
        return null;
    }
    
}
