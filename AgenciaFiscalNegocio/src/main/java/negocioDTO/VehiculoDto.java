package negocioDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asiel Apodaca Monge
 */
public class VehiculoDto {
    private Long id;
    private String serie;
    private String marca;
    private String linea;
    private String color;
    private String modelo;
    private PersonaDto persona;
    private List<TramitePlacasDto> tramitesPlacas;

    public VehiculoDto() {
        this.tramitesPlacas = new ArrayList<>();
    }

    public VehiculoDto(String serie, String marca, String linea, String color, String modelo) {
        this.serie = serie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.tramitesPlacas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }

    public List<TramitePlacasDto> getTramitesPlacas() {
        return tramitesPlacas;
    }

    public void setTramitesPlacas(List<TramitePlacasDto> tramitesPlacas) {
        this.tramitesPlacas = tramitesPlacas;
    }
    
    public void addTramitePlacas(TramitePlacasDto tramitePlacas) {
        tramitePlacas.setVehiculo(this);
        this.tramitesPlacas.add(tramitePlacas);
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", serie=" + serie + ", marca=" + marca + ", linea=" + linea + ", color=" + color + ", modelo=" + modelo + ", persona=" + persona + ", tramitesPlacas=" + tramitesPlacas + '}';
    }

    
    
    
}
