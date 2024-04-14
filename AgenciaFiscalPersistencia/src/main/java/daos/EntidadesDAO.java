package daos;

import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class EntidadesDAO implements IEntidadesDAO{
    private EntityManager em;

    public EntidadesDAO() {
        this.em=ClaseConexion.getEntityManager();
    }
    
    @Override
    public Boolean seCrearonEntidades() {
        // Obtiene el metamodelo de la base de datos
        Map<String, EntityType<?>> metamodel = (Map<String, EntityType<?>>) em.getMetamodel().getEntities();
        
        boolean tablasEncontradas = false;

        // Itera sobre el metamodelo para verificar la existencia de tablas
        for (String entityName : metamodel.keySet()) {
            System.out.println("Tabla encontrada: " + entityName);
            tablasEncontradas = true;
        }
        
        return tablasEncontradas;
    }
    
}
