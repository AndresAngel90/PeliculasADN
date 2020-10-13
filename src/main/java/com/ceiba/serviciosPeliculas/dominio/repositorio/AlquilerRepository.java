package com.ceiba.serviciosPeliculas.dominio.repositorio;

import com.ceiba.serviciosPeliculas.dominio.dto.AlquilerDTO;

public interface AlquilerRepository {
	
	AlquilerDTO alquilerInfo(Long peliculaCodigo);
	
	void alquilarPelicula(Long peliculaCodigo);

}
