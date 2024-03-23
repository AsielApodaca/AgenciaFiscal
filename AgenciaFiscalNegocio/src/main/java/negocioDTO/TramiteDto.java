package negocioDTO;


import java.util.Calendar;

/**
 *
 * @author Asiel Apodaca Monge
 */
public abstract class TramiteDTO {
    private Long id;
    private Calendar fechaEmision;
    private Float costoMxn;
    private EstadoDTO estado;
    private PersonaDTO persona;

    public TramiteDTO() {
    }

    public TramiteDTO(Calendar fechaEmision, Float costoMxn, EstadoDTO estado) {
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

    public EstadoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + 
                ", fechaEmision=" + fechaEmision + 
                ", costoMxn=" + costoMxn + 
                ", estado=" + estado + 
                ", persona=" + toStringPersona() + '}';
    }
    
    private String toStringPersona(){
        return persona.toStringReducido();
    }
    
    public String toStringReducido(){
        StringBuilder sb=new StringBuilder();
        sb.append("{id tramite: ").append(id);
        sb.append(", fecha emision: ").append(fechaEmision);
        sb.append(", costo: ").append(costoMxn);
        sb.append(", estado: ").append(estado);
        sb.append("}");
        return sb.toString();
    }
}
