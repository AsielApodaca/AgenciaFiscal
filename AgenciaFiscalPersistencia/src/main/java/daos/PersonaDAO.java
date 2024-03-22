/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Persona;
import entidades.Tramite;
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
        
        Predicate predicate=cb.equal(root.get("rfc"), persona.getRfc());
        criteria.select(root).where(predicate);
        
        TypedQuery<Persona> query=em.createQuery(criteria);
        Persona personaConsultada=query.getSingleResult();
        if(personaConsultada!=null)
            return personaConsultada;
        return null;
    }

    @Override
    public void agregarPersonas() {
        em.createStoredProcedureQuery("sp_insertar_personas",Persona.class);
    }

    @Override
    public void cerrarConexion() {
        em.close();
        emf.close();
    }

}
