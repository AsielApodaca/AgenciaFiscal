/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.TramiteLicencia;
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
public class TramiteLicenciaDAO implements ITramiteLicenciaDAO{

    
    private EntityManagerFactory emf;
    private EntityManager em;

    public TramiteLicenciaDAO() {
        emf = Persistence.createEntityManagerFactory("conexionPU");
        em = emf.createEntityManager();
    }

    @Override
    public TramiteLicencia obtenerTramiteLicencia(TramiteLicencia tramite) {
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<TramiteLicencia> criteria=cb.createQuery(TramiteLicencia.class);
        Root<TramiteLicencia> root=criteria.from(TramiteLicencia.class);
        
        
        Predicate predicate=cb.equal(root.get("id"), tramite.getId());
        criteria.select(root).where(predicate);
        
        return em.createQuery(criteria).getSingleResult();
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
    
}
