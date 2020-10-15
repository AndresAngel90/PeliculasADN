package com.ceiba.servicios_peliculas.infraestructura.persistencia.builder;

import com.ceiba.servicios_peliculas.dominio.Pelicula;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.entidad.PeliculaEntity;

public final class PeliculaBuilder {
	
	private PeliculaBuilder() {
		
	}
	
	public static Pelicula convertirPeliculaEntity(PeliculaEntity peliculaEtity) {
		
		return new Pelicula(peliculaEtity.getId(), peliculaEtity.getNombre(), peliculaEtity.getFechaEstreno(), peliculaEtity.getImageUrl());		
		
		
	}

}
