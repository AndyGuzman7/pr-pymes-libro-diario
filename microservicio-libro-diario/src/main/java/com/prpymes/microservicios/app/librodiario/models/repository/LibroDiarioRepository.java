package com.prpymes.microservicios.app.librodiario.models.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prpymes.microservicios.app.librodiario.models.entity.LibroDiario;

public interface LibroDiarioRepository extends CrudRepository<LibroDiario, Long> {
	
	@Query("select l from LibroDiario l join fetch l.detalles d where d.idLibroDiario=l.idLibroDiario and l.fecha between :fecha_inicio and :fecha_fin and l.tipoLibro = :tipo_libro")
	public List<LibroDiario> findByDatesAndBookType(@Param("fecha_inicio") Date fecha_inicio, @Param("fecha_fin") Date fecha_fin, @Param("tipo_libro") String tipo_libro);
}
