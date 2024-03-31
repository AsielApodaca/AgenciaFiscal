/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entidades;

import daos.ClaseConexion;
import daos.IPersonaDAO;
import daos.ITramiteDAO;
import daos.PersonaDAO;
import daos.TramiteLicenciaDAO;
import daos.VehiculoDAO;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import daos.IVehiculoDAO;
import java.util.Random;

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
//        EntityManagerFactory emf=Persistence.createEntityManagerFactory("conexionPU");
//        EntityManager em=emf.createEntityManager();
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
//        IVehiculoDAO vehiculo=new VehiculoDAO();
//        
//        em.getTransaction().begin();
//        Persona persona=em.find(Persona.class, 1L);
//        Vehiculo v=new Vehiculo("12345678901234567", "Toyota", "Corolla", "Negro", "LE", persona);
//        vehiculo.agregarVehiculo(v);
////        persona.agregarVehiculo(v);
//        em.getTransaction().commit();
//        
//        em.getTransaction().begin();
//        Persona p=em.find(Persona.class, 1L);
//        if(!p.getVehiculos().isEmpty()){
//            for (Vehiculo ve : p.getVehiculos()) {
//                System.out.println(ve.toString());
//            }
//        }else System.out.println("lista vacia");
//        
//        em.getTransaction().commit();
//        em.getTransaction().begin();
//        Persona p=em.find(Persona.class, 3L);
//        Vehiculo v=new Vehiculo("12345678911234567", "Toyota", "Camry", "Rojo", "LE", p);
//        p.agregarVehiculo(v);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
        
//        IPersonaDAO personaDao=new PersonaDAO();
//        List<Persona> personas=personaDao.agregarPersonas();
//        
//        if(!personas.isEmpty()){
//            for(Persona per:personas){
//                System.out.println("nombre: "+per.getNombreCompleto());
//                for(Vehiculo vp:per.getVehiculos()){
//                    System.out.println("serie vehiculo: "+vp.getSerie());
//                }
//            }
//        }
        
        //personaDao.cerrarConexion();
//        
//        IVehiculoDAO vehiculo=new VehiculoDAO();
//        Vehiculo vOb=vehiculo.obtenerVehiculo(new Vehiculo("12345678911234567"));
//        vehiculo.cerrarConexion();
        
        IPersonaDAO p=new PersonaDAO();
        Persona persona=new Persona("GALA850730M78");
        persona=p.obtenerPersona(persona);
        System.out.println("nombre persona: "+persona.getNombreCompleto());
        ITramiteDAO tramites= new TramiteLicenciaDAO();
        Tramite t=tramites.obtenerTramite(persona, "placas");
        if(t!=null){
            System.out.println(t.toString());
            TramitePlacas tramitePlacas=(TramitePlacas)t;
            System.out.println(tramitePlacas.getVehiculo().toString());
        }
        ClaseConexion.cerrarConexion();
//        Calendar fechaEmision=Calendar.getInstance();
        
////        
////        Tramite tp=new TramitePlacas("AAA-111", vOb, fechaEmision, 1500.0f, Estado.ACTIVO, p);
////        
////        if(tramites.registrarTramite(tp))
////            System.out.println("se registro con exito las placas");
////        else System.out.println("no se registraron las placas");
//         
//        Object obj=tramites.obtenerTramite(p, "licencia");
//        if(tramites.actualizarEstadoTramite((TramiteLicencia)obj))
//            System.out.println("se actualizo el estado");
//        else 
//            System.out.println("no se actualizo");
//        Tramite tl=new TramiteLicencia(fechaEmision, 700.0f, Estado.VIGENTE, p);
//        ((TramiteLicencia)tl).setVigencia(3);
//        if(tramites.registrarTramite(tl))
//            System.out.println("se registro con exito");
//        else System.out.println("no se registro");
//
//        List<Tramite> tramitesP=tramites.obtenerTramites(p);
//        List<Vehiculo> vehiculos=p.getVehiculos();
//        if(!vehiculos.isEmpty()){
//             for(Vehiculo ve:vehiculos){
//                System.out.println(ve.toString());
//            }
//        }
//        if(tramitesP!=null){
//            for(Tramite t:tramitesP){
//                System.out.println(t.toString());
//            }
//        }else System.out.println("no hay tramites");
//        tramites.cerrarConexion();
        
    }
    
}
