package dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa un vehículo.
 * Un vehículo tiene una serie, marca, línea, color, modelo, una persona asociada y una lista de trámites de placas.
 * Los trámites de placas pueden ser agregados a través del método addTramitePlacas().
 * 
 * @author Asiel Apodaca Monge
 */
public class Vehiculo {
    private Long id;
    private String serie;
    private String marca;
    private String linea;
    private String color;
    private String modelo;
    private Persona persona;
    private List<TramitePlacas> tramitesPlacas;

    /**
     * Constructor por defecto que inicializa la lista de trámites de placas.
     */
    public Vehiculo() {
        this.tramitesPlacas = new ArrayList<>();
    }

    /**
     * Constructor que inicializa las propiedades del vehículo.
     * 
     * @param serie La serie del vehículo.
     * @param marca La marca del vehículo.
     * @param linea La línea del vehículo.
     * @param color El color del vehículo.
     * @param modelo El modelo del vehículo.
     */
    public Vehiculo(String serie, String marca, String linea, String color, String modelo) {
        this.serie = serie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.tramitesPlacas = new ArrayList<>();
    }

    /**
     * Retorna el ID del vehículo.
     * 
     * @return El ID del vehículo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del vehículo.
     * 
     * @param id El ID del vehículo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna la serie del vehículo.
     * 
     * @return La serie del vehículo.
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Establece la serie del vehículo.
     * 
     * @param serie La serie del vehículo.
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * Retorna la marca del vehículo.
     * 
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     * 
     * @param marca La marca del vehículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Retorna la línea del vehículo.
     * 
     * @return La línea del vehículo.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea del vehículo.
     * 
     * @param linea La línea del vehículo.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Retorna el color del vehículo.
     * 
     * @return El color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del vehículo.
     * 
     * @param color El color del vehículo.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Retorna el modelo del vehículo.
     * 
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del vehículo.
     * 
     * @param modelo El modelo del vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Retorna la persona asociada al vehículo.
     * 
     * @return La persona asociada al vehículo.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al vehículo.
     * 
     * @param persona La persona asociada al vehículo.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Retorna la lista de trámites de placas asociados al vehículo.
     * 
     * @return La lista de trámites de placas asociados al vehículo.
     */
    public List<TramitePlacas> getTramitesPlacas() {
        return tramitesPlacas;
    }

    /**
     * Establece la lista de trámites de placas asociados al vehículo.
     * 
     * @param tramitesPlacas La lista de trámites de placas asociados al vehículo.
     */
    public void setTramitesPlacas(List<TramitePlacas> tramitesPlacas) {
        this.tramitesPlacas = tramitesPlacas;
    }
    
    /**
     * Agrega un trámite de placas a la lista de trámites de placas asociados al vehículo.
     * Establece el vehículo de este trámite como el vehículo actual.
     * 
     * @param tramitePlacas El trámite de placas a agregar.
     */
    public void addTramitePlacas(TramitePlacas tramitePlacas) {
        tramitePlacas.setVehiculo(this);
        this.tramitesPlacas.add(tramitePlacas);
    }

    /**
     * Retorna una representación en forma de cadena del vehículo.
     * 
     * @return Una cadena que representa el vehículo.
     */
    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", serie=" + serie + ", marca=" + marca + ", linea=" + linea + ", color=" + color + ", modelo=" + modelo + ", persona=" + persona + ", tramitesPlacas=" + tramitesPlacas + '}';
    }
}
