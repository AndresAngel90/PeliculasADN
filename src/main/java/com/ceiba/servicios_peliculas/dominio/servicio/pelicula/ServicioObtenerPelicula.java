package com.ceiba.servicios_peliculas.dominio.servicio.pelicula;

import java.util.List;

import com.ceiba.servicios_peliculas.dominio.Pelicula;
import com.ceiba.servicios_peliculas.dominio.PeliculaCrear;
import com.ceiba.servicios_peliculas.dominio.repositorio.PeliculasRepository;

public class ServicioObtenerPelicula {
	
	private final PeliculasRepository peliculasRepository;
	
	public ServicioObtenerPelicula(PeliculasRepository peliculasRepository) {
		
		this.peliculasRepository = peliculasRepository;
	}
	
	public List<Pelicula> obtenerPeliculas(){
		
		return peliculasRepository.obtenerListaPeliculasDisponibles();
		
	}
	
	public String crearPelicula(PeliculaCrear pelicula) {
		
		return peliculasRepository.agregar(pelicula);
	}

}
