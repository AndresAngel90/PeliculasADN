package com.ceiba.serviciosPeliculas.aplicacion.PeliculasManejador.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.serviciosPeliculas.dominio.dto.PeliculaDTO;
import com.ceiba.serviciosPeliculas.dominio.servicio.pelicula.ServicioObtenerPelicula;


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
