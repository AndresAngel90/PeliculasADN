package com.ceiba.serviciosPeliculas.infraestructura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.serviciosPeliculas.aplicacion.PeliculasManejador.impl.PeliculasManejador;
import com.ceiba.serviciosPeliculas.dominio.dto.PeliculaDTO;

@RestController
@RequestMapping("/peliculas")
public class PelicuasController {
	
	@Autowired
	private PeliculasManejador peliculasManejador;
	
	@GetMapping("/obtenerListaPeliculas")
	public List<PeliculaDTO> obtenerListaPeliculas() {
		
		return peliculasManejador.obtenerPeliculas();
	}

}
