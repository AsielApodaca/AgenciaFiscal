package negocioDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa un objeto de transferencia de datos (DTO) para un vehículo.
 * Contiene información sobre un vehículo, como su serie, marca, modelo, color, propietario y trámites de placas asociados.
 * 
 * <p>
 * Un objeto de transferencia de datos (DTO) es un objeto que transporta datos entre procesos o aplicaciones.
 * En este caso, el DTO se utiliza para transportar información de vehículos entre las capas de la aplicación.
 * </p>
 * 
 * <p>
 * Esta clase proporciona métodos para obtener y establecer los atributos del vehículo, así como para agregar trámites de placas asociados.
 * </p>
 * 
 * <p>
 * Tenga en cuenta que esta clase no contiene lógica de negocio, sino solo datos y métodos de acceso.
 * </p>
 * 
 * @author Asiel Apodaca Monge
 */
public class VehiculoDTO {
    private Long id;
    private String serie;
    private String marca;
    private String linea;
    private String color;
    private String modelo;
    private PersonaDTO persona;
    private List<TramitePlacasDTO> tramitesPlacas;

    /**
     * Constructor por defecto que inicializa la lista de trámites de placas.
     */
    public VehiculoDTO() {
        this.tramitesPlacas = new ArrayList<>();
    }

    /**
     * Constructor que inicializa los atributos básicos del vehículo y la lista de trámites de placas.
     * 
     * @param serie La serie del vehículo.
     * @param marca La marca del vehículo.
     * @param linea La línea del vehículo.
     * @param color El color del vehículo.
     * @param modelo El modelo del vehículo.
     */
    public VehiculoDTO(String serie, String marca, String linea, String color, String modelo) {
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
    public PersonaDTO getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al vehículo.
     * 
     * @param persona La persona asociada al vehículo.
     */
    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    /**
     * Retorna la lista de trámites de placas asociados al vehículo.
     * 
     * @return La lista de trámites de placas asociados al vehículo.
     */
    public List<TramitePlacasDTO> getTramitesPlacas() {
        return tramitesPlacas;
    }

    /**
     * Establece la lista de trámites de placas asociados al vehículo.
     * 
     * @param tramitesPlacas La lista de trámites de placas asociados al vehículo.
     */
    public void setTramitesPlacas(List<TramitePlacasDTO> tramitesPlacas) {
        this.tramitesPlacas = tramitesPlacas;
    }
    
    /**
     * Agrega un trámite de placas a la lista de trámites de placas asociados al vehículo.
     * 
     * @param tramitePlacas El trámite de placas a agregar.
     */
    public void addTramitePlacas(TramitePlacasDTO tramitePlacas) {
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
        return "VehiculoDTO{" + "id=" + id + ", serie=" + serie + ", marca=" + marca + ", linea=" + linea + ", color=" + color + ", modelo=" + modelo + ", persona=" + persona + ", tramitesPlacas=" + tramitesPlacas + '}';
    }

}
