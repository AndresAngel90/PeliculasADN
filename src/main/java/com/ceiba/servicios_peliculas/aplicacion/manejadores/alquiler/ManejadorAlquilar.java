package com.ceiba.servicios_peliculas.aplicacion.manejadores.alquiler;

import org.springframework.stereotype.Service;

import com.ceiba.servicios_peliculas.aplicacion.comando.ComandoAlquilerEjecutar;
import com.ceiba.servicios_peliculas.aplicacion.fabrica.FabricaAlquilerEjecutar;
import com.ceiba.servicios_peliculas.dominio.AlquilerEjecutar;
import com.ceiba.servicios_peliculas.dominio.servicio.pelicula.ServicioAlquilerPeliculas;

@Service
public class ManejadorAlquilar {
	
	private final ServicioAlquilerPeliculas servicioAlquilerPeliculas;
	private final FabricaAlquilerEjecutar fabricaAlquilerEjecutar;
	
	public ManejadorAlquilar(ServicioAlquilerPeliculas servicioAlquilerPeliculas, FabricaAlquilerEjecutar fabricaAlquilerEjecutar ) {
		
		this.servicioAlquilerPeliculas = servicioAlquilerPeliculas;
		this.fabricaAlquilerEjecutar = fabricaAlquilerEjecutar;
	}
	
	public void alquilar(ComandoAlquilerEjecutar comandoAlquilerEjecutar) {
		AlquilerEjecutar alquilerEjecutar = fabricaAlquilerEjecutar.crearAlquilerEjecutar(comandoAlquilerEjecutar);
		servicioAlquilerPeliculas.alquilar(alquilerEjecutar.getIdPelicula(), alquilerEjecutar.getFechaDevolucion(), alquilerEjecutar.getTarifa());
	}

}
