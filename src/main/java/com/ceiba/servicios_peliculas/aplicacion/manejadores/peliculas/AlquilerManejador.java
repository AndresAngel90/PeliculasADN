package com.ceiba.servicios_peliculas.aplicacion.manejadores.peliculas;

import org.springframework.stereotype.Service;

import com.ceiba.servicios_peliculas.dominio.dto.AlquilerDTO;
import com.ceiba.servicios_peliculas.dominio.servicio.pelicula.ServicioAlquilerPeliculas;

@Service
public class AlquilerManejador {

		private final ServicioAlquilerPeliculas servicioAlquilerPeliculas;
		
		public AlquilerManejador(ServicioAlquilerPeliculas servicioAlquilerPeliculas) {
			
			this.servicioAlquilerPeliculas = servicioAlquilerPeliculas;
		}
		
		public AlquilerDTO obtenerAlquilerInfo (long codigoPelicula) {
			
			return servicioAlquilerPeliculas.alquilarInfo(codigoPelicula);
		}
		
		public void alquilar(long idPelicula) {
			
			servicioAlquilerPeliculas.alquilar(idPelicula);
		}
}
