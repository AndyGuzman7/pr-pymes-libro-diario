package com.proyecto.microservicios.app.librodiario.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.microservicios.app.librodiario.models.entity.LibroDiario;
import com.proyecto.microservicios.app.librodiario.models.repository.LibroDiarioRepository;

@Service
public class LibroDiarioImpl implements LibroDiarioService {

	@Autowired
	private LibroDiarioRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<LibroDiario> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<LibroDiario> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public LibroDiario save(LibroDiario librodiario) {
		// TODO Auto-generated method stub
		return repository.save(librodiario);
	}

	@Override
	@Transactional
	public void deletebtId(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
