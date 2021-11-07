package com.example.demo;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosReservation {

	@Autowired 
	private RepositorioReservation metodosCrud;

	public List <reservation> getAll(){
		
		return metodosCrud.getAll();
	}
	public Optional<reservation> getReservation(int idReservation){
		
		return metodosCrud.getReservation(idReservation);
	}
	public reservation save(reservation reservations) {
		
		if(reservations.getIdReservation( )==null) {
			return metodosCrud.save(reservations);
		}
		else {
			Optional<reservation> evt=metodosCrud.getReservation(reservations.getIdReservation());
			if(evt.isEmpty()) {
				return metodosCrud.save(reservations);
			}
			else {
				return reservations;
			}
		}
		 
	}
	
	
	public reservation update(reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<reservation> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
	
}

