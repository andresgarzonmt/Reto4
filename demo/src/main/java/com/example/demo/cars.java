//1.Creación de la entidad o modelo

package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import javax.persistence.*;
@Entity 
@Table(name="carro")
public class cars implements Serializable  {
    /**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCar;
	private String name;
    private String brand;
    private Integer year;
    private String description;
   
    
    @ManyToOne
    @JoinColumn(name="idGama")
    @JsonIgnoreProperties("cars")
    private gama gama;
    
    @OneToMany(cascade= {CascadeType.PERSIST},mappedBy="car")
    @JsonIgnoreProperties({"car","client"})
    private List<message>messages;
    
    @OneToMany(cascade= {CascadeType.PERSIST},mappedBy="car")
    @JsonIgnoreProperties({"car","client"})
    private List<reservation> reservations;

	public Integer getIdCar() {
		return idCar;
	}

	public void setIdCar(Integer idCar) {
		this.idCar = idCar;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public gama getGama() {
		return gama;
	}

	public void setGama(gama gama) {
		this.gama = gama;
	}

	public List<message> getMessages() {
		return messages;
	}

	public void setMessages(List<message> messages) {
		this.messages = messages;
	}

	public List<reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<reservation> reservations) {
		this.reservations = reservations;
	}

	
  
}
