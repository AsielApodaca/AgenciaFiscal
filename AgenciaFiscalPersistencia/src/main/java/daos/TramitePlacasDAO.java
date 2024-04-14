package daos;

import static daos.TramiteDAO.LOG;
import entidades.Estado;
import entidades.Persona;
import entidades.TramitePlacas;
import entidades.Vehiculo;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Esta clase implementa la interfaz ITramitePlacasDAO y proporciona métodos para 
 * acceder a los datos de los trámites de placas en la base de datos.
 * 
 * author luiis
 */
public class TramitePlacasDAO extends TramiteDAO implements ITramitePlacasDAO {

    public TramitePlacasDAO() {
        super();
    }
    
    /**
     * Obtiene una lista de trámites de placas de la base de datos asociados a una persona.
     * 
     * @param personaTramite La persona asociada a los trámites de placas a buscar.
     * @return Una lista de trámites de placas asociados a la persona proporcionada.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
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

    /**
     * Obtiene trámites de placas de la base de datos según la serie del vehículo.
     * 
     * @param vehiculo El vehículo asociado a las placas a buscar.
     * @return Un trámite de placas correspondiente a la serie del vehículo proporcionado, o null si no se encontró.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
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
            return null;
        }catch(Exception e){
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al obtener las placas");
        }
    }

    /**
     * Renueva las placas de un vehículo en la base de datos.
     * 
     * @param tramite El trámite de placas que contiene la información de las nuevas placas.
     * @return Verdadero si las placas se renovaron correctamente, falso si ocurrió un error.
     * @throws PersistenciaException Si ocurre un error durante la actualización en la base de datos.
     */
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
            return false;
        }
    }

    /**
     * Obtiene trámites de placas de la base de datos según la matrícula.
     * 
     * @param placas El trámite de placas con la matrícula a buscar.
     * @return Un trámite de placas correspondiente a la matrícula proporcionada, o null si no se encontró.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
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
            return null;
        }catch(Exception e){
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al obtener las placas");
        }
    }
}
