package com.ceiba.servicios_peliculas.dominio.repositorio;

import java.util.List;

import com.ceiba.servicios_peliculas.dominio.dto.PeliculaDTO;
import com.ceiba.servicios_peliculas.infraestructura.persistencia.entidad.PeliculaEntity;

public interface PeliculasRepository {
	
	List<PeliculaDTO> obtenerListaPeliculasDisponibles();

}
