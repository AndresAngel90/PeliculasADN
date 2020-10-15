package com.ceiba.servicios_peliculas.infraestructura.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ceiba.servicios_peliculas.dominio.Pelicula;
import com.ceiba.servicios_peliculas.dominio.repositorio.PeliculasRepository;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.builder.PeliculaBuilder;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.entidad.PeliculaEntity;

@Repository("peliculasRepositorioPersistente")
public class PeliculasRepositorioPersistente implements PeliculasRepository {
	
	private static final  String FIND_PELICULAS_DISPONIBLES = "Pelicula.listar";
	private static final  String FIDN_PELICULA_BY_ID = "Pelicula.byID";
	private static final String ID_PELICULA = "idPelicula";
	
	private final EntityManager entityManager;
	
	
	public PeliculasRepositorioPersistente(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}

	@Override
	public List<Pelicula> obtenerListaPeliculasDisponibles() {		
		 
		
		List<Pelicula> listaPeliculasDTO = new ArrayList<>();
		
		Query query = entityManager.createNamedQuery(FIND_PELICULAS_DISPONIBLES);
		
		List<PeliculaEntity> listaPeliculas = query.getResultList();
		
		for (PeliculaEntity peliculaEntity : listaPeliculas) {
			
			listaPeliculasDTO.add(PeliculaBuilder.convertirPeliculaEntity(peliculaEntity));
			
		}
		
		return listaPeliculasDTO;
	}

	@Override
	public Pelicula obtenerPeliculaByID(long idPelicula) {	
		
		Query query = entityManager.createNamedQuery(FIDN_PELICULA_BY_ID);
		query.setParameter(ID_PELICULA, idPelicula);
		PeliculaEntity peliculaEntity = (PeliculaEntity) query.getSingleResult();		
		
		return PeliculaBuilder.convertirPeliculaEntity(peliculaEntity);
	}

}
