/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luiis
 */
@Entity
@Table(name="personas")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "rfc")
    private String rfc;
    
    @Column(name = "curp")
    private String curp;
    
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    @Column(name = "tiene_discacidad")
    private boolean tieneDiscapacidad;
    
    @OneToMany(mappedBy = "persona",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Tramite> tramites;

    public List<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    public void agregarTramite(Tramite tramite){
        this.tramites.add(tramite);
    }
    
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isTieneDiscapacidad() {
        return tieneDiscapacidad;
    }

    public void setTieneDiscapacidad(boolean tieneDiscapacidad) {
        this.tieneDiscapacidad = tieneDiscapacidad;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona() {
        super();
        this.tramites=new ArrayList<>();
    }

    public Persona(String rfc, String curp, String nombreCompleto, String telefono, Calendar fechaNacimiento, boolean tieneDiscapacidad) {
        this.rfc = rfc;
        this.curp = curp;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.tieneDiscapacidad = tieneDiscapacidad;
        this.tramites=new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("id=").append(id);
        sb.append(", rfc=").append(rfc);
        sb.append(", curp=").append(curp);
        sb.append(", nombreCompleto=").append(nombreCompleto);
        sb.append(", telefono=").append(telefono);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", tieneDiscapacidad=").append(tieneDiscapacidad);
        sb.append('}');
        return sb.toString();
    }

    
}
