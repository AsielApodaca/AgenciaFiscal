/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.TramitePlacas;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author luiis
 */
public class TramitePlacasDAO extends TramiteDAO implements ITramitePlacasDAO {

    public TramitePlacasDAO() {
        super();
    }
    
    @Override
    public List<TramitePlacas> obtenerTramitesPlacas(Persona personaTramite) {
        CriteriaQuery<TramitePlacas> criteria=cb.createQuery(TramitePlacas.class);
        Root<TramitePlacas> root=criteria.from(TramitePlacas.class);
        
        
        Predicate predicate=cb.equal(root.get("persona").get("rfc"),
                personaTramite.getRfc());
        criteria.select(root).where(predicate);
        
        TypedQuery<TramitePlacas> query=em.createQuery(criteria);
        List<TramitePlacas> tramitesPlacas;
        try{
            tramitesPlacas=query.getResultList();
            return tramitesPlacas;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
