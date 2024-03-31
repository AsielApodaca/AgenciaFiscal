/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Estado;
import entidades.Persona;
import entidades.TramiteLicencia;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
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

    @Override
    public TramiteLicencia obtenerLicenciaVigente(TramiteLicencia licencia) {
        CriteriaQuery<TramiteLicencia> criteria=cb.createQuery(TramiteLicencia.class);
        Root<TramiteLicencia> root=criteria.from(TramiteLicencia.class);
        //Join<Tramite,TramiteLicencia> joinTramiteL=root.join("id");
        //Join<Tramite,Persona> joinPersona=root.join("persona");
        
        Predicate equal=cb.equal(root.get("numLicencia"),licencia.getNumLicencia());
        Predicate predicado=cb.and(equal,cb.equal(root.<Estado>get("estado"), Estado.VIGENTE));
        criteria.select(root).where(predicado);
        
        TypedQuery<TramiteLicencia> query=em.createQuery(criteria);
        TramiteLicencia tramiteLicencia;
        try{
            tramiteLicencia=query.getSingleResult();
            return tramiteLicencia;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
