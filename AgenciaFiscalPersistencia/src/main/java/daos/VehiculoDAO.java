/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.Vehiculo;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author luiis
 */
public class VehiculoDAO implements IVehiculoDAO {

    //private EntityManagerFactory emf;
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

//    @Override
//    public void cerrarConexion() {
//        em.close();
//        emf.close();
//    }
    
}
