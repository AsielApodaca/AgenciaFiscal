package negocioDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Esta clase representa un objeto de transferencia de datos (DTO) para una persona.
 * Contiene información sobre una persona, como su RFC, nombre completo, fecha de nacimiento, CURP, teléfono, discapacidad, vehículos y trámites asociados.
 * 
 * 
 * @author Asiel Apodaca Monge
 */
public class PersonaDTO {
    private Long id;
    private String rfc;
    private String nombreCompleto;
    private Calendar fechaNacimiento;
    private String curp;
    private String telefono;
    private Boolean discapaciad;
    private List<VehiculoDTO> vehiculos;
    private List<TramiteDTO> tramites;

    /**
     * Constructor por defecto que inicializa las listas de vehículos y trámites.
     */
    public PersonaDTO() {
        this.vehiculos = new ArrayList<>();
        this.tramites = new ArrayList<>();
    }

    /**
     * Constructor que inicializa los atributos básicos de la persona y las listas de vehículos y trámites.
     * 
     * @param rfc El RFC de la persona.
     * @param nombreCompleto El nombre completo de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param curp El CURP de la persona.
     * @param telefono El número de teléfono de la persona.
     * @param discapacidad Indica si la persona tiene alguna discapacidad.
     */
    public PersonaDTO(String rfc, String nombreCompleto, Calendar fechaNacimiento, String curp, String telefono, Boolean discapacidad) {
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
     * Retorna el CURP de la persona.
     * 
     * @return El CURP de la persona.
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Establece el CURP de la persona.
     * 
     * @param curp El CURP de la persona.
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * Retorna el número de teléfono de la persona.
     * 
     * @return El número de teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono de la persona.
     * 
     * @param telefono El número de teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Indica si la persona tiene alguna discapacidad.
     * 
     * @return true si la persona tiene alguna discapacidad, false en caso contrario.
     */
    public Boolean getDiscapaciad() {
        return discapaciad;
    }

    /**
     * Establece si la persona tiene alguna discapacidad.
     * 
     * @param discapaciad true si la persona tiene alguna discapacidad, false en caso contrario.
     */
    public void setDiscapaciad(Boolean discapaciad) {
        this.discapaciad = discapaciad;
    }
    
    /**
     * Retorna la lista de vehículos asociados a la persona.
     * 
     * @return La lista de vehículos asociados a la persona.
     */
    public List<VehiculoDTO> getVehiculos() {
        return vehiculos;
    }

    /**
     * Establece la lista de vehículos asociados a la persona.
     * 
     * @param vehiculos La lista de vehículos asociados a la persona.
     */
    public void setVehiculos(List<VehiculoDTO> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    /**
     * Agrega un vehículo a la lista de vehículos asociados a la persona.
     * 
     * @param vehiculo El vehículo a agregar.
     */
    public void addVehiculo(VehiculoDTO vehiculo) {
        vehiculo.setPersona(this);
        this.vehiculos.add(vehiculo);
    }

    /**
     * Retorna la lista de trámites asociados a la persona.
     * 
     * @return La lista de trámites asociados a la persona.
     */
    public List<TramiteDTO> getTramites() {
        return tramites;
    }

    /**
     * Establece la lista de trámites asociados a la persona.
     * 
     * @param tramites La lista de trámites asociados a la persona.
     */
    public void setTramites(List<TramiteDTO> tramites) {
        this.tramites = tramites;
    }
    
    /**
     * Agrega un trámite a la lista de trámites asociados a la persona.
     * 
     * @param tramite El trámite a agregar.
     */
    public void addTramite(TramiteDTO tramite){
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
        return "PersonaDTO{" + "id=" + id + 
                ", rfc=" + rfc + 
                ", nombreCompleto=" + nombreCompleto + 
                ", fechaNacimiento=" + fechaToString() + 
                ", curp=" + curp +
                ", telefono=" + telefono + 
                ", discapaciad=" + discapaciad + 
                ", vehiculos=" + vehiculos + 
                ", tramites=[" + toStringTramites() + ']'+'}';
    }

    /**
     * Retorna una representación reducida de la persona, solo con su RFC y nombre completo.
     * 
     * @return Una cadena que representa la persona de forma reducida.
     */
    public String toStringReducido(){
        StringBuilder sb=new StringBuilder();
        sb.append('{');
        sb.append("rfc: ").append(rfc);
        sb.append(", nombre completo: ").append(nombreCompleto);
        sb.append('}');
        return sb.toString();
    }
    
    /**
     * Convierte la fecha de nacimiento en una cadena formateada.
     * 
     * @return La fecha de nacimiento formateada como una cadena.
     */
    public String fechaToString(){
        SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(getFechaNacimiento().getTime());
    }
    
    /**
     * Genera una cadena que representa los trámites asociados a la persona de forma reducida.
     * 
     * @return Una cadena que representa los trámites asociados a la persona de forma reducida.
     */
    private String toStringTramites(){
        StringBuilder sb=new StringBuilder();
        for(TramiteDTO t:this.tramites){
            sb.append(t.toStringReducido());
        }
        return sb.toString();
    }
}
