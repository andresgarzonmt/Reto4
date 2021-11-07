package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosClient {

	@Autowired 
	private RepositorioClient metodosCrud;

	public List <client> getAll(){
		
		return metodosCrud.getAll();
	}
	public Optional<client> getClient(int idClient){
		
		return metodosCrud.getClient(idClient);
	}
	public client save(client client) {
		
		if(client.getIdClient( )==null) {
			return metodosCrud.save(client);
		}
		else {
			Optional<client> evt=metodosCrud.getClient(client.getIdClient());
			if(evt.isEmpty()) {
				return metodosCrud.save(client);
			}
			else {
				return client;
			}
		}
		 
	}
	
	 public client update(client client){
	        if(client.getIdClient()!=null){
	            Optional<client> e= metodosCrud.getClient(client.getIdClient());
	            if(!e.isEmpty()){
	                if(client.getName()!=null){
	                    e.get().setName(client.getName());
	                }
	                if(client.getAge() !=0){
	                    e.get().setAge(client.getAge());
	                }
	                if(client.getPassword()!=null){
	                    e.get().setPassword(client.getPassword());
	                }
	                metodosCrud.save(e.get());
	                return e.get();
	            }else{
	                return client;
	            }
	        }else{
	            return client;
	        }
	    }

	    public boolean deleteClient(int clientId) {
	        Boolean aBoolean = getClient(clientId).map(client -> {
	            metodosCrud.delete(client);
	            return true;
	        }).orElse(false);
	        return aBoolean;
	    }
	
	
}

