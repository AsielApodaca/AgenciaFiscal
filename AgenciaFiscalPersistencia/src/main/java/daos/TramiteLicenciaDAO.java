package daos;

import static daos.TramiteDAO.LOG;
import entidades.Estado;
import entidades.Persona;
import entidades.TramiteLicencia;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Esta clase implementa la interfaz ITramiteLicenciaDAO y proporciona métodos para 
 * acceder a los datos de los trámites de licencia en la base de datos.
 * 
 * author luiis
 */
public class TramiteLicenciaDAO extends TramiteDAO implements ITramiteLicenciaDAO{

    
    public TramiteLicenciaDAO() {
        super();
    }

    /**
     * Obtiene una lista de trámites de licencia de la base de datos asociados a una persona.
     * 
     * @param personaTramite La persona asociada a los trámites de licencia a buscar.
     * @return Una lista de trámites de licencia asociados a la persona proporcionada.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    @Override
    public List<TramiteLicencia> obtenerTramitesLicencia(Persona personaTramite)throws PersistenciaException{
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
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al obtener la licencia");
        }
    }

    /**
     * Obtiene una licencia de conducir vigente de la base de datos según el número de licencia.
     * 
     * @param licencia La licencia de conducir a buscar.
     * @return La licencia de conducir vigente correspondiente al número proporcionado, o null si no se encontró.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    @Override
    public TramiteLicencia obtenerLicenciaVigente(TramiteLicencia licencia)throws PersistenciaException {
        CriteriaQuery<TramiteLicencia> criteria=cb.createQuery(TramiteLicencia.class);
        Root<TramiteLicencia> root=criteria.from(TramiteLicencia.class);
        
        Predicate equal=cb.equal(root.get("numLicencia"),licencia.getNumLicencia());
        Predicate predicado=cb.and(equal,cb.equal(root.<Estado>get("estado"), Estado.VIGENTE));
        criteria.select(root).where(predicado);
        
        TypedQuery<TramiteLicencia> query=em.createQuery(criteria);
        TramiteLicencia tramiteLicencia;
        try{
            tramiteLicencia=query.getSingleResult();
            return tramiteLicencia;
        }catch(NoResultException ex){
            return null;
        }catch(Exception e){
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al obtener la licencia");
        }
    }
    
    /**
     * Obtiene una licencia de conducir de la base de datos según el número de licencia.
     * 
     * @param licencia La licencia de conducir a buscar.
     * @return La licencia de conducir correspondiente al número proporcionado, o null si no se encontró.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    @Override
    public TramiteLicencia obtenerLicencia(TramiteLicencia licencia)throws PersistenciaException {
        CriteriaQuery<TramiteLicencia> criteria=cb.createQuery(TramiteLicencia.class);
        Root<TramiteLicencia> root=criteria.from(TramiteLicencia.class);
        
        Predicate equal=cb.equal(root.get("numLicencia"),licencia.getNumLicencia());
        criteria.select(root).where(equal);
        
        TypedQuery<TramiteLicencia> query=em.createQuery(criteria);
        TramiteLicencia tramiteLicencia;
        try{
            tramiteLicencia=query.getSingleResult();
            return tramiteLicencia;
        }catch(NoResultException ex){
            return null;
        }catch(Exception e){
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al obtener la licencia");
        }
    }
    
    /**
     * Actualiza la fecha de vencimiento de una licencia de conducir en la base de datos.
     * 
     * @param licencia La licencia de conducir cuya fecha de vencimiento se actualizará.
     * @return Verdadero si la fecha de vencimiento se actualizó correctamente, falso si ocurrió un error.
     * @throws PersistenciaException Si ocurre un error durante la actualización en la base de datos.
     */
    @Override
    public boolean actualizarFechaVencimiento(TramiteLicencia licencia) throws PersistenciaException {
        try{
            TramiteLicencia tl=em.find(TramiteLicencia.class, licencia.getId());
            em.getTransaction().begin();
            tl.setFechaCaducidad(licencia.getFechaCaducidad());
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            em.getTransaction().rollback();
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al actualizar la licencia");
        }
    }

}
