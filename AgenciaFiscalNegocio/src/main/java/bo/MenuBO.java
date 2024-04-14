package bo;

import daos.EntidadesDAO;
import daos.IEntidadesDAO;
import iBo.IMenuBO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class MenuBO implements IMenuBO{
    private static IEntidadesDAO entidadesDAO;
    
    public MenuBO() {
        this.entidadesDAO = new EntidadesDAO();
    }
    
    @Override
    public Boolean verificarExistenciaDeEntidades() {
        return entidadesDAO.seCrearonEntidades();
    }
}
