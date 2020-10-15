package com.ceiba.servicios_peliculas.infraestructura.persistencia.builder;

import com.ceiba.servicios_peliculas.dominio.Alquiler;
import com.ceiba.servicios_peliculas.dominio.AlquilerInfo;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.entidad.AlquilerEntity;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.entidad.PeliculaEntity;

public final class AlquilerIbuilder {
	
	private AlquilerIbuilder() {
		
	}
	
	
	public static AlquilerInfo generarAlquilerDTO(PeliculaEntity peliculaEntity) {
		
		return new AlquilerInfo(peliculaEntity.getId(), peliculaEntity.getNombre(),  peliculaEntity.getFechaEstreno(), peliculaEntity.getImageUrl());
		
	}
	
	public static AlquilerEntity convertirAAlquilerEntity(Alquiler alquiler, PeliculaEntity peliculaEntity) {		
		
		AlquilerEntity alquilerEntity = new AlquilerEntity();
		
		alquilerEntity.setEstadoAlquiler("A");
		alquilerEntity.setFechaDevolucion(alquiler.getFechaDevolucion());
		alquilerEntity.setValorAlquiler(alquiler.getTarifa());
		alquilerEntity.setPelicula(peliculaEntity);
		return alquilerEntity;
		
	}
	

}
