package com.prpymes.microservicios.app.librodiario.cuenta.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prpymes.microservicios.app.librodiario.cuenta.entity.Cuentas;


public interface CuentaRepository extends CrudRepository<Cuentas , Long>{
	
	@Query ("select a from Cuentas a where a.idEmpresa = :id_empresa and a.status = 1")
	Iterable<Cuentas> findByIdEmpresa(@Param("id_empresa") Long id_empresa);
	
}
