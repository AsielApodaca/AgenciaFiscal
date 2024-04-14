package dominio;

import java.util.Calendar;

/**
 * Esta clase representa un trámite de licencia de conducir.
 * Un trámite de licencia de conducir extiende la clase Tramite y añade propiedades específicas como vigencia, fecha de caducidad y número de licencia.
 * 
 * @author Asiel Apodaca Monge
 */
public class TramiteLicencia extends Tramite{
    private Integer vigencia; 
    private Calendar fechaCaducidad;
    private String numLicencia;

    /**
     * Constructor por defecto.
     */
    public TramiteLicencia() {
        super();
    }

    /**
     * Constructor que inicializa las propiedades del trámite de licencia.
     * 
     * @param fechaEmision La fecha de emisión del trámite.
     * @param costoMxn El costo del trámite en MXN.
     * @param estado El estado del trámite.
     */
    public TramiteLicencia(Calendar fechaEmision, Float costoMxn, Estado estado) {
        super(fechaEmision, costoMxn, estado);
    }

    /**
     * Constructor que inicializa las propiedades del trámite de licencia incluyendo la vigencia.
     * 
     * @param vigencia La vigencia de la licencia en años.
     * @param fechaEmision La fecha de emisión del trámite.
     * @param costoMxn El costo del trámite en MXN.
     * @param estado El estado del trámite.
     */
    public TramiteLicencia(Integer vigencia, Calendar fechaEmision, Float costoMxn, Estado estado) {
        super(fechaEmision, costoMxn, estado);
        this.vigencia = vigencia;
    }

    /**
     * Retorna el número de licencia asociado al trámite.
     * 
     * @return El número de licencia asociado al trámite.
     */
    public String getNumLicencia() {
        return numLicencia;
    }

    /**
     * Establece el número de licencia asociado al trámite.
     * 
     * @param numLicencia El número de licencia asociado al trámite.
     */
    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }
    
    /**
     * Retorna la vigencia de la licencia en años.
     * 
     * @return La vigencia de la licencia en años.
     */
    public Integer getVigencia() {
        return vigencia;
    }

    /**
     * Establece la vigencia de la licencia en años y calcula la fecha de caducidad basada en la fecha de emisión y la vigencia.
     * 
     * @param vigencia La vigencia de la licencia en años.
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
     * Retorna una representación en forma de cadena del trámite de licencia.
     * 
     * @return Una cadena que representa el trámite de licencia.
     */
    @Override
    public String toString() {
        return super.toString() + "TramiteLicencia{" + "vigencia=" + vigencia + ", fechaCaducidad=" + fechaCaducidad + '}';
    }  
}
