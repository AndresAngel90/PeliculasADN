package com.ceiba.servicios_peliculas.aplicacion.manejadores.peliculas;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.servicios_peliculas.dominio.dto.PeliculaDTO;
import com.ceiba.servicios_peliculas.dominio.servicio.pelicula.ServicioObtenerPelicula;


@Service
public class PeliculasManejador{

	private final ServicioObtenerPelicula servicioObtenerPelicula;
	
	public PeliculasManejador(ServicioObtenerPelicula servicioObtenerPelicula) {
		
		this.servicioObtenerPelicula = servicioObtenerPelicula;
	}
	
	public List<PeliculaDTO> obtenerPeliculas() {
		
		return this.servicioObtenerPelicula.obtenerPeliculas();
	}

}
