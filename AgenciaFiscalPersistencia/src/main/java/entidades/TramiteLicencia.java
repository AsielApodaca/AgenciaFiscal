/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luiis
 */
@Entity
@Table(name = "tramites_licencias")
public class TramiteLicencia extends Tramite implements Serializable {
    
    @Column(name = "vigencia")
    private Integer vigencia;
    
    @Column(name = "fecha_caducidad")
    @Temporal(TemporalType.DATE)
    private Calendar fechaCaducidad;
    
    @PreRemove
    @PrePersist
    @PreUpdate
    public void actualizarEstado() {
        if (fechaCaducidad != null && fechaCaducidad.before(Calendar.getInstance())) {
            super.setEstado(Estado.CADUCO);
        }
    }
    
    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public Calendar getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Calendar fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public TramiteLicencia() {
    }

    public TramiteLicencia(Integer vigencia, Calendar fechaCaducidad,
            Calendar fechaEmision, Float costoMxn, Estado estado, Persona persona) {
        super(fechaEmision, costoMxn, estado, persona);
        this.vigencia = vigencia;
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TramiteLicencia{");
        sb.append(super.toString());
        sb.append("vigencia=").append(vigencia);
        sb.append(", fechaCaducidad=").append(fechaToString(fechaCaducidad));
        sb.append('}');
        return sb.toString();
    }
    
}
