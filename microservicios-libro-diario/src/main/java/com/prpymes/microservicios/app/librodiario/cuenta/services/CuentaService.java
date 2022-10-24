package com.prpymes.microservicios.app.librodiario.cuenta.services;

import java.util.Optional;

import com.prpymes.microservicios.app.librodiario.cuenta.entity.Cuentas;


public interface CuentaService {
	public Iterable<Cuentas> findByIdEmpresa(Long id_empresa);
	
	public Optional<Cuentas> findById(Long id);
	
	public Cuentas save(Cuentas alumno);
	
	public void deleteById(Long id);
	
}
