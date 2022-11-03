package com.proyecto.microservicios.app.librodiario.services;

import java.util.Optional;

import com.proyecto.microservicios.app.librodiario.models.entity.DetalleLibroDiario;

public interface DetalleLibroDiarioService {
	public Iterable<DetalleLibroDiario> findAll();
	
	public Optional<DetalleLibroDiario> findById(Long id);
	
	public DetalleLibroDiario save(DetalleLibroDiario business);
	
	public void deleteById(Long id);
}
