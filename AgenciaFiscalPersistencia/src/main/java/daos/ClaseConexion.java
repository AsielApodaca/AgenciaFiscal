package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Esta clase proporciona métodos para obtener una instancia de EntityManager, 
 * que se utiliza para interactuar con la base de datos, y para cerrar la conexión 
 * con la base de datos cuando ya no es necesaria.
 * 
 * author luiis
 */
public class ClaseConexion {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexionPU");
    private static EntityManager em;
    
    private ClaseConexion() {}
    
    /**
     * Obtiene una instancia compartida de EntityManager.
     * 
     * @return Una instancia de EntityManager.
     */
    public static synchronized EntityManager getEntityManager() {
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }
    
    /**
     * Cierra la conexión con la base de datos y libera los recursos asociados.
     */
    public static void cerrarConexion() {
        if (em.isOpen()) {
            em.close();
            System.out.println("entity manager cerrado");
        }
        if (emf.isOpen()) {
            emf.close();
            System.out.println("entity manager factory cerrado");
        }
    }
}
