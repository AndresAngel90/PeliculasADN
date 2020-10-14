package com.ceiba.servicios_peliculas.dominio.servicio.pelicula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.servicios_peliculas.dominio.dto.PeliculaDTO;
import com.ceiba.servicios_peliculas.dominio.repositorio.PeliculasRepository;

@Component
public class ServicioObtenerPelicula {
	
	@Autowired
	private PeliculasRepository peliculasRepository;
	
	
	public List<PeliculaDTO> obtenerPeliculas(){
		
		return peliculasRepository.obtenerListaPeliculasDisponibles();
		
	}

}
