package bo;

import daos.IPersonaDAO;
import daos.PersonaDAO;
import excepciones.PersistenciaException;
import iBo.IMenuBO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la interfaz IMenuBO para verificar la existencia de entidades en el sistema.
 * Esta clase se encarga de verificar si existen registros en la tabla de personas.
 * @author Asiel Apodaca Monge
 */
public class MenuBO implements IMenuBO{
    private static IPersonaDAO personaDAO;
    
    /**
     * Constructor por defecto que inicializa el objeto de acceso a datos para personas.
     */
    public MenuBO() {
        this.personaDAO = new PersonaDAO();
    }
    
    /**
     * Verifica si existen entidades en el sistema.
     * @return true si existen registros en la tabla de personas, false si está vacía.
     */
    @Override
    public boolean verificarExistenciaDeEntidades() {
        try {
            return !personaDAO.tablaPersonasEstaVacia();
        } catch (PersistenciaException ex) {
            Logger.getLogger(MenuBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
