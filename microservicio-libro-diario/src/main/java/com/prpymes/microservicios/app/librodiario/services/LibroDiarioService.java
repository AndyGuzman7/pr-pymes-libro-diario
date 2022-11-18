package com.prpymes.microservicios.app.librodiario.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prpymes.microservicios.app.librodiario.models.entity.LibroDiario;

public interface LibroDiarioService {
	
	public List<LibroDiario> findAll();
	
	public Page<LibroDiario> findAll(Pageable pageable);
	
	public List<LibroDiario> findByDatesAndBookType(Date fecha_inicio, Date fecha_fin, String tipo_libro);
	
	public LibroDiario save(LibroDiario libro_diario);
	
	public Optional<LibroDiario> findById(Long id_libro_diario);

}
