package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Esta clase representa una persona.
 * Una persona tiene un RFC, nombre completo, fecha de nacimiento, CURP, teléfono,
 * una indicación de si tiene discapacidad, una lista de vehículos asociados y una lista de trámites.
 * Los vehículos y trámites pueden ser agregados mediante los métodos addVehiculo() y addTramite() respectivamente.
 * 
 * @author Asiel Apodaca Monge
 */
public class Persona {
    private Long id;
    private String rfc;
    private String nombreCompleto;
    private Calendar fechaNacimiento;
    private String curp;
    private String telefono;
    private Boolean discapaciad;
    private List<Vehiculo> vehiculos;
    private List<Tramite> tramites;

    /**
     * Constructor por defecto que inicializa las listas de vehículos y trámites.
     */
    public Persona() {
        this.vehiculos = new ArrayList<>();
        this.tramites = new ArrayList<>();
    }

    /**
     * Constructor que inicializa las propiedades de la persona.
     * 
     * @param rfc El RFC de la persona.
     * @param nombreCompleto El nombre completo de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param curp La CURP de la persona.
     * @param telefono El teléfono de la persona.
     * @param discapacidad Indica si la persona tiene discapacidad.
     */
    public Persona(String rfc, String nombreCompleto, Calendar fechaNacimiento, String curp, String telefono, Boolean discapacidad) {
        this.rfc = rfc;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.telefono = telefono;
        this.discapaciad = discapacidad;
        this.vehiculos = new ArrayList<>();
        this.tramites = new ArrayList<>();
    }

    /**
     * Retorna el ID de la persona.
     * 
     * @return El ID de la persona.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la persona.
     * 
     * @param id El ID de la persona.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna el RFC de la persona.
     * 
     * @return El RFC de la persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC de la persona.
     * 
     * @param rfc El RFC de la persona.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Retorna el nombre completo de la persona.
     * 
     * @return El nombre completo de la persona.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo de la persona.
     * 
     * @param nombreCompleto El nombre completo de la persona.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Retorna la fecha de nacimiento de la persona.
     * 
     * @return La fecha de nacimiento de la persona.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     * 
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Retorna la CURP de la persona.
     * 
     * @return La CURP de la persona.
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Establece la CURP de la persona.
     * 
     * @param curp La CURP de la persona.
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * Retorna el teléfono de la persona.
     * 
     * @return El teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono de la persona.
     * 
     * @param telefono El teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Retorna un booleano indicando si la persona tiene discapacidad.
     * 
     * @return true si la persona tiene discapacidad, false de lo contrario.
     */
    public Boolean getDiscapaciad() {
        return discapaciad;
    }

    /**
     * Establece si la persona tiene discapacidad.
     * 
     * @param discapaciad true si la persona tiene discapacidad, false de lo contrario.
     */
    public void setDiscapaciad(Boolean discapaciad) {
        this.discapaciad = discapaciad;
    }
    
    /**
     * Retorna la lista de vehículos asociados a la persona.
     * 
     * @return La lista de vehículos asociados a la persona.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Establece la lista de vehículos asociados a la persona.
     * 
     * @param vehiculos La lista de vehículos asociados a la persona.
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    /**
     * Agrega un vehículo a la lista de vehículos asociados a la persona.
     * Establece la persona de este vehículo como la persona actual.
     * 
     * @param vehiculo El vehículo a agregar.
     */
    public void addVehiculo(Vehiculo vehiculo) {
        vehiculo.setPersona(this);
        this.vehiculos.add(vehiculo);
    }

    /**
     * Retorna la lista de trámites asociados a la persona.
     * 
     * @return La lista de trámites asociados a la persona.
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

    /**
     * Establece la lista de trámites asociados a la persona.
     * 
     * @param tramites La lista de trámites asociados a la persona.
     */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }
    
    /**
     * Agrega un trámite a la lista de trámites asociados a la persona.
     * Establece la persona de este trámite como la persona actual.
     * 
     * @param tramite El trámite a agregar.
     */
    public void addTramite(Tramite tramite){
        tramite.setPersona(this);
        this.tramites.add(tramite);
    }

    /**
     * Retorna una representación en forma de cadena de la persona.
     * 
     * @return Una cadena que representa la persona.
     */
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", rfc=" + rfc + ", nombreCompleto=" + nombreCompleto + ", fechaNacimiento=" + fechaNacimiento + ", curp=" + curp + ", telefono=" + telefono + ", discapaciad=" + discapaciad + ", vehiculos=" + vehiculos + ", tramites=" + tramites + '}';
    }

    
    
}
