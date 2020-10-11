package com.ceiba.serviciosPeliculas.infraestructura.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ceiba.serviciosPeliculas.dominio.dto.AlquilerDTO;
import com.ceiba.serviciosPeliculas.dominio.repositorio.AlquilerRepository;
import com.ceiba.serviciosPeliculas.infraestructura.persistencia.builder.AlquilerDTObuilder;
import com.ceiba.serviciosPeliculas.infraestructura.persistencia.entidad.PeliculaEntity;

public class AlquilerReposiotorioPersistente implements AlquilerRepository {
	
	private static final String FIND_PELICULSBYID = "Pelicula.byID";
	
	private static final String ID_PELICULA = "idPelicula";
	
	private final EntityManager entityManager;
	
	public AlquilerReposiotorioPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public AlquilerDTO alquilerInfo(Long peliculaCodigo) {
		
		AlquilerDTO alquilerDTO = new AlquilerDTO();
		PeliculaEntity peliculaEntity =  new PeliculaEntity();
		Query query = entityManager.createNamedQuery(FIND_PELICULSBYID);
		query.setParameter(ID_PELICULA, peliculaCodigo);
		
		peliculaEntity = (PeliculaEntity) query.getSingleResult();
		
		alquilerDTO = AlquilerDTObuilder.generarAlquilerDTO(peliculaEntity);
		return alquilerDTO;
	}

}
