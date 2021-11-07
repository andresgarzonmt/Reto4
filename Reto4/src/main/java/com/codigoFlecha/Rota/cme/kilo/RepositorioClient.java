//3.Repositorio

package com.codigoFlecha.Rota.cme.kilo;



import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClient {

	@Autowired
	private InterfaceClient crud;
	
	public List<client> getAll(){
		return (List<client>) crud.findAll();
	}
	
	public Optional  <client> getClient(int idClient){
		return crud.findById(idClient);
	}

	public client save(client clientico) {
		return  crud.save(clientico);	
	}
	public void delete(client clientico){
        crud.delete(clientico);
    }
	
}
	