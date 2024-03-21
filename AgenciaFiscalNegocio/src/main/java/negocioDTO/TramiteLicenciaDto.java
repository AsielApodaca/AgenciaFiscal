package negocioDTO;


import java.util.Calendar;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class TramiteLicenciaDto extends TramiteDto{
    private Integer vigencia; 
    private Calendar fechaCaducidad;

    public TramiteLicenciaDto() {
        super();
    }

    public TramiteLicenciaDto(Calendar fechaEmision, Float costoMxn, EstadoDto estado) {
        super(fechaEmision, costoMxn, estado);
    }

    public TramiteLicenciaDto(Integer vigencia, Calendar fechaEmision, Float costoMxn, EstadoDto estado) {
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
        return super.toString() + "TramiteLicencia{" + "vigencia=" + vigencia + ", fechaCaducidad=" + fechaCaducidad + '}';
    }

    
    
}
