package com.ceiba.serviciosPeliculas.aplicacion.PeliculasManejador.impl;

import org.springframework.stereotype.Service;

import com.ceiba.serviciosPeliculas.dominio.dto.AlquilerDTO;
import com.ceiba.serviciosPeliculas.dominio.servicio.pelicula.ServicioAlquilerPeliculas;

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
