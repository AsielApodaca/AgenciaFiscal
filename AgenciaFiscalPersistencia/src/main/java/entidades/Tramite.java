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
 * Clase que representa un trámite en el sistema.
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

    /**
     * Devuelve la persona asociada al trámite.
     * @return Persona asociada al trámite.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al trámite.
     * @param persona Persona asociada al trámite.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    /**
     * Devuelve la fecha de emisión del trámite.
     * @return Fecha de emisión del trámite.
     */
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la fecha de emisión del trámite.
     * @param fechaEmision Fecha de emisión del trámite.
     */
    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Devuelve el costo en MXN del trámite.
     * @return Costo en MXN del trámite.
     */
    public Float getCostoMxn() {
        return costoMxn;
    }

    /**
     * Establece el costo en MXN del trámite.
     * @param costoMxn Costo en MXN del trámite.
     */
    public void setCostoMxn(Float costoMxn) {
        this.costoMxn = costoMxn;
    }

    /**
     * Devuelve el estado del trámite.
     * @return Estado del trámite.
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado del trámite.
     * @param estado Estado del trámite.
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    /**
     * Devuelve el ID del trámite.
     * @return ID del trámite.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del trámite.
     * @param id ID del trámite.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Constructor por defecto de la clase Tramite.
     */
    public Tramite() {
    }

    /**
     * Constructor de la clase Tramite con todos los atributos.
     * @param fechaEmision Fecha de emisión del trámite.
     * @param costoMxn Costo en MXN del trámite.
     * @param estado Estado del trámite.
     * @param persona Persona asociada al trámite.
     */
    public Tramite(Calendar fechaEmision, Float costoMxn, Estado estado, Persona persona) {
        this.fechaEmision = fechaEmision;
        this.costoMxn = costoMxn;
        this.estado = estado;
        this.persona=persona;
    }
    
    /**
     * Convierte la fecha de emisión a una cadena en el formato "yyyy-MM-dd".
     * @return Fecha de emisión en formato de cadena.
     */
    public String getFechaEmisionString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fechaEmision.getTime());
    }

    /**
     * Método toString para la clase Tramite.
     * @return Representación en cadena del trámite.
     */
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

    /**
     * Convierte una fecha a una cadena en el formato "yyyy-MM-dd".
     * @param fecha Fecha a convertir.
     * @return Fecha en formato de cadena.
     */
    public String fechaToString(Calendar fecha){
        SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fecha.getTime());
    }
    
}
