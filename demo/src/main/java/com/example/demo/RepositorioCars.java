//3.Repositorio

package com.example.demo;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCars {

	@Autowired
	private InterfaceCars crud;
	
	public List<cars> getAll(){
		return (List<cars>) crud.findAll();
	}
	
	public Optional  <cars> getCars(int idCars){
		return crud.findById(idCars);
	}

	public cars save(cars carrito) {
		return  crud.save(carrito);	
	}
	  public void delete(cars carrito){
	        crud.delete(carrito);
	    }
	    
}
	