//1.Creación de la entidad o modelo

package com.codigoFlecha.Rota.cme.kilo;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity 
@Table(name="gama")
public class gama implements Serializable {
    /**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idGama;
  
    private String name;
    private String description;
	public Integer getIdGama() {
		return idGama;
	}
	public void setIdGama(Integer idGama) {
		this.idGama = idGama;
	}
	@OneToMany(cascade= {CascadeType.PERSIST},mappedBy="gama")
    @JsonIgnoreProperties("gama")
    List<cars>cars;
    
	public List<cars> getCars() {
		return cars;
	}
	public void setCars(List<cars> cars) {
		this.cars = cars;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
       
}
