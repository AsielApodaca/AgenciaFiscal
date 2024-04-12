package dominio;

import java.util.Calendar;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class TramiteLicencia extends Tramite{
    private Integer vigencia; 
    private Calendar fechaCaducidad;
    private String numLicencia;

    public TramiteLicencia() {
        super();
    }

    public TramiteLicencia(Calendar fechaEmision, Float costoMxn, Estado estado) {
        super(fechaEmision, costoMxn, estado);
    }

    public TramiteLicencia(Integer vigencia, Calendar fechaEmision, Float costoMxn, Estado estado) {
        super(fechaEmision, costoMxn, estado);
        this.vigencia = vigencia;
    }

    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }
    
    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, vigencia);
        this.fechaCaducidad = calendar;
    }

    public Calendar getFechaCaducidad() {
        return fechaCaducidad;
    }

    @Override
    public String toString() {
        return super.toString() + "TramiteLicencia{" + "vigencia=" + vigencia + ", fechaCaducidad=" + fechaCaducidad + '}';
    }

    
    
}
