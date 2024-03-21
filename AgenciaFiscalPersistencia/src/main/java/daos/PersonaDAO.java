/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.Tramite;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
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
    
    public PersonaDAO(){
        emf=Persistence.createEntityManagerFactory("conexionPU");
        em=emf.createEntityManager();
    }
    
    @Override
    public Persona obtenerPersona(Persona persona) {
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteria=cb.createQuery(Persona.class);
        Root<Persona> root=criteria.from(Persona.class);
        
        Predicate predicate=cb.equal(root.get("id"), persona.getId());
        criteria.select(root).where(predicate);
        
        em.close();
        emf.close();
        return em.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Persona> agregarPersonas() {
        StoredProcedureQuery spq=em.createStoredProcedureQuery("sp_insertar_personas",Persona.class);
        
        em.close();
        emf.close();
        return spq.getResultList();
    }

    @Override
    public void agregarTramite(Persona persona,Tramite tramite) {
        Persona p=em.find(Persona.class, persona.getId());
        if(p!=null){
            p.agregarTramite(tramite);
            System.out.println("se agrego el tramite correctamente");
        }else
            System.out.println("no se encontro a la persona");
        em.close();
        emf.close();
    }

}
