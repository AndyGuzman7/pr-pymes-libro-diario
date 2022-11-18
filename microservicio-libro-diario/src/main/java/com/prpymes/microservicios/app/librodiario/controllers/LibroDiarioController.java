package com.prpymes.microservicios.app.librodiario.controllers;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin({"http://localhost:4200"})
@RestController
public class LibroDiarioController {
	
	@Autowired
	private LibroDiarioService service;
	
	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody LibroDiario libro_diario, BindingResult result)
	{
		if(result.hasErrors()) 
		{
			return this.validar(result);
		}
		LibroDiario libroDiarioDb = service.save(libro_diario);
		return ResponseEntity.status(HttpStatus.CREATED).body(libroDiarioDb);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar()
	{
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/paginar")
	public ResponseEntity<?> listarPorPaginas(Pageable pageable)
	{
		return ResponseEntity.ok().body(service.findAll(pageable));
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
	
	protected ResponseEntity<?> validar(BindingResult result)
	{
		Map<String,Object> errores =new HashMap<>();
		result.getFieldErrors().forEach(err ->
		{
			errores.put(err.getField(), "El campo "+ err.getField() + " " +err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
}
