/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
 *
 * @author luiis
 */
@Entity
@Table(name = "vehiculos")
public class Vehiculo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "serie")
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
    
    @OneToMany(mappedBy = "vehiculo",cascade =CascadeType.MERGE)
    private List<TramitePlacas> tramitesPlacas;

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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<TramitePlacas> getTramitesPlacas() {
        return tramitesPlacas;
    }

    public void setTramitesPlacas(List<TramitePlacas> tramitesPlacas) {
        this.tramitesPlacas = tramitesPlacas;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehiculo() {
        this.tramitesPlacas=new ArrayList<>();
    }

    public Vehiculo(String serie, String marca, String linea, String color, String modelo, Persona persona, List<TramitePlacas> tramitesPlacas) {
        this.serie = serie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.persona = persona;
        this.tramitesPlacas = tramitesPlacas;
    }

    public Vehiculo(String serie, String marca, String linea, String color, String modelo, Persona persona) {
        this.serie = serie;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.persona = persona;
        this.tramitesPlacas=new ArrayList<>();
    }

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
