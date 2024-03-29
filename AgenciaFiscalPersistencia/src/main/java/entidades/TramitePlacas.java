/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    
    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false)//o serie_vehiculo
    private Vehiculo vehiculo;

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

    public TramitePlacas() {
    }
    
    
    public TramitePlacas(String matricula, Vehiculo vehiculo, Calendar fechaEmision, Float costoMxn, Estado estado, Persona persona) {
        super(fechaEmision, costoMxn, estado, persona);
        this.matricula = matricula;
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
