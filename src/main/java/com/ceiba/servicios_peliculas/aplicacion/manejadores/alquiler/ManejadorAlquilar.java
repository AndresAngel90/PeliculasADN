package com.ceiba.servicios_peliculas.aplicacion.manejadores.alquiler;

import org.springframework.stereotype.Service;

import com.ceiba.servicios_peliculas.dominio.servicio.pelicula.ServicioAlquilerPeliculas;

@Service
public class ManejadorAlquilar {
	
	private final ServicioAlquilerPeliculas servicioAlquilerPeliculas;
	
	public ManejadorAlquilar(ServicioAlquilerPeliculas servicioAlquilerPeliculas) {
		
		this.servicioAlquilerPeliculas = servicioAlquilerPeliculas;
	}
	
	

	
	public void alquilar(long idPelicula, String fechaDevolucion, int tarfia) {
		
		servicioAlquilerPeliculas.alquilar(idPelicula, fechaDevolucion, tarfia);
	}

}
