package com.ac75.web.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.ac75.web.app.domain.Marca;
import com.ac75.web.app.service.IMarcaService;

@RestController
@RequestMapping("/marcas")
public class MarcaController {
	
	@Autowired
	private IMarcaService marcaService;

	@GetMapping("/status")
	public ResponseEntity<Object> getOKPath(HttpServletRequest httpServletRequest) {
		
		return new ResponseEntity<>(httpServletRequest.getRequestURI() + " Status: Online" ,
				HttpStatus.OK);

	}
	
	@GetMapping("/")
	public ResponseEntity<Object> getAllMarcas(HttpServletRequest httpServletRequest) {
		String JSON;		
		JSON= new Gson().toJson(marcaService.getAllMarcas());		
		return new ResponseEntity<>(JSON,
				HttpStatus.OK);

	}
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Marca marca){
		Marca newmarca = marcaService.save(marca);
		return ResponseEntity.ok(newmarca);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @RequestBody Marca marca){
		marcaService.update(marca, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		marcaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
