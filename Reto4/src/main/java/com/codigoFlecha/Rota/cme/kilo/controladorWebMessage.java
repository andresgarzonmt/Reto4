package com.codigoFlecha.Rota.cme.kilo;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins =
"*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class controladorWebMessage {
@GetMapping("/HolaMessage")
public String saludar() {
	return "Hola mundo mensaje";
	
}
@Autowired
private ServiciosMessage servicios;
@GetMapping("/all")
public List <message> getMessage(){
	return servicios.getAll();
}
@GetMapping("/id")
public Optional <message> getMessage(@PathVariable("id") int idMessage){
	return servicios.getMessage(idMessage);
}
@PostMapping("/save")

@ResponseStatus(HttpStatus.CREATED)
public message save(@RequestBody message messages) {
 return servicios.save(messages);	
}

@PutMapping("/update")
@ResponseStatus(HttpStatus.CREATED)
public message update(@RequestBody message messages) {
    return servicios.update(messages);
}

@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public boolean delete(@PathVariable("id") int messages) {
    return servicios.deleteMessage(messages);
}

}
