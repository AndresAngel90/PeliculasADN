package com.ceiba.servicios_peliculas.aplicacion.manejadores.peliculas;

import org.springframework.stereotype.Service;

import com.ceiba.servicios_peliculas.aplicacion.comando.ComandoPelicula;
import com.ceiba.servicios_peliculas.aplicacion.fabrica.FabricaPelicula;
import com.ceiba.servicios_peliculas.dominio.PeliculaCrear;
import com.ceiba.servicios_peliculas.dominio.servicio.pelicula.ServicioObtenerPelicula;

@Service
public class PeliculasManejadorAgregar {
	
	private final ServicioObtenerPelicula servicioObtenerPelicula;
	private final FabricaPelicula fabricaPelicula;

	public PeliculasManejadorAgregar(ServicioObtenerPelicula servicioObtenerPelicula, FabricaPelicula fabricaPelicula) {
		this.servicioObtenerPelicula = servicioObtenerPelicula;
		this.fabricaPelicula = fabricaPelicula;
	}
	
	public String agregar(ComandoPelicula comandoPelicula) {
		PeliculaCrear pelicula = this.fabricaPelicula.crearPeliculaCrear(comandoPelicula);
		return this.servicioObtenerPelicula.crearPelicula(pelicula);		
		
	}

}
