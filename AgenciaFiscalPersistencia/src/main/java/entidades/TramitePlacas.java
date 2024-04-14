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
 * Clase que representa un trámite de placas en el sistema.
 * Extiende la clase Tramite.
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

    /**
     * Devuelve la matrícula asociada al trámite de placas.
     * @return La matrícula del vehículo.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Genera una matrícula aleatoria y la establece.
     */
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
    
    /**
     * Establece la matrícula asociada al trámite de placas.
     * @param matricula La matrícula del vehículo.
     */
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    /**
     * Devuelve el vehículo asociado al trámite de placas.
     * @return El vehículo asociado al trámite.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehículo asociado al trámite de placas.
     * @param vehiculo El vehículo asociado al trámite.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Constructor por defecto de la clase TramitePlacas.
     */
    public TramitePlacas() {
    }
    
    
    /**
     * Constructor de la clase TramitePlacas con todos los atributos.
     * @param vehiculo Vehículo asociado al trámite.
     * @param fechaEmision Fecha de emisión del trámite.
     * @param costoMxn Costo en MXN del trámite.
     * @param estado Estado del trámite.
     * @param persona Persona asociada al trámite.
     */
    public TramitePlacas(Vehiculo vehiculo, Calendar fechaEmision, Float costoMxn, Estado estado, Persona persona) {
        super(fechaEmision, costoMxn, estado, persona);
        this.vehiculo = vehiculo;
    }

    /**
     * Método toString para la clase TramitePlacas.
     * @return Representación en cadena del trámite de placas.
     */
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
    
    /**
     * Devuelve una representación reducida en cadena del trámite de placas.
     * @return Representación reducida en cadena del trámite de placas.
     */
    public String toStringReducido(){
        StringBuilder sb = new StringBuilder();
        sb.append("{matricula=").append(matricula);
        sb.append(", estado=").append(super.getEstado());
        sb.append("}");
        return sb.toString();
    }
}
