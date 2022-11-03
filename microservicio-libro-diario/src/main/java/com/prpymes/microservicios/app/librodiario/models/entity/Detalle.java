package com.prpymes.microservicios.app.librodiario.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="detalle")
public class Detalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnoreProperties(value = {"detalles"})
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro_diario")
	@NotNull
    private LibroDiario libroDiario;
	
	@NotEmpty
	private String tipoDetalle;
	
	private Double monto;
	
	public Long getId() {
		return id;
	}

	public void setIdLibroDiario(Long id) {
		this.id = id;
	}
	
	public LibroDiario getLibroDiario() {
		return libroDiario;
	}
	public void setLibroDiario(LibroDiario libroDiario) {
		this.libroDiario = libroDiario;
	}
	
	public String getTipoDetalle() {
		return tipoDetalle;
	}
	public void setTipoDetalle(String tipoDetalle) {
		this.tipoDetalle = tipoDetalle;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) 
		{
			return true;
		}
		
		if(!(obj instanceof Detalle)) 
		{
			return false;
		}
		
		Detalle d=(Detalle) obj;
		return this.id !=null && this.id.equals(d.getId());
	}
}
