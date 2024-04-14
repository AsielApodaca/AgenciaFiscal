package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa un trámite de licencia en el sistema.
 * Extiende la clase Tramite.
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
    
    @Column(name = "num_licencia", unique = true)
    private String numLicencia;

    /**
     * Devuelve el número de licencia.
     * @return Número de licencia.
     */
    public String getNumLicencia() {
        return numLicencia;
    }

    /**
     * Genera un número de licencia aleatorio y lo establece.
     */
    public void setNumLicencia() {
        Random r = new Random();
        long random = Math.abs(r.nextLong() % 1000000000L);
        this.numLicencia = String.valueOf(random);
    }
    
    /**
     * Establece el número de licencia.
     * @param numLicencia Número de licencia a establecer.
     */
    public void setNumLicencia(String numLicencia){
        this.numLicencia = numLicencia;
    }
    
    /**
     * Actualiza el estado del trámite según la fecha de caducidad.
     */
    @PreRemove
    @PrePersist
    @PreUpdate
    public void actualizarEstado() {
        if (fechaCaducidad != null && fechaCaducidad.before(Calendar.getInstance())) {
            super.setEstado(Estado.CADUCO);
        }
    }
    
    /**
     * Devuelve la vigencia de la licencia.
     * @return Vigencia de la licencia.
     */
    public Integer getVigencia() {
        return vigencia;
    }

    /**
     * Establece la vigencia de la licencia y calcula su fecha de caducidad.
     * @param vigencia Vigencia de la licencia en años.
     */
    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, vigencia);
        this.fechaCaducidad = calendar;
    }

    /**
     * Devuelve la fecha de caducidad de la licencia.
     * @return Fecha de caducidad de la licencia.
     */
    public Calendar getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * Establece la fecha de caducidad de la licencia.
     * @param fechaCaducidad Fecha de caducidad de la licencia.
     */
    public void setFechaCaducidad(Calendar fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    /**
     * Constructor por defecto de la clase TramiteLicencia.
     */
    public TramiteLicencia() {
    }
    
    
    /**
     * Constructor que inicializa un objeto de tipo TramiteLicencia con la fecha
     * de emisión, costo en moneda nacional, estado y persona especificados.
     *
     * @param fechaEmision Fecha de emisión del trámite de licencia.
     * @param costoMxn Costo del trámite en moneda nacional.
     * @param estado Estado del trámite.
     * @param persona Persona asociada al trámite de licencia.
     */
    public TramiteLicencia(Calendar fechaEmision, Float costoMxn, Estado estado, Persona persona) {
        super(fechaEmision, costoMxn, estado, persona);
    }

    /**
     * Constructor de la clase TramiteLicencia con todos los atributos.
     * @param vigencia Vigencia de la licencia.
     * @param fechaEmision Fecha de emisión del trámite.
     * @param costoMxn Costo en MXN del trámite.
     * @param estado Estado del trámite.
     * @param persona Persona asociada al trámite.
     */
    public TramiteLicencia(Integer vigencia, Calendar fechaEmision, Float costoMxn, Estado estado, Persona persona) {
        super(fechaEmision, costoMxn, estado, persona);
        this.vigencia = vigencia;
    }

    /**
     * Método toString para la clase TramiteLicencia.
     * @return Representación en cadena del trámite de licencia.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TramiteLicencia{");
        sb.append(super.toString());
        sb.append("vigencia=").append(vigencia);
        sb.append(", fechaCaducidad=").append(fechaToString(fechaCaducidad));
        sb.append(", numero licencia=").append(numLicencia);
        sb.append('}');
        return sb.toString();
    }
    
}
