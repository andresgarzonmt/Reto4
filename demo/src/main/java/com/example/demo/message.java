//1.Creación de la entidad o modelo

package com.example.demo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;
@Entity 
@Table(name="mensaje")
public class message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idMessage;
	
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name="idCars")
    @JsonIgnoreProperties({"messages","client","reservations"})
    private cars car;
    
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"messages","reservations","car"})
    private client client;

	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
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
		this.client= client;
	}

    
}
