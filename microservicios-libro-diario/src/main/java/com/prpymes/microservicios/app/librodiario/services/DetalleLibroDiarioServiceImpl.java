package com.prpymes.microservicios.app.librodiario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.librodiario.models.entity.Cuentas;
import com.prpymes.microservicios.app.librodiario.models.entity.DetalleLibroDiario;
import com.prpymes.microservicios.app.librodiario.models.repository.DetalleLibroDiarioRepository;

@Service
public class DetalleLibroDiarioServiceImpl implements DetalleLibroDiarioService {
	
	@Autowired
	private DetalleLibroDiarioRepository repository;
	
	@Override
	@Transactional
	public DetalleLibroDiario save(DetalleLibroDiario libro) {
		return repository.save(libro);
	}
	
	/*@Override
	@Transactional(readOnly = true)
	public Iterable<String> findMontoCuentas(String codigoCuenta) {
		// TODO Auto-generated method stub
		return repository.findMontoCuentas(codigoCuenta);
	}*/
}
