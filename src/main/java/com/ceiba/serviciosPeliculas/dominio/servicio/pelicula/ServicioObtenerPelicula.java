package com.ceiba.serviciosPeliculas.dominio.servicio.pelicula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.serviciosPeliculas.dominio.dto.PeliculaDTO;
import com.ceiba.serviciosPeliculas.dominio.repositorio.PeliculasRepository;

@Component
public class ServicioObtenerPelicula {
	
	@Autowired
	private PeliculasRepository peliculasRepository;
	
	
	public List<PeliculaDTO> obtenerPeliculas(){
		
		return peliculasRepository.obtenerListaPeliculasDisponibles();
		
	}

}
