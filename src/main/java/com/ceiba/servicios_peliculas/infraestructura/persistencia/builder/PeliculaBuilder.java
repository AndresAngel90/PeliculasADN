package com.ceiba.servicios_peliculas.infraestructura.persistencia.builder;

import com.ceiba.servicios_peliculas.dominio.Pelicula;
import com.ceiba.servicios_peliculas.dominio.PeliculaCrear;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.entidad.PeliculaEntity;

public final class PeliculaBuilder {
	
	private PeliculaBuilder() {
		
	}
	
	public static Pelicula convertirPeliculaEntity(PeliculaEntity peliculaEtity) {
		
		return new Pelicula(peliculaEtity.getId(), peliculaEtity.getNombre(), peliculaEtity.getFechaEstreno(), peliculaEtity.getImageUrl(), peliculaEtity.getSinopsis());		
		
		
	}
	
	public static PeliculaEntity transformacionEntity(PeliculaCrear peliculaCrear) {
		
		PeliculaEntity peliculaEntity = new PeliculaEntity();	
		
		peliculaEntity.setNombre(peliculaCrear.getNombre());
		peliculaEntity.setFechaEstreno(peliculaCrear.getFechaEstreno());
		peliculaEntity.setImageUrl(peliculaCrear.getImageUrl());
		peliculaEntity.setStock(peliculaCrear.getStock());
		peliculaEntity.setStockInicial(peliculaCrear.getStockInicial());
		peliculaEntity.setSinopsis(peliculaCrear.getSinopsis());
		
		return peliculaEntity;
		
		
	}

}
