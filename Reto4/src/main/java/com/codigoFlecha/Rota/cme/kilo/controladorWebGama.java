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
@RequestMapping("/api/Gama")
@CrossOrigin(origins =
"*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class controladorWebGama {
@GetMapping("/Holagama")
public String saludar() {
	return "Hola mundo gama";
	
}
@Autowired
private ServiciosGama servicios;
@GetMapping("/all")
public List <gama> getGama(){
	return servicios.getAll();
}
@GetMapping("/id")
public Optional <gama> getGama(@PathVariable("id") int idGama){
	return servicios.getGama(idGama);
}
@PostMapping("/save")

@ResponseStatus(HttpStatus.CREATED)
public gama save(@RequestBody gama gama) {
 return servicios.save(gama);	
}

@PutMapping("/update")
@ResponseStatus(HttpStatus.CREATED)
public gama update(@RequestBody gama categoria) {
    return servicios.update(categoria);
}

@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public boolean delete(@PathVariable("id") int categoriaId) {
    return servicios.deletecategoria(categoriaId);
}

}
