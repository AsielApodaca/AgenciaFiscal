/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author luiis
 */
public class PersonaDAO implements IPersonaDAO{

    private EntityManagerFactory emf;
    private EntityManager em;
    private CriteriaBuilder cb;
    
    public PersonaDAO(){
        emf=Persistence.createEntityManagerFactory("conexionPU");
        em=emf.createEntityManager();
        cb=em.getCriteriaBuilder();
    }
    
    @Override
    public Persona obtenerPersona(Persona persona) {
        CriteriaQuery<Persona> criteria=cb.createQuery(Persona.class);
        Root<Persona> root=criteria.from(Persona.class);
        
        Predicate predicate=cb.equal(root.get("rfc"), persona.getRfc());
        criteria.select(root).where(predicate);
        
        TypedQuery<Persona> query=em.createQuery(criteria);
        try {
            Persona personaConsultada=query.getSingleResult();
            return personaConsultada;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    @Override
    public List<Persona> agregarPersonas() {
        StoredProcedureQuery spc=em.createStoredProcedureQuery("sp_insertar_personas",Persona.class);
        em.getTransaction().begin();
        if(spc.execute()){
            List<Persona> personasAgregadas=spc.getResultList();
            em.getTransaction().commit();
            return personasAgregadas;
        }
        em.getTransaction().commit();
        System.out.println("no se obtuvo el result set");
        return null;
    }

    @Override
    public void cerrarConexion() {
        em.close();
        emf.close();
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        Persona personaBuscada=em.find(Persona.class, persona.getId());
        if(personaBuscada!=null){
            em.getTransaction().begin();
            personaBuscada.setTieneDiscapacidad(true);
            em.getTransaction().commit();
            return personaBuscada;
        }
        return null;
    }

}
