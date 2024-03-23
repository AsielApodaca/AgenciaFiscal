package negocioDTO;


import java.util.Calendar;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class TramiteLicenciaDTO extends TramiteDTO{
    private Integer vigencia; 
    private Calendar fechaCaducidad;

    public TramiteLicenciaDTO() {
        super();
    }

    public TramiteLicenciaDTO(Calendar fechaEmision, Float costoMxn, EstadoDTO estado) {
        super(fechaEmision, costoMxn, estado);
    }

    public TramiteLicenciaDTO(Integer vigencia, Calendar fechaEmision, Float costoMxn, EstadoDTO estado) {
        super(fechaEmision, costoMxn, estado);
        this.vigencia = vigencia;
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
        return super.toString() + "TramiteLicencia{" + 
                "vigencia=" + vigencia + 
                ", fechaCaducidad=" + fechaCaducidad + '}';
    }

    
    
}
