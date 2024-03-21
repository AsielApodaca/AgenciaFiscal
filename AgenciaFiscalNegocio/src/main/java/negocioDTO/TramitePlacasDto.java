package negocioDTO;


import java.util.Calendar;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class TramitePlacasDTO extends TramiteDTO{
    private String matricula;
    private VehiculoDTO vehiculo;

    public TramitePlacasDTO() {
        super();
    }

    public TramitePlacasDTO(Calendar fechaEmision, Float costoMxn, EstadoDTO estado) {
        super(fechaEmision, costoMxn, estado);
    }

    public TramitePlacasDTO(String matricula, Calendar fechaEmision, Float costoMxn, EstadoDTO estado) {
        super(fechaEmision, costoMxn, estado);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return super.toString() + "TramitePlacas{" + "matricula=" + matricula + ", vehiculo=" + vehiculo + '}';
    }
    
    
    
    
}
