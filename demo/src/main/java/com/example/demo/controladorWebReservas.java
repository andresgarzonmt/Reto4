package com.example.demo;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins =
"*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class controladorWebReservas {
	@GetMapping("/HolaReservation")
	public String saludar() {
		return "Hola mundo Reserva";
		
	}
	@Autowired
	private ServiciosReservation servicios;
	@GetMapping("/all")
	public List <reservation> getReservation(){
		return servicios.getAll();
	}
	@GetMapping("/id")
	public Optional <reservation> getReservation(@PathVariable("id") int idReservation){
		return servicios.getReservation(idReservation);
	}
	@PostMapping("/save")

	@ResponseStatus(HttpStatus.CREATED)
	public reservation save(@RequestBody reservation reservations) {
	 return servicios.save(reservations);	
	}
	 @PutMapping("/update")
	    @ResponseStatus(HttpStatus.CREATED)
	    public reservation update(@RequestBody reservation reservations) {
	        return servicios.update(reservations);
	    }

	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public boolean delete(@PathVariable("id") int idReservation) {
	        return servicios.deleteReservation(idReservation);
	    }
}
