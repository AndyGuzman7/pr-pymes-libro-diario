package com.prpymes.microservicios.app.librodiario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.librodiario.models.entity.Detalle;
import com.prpymes.microservicios.app.librodiario.services.DetalleService;

@RestController
public class DetalleController {
	
	@Autowired
	private DetalleService service;
	
	@PostMapping("/detalle")
	public ResponseEntity<?> crear(@RequestBody Detalle detalle){
		Detalle detalleDb = service.save(detalle);
		return ResponseEntity.status(HttpStatus.CREATED).body(detalleDb);
	}
	
}
