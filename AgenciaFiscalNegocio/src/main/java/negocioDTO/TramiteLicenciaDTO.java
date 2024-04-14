package negocioDTO;

import java.util.Calendar;

/**
 * Clase que representa un trámite de licencia.
 * Extiende la clase abstracta TramiteDTO.
 * 
 * <p>Un trámite de licencia es un tipo específico de trámite que se emite para autorizar la conducción de vehículos por parte de una persona.</p>
 * 
 * <p>Este trámite incluye información adicional como la vigencia de la licencia, la fecha de caducidad y el número de licencia.</p>
 * 
 * <p>Tenga en cuenta que esta clase es una representación de un trámite de licencia en el sistema.</p>
 * 
 * <p>No se espera que esta clase sea instanciada directamente, sino que se debe crear una instancia de ella a través de los métodos correspondientes del sistema.</p>
 * 
 * @author Asiel Apodaca Monge
 */
public class TramiteLicenciaDTO extends TramiteDTO{
    private Integer vigencia; 
    private Calendar fechaCaducidad;
    private String numLicencia;

    /**
     * Retorna el número de licencia.
     * 
     * @return El número de licencia.
     */
    public String getNumLicencia() {
        return numLicencia;
    }

    /**
     * Establece el número de licencia.
     * 
     * @param numLicencia El número de licencia.
     */
    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    /**
     * Constructor por defecto.
     */
    public TramiteLicenciaDTO() {
        super();
    }

    /**
     * Constructor que inicializa la fecha de emisión, el costo y el estado del trámite de licencia.
     * 
     * @param fechaEmision La fecha de emisión del trámite.
     * @param costoMxn El costo del trámite en moneda mexicana.
     * @param estado El estado del trámite.
     */
    public TramiteLicenciaDTO(Calendar fechaEmision, Float costoMxn, EstadoDTO estado) {
        super(fechaEmision, costoMxn, estado);
    }

    /**
     * Constructor que inicializa la vigencia, la fecha de emisión, el costo y el estado del trámite de licencia.
     * 
     * @param vigencia La vigencia de la licencia.
     * @param fechaEmision La fecha de emisión del trámite.
     * @param costoMxn El costo del trámite en moneda mexicana.
     * @param estado El estado del trámite.
     */
    public TramiteLicenciaDTO(Integer vigencia, Calendar fechaEmision, Float costoMxn, EstadoDTO estado) {
        super(fechaEmision, costoMxn, estado);
        this.vigencia = vigencia;
    }

    /**
     * Retorna la vigencia de la licencia.
     * 
     * @return La vigencia de la licencia.
     */
    public Integer getVigencia() {
        return vigencia;
    }

    /**
     * Establece la vigencia de la licencia y calcula la fecha de caducidad en función de ella.
     * 
     * @param vigencia La vigencia de la licencia.
     */
    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, vigencia);
        this.fechaCaducidad = calendar;
    }

    /**
     * Retorna la fecha de caducidad de la licencia.
     * 
     * @return La fecha de caducidad de la licencia.
     */
    public Calendar getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * Establece la fecha de caducidad de la licencia.
     * 
     * @param fecha La fecha de caducidad de la licencia.
     */
    public void setFechaCaducidad(Calendar fecha){
        this.fechaCaducidad=fecha;
    }
    
    /**
     * Retorna una representación en forma de cadena del trámite de licencia.
     * 
     * @return Una cadena que representa el trámite de licencia.
     */
    @Override
    public String toString() {
        return super.toString() + "TramiteLicencia{" + 
                "vigencia=" + vigencia + 
                ", fechaCaducidad=" + fechaToString(fechaCaducidad) + 
                ", numero licencia=" + numLicencia +
                '}';
    }
}
