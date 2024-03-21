package iBo;

import negocioDTO.PersonaDTO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public interface iRegistrarLicenciaBO {
    public PersonaDTO consultarPersonaPorRfc(String Rfc);
    public String registrarLicencia();
    
}
