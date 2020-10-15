package com.ceiba.servicios_peliculas.infraestructura.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ceiba.servicios_peliculas.dominio.Alquiler;
import com.ceiba.servicios_peliculas.dominio.AlquilerInfo;
import com.ceiba.servicios_peliculas.dominio.repositorio.AlquilerRepository;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.builder.AlquilerIbuilder;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.entidad.AlquilerEntity;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.entidad.PeliculaEntity;

@Repository("alquilerReposiotorioPersistente")
public class AlquilerReposiotorioPersistente implements AlquilerRepository {
	
	private static final String FIND_PELICULSBYID = "Pelicula.byID";
	
	private static final String ALQUILAR_PELICULABYID = "AlquilarPelicula.byID";
	
	private static final String ID_PELICULA = "idPelicula";
	
	private final EntityManager entityManager;
	
	public AlquilerReposiotorioPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public AlquilerInfo alquilerInfo(Long peliculaCodigo) {
		
		Query query = entityManager.createNamedQuery(FIND_PELICULSBYID);
		query.setParameter(ID_PELICULA, peliculaCodigo);
		
		PeliculaEntity peliculaEntity  = (PeliculaEntity) query.getSingleResult();		
		return  AlquilerIbuilder.generarAlquilerDTO(peliculaEntity);
	}

	@Override
	@Transactional
	public void alquilarPelicula(Alquiler alquiler) {
		
		Query query = entityManager.createNamedQuery(FIND_PELICULSBYID);
		query.setParameter(ID_PELICULA, alquiler.getPelicula().getPeliculaID());
		
		PeliculaEntity peliculaEntity = (PeliculaEntity) query.getSingleResult();		
		AlquilerEntity alquilerEntity = AlquilerIbuilder.convertirAAlquilerEntity(alquiler, peliculaEntity);		
		entityManager.persist(alquilerEntity);
		
		Query queryStock = entityManager.createNamedQuery(ALQUILAR_PELICULABYID);
		queryStock.setParameter(ID_PELICULA, alquiler.getPelicula().getPeliculaID()).executeUpdate();
		
	
	}

}
