package com.ceiba.servicios_peliculas.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.servicios_peliculas.aplicacion.comando.ComandoAlquilerEjecutar;
import com.ceiba.servicios_peliculas.dominio.AlquilerEjecutar;

@Component
public class FabricaAlquilerEjecutar {
	
	public AlquilerEjecutar crearAlquilerEjecutar(ComandoAlquilerEjecutar comandoAlquilerEjecutar) {
		
		return new AlquilerEjecutar(comandoAlquilerEjecutar.getIdPelicula(), comandoAlquilerEjecutar.getFechaDevolucion(), comandoAlquilerEjecutar.getTarifa());
	}

}
