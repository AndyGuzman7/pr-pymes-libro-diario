package com.prpymes.microservicios.app.librodiario.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="libro_diario")
public class LibroDiario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLibroDiario;
	
	@JsonIgnoreProperties(value = {"libroDiario"}, allowSetters = true)
	@OneToMany(mappedBy = "libroDiario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Detalle> detalles;
	
	@NotEmpty
	private String glosa;
	
	@NotEmpty
	private String razonSocial;
	
	@NotEmpty
	private String tipoLibro;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	
	public LibroDiario() {
		this.detalles=new ArrayList<>();
	}

	public Long getIdLibroDiario() {
		return idLibroDiario;
	}

	public void setIdLibroDiario(Long idLibroDiario) {
		this.idLibroDiario = idLibroDiario;
	}

	public String getGlosa() {
		return glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getTipoLibro() {
		return tipoLibro;
	}

	public void setTipoLibro(String tipoLibro) {
		this.tipoLibro = tipoLibro;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles.clear();
		detalles.forEach(this::addDetalle);
	}
	
	public void addDetalle(Detalle detalle) {
		this.detalles.add(detalle);
		detalle.setLibroDiario(this);
	}
	
	public void removeDetalle(Detalle detalle) {
		this.detalles.remove(detalle);
		detalle.setLibroDiario(null);
	}
}
