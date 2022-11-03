package com.proyecto.microservicios.app.librodiario.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.microservicios.app.librodiario.models.entity.LibroDiario;

public interface LibroDiarioRepository extends CrudRepository<LibroDiario, Long> {

}
