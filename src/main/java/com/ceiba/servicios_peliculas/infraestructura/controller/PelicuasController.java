package com.ceiba.servicios_peliculas.infraestructura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.servicios_peliculas.aplicacion.manejadores.peliculas.AlquilerManejador;
import com.ceiba.servicios_peliculas.aplicacion.manejadores.peliculas.PeliculasManejador;
import com.ceiba.servicios_peliculas.dominio.dto.AlquilerDTO;
import com.ceiba.servicios_peliculas.dominio.dto.PeliculaDTO;

@RestController
@RequestMapping("/peliculas")
public class PelicuasController {
	
	@Autowired
	private PeliculasManejador peliculasManejador;
	
	@Autowired
	private AlquilerManejador alquilerManejador;
	
	@GetMapping("/obtenerListaPeliculas")
	public List<PeliculaDTO> obtenerListaPeliculas() {
		
		return peliculasManejador.obtenerPeliculas();
	}
	
	@GetMapping("/obtenerAlquilerInfo/peliculaId/{id}")
	public AlquilerDTO obtenerAlquilerInfo(@PathVariable long id) {
		
		return alquilerManejador.obtenerAlquilerInfo(id);
	}
	
	@GetMapping("/alquilar/peliculaId/{id}")
	public void alquilar(@PathVariable long id) {
		
		alquilerManejador.alquilar(id);
	}

}
