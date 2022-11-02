package com.prpymes.microservicios.app.librodiario.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.librodiario.models.entity.LibroDiario;
import com.prpymes.microservicios.app.librodiario.models.repository.LibroDiarioRepository;

@Service
public class LibroDiarioServiceImpl implements LibroDiarioService {
	
	@Autowired
	private LibroDiarioRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<LibroDiario> findByDatesAndBookType(Date fecha_inicio, Date fecha_fin, String tipo_libro) {
		return repository.findByDatesAndBookType(fecha_inicio, fecha_fin, tipo_libro);
	}

	@Override
	@Transactional
	public LibroDiario save(LibroDiario libro_diario) {
		return repository.save(libro_diario);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<LibroDiario> findById(Long id_libro_diario) {
		
		return repository.findById(id_libro_diario);
	}

}
