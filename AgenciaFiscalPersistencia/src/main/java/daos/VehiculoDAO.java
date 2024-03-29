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

/**
 *
 * @author luiis
 */
public class VehiculoDAO implements IVehiculo {

    private EntityManagerFactory emf;
    private EntityManager em;

    public VehiculoDAO() {
        emf=Persistence.createEntityManagerFactory("conexionPU");
        em=emf.createEntityManager();
    }
    
    @Override
    public boolean agregarVehiculo(Vehiculo vehiculo) {
        Long id_persona=vehiculo.getPersona().getId();
        Persona p=em.find(Persona.class, id_persona);
        if(p!=null){
            em.getTransaction().begin();
            em.persist(vehiculo);
            em.getTransaction().commit();
            return true;
        }
        System.out.println("la persona asignada al vehiculo no se encuentra registrada");
        return false;
    }

    @Override
    public Vehiculo obtenerVehiculo(Vehiculo vehiculo) {
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cerrarConexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
