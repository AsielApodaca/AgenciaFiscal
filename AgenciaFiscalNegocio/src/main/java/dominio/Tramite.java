package dominio;

import java.util.Calendar;

/**
 *
 * @author Asiel Apodaca Monge
 */
public abstract class Tramite {
    private Long id;
    private Calendar fechaEmision;
    private Float costoMxn;
    private Estado estado;
    private Persona persona;

    public Tramite() {
    }

    public Tramite(Calendar fechaEmision, Float costoMxn, Estado estado) {
        this.fechaEmision = fechaEmision;
        this.costoMxn = costoMxn;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", fechaEmision=" + fechaEmision + ", costoMxn=" + costoMxn + ", estado=" + estado + ", persona=" + persona + '}';
    }
    
    
}
