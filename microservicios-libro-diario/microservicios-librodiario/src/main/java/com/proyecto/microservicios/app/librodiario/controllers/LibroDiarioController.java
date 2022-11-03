package com.proyecto.microservicios.app.librodiario.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.microservicios.app.librodiario.models.entity.LibroDiario;
import com.proyecto.microservicios.app.librodiario.services.LibroDiarioService;

@RestController
public class LibroDiarioController {
	
	@Autowired
	private LibroDiarioService service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<LibroDiario> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody LibroDiario librodiario){
		LibroDiario librodiarioDb = service.save(librodiario);
		return ResponseEntity.status(HttpStatus.CREATED).body(librodiarioDb);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody LibroDiario librodiario, @PathVariable Long id){
		Optional<LibroDiario> o = service.findById(id);
		
		if(o.isEmpty()) {
			 return ResponseEntity.notFound().build();
		}
		LibroDiario librodiarioDb = o.get();
		librodiarioDb.setGlosa(librodiario.getGlosa());
		librodiarioDb.setRazon_social(librodiario.getRazon_social());
		librodiarioDb.setTipo_libro(librodiario.getTipo_libro());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(librodiarioDb));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id)
	{
		service.deletebtId(id);
		return ResponseEntity.noContent().build();
	}
}
