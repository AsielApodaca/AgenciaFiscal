/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Estado;
import entidades.Persona;
import entidades.Tramite;
import entidades.TramiteLicencia;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author luiis
 */
public class TramiteLicenciaDAO extends TramiteDAO implements ITramiteLicenciaDAO{

    
    public TramiteLicenciaDAO() {
        super();
    }
//
    
//    public TramiteLicencia obtenerTramiteLicencia(Persona personaTramite) {
//        CriteriaQuery<TramiteLicencia> criteria=cb.createQuery(TramiteLicencia.class);
//        Root<TramiteLicencia> root=criteria.from(TramiteLicencia.class);
//        
//        
//        Predicate equal=cb.equal(root.get("rfc"), 
//                personaTramite.getRfc());
//        Predicate predicado=cb.and(equal,cb.equal(root.<Estado>get("estado"), Estado.VIGENTE));
//        criteria.select(root).where(predicado);
//        
//        TypedQuery<TramiteLicencia> query=em.createQuery(criteria);
//        TramiteLicencia tramiteLicencia;
//        try{
//            tramiteLicencia=query.getSingleResult();
//            return tramiteLicencia;
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }

    @Override
    public List<TramiteLicencia> obtenerTramitesLicencia(Persona personaTramite){
        CriteriaQuery<TramiteLicencia> criteria=cb.createQuery(TramiteLicencia.class);
        Root<TramiteLicencia> root=criteria.from(TramiteLicencia.class);
        
        
        Predicate predicate=cb.equal(root.get("persona").get("rfc"),
                personaTramite.getRfc());
        criteria.select(root).where(predicate);
        
        TypedQuery<TramiteLicencia> query=em.createQuery(criteria);
        List<TramiteLicencia> tramitesLicencia;
        try{
            tramitesLicencia=query.getResultList();
            return tramitesLicencia;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
//    public TramiteLicencia agregarTramiteLicencia(TramiteLicencia tramite) {
//        Long id_persona=tramite.getPersona().getId();
//        Persona p=em.find(Persona.class, id_persona);
//        if(p!=null){
//            em.getTransaction().begin();
//            em.persist(tramite);
//            p.agregarTramite(tramite);
//            em.getTransaction().commit();
//            return tramite;
//        }
//        System.out.println("la persona asignada al tramite no se encuentra registrada");
//        return null;
//    }

//    public boolean actualizarEstadoLicencia(TramiteLicencia tramite) {
//        em.getTransaction().begin();
//        CriteriaUpdate<TramiteLicencia> criteria=cb.createCriteriaUpdate(TramiteLicencia.class);
//        Root<TramiteLicencia> root=criteria.from(TramiteLicencia.class);
//        
//        Predicate predicate=cb.equal(root.get("id"), tramite.getId());
//        criteria.set(root.<Estado>get("estado"), Estado.CADUCO).
//                where(predicate);
//        
//        int resultado=em.createQuery(criteria).executeUpdate();
//        em.getTransaction().commit();
//        return resultado>0;
//    }

}
