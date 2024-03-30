/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.Vehiculo;
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
public class VehiculoDAO implements IVehiculoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public VehiculoDAO() {
        emf=Persistence.createEntityManagerFactory("conexionPU");
        em=emf.createEntityManager();
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
    public Vehiculo obtenerVehiculo(Vehiculo vehiculo) {
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<Vehiculo> criteria=cb.createQuery(Vehiculo.class);
        Root<Vehiculo> root=criteria.from(Vehiculo.class);
        
        
        Predicate predicate=cb.equal(root.get("serie"), vehiculo.getSerie());
        criteria.select(root).where(predicate);
        
        return em.createQuery(criteria).getSingleResult();
    }

    @Override
    public void cerrarConexion() {
        em.close();
        emf.close();
    }
    
}
