package negocioDTO;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
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

    public PersonaDTO() {
        this.vehiculos = new ArrayList<>();
        this.tramites = new ArrayList<>();
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getDiscapaciad() {
        return discapaciad;
    }

    public void setDiscapaciad(Boolean discapaciad) {
        this.discapaciad = discapaciad;
    }
    
    public List<VehiculoDTO> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<VehiculoDTO> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public void addVehiculo(VehiculoDTO vehiculo) {
        vehiculo.setPersona(this);
        this.vehiculos.add(vehiculo);
    }

    public List<TramiteDTO> getTramites() {
        return tramites;
    }

    public void setTramites(List<TramiteDTO> tramites) {
        this.tramites = tramites;
    }
    
    public void addTramite(TramiteDTO tramite){
        tramite.setPersona(this);
        this.tramites.add(tramite);
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + 
                ", rfc=" + rfc + 
                ", nombreCompleto=" + nombreCompleto + 
                ", fechaNacimiento=" + fechaNacimiento + 
                ", curp=" + curp +
                ", telefono=" + telefono + 
                ", discapaciad=" + discapaciad + 
                ", vehiculos=" + vehiculos + 
                ", tramites=[" + toStringTramites() + ']'+'}';
    }

    private String toStringTramites(){
        StringBuilder sb=new StringBuilder();
        for(TramiteDTO t:this.tramites){
            sb.append(t.toStringReducido());
        }
        return sb.toString();
    }
    
    public String toStringReducido(){
        StringBuilder sb=new StringBuilder();
        sb.append('{');
        sb.append("rfc: ").append(rfc);
        sb.append(", nombre completo: ").append(nombreCompleto);
        sb.append('}');
        return sb.toString();
    }
    
}
