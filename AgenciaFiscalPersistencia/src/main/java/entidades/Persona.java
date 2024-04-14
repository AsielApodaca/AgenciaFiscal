/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import cifrado.CifradoAES;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @Column(name = "tiene_discapacidad")
    private Boolean tieneDiscapacidad;
    
    @OneToMany(mappedBy = "persona",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Tramite> tramites;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private List<Vehiculo> vehiculos;

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public void agregarVehiculo(Vehiculo vehiculo){
        this.vehiculos.add(vehiculo);
    }
    
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
        try {
            return CifradoAES.decrypt(telefono);
        } catch (Exception ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void setTelefono(String telefono) {
        try {
            this.telefono = CifradoAES.encrypt(telefono);
        } catch (Exception ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            this.telefono = null;
        }
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean esDiscapacitado() {
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

    public Persona(String rfc) {
        this.rfc = rfc;
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
        sb.append(", fechaNacimiento=").append(fechaToString());
        sb.append(", tieneDiscapacidad=").append(tieneDiscapacidad);
        sb.append('}');
        return sb.toString();
    }

    public String fechaToString(){
        SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(getFechaNacimiento().getTime());
    }
}
