package com.ceiba.servicios_peliculas.infraestructura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;


import com.ceiba.servicios_peliculas.aplicacion.comando.ComandoPelicula;
import com.ceiba.servicios_peliculas.aplicacion.manejadores.peliculas.PeliculasManejador;
import com.ceiba.servicios_peliculas.aplicacion.manejadores.peliculas.PeliculasManejadorAgregar;
import com.ceiba.servicios_peliculas.dominio.Pelicula;

@RestController
@RequestMapping("/peliculas")
public class PelicuasController {
	
	
	private final PeliculasManejador peliculasManejador;
	
	private final PeliculasManejadorAgregar peliculasManejadorAgregar;
	
	
	
	public PelicuasController(PeliculasManejador peliculasManejador, PeliculasManejadorAgregar peliculasManejadorAgregar) {
		
		this.peliculasManejador = peliculasManejador;
		this.peliculasManejadorAgregar = peliculasManejadorAgregar;
		
	}
	
	@GetMapping("/obtenerListaPeliculas")
	public List<Pelicula> obtenerListaPeliculas() {
		
		return peliculasManejador.obtenerPeliculas();
	}
	
	@PostMapping("/agregar")
	public String alquilar(@RequestBody ComandoPelicula comandoPelicula) {	
		
		return this.peliculasManejadorAgregar.agregar(comandoPelicula);
	}
	
}
