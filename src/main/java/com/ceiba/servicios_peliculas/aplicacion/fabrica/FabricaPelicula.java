package com.ceiba.servicios_peliculas.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.servicios_peliculas.aplicacion.comando.ComandoPelicula;
import com.ceiba.servicios_peliculas.dominio.PeliculaCrear;

@Component
public class FabricaPelicula {
	
	public PeliculaCrear crearPeliculaCrear(ComandoPelicula comandoPelicula) {
		
		return new PeliculaCrear(comandoPelicula.getNombre(), comandoPelicula.getFechaEstreno(),
				comandoPelicula.getStock(), comandoPelicula.getStockInicial(), comandoPelicula.getImageUrl(),
				comandoPelicula.getSinopsis());
	}

}
