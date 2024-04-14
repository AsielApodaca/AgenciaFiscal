package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa un vehículo en el sistema.
 * 
 * Un vehículo puede estar asociado a una persona y puede tener múltiples trámites de placas.
 * 
 * @author luiis
 */
@Entity
@Table(name = "vehiculos")
public class Vehiculo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "serie", unique = true)
    private String serie;
    
    @Column(name = "marca")
    private String marca;
    
    @Column(name = "linea")
    private String linea;
    
    @Column(name = "color")
    private String color;
    
    @Column(name = "modelo")
    private String modelo;
    
    @ManyToOne
    @JoinColumn(name = "id_persona",nullable = false)
    private Persona persona;
    
    @OneToMany(mappedBy = "vehiculo")
    private List<TramitePlacas> tramitesPlacas;

    /**
     * Devuelve la serie del vehículo.
     * @return La serie del vehículo.
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Establece la serie del vehículo.
     * @param serie La serie del vehículo.
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * Devuelve la marca del vehículo.
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     * @param marca La marca del vehículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Devuelve la línea del vehículo.
     * @return La línea del vehículo.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea del vehículo.
     * @param linea La línea del vehículo.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Devuelve el color del vehículo.
     * @return El color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del vehículo.
     * @param color El color del vehículo.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Devuelve el modelo del vehículo.
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del vehículo.
     * @param modelo El modelo del vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve la persona asociada al vehículo.
     * @return La persona asociada al vehículo.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al vehículo.
     * @param persona La persona asociada al vehículo.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Devuelve la lista de trámites de placas asociados al vehículo.
     * @return La lista de trámites de placas asociados al vehículo.
     */
    public List<TramitePlacas> getTramitesPlacas() {
        return tramitesPlacas;
    }

    /**
     * Establece la lista de trámites de placas asociados al vehículo.
     * @param tramitesPlacas La lista de trámites de placas asociados al vehículo.
     */
    public void setTramitesPlacas(List<TramitePlacas> tramitesPlacas) {
        this.tramitesPlacas = tramitesPlacas;
    }
    
    /**
     * Devuelve el ID del vehículo.
     * @return El ID del vehículo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del vehículo.
     * @param id El ID del vehículo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Constructor por defecto de la clase Vehiculo.
     * Inicializa la lista de trámites de placas asociados al vehículo como una lista vacía.
     */
    public Vehiculo() {
        this.tramitesPlacas=new ArrayList<>();
    }

    /**
     * Constructor de la clase Vehiculo con todos los atributos.
     * @param serie Serie del vehículo.
     * @param marca Marca del vehículo.
     * @param linea Línea del vehículo.
     * @param color Color del vehículo.
     * @param modelo Modelo del vehículo.
     * @param persona Persona asociada al vehículo.
     * @param tramitesPlacas Lista de trámites de placas asociados al vehículo.
     */
    public Vehiculo(String serie, String marca, String linea, String color, String modelo, Persona persona, List<TramitePlacas> tramitesPlacas) {
        this.serie = serie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.persona = persona;
        this.tramitesPlacas = tramitesPlacas;
    }

    /**
     * Constructor de la clase Vehiculo sin la lista de trámites de placas.
     * @param serie Serie del vehículo.
     * @param marca Marca del vehículo.
     * @param linea Línea del vehículo.
     * @param color Color del vehículo.
     * @param modelo Modelo del vehículo.
     * @param persona Persona asociada al vehículo.
     */
    public Vehiculo(String serie, String marca, String linea, String color, String modelo, Persona persona) {
        this.serie = serie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.persona = persona;
        this.tramitesPlacas=new ArrayList<>();
    }

    /**
     * Constructor de la clase Vehiculo con solo la serie.
     * @param serie Serie del vehículo.
     */
    public Vehiculo(String serie) {
        this.serie = serie;
        this.tramitesPlacas=new ArrayList<>();
    }

    /**
     * Método toString para la clase Vehiculo.
     * @return Representación en cadena del vehículo.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehiculo[");
        sb.append("id=").append(id);
        sb.append(", serie=").append(serie);
        sb.append(", marca=").append(marca);
        sb.append(", linea=").append(linea);
        sb.append(", color=").append(color);
        sb.append(", modelo=").append(modelo);
        sb.append(", persona=").append(persona);
        if(!tramitesPlacas.isEmpty()){
            sb.append(", placas=").append(
                    tramitesPlacas.get(tramitesPlacas.size() - 1).toStringReducido());
        }
        sb.append(']');
        return sb.toString();
    }

    /**
     * Devuelve una representación en cadena de los registros de placas asociados al vehículo.
     * @return Representación en cadena de los registros de placas asociados al vehículo.
     */
    public String toStringRegistrosPlacas(){
        StringBuilder sb = new StringBuilder();
        sb.append("Registros de placas[");
        for(TramitePlacas tp:tramitesPlacas){
            sb.append(tp.toStringReducido());
        }
        sb.append("]");
        return sb.toString();
    }
}
