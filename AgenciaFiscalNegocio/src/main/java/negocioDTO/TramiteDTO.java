package negocioDTO;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Clase abstracta que representa un trámite.
 * 
 * <p>
 * Un trámite es una acción o procedimiento administrativo realizado en el sistema.
 * </p>
 * 
 * <p>
 * Esta clase proporciona métodos para obtener y establecer los atributos de un trámite, como la fecha de emisión, el costo, el estado y la persona asociada.
 * </p>
 * 
 * <p>
 * Tenga en cuenta que esta clase es abstracta y no debe ser instanciada directamente. En su lugar, debe ser extendida por clases concretas que representen tipos específicos de trámites.
 * </p>
 * 
 * @author Asiel Apodaca Monge
 */
public abstract class TramiteDTO {
    private Long id;
    private Calendar fechaEmision;
    private Float costoMxn;
    private EstadoDTO estado;
    private PersonaDTO persona;

    /**
     * Constructor por defecto.
     */
    public TramiteDTO() {
    }

    /**
     * Constructor que inicializa la fecha de emisión, el costo y el estado del trámite.
     * 
     * @param fechaEmision La fecha de emisión del trámite.
     * @param costoMxn El costo del trámite en moneda mexicana.
     * @param estado El estado del trámite.
     */
    public TramiteDTO(Calendar fechaEmision, Float costoMxn, EstadoDTO estado) {
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
     * Retorna el costo del trámite en moneda mexicana.
     * 
     * @return El costo del trámite en moneda mexicana.
     */
    public Float getCostoMxn() {
        return costoMxn;
    }

    /**
     * Establece el costo del trámite en moneda mexicana.
     * 
     * @param costoMxn El costo del trámite en moneda mexicana.
     */
    public void setCostoMxn(Float costoMxn) {
        this.costoMxn = costoMxn;
    }

    /**
     * Retorna el estado del trámite.
     * 
     * @return El estado del trámite.
     */
    public EstadoDTO getEstado() {
        return estado;
    }

    /**
     * Establece el estado del trámite.
     * 
     * @param estado El estado del trámite.
     */
    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }

    /**
     * Retorna la persona asociada al trámite.
     * 
     * @return La persona asociada al trámite.
     */
    public PersonaDTO getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al trámite.
     * 
     * @param persona La persona asociada al trámite.
     */
    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    /**
     * Retorna una representación en forma de cadena del trámite.
     * 
     * @return Una cadena que representa el trámite.
     */
    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + 
                ", fechaEmision=" + fechaEmision + 
                ", costoMxn=" + costoMxn + 
                ", estado=" + estado + 
                ", persona=" + toStringPersona() + '}';
    }
    
    /**
     * Genera una representación reducida del trámite como una cadena.
     * 
     * @return Una cadena que representa el trámite de forma reducida.
     */
    public String toStringReducido(){
        StringBuilder sb=new StringBuilder();
        sb.append("{id tramite: ").append(id);
        sb.append(", fecha emision: ").append(fechaToString(fechaEmision));
        sb.append(", costo: ").append(costoMxn);
        sb.append(", estado: ").append(estado);
        sb.append("}");
        return sb.toString();
    }
    
    /**
     * Convierte una fecha en formato de calendario a una cadena formateada.
     * 
     * @param fecha La fecha a formatear.
     * @return La fecha formateada como una cadena.
     */
    public String fechaToString(Calendar fecha){
        SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fecha.getTime());
    }
    
    /**
     * Retorna una representación reducida de la persona asociada al trámite como una cadena.
     * 
     * @return Una cadena que representa la persona asociada al trámite de forma reducida.
     */
    private String toStringPersona(){
        return persona.toStringReducido();
    }
}
