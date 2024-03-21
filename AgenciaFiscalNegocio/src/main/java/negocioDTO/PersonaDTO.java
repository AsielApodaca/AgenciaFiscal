package negocioDTO;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class PersonaDto {
    private Long id;
    private String rfc;
    private String nombreCompleto;
    private Calendar fechaNacimiento;
    private String curp;
    private String telefono;
    private Boolean discapaciad;
    private List<VehiculoDto> vehiculos;
    private List<TramiteDto> tramites;

    public PersonaDto() {
        this.vehiculos = new ArrayList<>();
        this.tramites = new ArrayList<>();
    }

    public PersonaDto(String rfc, String nombreCompleto, Calendar fechaNacimiento, String curp, String telefono, Boolean discapacidad) {
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
    
    public List<VehiculoDto> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<VehiculoDto> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public void addVehiculo(VehiculoDto vehiculo) {
        vehiculo.setPersona(this);
        this.vehiculos.add(vehiculo);
    }

    public List<TramiteDto> getTramites() {
        return tramites;
    }

    public void setTramites(List<TramiteDto> tramites) {
        this.tramites = tramites;
    }
    
    public void addTramite(TramiteDto tramite){
        tramite.setPersona(this);
        this.tramites.add(tramite);
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", rfc=" + rfc + ", nombreCompleto=" + nombreCompleto + ", fechaNacimiento=" + fechaNacimiento + ", curp=" + curp + ", telefono=" + telefono + ", discapaciad=" + discapaciad + ", vehiculos=" + vehiculos + ", tramites=" + tramites + '}';
    }

    
    
}
