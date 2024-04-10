/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import static daos.TramiteDAO.LOG;
import entidades.Estado;
import entidades.Persona;
import entidades.TramitePlacas;
import entidades.Vehiculo;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
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
    public List<TramitePlacas> obtenerTramitesPlacas(Persona personaTramite)throws PersistenciaException {
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
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al obtener las placas");
        }
    }

    @Override
    public TramitePlacas obtenerPlacasPorSerieAuto(Vehiculo vehiculo) throws PersistenciaException{
        CriteriaQuery<TramitePlacas> criteria=cb.createQuery(TramitePlacas.class);
        Root<TramitePlacas> root=criteria.from(TramitePlacas.class);
        Join<TramitePlacas, Vehiculo> join=root.join("vehiculo");
        
        Predicate equal=cb.equal(join.get("serie"), vehiculo.getSerie());
        Predicate predicado=cb.and(equal,cb.equal(root.<Estado>get("estado"),Estado.ACTIVO));
        
        criteria.select(root).where(predicado);
        
        TypedQuery<TramitePlacas> query=em.createQuery(criteria);
        TramitePlacas tramite;
        try{
            tramite=query.getSingleResult();
            return tramite;
        }catch(NoResultException ex){
            System.out.println(ex.getMessage());
            return null;
        }catch(Exception e){
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al obtener las placas");
        }
    }

    @Override
    public boolean renovarPlacas(TramitePlacas tramite)throws PersistenciaException {
        try {
            em.getTransaction().begin();
            em.merge(tramite);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al renovar las placas");
        }
    }

    @Override
    public TramitePlacas obtenerPlacasPorMatricula(TramitePlacas placas)throws PersistenciaException {
        CriteriaQuery<TramitePlacas> criteria=cb.createQuery(TramitePlacas.class);
        Root<TramitePlacas> root=criteria.from(TramitePlacas.class);
        
        criteria.select(root).where(
                cb.equal(
                        root.get("matricula"),
                        placas.getMatricula()
                )
        );
        
        TypedQuery<TramitePlacas> query=em.createQuery(criteria);
        TramitePlacas tramite;
        try{
            tramite=query.getSingleResult();
            return tramite;
        }catch(NoResultException ex){
            System.out.println(ex.getMessage());
            return null;
        }catch(Exception e){
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al obtener las placas");
        }
    }
}
