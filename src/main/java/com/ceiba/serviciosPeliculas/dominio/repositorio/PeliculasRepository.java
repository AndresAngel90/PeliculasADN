package com.ceiba.serviciosPeliculas.dominio.repositorio;

import java.util.List;

import com.ceiba.serviciosPeliculas.dominio.dto.PeliculaDTO;
import com.ceiba.serviciosPeliculas.infraestructura.persistencia.entidad.PeliculaEntity;

public interface PeliculasRepository {
	
	List<PeliculaDTO> obtenerListaPeliculasDisponibles();

}
