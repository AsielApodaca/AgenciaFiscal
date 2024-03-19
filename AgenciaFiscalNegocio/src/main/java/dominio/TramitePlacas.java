package dominio;

import java.util.Calendar;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class TramitePlacas extends Tramite{
    private String matricula;
    private Vehiculo vehiculo;

    public TramitePlacas() {
        super();
    }

    public TramitePlacas(Calendar fechaEmision, Float costoMxn, Estado estado) {
        super(fechaEmision, costoMxn, estado);
    }

    public TramitePlacas(String matricula, Calendar fechaEmision, Float costoMxn, Estado estado) {
        super(fechaEmision, costoMxn, estado);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return super.toString() + "TramitePlacas{" + "matricula=" + matricula + ", vehiculo=" + vehiculo + '}';
    }
    
    
    
    
}
