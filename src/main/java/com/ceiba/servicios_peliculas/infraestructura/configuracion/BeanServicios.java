package com.ceiba.servicios_peliculas.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.servicios_peliculas.dominio.repositorio.AlquilerRepository;
import com.ceiba.servicios_peliculas.dominio.repositorio.PeliculasRepository;
import com.ceiba.servicios_peliculas.dominio.servicio.pelicula.ServicioAlquilerPeliculas;
import com.ceiba.servicios_peliculas.dominio.servicio.pelicula.ServicioObtenerPelicula;

@Configuration
public class BeanServicios {
	
	
	@Bean
	public ServicioAlquilerPeliculas servicioAlquilerPeliculas(AlquilerRepository alquilerRepository, PeliculasRepository peliculasRepository) {
		
		return new ServicioAlquilerPeliculas(alquilerRepository, peliculasRepository);
	}
	
	@Bean
	public ServicioObtenerPelicula servicioObtenerPelicula(PeliculasRepository peliculasRepository) {
		
		return new ServicioObtenerPelicula(peliculasRepository);
	}
	
	

}
