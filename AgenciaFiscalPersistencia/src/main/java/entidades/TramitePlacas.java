package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author luiis
 */
@Entity
@Table(name = "tramites_placas")
public class TramitePlacas extends Tramite implements Serializable {

    @Column(name = "matricula")
    private String matricula;
    
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo vehiculo;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula() {
        char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        // Generador de números aleatorios
        Random random = new Random();
        
        // Generar las tres letras aleatorias
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char letra = letras[random.nextInt(letras.length)];
            sb.append(letra);
        }
        
        // Agregar el guión
        sb.append("-");
        
        // Generar los tres dígitos aleatorios
        for (int i = 0; i < 3; i++) {
            int digito = random.nextInt(10); // Números del 0 al 9
            sb.append(digito);
        }
        this.matricula = sb.toString();
    }
    
    public void setMatricula(String matricula){
        this.matricula=matricula;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public TramitePlacas() {
    }
    
    
    public TramitePlacas(Vehiculo vehiculo, Calendar fechaEmision, Float costoMxn, Estado estado, Persona persona) {
        super(fechaEmision, costoMxn, estado, persona);
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TramitePlacas{");
        sb.append(super.toString());
        sb.append(", matricula=").append(matricula);
        sb.append(", serie vehiculo=").append(vehiculo.getSerie());
        sb.append('}');
        return sb.toString();
    }
    
    public String toStringReducido(){
        StringBuilder sb = new StringBuilder();
        sb.append("{matricula=").append(matricula);
        sb.append(", estado=").append(super.getEstado());
        sb.append("}");
        return sb.toString();
    }
}
