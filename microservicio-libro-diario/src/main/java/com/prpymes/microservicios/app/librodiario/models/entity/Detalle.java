package com.prpymes.microservicios.app.librodiario.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalle")
public class Detalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLibroDiario;
	
	/*@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@MapsId
    @JoinColumn(name = "idLibroDiario", nullable = true)
    private LibroDiario libroDiario;*/
	
	private String tipoDetalle;
	private Double monto;
	
	public Long getIdLibroDiario() {
		return idLibroDiario;
	}

	public void setIdLibroDiario(Long idLibroDiario) {
		this.idLibroDiario = idLibroDiario;
	}
	
	/*public LibroDiario getLibroDiario() {
		return libroDiario;
	}
	public void setLibroDiario(LibroDiario libroDiario) {
		this.libroDiario = libroDiario;
	}*/
	
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
		return this.idLibroDiario !=null && this.idLibroDiario.equals(d.getIdLibroDiario());
	}
}
