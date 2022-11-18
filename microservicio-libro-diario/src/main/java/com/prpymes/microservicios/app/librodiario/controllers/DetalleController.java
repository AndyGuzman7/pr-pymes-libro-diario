package com.prpymes.microservicios.app.librodiario.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.librodiario.models.entity.Detalle;
import com.prpymes.microservicios.app.librodiario.services.DetalleService;

@CrossOrigin({"http://localhost:4200"})
@RestController
public class DetalleController {
	
	@Autowired
	private DetalleService service;
	
	@PostMapping("/detalle")
	public ResponseEntity<?> crear(@Valid @RequestBody Detalle detalle, BindingResult result){
		if(result.hasErrors()) 
		{
			return this.validar(result);
		}
		Detalle detalleDb = service.save(detalle);
		return ResponseEntity.status(HttpStatus.CREATED).body(detalleDb);
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
