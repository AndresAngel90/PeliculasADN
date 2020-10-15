package com.ceiba.servicios_peliculas.infraestructura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.servicios_peliculas.aplicacion.manejadores.peliculas.PeliculasManejador;
import com.ceiba.servicios_peliculas.dominio.Pelicula;

@RestController
@RequestMapping("/peliculas")
public class PelicuasController {
	
	
	private final PeliculasManejador peliculasManejador;	
	
	
	
	public PelicuasController(PeliculasManejador peliculasManejador) {
		
		this.peliculasManejador = peliculasManejador;
		
	}
	
	@GetMapping("/obtenerListaPeliculas")
	public List<Pelicula> obtenerListaPeliculas() {
		
		return peliculasManejador.obtenerPeliculas();
	}	
	
}
