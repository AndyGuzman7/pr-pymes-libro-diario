package com.proyecto.microservicios.app.librodiario.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.microservicios.app.librodiario.models.entity.DetalleLibroDiario;

public interface DetalleLibroDiarioRepository extends CrudRepository<DetalleLibroDiario, Long> {

}
