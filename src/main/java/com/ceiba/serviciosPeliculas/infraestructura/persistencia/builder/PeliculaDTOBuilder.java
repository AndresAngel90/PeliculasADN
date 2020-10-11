package com.ceiba.serviciosPeliculas.infraestructura.persistencia.builder;

import com.ceiba.serviciosPeliculas.dominio.dto.PeliculaDTO;
import com.ceiba.serviciosPeliculas.infraestructura.persistencia.entidad.PeliculaEntity;

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
