package com.prpymes.microservicios.app.librodiario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.librodiario.models.entity.Detalle;
import com.prpymes.microservicios.app.librodiario.models.repository.DetalleRepository;

@Service
public class DetalleServiceImpl implements DetalleService {
	
	@Autowired
	private DetalleRepository repository;
	
	@Override
	@Transactional
	public Detalle save(Detalle detalle) {
		return repository.save(detalle);
	}
}
