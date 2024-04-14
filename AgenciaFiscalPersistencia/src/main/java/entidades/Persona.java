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
 * Clase que representa a una persona en el sistema.
 * 
 * author luiis
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

    /**
     * Devuelve la lista de vehículos asociados a la persona.
     * @return Lista de vehículos.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Establece la lista de vehículos asociados a la persona.
     * @param vehiculos Lista de vehículos.
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    /**
     * Agrega un vehículo a la lista de vehículos asociados a la persona.
     * @param vehiculo Vehículo a agregar.
     */
    public void agregarVehiculo(Vehiculo vehiculo){
        this.vehiculos.add(vehiculo);
    }
    
    /**
     * Devuelve la lista de trámites asociados a la persona.
     * @return Lista de trámites.
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

    /**
     * Establece la lista de trámites asociados a la persona.
     * @param tramites Lista de trámites.
     */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    /**
     * Agrega un trámite a la lista de trámites asociados a la persona.
     * @param tramite Trámite a agregar.
     */
    public void agregarTramite(Tramite tramite){
        this.tramites.add(tramite);
    }
    
    /**
     * Devuelve el RFC de la persona.
     * @return RFC de la persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC de la persona.
     * @param rfc RFC de la persona.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Devuelve el CURP de la persona.
     * @return CURP de la persona.
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Establece el CURP de la persona.
     * @param curp CURP de la persona.
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * Devuelve el nombre completo de la persona.
     * @return Nombre completo de la persona.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo de la persona.
     * @param nombreCompleto Nombre completo de la persona.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Devuelve el teléfono de la persona.
     * @return Teléfono de la persona.
     */
    public String getTelefono() {
        try {
            return CifradoAES.decrypt(telefono);
        } catch (Exception ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Establece el teléfono de la persona.
     * @param telefono Teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        try {
            this.telefono = CifradoAES.encrypt(telefono);
        } catch (Exception ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            this.telefono = null;
        }
    }

    /**
     * Devuelve la fecha de nacimiento de la persona.
     * @return Fecha de nacimiento de la persona.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     * @param fechaNacimiento Fecha de nacimiento de la persona.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Indica si la persona tiene alguna discapacidad.
     * @return true si la persona tiene alguna discapacidad, false en caso contrario.
     */
    public boolean esDiscapacitado() {
        return tieneDiscapacidad;
    }

    /**
     * Establece si la persona tiene alguna discapacidad.
     * @param tieneDiscapacidad true si la persona tiene alguna discapacidad, false en caso contrario.
     */
    public void setTieneDiscapacidad(boolean tieneDiscapacidad) {
        this.tieneDiscapacidad = tieneDiscapacidad;
    }
    
    /**
     * Devuelve el ID de la persona.
     * @return ID de la persona.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la persona.
     * @param id ID de la persona.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Constructor por defecto de la clase Persona.
     */
    public Persona() {
        super();
        this.tramites=new ArrayList<>();
    }

    /**
     * Constructor de la clase Persona con todos los atributos.
     * @param rfc RFC de la persona.
     * @param curp CURP de la persona.
     * @param nombreCompleto Nombre completo de la persona.
     * @param telefono Teléfono de la persona.
     * @param fechaNacimiento Fecha de nacimiento de la persona.
     * @param tieneDiscapacidad Indica si la persona tiene alguna discapacidad.
     */
    public Persona(String rfc, String curp, String nombreCompleto, String telefono, Calendar fechaNacimiento, boolean tieneDiscapacidad) {
        this.rfc = rfc;
        this.curp = curp;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.tieneDiscapacidad = tieneDiscapacidad;
        this.tramites=new ArrayList<>();
    }

    /**
     * Constructor de la clase Persona con RFC.
     * @param rfc RFC de la persona.
     */
    public Persona(String rfc) {
        this.rfc = rfc;
        this.tramites=new ArrayList<>();
    }
    
    /**
     * Método toString para la clase Persona.
     * @return Representación en cadena de la persona.
     */
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

    /**
     * Convierte la fecha de nacimiento a una cadena en el formato "yyyy-MM-dd".
     * @return Fecha de nacimiento en formato de cadena.
     */
    public String fechaToString(){
        SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(getFechaNacimiento().getTime());
    }
}
