package iBo;

import excepciones.NegocioException;
import java.util.Calendar;
import java.util.List;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteDTO;

/**
 *
 * @author asielapodaca
 */
public interface IGenerarReporteBO {
    public List<TramiteDTO> obtenerTramites(Calendar fechaDesde, Calendar fechaHasta, String tipoTramite, PersonaDTO personaTramiteDTO) throws NegocioException;
}
