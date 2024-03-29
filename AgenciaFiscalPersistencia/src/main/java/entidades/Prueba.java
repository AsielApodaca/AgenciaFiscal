/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entidades;

import daos.IPersonaDAO;
import daos.IVehiculo;
import daos.PersonaDAO;
import daos.VehiculoDAO;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luiis
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("conexionPU");
        EntityManager em=emf.createEntityManager();
//        
//        Calendar fechaNac=Calendar.getInstance();
//        Calendar fechaEmision=Calendar.getInstance();
//        Calendar fechaCaducidad=fechaEmision;
//        fechaCaducidad.add(Calendar.YEAR, 2);
//        fechaNac.set(2003, 11, 20);
//        Persona persona1=new Persona("MOEL0311209LSJ", "MOEL031120MSRRSSA8", 
//                "Luisa Fernanda Morales Espinoza", "644112266", fechaNac, false);
//        TramiteLicencia tramiteLicencia=new TramiteLicencia(2, fechaCaducidad, fechaEmision, 900.00f, Estado.ACTIVO, persona1);
//        persona1.agregarTramite(tramiteLicencia);
//        
//        em.getTransaction().begin();
//        em.persist(persona1);
//        em.getTransaction().commit();
//        
//        em.close();
//        emf.close();

//        IPersonaDAO persona=new PersonaDAO();
//        
//        persona.agregarPersonas();
        IVehiculo vehiculo=new VehiculoDAO();
        
        em.getTransaction().begin();
        Persona persona=em.find(Persona.class, 1L);
        Vehiculo v=new Vehiculo("12345678901234567", "Toyota", "Corolla", "Negro", "LE", persona);
        vehiculo.agregarVehiculo(v);
//        persona.agregarVehiculo(v);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        Persona p=em.find(Persona.class, 1L);
        if(!p.getVehiculos().isEmpty()){
            for (Vehiculo ve : p.getVehiculos()) {
                System.out.println(ve.toString());
            }
        }else System.out.println("lista vacia");
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
