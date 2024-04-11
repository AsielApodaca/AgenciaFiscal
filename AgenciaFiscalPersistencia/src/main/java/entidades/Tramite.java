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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luiis
 */
@Entity
@Table(name = "tramites")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tramite")
    private Long id;
    
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Calendar fechaEmision;
    
    @Column(name="costo_mxn")
    private Float costoMxn;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name="id_persona",nullable=false)
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Float getCostoMxn() {
        return costoMxn;
    }

    public void setCostoMxn(Float costoMxn) {
        this.costoMxn = costoMxn;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tramite() {
    }

    public Tramite(Calendar fechaEmision, Float costoMxn, Estado estado, Persona persona) {
        this.fechaEmision = fechaEmision;
        this.costoMxn = costoMxn;
        this.estado = estado;
        this.persona=persona;
    }
    
    public String getFechaEmisionString() {
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    return formatoFecha.format(fechaEmision.getTime());
}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tramite{");
        sb.append("id=").append(id);
        sb.append(", fechaEmision=").append(fechaToString(fechaEmision));
        sb.append(", costoMxn=").append(costoMxn);
        sb.append(", estado=").append(estado);
        sb.append(", persona=").append(persona);
        sb.append('}');
        return sb.toString();
    }

    public String fechaToString(Calendar fecha){
        SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fecha.getTime());
    }
    
}
