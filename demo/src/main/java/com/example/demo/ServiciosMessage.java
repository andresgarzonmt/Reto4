package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMessage {

	@Autowired 
	private RepositorioMessage metodosCrud;

	public List <message> getAll(){
		
		return metodosCrud.getAll();
	}
	public Optional<message> getMessage(int idMessage){
		
		return metodosCrud.getMessage(idMessage);
	}
	public message save(message messages) {
		
		if(messages.getIdMessage( )==null) {
			return metodosCrud.save(messages);
		}
		else {
			Optional<message> evt=metodosCrud.getMessage(messages.getIdMessage());
			if(evt.isEmpty()) {
				return metodosCrud.save(messages);
			}
			else {
				return messages;
			}
		}
		 
	}
	
	 public message update(message message){
	        if(message.getIdMessage()!=null){
	            Optional<message> e= metodosCrud.getMessage(message.getIdMessage());
	            if(!e.isEmpty()){
	                if(message.getMessageText()!=null){
	                    e.get().setMessageText(message.getMessageText());
	                }
	                metodosCrud.save(e.get());
	                return e.get();
	            }else{
	                return message;
	            }
	        }else{
	            return message;
	        }
	    }

	    public boolean deleteMessage(int messageId) {
	        Boolean aBoolean = getMessage(messageId).map(message -> {
	            metodosCrud.delete(message);
	            return true;
	        }).orElse(false);
	        return aBoolean;
	    }
	
}

