package com.ceiba.servicios_peliculas.dominio.repositorio;

import com.ceiba.servicios_peliculas.dominio.Alquiler;
import com.ceiba.servicios_peliculas.dominio.AlquilerInfo;

public interface AlquilerRepository {
	
	AlquilerInfo alquilerInfo(Long peliculaCodigo);
	
	void alquilarPelicula(Alquiler alquiler);

}
