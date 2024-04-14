package dominio;

import java.util.Calendar;

/**
 * Esta clase representa un trámite de placas de vehículo.
 * Un trámite de placas extiende la clase Tramite y añade propiedades específicas como la matrícula del vehículo asociado.
 * 
 * @author Asiel Apodaca Monge
 */
public class TramitePlacas extends Tramite{
    private String matricula;
    private Vehiculo vehiculo;

    /**
     * Constructor por defecto.
     */
    public TramitePlacas() {
        super();
    }

    /**
     * Constructor que inicializa las propiedades del trámite de placas.
     * 
     * @param fechaEmision La fecha de emisión del trámite.
     * @param costoMxn El costo del trámite en MXN.
     * @param estado El estado del trámite.
     */
    public TramitePlacas(Calendar fechaEmision, Float costoMxn, Estado estado) {
        super(fechaEmision, costoMxn, estado);
    }

    /**
     * Constructor que inicializa las propiedades del trámite de placas incluyendo la matrícula del vehículo asociado.
     * 
     * @param matricula La matrícula del vehículo asociado al trámite.
     * @param fechaEmision La fecha de emisión del trámite.
     * @param costoMxn El costo del trámite en MXN.
     * @param estado El estado del trámite.
     */
    public TramitePlacas(String matricula, Calendar fechaEmision, Float costoMxn, Estado estado) {
        super(fechaEmision, costoMxn, estado);
        this.matricula = matricula;
    }

    /**
     * Retorna la matrícula del vehículo asociado al trámite.
     * 
     * @return La matrícula del vehículo asociado al trámite.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del vehículo asociado al trámite.
     * 
     * @param matricula La matrícula del vehículo asociado al trámite.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Retorna el vehículo asociado al trámite.
     * 
     * @return El vehículo asociado al trámite.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehículo asociado al trámite.
     * 
     * @param vehiculo El vehículo asociado al trámite.
     */
    public void setVehiculo(Vehiculo vehiculo) {
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
