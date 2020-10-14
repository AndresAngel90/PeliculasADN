package com.ceiba.servicios_peliculas.infraestructura.persistencia.builder;

import com.ceiba.servicios_peliculas.dominio.dto.AlquilerDTO;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.entidad.PeliculaEntity;

public final class AlquilerDTObuilder {
	
	
	public static AlquilerDTO generarAlquilerDTO(PeliculaEntity peliculaEntity) {
		
		AlquilerDTO alquilerDTO = new AlquilerDTO();
		alquilerDTO.setIdPelicula(peliculaEntity.getId());
		alquilerDTO.setNombrePelicula(peliculaEntity.getNombre());
		alquilerDTO.setUrlImagen(peliculaEntity.getImageUrl());
		alquilerDTO.setFechaEstrenoAlquiler(peliculaEntity.getFechaEstreno());
		
		return alquilerDTO;
		
	}
	

}
