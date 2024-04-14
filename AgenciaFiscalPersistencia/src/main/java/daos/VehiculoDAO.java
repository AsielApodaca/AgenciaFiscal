package daos;

import entidades.Vehiculo;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Esta clase implementa la interfaz IVehiculoDAO y proporciona métodos para acceder a los datos de los vehículos en la base de datos.
 * 
 * author luiis
 */
public class VehiculoDAO implements IVehiculoDAO {

    private EntityManager em;
    private final static Logger LOG= Logger.getLogger(VehiculoDAO.class.getName());
    
    public VehiculoDAO() {
        em=ClaseConexion.getEntityManager();
    }
    
//    @Override
//    public boolean agregarVehiculo(Vehiculo vehiculo) {
//        Long id_persona=vehiculo.getPersona().getId();
//        Persona p=em.find(Persona.class, id_persona);
//        if(p!=null){
//            em.getTransaction().begin();
//            p.agregarVehiculo(vehiculo);
//            //em.persist(vehiculo);
//            em.getTransaction().commit();
//            return true;
//        }
//        System.out.println("la persona asignada al vehiculo no se encuentra registrada");
//        return false;
//    }

    
    /**
     * Obtiene un vehículo de la base de datos según su número de serie.
     * 
     * @param vehiculo El vehículo con el número de serie a buscar.
     * @return Un objeto Vehiculo correspondiente al número de serie proporcionado, o null si no se encontró.
     * @throws PersistenciaException Si ocurre un error durante la búsqueda en la base de datos.
     */
    @Override
    public Vehiculo obtenerVehiculo(Vehiculo vehiculo)throws PersistenciaException {
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<Vehiculo> criteria=cb.createQuery(Vehiculo.class);
        Root<Vehiculo> root=criteria.from(Vehiculo.class);
        
        Predicate predicate=cb.equal(root.get("serie"), vehiculo.getSerie());
        criteria.select(root).where(predicate);
        
        TypedQuery<Vehiculo> query=em.createQuery(criteria);
        Vehiculo vehiculoObtenido;
        try{
            vehiculoObtenido=query.getSingleResult();
            return vehiculoObtenido;
        }catch(Exception e){
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new PersistenciaException("Ocurrio un error al obtener el vehiculo");
        }
    }

}
