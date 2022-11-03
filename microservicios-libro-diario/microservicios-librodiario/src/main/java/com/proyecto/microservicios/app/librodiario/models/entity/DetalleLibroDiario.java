package com.proyecto.microservicios.app.librodiario.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detallelibrodiario")
public class DetalleLibroDiario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_detalle;
	
	private Long id_libro;
	private Long id_cuenta;
	private String tipo_detalle;
	private Double monto;
	public Long getId_detalle() {
		return id_detalle;
	}
	public void setId_detalle(Long id_detalle) {
		this.id_detalle = id_detalle;
	}
	public Long getId_libro() {
		return id_libro;
	}
	public void setId_libro(Long id_libro) {
		this.id_libro = id_libro;
	}
	public Long getId_cuenta() {
		return id_cuenta;
	}
	public void setId_cuenta(Long id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	public String getTipo_detalle() {
		return tipo_detalle;
	}
	public void setTipo_detalle(String tipo_detalle) {
		this.tipo_detalle = tipo_detalle;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
}
