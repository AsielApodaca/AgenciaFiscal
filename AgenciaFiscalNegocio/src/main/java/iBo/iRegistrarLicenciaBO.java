package iBo;

import negocioDTO.PersonaDTO;
import negocioDTO.TramiteLicenciaDTO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public interface iRegistrarLicenciaBO {
    public PersonaDTO consultarPersonaPorRfc(String Rfc);
    public TramiteLicenciaDTO registrarLicencia(TramiteLicenciaDTO tramiteLicencia);
    public void cerrarConexiones();
    
}
