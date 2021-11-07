//1.Creación de la entidad o modelo

package com.example.demo;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;
@Entity 
@Table(name="cliente")
public class client implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Integer idClient;
   
    private String email;
    private String password;
    private String name;
    private int    age;
    
    @OneToMany(cascade= {CascadeType.PERSIST},mappedBy="client")
    List<message>messages;

    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="client")
    List<reservation> reservations;

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<message> getMessages() {
		return messages;
	}

	public void setMessageList(List<message> messages) {
		this.messages = messages;
	}

	public List<reservation> getReservations() {
		return reservations;
	}

	public void setReservationList(List<reservation> reservations) {
		this.reservations = reservations;
	}
    
    
	
	
	
    
}
