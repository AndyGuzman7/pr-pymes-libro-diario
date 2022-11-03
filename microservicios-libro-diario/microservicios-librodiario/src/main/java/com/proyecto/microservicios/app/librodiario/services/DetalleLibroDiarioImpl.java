package com.proyecto.microservicios.app.librodiario.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.microservicios.app.librodiario.models.entity.DetalleLibroDiario;
import com.proyecto.microservicios.app.librodiario.models.repository.DetalleLibroDiarioRepository;


@Service
public class DetalleLibroDiarioImpl implements DetalleLibroDiarioService {

	@Autowired
	private DetalleLibroDiarioRepository repository;	
	@Override
	@Transactional(readOnly = true)
	public Iterable<DetalleLibroDiario> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<DetalleLibroDiario> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
	
	@Override
	@Transactional
	public DetalleLibroDiario save(DetalleLibroDiario libro) {
		// TODO Auto-generated method stub
		return repository.save(libro);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}


}
