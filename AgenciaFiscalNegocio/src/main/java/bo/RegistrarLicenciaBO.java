package bo;

import iBo.iRegistrarLicenciaBO;
import negocioDTO.PersonaDTO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class RegistrarLicenciaBO implements iRegistrarLicenciaBO{

    public RegistrarLicenciaBO() {
    }

    
    @Override
    public PersonaDTO consultarPersonaPorRfc(String Rfc) {
        return null;
    }

    @Override
    public Boolean registrarLicencia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
