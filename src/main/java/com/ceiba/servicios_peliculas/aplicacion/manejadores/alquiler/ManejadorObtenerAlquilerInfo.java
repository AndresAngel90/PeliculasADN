package com.ceiba.servicios_peliculas.aplicacion.manejadores.alquiler;

import org.springframework.stereotype.Service;

import com.ceiba.servicios_peliculas.dominio.AlquilerInfo;
import com.ceiba.servicios_peliculas.dominio.servicio.pelicula.ServicioAlquilerPeliculas;

@Service
public class ManejadorObtenerAlquilerInfo {

		private final ServicioAlquilerPeliculas servicioAlquilerPeliculas;
		
		public ManejadorObtenerAlquilerInfo(ServicioAlquilerPeliculas servicioAlquilerPeliculas) {
			
			this.servicioAlquilerPeliculas = servicioAlquilerPeliculas;
		}
		
		public AlquilerInfo obtenerAlquilerInfo (long codigoPelicula) {
			
			return servicioAlquilerPeliculas.alquilarInfo(codigoPelicula);
		}
}
