package bo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import daos.ITramiteDAO;
import daos.TramiteDAO;
import negocioDTO.PersonaDTO;
import entidades.Persona;
import entidades.Tramite;
import entidades.TramiteLicencia;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import iBo.IGenerarReporteBO;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import negocioDTO.TramiteDTO;
import negocioDTO.TramiteLicenciaDTO;
import negocioDTO.TramitePlacasDTO;

/**
 * Implementación de la interfaz IGenerarReporteBO para generar reportes en formato PDF.
 * Esta clase se encarga de generar reportes en formato PDF basados en los trámites obtenidos.
 * @author Asiel Apodaca Monge
 */
public class GenerarReporteBO implements IGenerarReporteBO {

    private static ITramiteDAO tramiteDAO;

    /**
     * Constructor por defecto que inicializa el objeto de acceso a datos para trámites.
     */
    public GenerarReporteBO() {
        this.tramiteDAO = new TramiteDAO();
    }

    /**
     * Obtiene una lista de trámites basados en los parámetros especificados.
     * @param fechaDesde Fecha de inicio del intervalo de tiempo para filtrar trámites.
     * @param fechaHasta Fecha de fin del intervalo de tiempo para filtrar trámites.
     * @param tipoTramite Tipo de trámite a filtrar ("Trámite de licencia" o "Trámite de placas").
     * @param personaTramiteDTO Datos de la persona asociada a los trámites, o null si no se desea filtrar por persona.
     * @return Una lista de objetos de tipo TramiteDTO que representan los trámites obtenidos.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la consulta.
     */
    @Override
    public List<TramiteDTO> obtenerTramites(Calendar fechaDesde, Calendar fechaHasta, String tipoTramite, PersonaDTO personaTramiteDTO) throws NegocioException {
        try {
            Persona personaTramite = null;
            if (personaTramiteDTO != null) {
                personaTramite = new Persona(personaTramiteDTO.getRfc());
            }
            List<Tramite> tramites = tramiteDAO.obtenerTramites(fechaDesde, fechaHasta, tipoTramite, personaTramite);
            if (tramites == null) {
                return null;
            }

            List<TramiteDTO> tramitesDTO = new ArrayList<>();

            // Entidad tramite a Dto tramite
            for (Tramite tramite : tramites) {
                TramiteDTO tramiteDTO;
                if (tramite instanceof TramiteLicencia) {
                    tramiteDTO = new TramiteLicenciaDTO();
                } else {
                    tramiteDTO = new TramitePlacasDTO();
                }

                PersonaDTO personaDTO = new PersonaDTO();
                Persona persona = tramite.getPersona();
                personaDTO.setRfc(persona.getRfc());
                personaDTO.setNombreCompleto(persona.getNombreCompleto());

                tramiteDTO.setPersona(personaDTO);
                tramiteDTO.setFechaEmision(tramite.getFechaEmision());
                tramiteDTO.setCostoMxn(tramite.getCostoMxn());

                tramitesDTO.add(tramiteDTO);
            }

            return tramitesDTO;

        } catch (PersistenciaException pe) {
            throw new NegocioException(pe.getMessage());
        }

    }

    /**
     * Genera un archivo PDF con la lista de trámites proporcionada.
     * @param tramites Lista de trámites a incluir en el reporte.
     * @return true si el archivo PDF se generó exitosamente, false en caso contrario.
     * @throws NegocioException Si ocurre un error en la lógica de negocio durante la generación del PDF.
     */
    @Override
    public Boolean generarPDF(List<TramiteDTO> tramites) throws NegocioException {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            String nombreArchivo = ruta + "/Desktop/ConsultaGenerada.pdf";

            // Agregar metadatos
            documento.addTitle("Consulta Generada");
            documento.addCreationDate();
            documento.addAuthor("Tu Nombre");

            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

            // Crear un objeto PdfWriter para escribir en el documento
            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(nombreArchivo));

            // Agregar título, fecha y número de páginas al principio del documento
            writer.setPageEvent(new PdfPageEventHelper() {
                @Override
                public void onEndPage(PdfWriter writer, Document document) {
                    PdfNumber pageNumber = new PdfNumber(writer.getPageNumber());
                    writer.getDirectContent().saveState();
                    String texto = "Página " + writer.getPageNumber();
                    float distancia = 20;
                    float fontSize = 12;
                    float width = document.getPageSize().getWidth();
                    float height = document.getPageSize().getTop();
                    PdfContentByte canvas = writer.getDirectContent();
                    ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, new Phrase(texto, new Font(Font.FontFamily.HELVETICA, fontSize)), width - distancia, distancia, 0);
                    canvas.restoreState();
                }
            });

            documento.open();
            documento.add(new Paragraph("Reportes de trámites"));
            documento.add(new Paragraph("Fecha de creación: " + formatoFecha.format(Calendar.getInstance().getTime())));
            documento.add(new Paragraph(" "));

            PdfPTable tabla = new PdfPTable(4);
            tabla.addCell("Nombre Completo");
            tabla.addCell("Tipo");
            tabla.addCell("Fecha Emisión");
            tabla.addCell("Costo MXN");

            for (TramiteDTO tramite : tramites) {
                String tipo;
                if (tramite instanceof TramiteLicenciaDTO) {
                    tipo = "Trámite de licencia";
                } else {
                    tipo = "Trámite de placas";
                }

                tabla.addCell(tramite.getPersona().getNombreCompleto());
                tabla.addCell(tipo);
                tabla.addCell(formatoFecha.format(tramite.getFechaEmision().getTime()));
                tabla.addCell("$" + tramite.getCostoMxn());
            }

            documento.add(tabla);
            documento.close();
            return true;
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

}
