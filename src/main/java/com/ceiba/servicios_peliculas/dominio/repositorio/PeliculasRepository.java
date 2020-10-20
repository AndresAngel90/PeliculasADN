package com.ceiba.servicios_peliculas.dominio.repositorio;

import java.util.List;

import com.ceiba.servicios_peliculas.dominio.Pelicula;
import com.ceiba.servicios_peliculas.dominio.PeliculaCrear;

public interface PeliculasRepository {
	
	List<Pelicula> obtenerListaPeliculasDisponibles();
	
	Pelicula obtenerPeliculaByID(long idPelicula);
	
	String agregar(PeliculaCrear peliculaCrear);

}
