package com.ceiba.servicios_peliculas.infraestructura.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ceiba.servicios_peliculas.dominio.dto.PeliculaDTO;
import com.ceiba.servicios_peliculas.dominio.repositorio.PeliculasRepository;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.builder.PeliculaDTOBuilder;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.entidad.PeliculaEntity;

@Repository("peliculasRepositorioPersistente")
public class PeliculasRepositorioPersistente implements PeliculasRepository {
	
	private final static String FIND_PELICULAS_DISPONIBLES = "Pelicula.listar";
	
	private final EntityManager entityManager;
	
	
	public PeliculasRepositorioPersistente(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}

	@Override
	public List<PeliculaDTO> obtenerListaPeliculasDisponibles() {
		
		List<PeliculaEntity> listaPeliculas = new ArrayList<PeliculaEntity>();
		
		List<PeliculaDTO> listaPeliculasDTO = new ArrayList<PeliculaDTO>();
		
		Query query = entityManager.createNamedQuery(FIND_PELICULAS_DISPONIBLES);
		
		listaPeliculas = query.getResultList();
		
		for (PeliculaEntity peliculaEntity : listaPeliculas) {
			
			listaPeliculasDTO.add(PeliculaDTOBuilder.convertirPeliculaEntity(peliculaEntity));
			
		}
		
		return listaPeliculasDTO;
	}

}
