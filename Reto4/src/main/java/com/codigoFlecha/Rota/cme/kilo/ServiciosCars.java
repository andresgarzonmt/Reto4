package com.codigoFlecha.Rota.cme.kilo;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosCars {

	@Autowired 
	private RepositorioCars metodosCrud;

	public List <cars> getAll(){
		
		return metodosCrud.getAll();
	}
	public Optional<cars> getCars(int idCars){
		
		return metodosCrud.getCars(idCars);
	}
	public cars save(cars carrito) {
		
		if(carrito.getIdCar( )==null) {
			return metodosCrud.save(carrito);
		}
		else {
			Optional<cars> evt=metodosCrud.getCars(carrito.getIdCar());
			if(evt.isEmpty()) {
				return metodosCrud.save(carrito);
			}
			else {
				return carrito;
			}
		}
		 
	}
	

    public cars update(cars carrito){
        if(carrito.getIdCar()!=null){
            Optional<cars> e=metodosCrud.getCars(carrito.getIdCar());
            if(!e.isEmpty()){
                if(carrito.getName()!=null){
                    e.get().setName(carrito.getName());
                }
                if(carrito.getBrand()!=null){
                    e.get().setBrand(carrito.getBrand());
                }
                if(carrito.getYear()!=null){
                    e.get().setYear(carrito.getYear());
                }
                if(carrito.getDescription()!=null){
                    e.get().setDescription(carrito.getDescription());
                }
                if(carrito.getGama()!=null){
                    e.get().setGama(carrito.getGama());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return carrito;
            }
        }else{
            return carrito;
        }
    }


    public boolean deleteBike(int idCar) {
        Boolean aBoolean = getCars(idCar).map(car -> {
            metodosCrud.delete(car);
            return true;
        }).orElse(false);
        return aBoolean;
    }
	
	
	
}

