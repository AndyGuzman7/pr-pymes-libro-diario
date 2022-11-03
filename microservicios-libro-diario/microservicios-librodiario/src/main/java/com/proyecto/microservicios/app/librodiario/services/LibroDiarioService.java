package com.proyecto.microservicios.app.librodiario.services;

import java.util.Optional;

import com.proyecto.microservicios.app.librodiario.models.entity.LibroDiario;

public interface LibroDiarioService {
	
	public Iterable<LibroDiario> findAll();
	
	public Optional<LibroDiario> findById(Long id);
	
	public LibroDiario save(LibroDiario librodiario);
	
	public void deletebtId(Long id);
}
