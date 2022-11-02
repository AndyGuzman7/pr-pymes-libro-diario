package com.prpymes.microservicios.app.librodiario.controllers;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.librodiario.models.entity.Detalle;
import com.prpymes.microservicios.app.librodiario.models.entity.LibroDiario;
import com.prpymes.microservicios.app.librodiario.services.LibroDiarioService;

@RestController
public class LibroDiarioController {
	
	@Autowired
	private LibroDiarioService service;
	
	@GetMapping("/prueba")
	ResponseEntity<String> hello() {
	    return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody LibroDiario libro_diario){
		LibroDiario libroDiarioDb = service.save(libro_diario);
		return ResponseEntity.status(HttpStatus.CREATED).body(libroDiarioDb);
	}
	
	@GetMapping("/mostrar")
	public ResponseEntity<?> mostrarPorFechas(@RequestParam Date fecha_inicio, @RequestParam Date fecha_fin, @RequestParam String tipo_libro)
	{
		return ResponseEntity.ok(service.findByDatesAndBookType(fecha_inicio, fecha_fin, tipo_libro));
	}
	
	@PutMapping("/asignar/{id}")
	public ResponseEntity<?> asignarDetalles(@RequestBody List<Detalle> detalles, @PathVariable Long id)
	{
		Optional<LibroDiario> o=this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		LibroDiario dbLibroDiario = o.get();
		
		detalles.forEach(a->{
			dbLibroDiario.addDetalle(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbLibroDiario));
	}
	
	@PutMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarDetalle(@RequestBody Detalle detalle, @PathVariable Long id)
	{
		Optional<LibroDiario> o=this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		LibroDiario dbLibroDiario = o.get();
		
		dbLibroDiario.removeDetalle(detalle);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbLibroDiario));
	}
}
