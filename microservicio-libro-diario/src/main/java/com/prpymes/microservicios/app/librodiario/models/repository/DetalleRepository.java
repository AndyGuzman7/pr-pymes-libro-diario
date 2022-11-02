package com.prpymes.microservicios.app.librodiario.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.prpymes.microservicios.app.librodiario.models.entity.Detalle;

public interface DetalleRepository extends CrudRepository<Detalle, Long> {
	
	
}
