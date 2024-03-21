package negocioDTO;


import java.util.Calendar;

/**
 *
 * @author Asiel Apodaca Monge
 */
public abstract class TramiteDto {
    private Long id;
    private Calendar fechaEmision;
    private Float costoMxn;
    private EstadoDto estado;
    private PersonaDto persona;

    public TramiteDto() {
    }

    public TramiteDto(Calendar fechaEmision, Float costoMxn, EstadoDto estado) {
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

    public EstadoDto getEstado() {
        return estado;
    }

    public void setEstado(EstadoDto estado) {
        this.estado = estado;
    }

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", fechaEmision=" + fechaEmision + ", costoMxn=" + costoMxn + ", estado=" + estado + ", persona=" + persona + '}';
    }
    
    
}
