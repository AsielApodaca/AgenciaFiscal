package negocioDTO;


import java.util.Calendar;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class TramitePlacasDto extends TramiteDto{
    private String matricula;
    private VehiculoDto vehiculo;

    public TramitePlacasDto() {
        super();
    }

    public TramitePlacasDto(Calendar fechaEmision, Float costoMxn, EstadoDto estado) {
        super(fechaEmision, costoMxn, estado);
    }

    public TramitePlacasDto(String matricula, Calendar fechaEmision, Float costoMxn, EstadoDto estado) {
        super(fechaEmision, costoMxn, estado);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public VehiculoDto getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDto vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return super.toString() + "TramitePlacas{" + "matricula=" + matricula + ", vehiculo=" + vehiculo + '}';
    }
    
    
    
    
}
