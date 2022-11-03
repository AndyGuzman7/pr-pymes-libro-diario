package com.proyecto.microservicios.app.librodiario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.microservicios.app.librodiario.models.entity.DetalleLibroDiario;
import com.proyecto.microservicios.app.librodiario.services.DetalleLibroDiarioService;
@RestController	
public class DetalleLibroDiarioController {
	@Autowired
	private DetalleLibroDiarioService service;
	
	@PostMapping("/business")
	public ResponseEntity<?> crear(@RequestBody DetalleLibroDiario detallelibrodiario) {
		DetalleLibroDiario detallelibrodiarioDb = service.save(detallelibrodiario);
		return ResponseEntity.status(HttpStatus.CREATED).body(detallelibrodiarioDb);
	}
}
