package com.example.demo;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosGama {

	@Autowired 
	private RepositorioGama metodosCrud;

	public List <gama> getAll(){
		
		return metodosCrud.getAll();
	}
	public Optional<gama> getGama(int idGama){
		
		return metodosCrud.getGama(idGama);
	}
	public gama save(gama gama) {
		
		if(gama.getIdGama( )==null) {
			return metodosCrud.save(gama);
		}
		else {
			Optional<gama> evt=metodosCrud.getGama(gama.getIdGama());
			if(evt.isEmpty()) {
				return metodosCrud.save(gama);
			}
			else {
				return gama;
			}
		}
		 
	}
	
	 public gama update(gama categoria){
	        if(categoria.getIdGama()!=null){
	            Optional<gama>g=metodosCrud.getGama(categoria.getIdGama());
	            if(!g.isEmpty()){
	                if(categoria.getDescription()!=null){
	                    g.get().setDescription(categoria.getDescription());
	                }
	                if(categoria.getName()!=null){
	                    g.get().setName(categoria.getName());
	                }
	                return metodosCrud.save(g.get());
	            }
	        }
	        return categoria;
	    }
	    public boolean deletecategoria(int categoriaId){
	        Boolean d=getGama(categoriaId).map(gama -> {
	            metodosCrud.delete(gama);
	            return true;
	        }).orElse(false);
	        return d;
	    }
	    
	
}

