package iBo;

import excepciones.NegocioException;
import java.util.Calendar;
import java.util.List;
import negocioDTO.PersonaDTO;
import negocioDTO.TramiteDTO;

/**
 * Interfaz que define métodos para la generación de reportes en el sistema.
 * 
 * <p>Esta interfaz proporciona métodos para obtener y generar reportes basados en ciertos criterios, como fecha, tipo de trámite y persona.</p>
 * 
 * @author asielapodaca
 */
public interface IGenerarReporteBO {
    /**
     * Obtiene los trámites según los criterios especificados.
     * 
     * @param fechaDesde La fecha de inicio para filtrar los trámites.
     * @param fechaHasta La fecha de fin para filtrar los trámites.
     * @param tipoTramite El tipo de trámite utilizado para filtrar los trámites.
     * @param personaTramiteDTO La persona asociada al trámite utilizado para filtrar los trámites.
     * @return Una lista de trámites que cumplen con los criterios especificados.
     * @throws NegocioException Si ocurre un error durante la obtención de los trámites.
     */
    public List<TramiteDTO> obtenerTramites(Calendar fechaDesde, Calendar fechaHasta, String tipoTramite, PersonaDTO personaTramiteDTO) throws NegocioException;
    
    /**
     * Genera un archivo PDF a partir de una lista de trámites.
     * 
     * @param tramites La lista de trámites que se desea incluir en el archivo PDF.
     * @return true si el PDF se generó correctamente, false en caso contrario.
     * @throws NegocioException Si ocurre un error durante la generación del PDF.
     */
    public Boolean generarPDF(List<TramiteDTO> tramites) throws NegocioException;
}
