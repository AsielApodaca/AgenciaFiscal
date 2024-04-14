package bo;

import daos.IPersonaDAO;
import daos.PersonaDAO;
import excepciones.PersistenciaException;
import iBo.IMenuBO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class MenuBO implements IMenuBO{
    private static IPersonaDAO personaDAO;
    
    public MenuBO() {
        this.personaDAO = new PersonaDAO();
    }
    
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
