package com.ceiba.servicios_peliculas.infraestructura.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ceiba.servicios_peliculas.dominio.Alquiler;
import com.ceiba.servicios_peliculas.dominio.AlquilerInfo;
import com.ceiba.servicios_peliculas.dominio.excepcion.AlquilerExcepcion;
import com.ceiba.servicios_peliculas.dominio.repositorio.AlquilerRepository;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.builder.AlquilerIbuilder;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.entidad.AlquilerEntity;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.entidad.PeliculaEntity;

@Repository("alquilerReposiotorioPersistente")
public class AlquilerReposiotorioPersistenteH2 implements AlquilerRepository {
	
	private static final String ERROR_GETPELICULA = "Hay un error al obtener su pelicula por favor verifique el id de la película o intente más tarde";
	
	private static final String FIND_PELICULSBYID = "Pelicula.byID";
	
	private static final String ALQUILAR_PELICULABYID = "AlquilarPelicula.byID";
	
	private static final String ID_PELICULA = "idPelicula";
	
	private final EntityManager entityManager;
	
	private static final Logger LOG = LogManager.getLogger(AlquilerReposiotorioPersistenteH2.class);
	
	public AlquilerReposiotorioPersistenteH2(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public AlquilerInfo alquilerInfo(Long peliculaCodigo) {
		
		Query query = entityManager.createNamedQuery(FIND_PELICULSBYID);
		query.setParameter(ID_PELICULA, peliculaCodigo);
		
		try {
			
			PeliculaEntity peliculaEntity  = (PeliculaEntity) query.getSingleResult();	
			return  AlquilerIbuilder.generarAlquilerDTO(peliculaEntity);
		} catch (Exception e) {
			LOG.error("ERROR:", e);
			throw new AlquilerExcepcion(ERROR_GETPELICULA);
		}
			
		
	}

	@Override
	@Transactional
	public void alquilarPelicula(Alquiler alquiler) {
		
		Query query = entityManager.createNamedQuery(FIND_PELICULSBYID);
		query.setParameter(ID_PELICULA, alquiler.getPelicula().getPeliculaID());
		
		Query queryStock = entityManager.createNamedQuery(ALQUILAR_PELICULABYID);
			
		PeliculaEntity peliculaEntity = (PeliculaEntity) query.getSingleResult();		
		AlquilerEntity alquilerEntity = AlquilerIbuilder.convertirAAlquilerEntity(alquiler, peliculaEntity);		
		entityManager.persist(alquilerEntity);			
		alquilerEntity.getId();
		queryStock.setParameter(ID_PELICULA, alquiler.getPelicula().getPeliculaID()).executeUpdate();
			
		
		
	
	}

}
