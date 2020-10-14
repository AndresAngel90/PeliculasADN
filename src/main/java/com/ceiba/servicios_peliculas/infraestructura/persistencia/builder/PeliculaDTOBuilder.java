package com.ceiba.servicios_peliculas.infraestructura.persistencia.builder;

import com.ceiba.servicios_peliculas.dominio.dto.PeliculaDTO;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.entidad.PeliculaEntity;

public final class PeliculaDTOBuilder {
	
	
	public static PeliculaDTO convertirPeliculaEntity(PeliculaEntity peliculaEtity) {
		
		PeliculaDTO peliculaDTO = new PeliculaDTO();
		
		peliculaDTO.setFechaEstreno(peliculaEtity.getFechaEstreno());
		peliculaDTO.setTituloPelicula(peliculaEtity.getNombre());
		peliculaDTO.setUrlImagen(peliculaEtity.getImageUrl());
		peliculaDTO.setPeliculaID(peliculaEtity.getId());
		return peliculaDTO;
		
	}

}
