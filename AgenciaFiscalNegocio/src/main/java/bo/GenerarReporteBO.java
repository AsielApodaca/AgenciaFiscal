package bo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import daos.ITramiteDAO;
import daos.TramiteDAO;
import negocioDTO.PersonaDTO;
import entidades.Persona;
import entidades.Tramite;
import entidades.Estado;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocioDTO.TramiteDTO;
import negocioDTO.TramiteLicenciaDTO;
import negocioDTO.TramitePlacasDTO;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class GenerarReporteBO implements IGenerarReporteBO{

    private static ITramiteDAO tramiteDAO;
    
    public GenerarReporteBO() {
        this.tramiteDAO = new TramiteDAO();
    }
    
    @Override
    public List<TramiteDTO> obtenerTramites(Calendar fechaDesde, Calendar fechaHasta, String tipoTramite, PersonaDTO personaTramiteDTO) throws NegocioException {
        try {
            Persona personaTramite = null;
            if(personaTramiteDTO != null){
                personaTramite = new Persona(personaTramiteDTO.getRfc());
            }
            List<Tramite> tramites = tramiteDAO.obtenerTramites(fechaDesde, fechaHasta, tipoTramite, personaTramite);
            if(tramites == null) return null;
            
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
    
    @Override
    public Boolean generarPDF(List<TramiteDTO> tramites) throws NegocioException {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ConsultaGenerada.pdf"));
            documento.open();


            PdfPTable tabla = new PdfPTable(4);
            tabla.addCell("Nombre Completo");
            tabla.addCell("Tipo");
            tabla.addCell("Fecha Emisión");
            tabla.addCell("Costo MXN");
          

            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            
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
