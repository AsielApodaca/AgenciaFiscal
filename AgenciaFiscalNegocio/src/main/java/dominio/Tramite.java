package dominio;

import java.util.Calendar;

/**
 * Esta clase abstracta representa un trámite genérico.
 * Un trámite tiene una fecha de emisión, un costo en MXN, un estado y una persona asociada.
 * Esta clase es abstracta ya que se espera que sea extendida por clases específicas de trámites.
 * 
 * @author Asiel Apodaca Monge
 */
public abstract class Tramite {
    private Long id;
    private Calendar fechaEmision;
    private Float costoMxn;
    private Estado estado;
    private Persona persona;

    /**
     * Constructor por defecto.
     */
    public Tramite() {
    }

    /**
     * Constructor que inicializa las propiedades del trámite.
     * 
     * @param fechaEmision La fecha de emisión del trámite.
     * @param costoMxn El costo del trámite en MXN.
     * @param estado El estado del trámite.
     */
    public Tramite(Calendar fechaEmision, Float costoMxn, Estado estado) {
        this.fechaEmision = fechaEmision;
        this.costoMxn = costoMxn;
        this.estado = estado;
    }

    /**
     * Retorna el ID del trámite.
     * 
     * @return El ID del trámite.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del trámite.
     * 
     * @param id El ID del trámite.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna la fecha de emisión del trámite.
     * 
     * @return La fecha de emisión del trámite.
     */
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la fecha de emisión del trámite.
     * 
     * @param fechaEmision La fecha de emisión del trámite.
     */
    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Retorna el costo del trámite en MXN.
     * 
     * @return El costo del trámite en MXN.
     */
    public Float getCostoMxn() {
        return costoMxn;
    }

    /**
     * Establece el costo del trámite en MXN.
     * 
     * @param costoMxn El costo del trámite en MXN.
     */
    public void setCostoMxn(Float costoMxn) {
        this.costoMxn = costoMxn;
    }

    /**
     * Retorna el estado del trámite.
     * 
     * @return El estado del trámite.
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado del trámite.
     * 
     * @param estado El estado del trámite.
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Retorna la persona asociada al trámite.
     * 
     * @return La persona asociada al trámite.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al trámite.
     * 
     * @param persona La persona asociada al trámite.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Retorna una representación en forma de cadena del trámite.
     * 
     * @return Una cadena que representa el trámite.
     */
    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", fechaEmision=" + fechaEmision + ", costoMxn=" + costoMxn + ", estado=" + estado + ", persona=" + persona + '}';
    }   
}
