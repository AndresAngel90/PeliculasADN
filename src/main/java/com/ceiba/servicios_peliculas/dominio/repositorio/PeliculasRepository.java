package com.ceiba.servicios_peliculas.dominio.repositorio;

import java.util.List;

import com.ceiba.servicios_peliculas.dominio.Pelicula;

public interface PeliculasRepository {
	
	List<Pelicula> obtenerListaPeliculasDisponibles();
	
	Pelicula obtenerPeliculaByID(long idPelicula);

}
