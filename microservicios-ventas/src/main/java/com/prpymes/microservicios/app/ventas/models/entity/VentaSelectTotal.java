package com.prpymes.microservicios.app.ventas.models.entity;

import java.util.Date;

import javax.persistence.Entity;

public interface VentaSelectTotal {
	double getTotal();
	Date getFechaCreacion();	
}
