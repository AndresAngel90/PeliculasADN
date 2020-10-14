package com.ceiba.servicios_peliculas.dominio.repositorio;

import com.ceiba.servicios_peliculas.dominio.dto.AlquilerDTO;

public interface AlquilerRepository {
	
	AlquilerDTO alquilerInfo(Long peliculaCodigo);
	
	void alquilarPelicula(Long peliculaCodigo);

}
