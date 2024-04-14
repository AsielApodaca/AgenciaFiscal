package negocioDTO;

import java.util.Calendar;

/**
 * Clase que representa un trámite de placas.
 * Extiende la clase abstracta TramiteDTO.
 * 
 * <p>Un trámite de placas es un tipo específico de trámite que se emite para autorizar la circulación de un vehículo.</p>
 * 
 * <p>Este trámite incluye información adicional como la matrícula del vehículo asociado.</p>
 * 
 * <p>Tenga en cuenta que esta clase es una representación de un trámite de placas en el sistema.</p>
 * 
 * <p>No se espera que esta clase sea instanciada directamente, sino que se debe crear una instancia de ella a través de los métodos correspondientes del sistema.</p>
 * 
 * @author Asiel Apodaca Monge
 */
public class TramitePlacasDTO extends TramiteDTO{
    private String matricula;
    private VehiculoDTO vehiculo;

    /**
     * Constructor por defecto.
     */
    public TramitePlacasDTO() {
        super();
    }

    /**
     * Constructor que inicializa la fecha de emisión, el costo y el estado del trámite de placas.
     * 
     * @param fechaEmision La fecha de emisión del trámite.
     * @param costoMxn El costo del trámite en moneda mexicana.
     * @param estado El estado del trámite.
     */
    public TramitePlacasDTO(Calendar fechaEmision, Float costoMxn, EstadoDTO estado) {
        super(fechaEmision, costoMxn, estado);
    }

    /**
     * Constructor que inicializa la matrícula, la fecha de emisión, el costo y el estado del trámite de placas.
     * 
     * @param matricula La matrícula del vehículo.
     * @param fechaEmision La fecha de emisión del trámite.
     * @param costoMxn El costo del trámite en moneda mexicana.
     * @param estado El estado del trámite.
     */
    public TramitePlacasDTO(String matricula, Calendar fechaEmision, Float costoMxn, EstadoDTO estado) {
        super(fechaEmision, costoMxn, estado);
        this.matricula = matricula;
    }

    /**
     * Retorna la matrícula del vehículo asociado al trámite de placas.
     * 
     * @return La matrícula del vehículo asociado.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del vehículo asociado al trámite de placas.
     * 
     * @param matricula La matrícula del vehículo asociado.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Retorna el vehículo asociado al trámite de placas.
     * 
     * @return El vehículo asociado al trámite.
     */
    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehículo asociado al trámite de placas.
     * 
     * @param vehiculo El vehículo asociado al trámite.
     */
    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Retorna una representación en forma de cadena del trámite de placas.
     * 
     * @return Una cadena que representa el trámite de placas.
     */
    @Override
    public String toString() {
        return super.toString() + "TramitePlacas{" + "matricula=" + matricula + ", vehiculo=" + vehiculo + '}';
    }
}
