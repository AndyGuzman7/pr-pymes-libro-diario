package com.prpymes.microservicios.app.librodiario.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prpymes.microservicios.app.librodiario.models.entity.DetalleLibroDiario;

public interface DetalleLibroDiarioRepository extends CrudRepository<DetalleLibroDiario , Long> {
	/*@Query ("select CONCAT(b.codigoCuenta,',' ,SUM(a.monto)) from DetalleLibroDiario a"
			+ "INNER JOIN Cuentas b ON b.idCuenta = a.id_cuenta where b.codigoCuenta = :codigoCuenta and b.status = 1"
			+"GROUP BY b.codigoCuenta")
	Iterable<String> findMontoCuentas(@Param("codigoCuenta") String codigoCuenta);*/
}
