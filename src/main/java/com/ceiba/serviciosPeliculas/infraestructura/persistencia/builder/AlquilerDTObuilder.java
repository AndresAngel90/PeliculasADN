package com.ceiba.serviciosPeliculas.infraestructura.persistencia.builder;

import com.ceiba.serviciosPeliculas.dominio.dto.AlquilerDTO;
import com.ceiba.serviciosPeliculas.infraestructura.persistencia.entidad.PeliculaEntity;

public final class AlquilerDTObuilder {
	
	
	public static AlquilerDTO generarAlquilerDTO(PeliculaEntity peliculaEntity) {
		
		AlquilerDTO alquilerDTO = new AlquilerDTO();
		alquilerDTO.setIdPelicula(peliculaEntity.getId());
		alquilerDTO.setNombrePelicula(peliculaEntity.getNombre());
		alquilerDTO.setUrlImagen(peliculaEntity.getImageUrl());
		
		return alquilerDTO;
		
	}
	

}
