package iBo;

import java.util.List;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteLicenciaDTO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public interface iRegistrarLicenciaBO {
    public PersonaDTO consultarPersonaPorRfc(String Rfc);
    public boolean registrarLicencia(TramiteLicenciaDTO tramiteLicencia);
    public void cerrarConexiones();
    public PersonaDTO actualizarDiscapacidadPersona(PersonaDTO persona);
    public List<PersonaDTO> obtenerPersonasRegistradas();
}
