//1.Creación de la entidad o modelo

package com.example.demo;
//holaS
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

import javax.persistence.*;
@Entity 
@Table(name="reserva")
public class reservation implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idReservation;
	
    private Date  startDate;
    
    private Date devolutionDate;
    private String status="created";
    
    @ManyToOne
    @JoinColumn(name = "idCars")
    @JsonIgnoreProperties({"reservations","car"})
    private cars car;
    
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"reservations","messages","car"})
    private client client;
    
    private String score;

	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	public cars getCar() {
		return car;
	}

	public void setCar(cars car) {
		this.car = car;
	}

	public client getClient() {
		return client;
	}

	public void setClient(client client) {
		this.client = client;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}