package com.ceiba.servicios_peliculas.infraestructura.controller;


import org.springframework.web.bind.annotation.*;

import com.ceiba.servicios_peliculas.aplicacion.comando.ComandoAlquilerEjecutar;
import com.ceiba.servicios_peliculas.aplicacion.manejadores.alquiler.ManejadorAlquilar;
import com.ceiba.servicios_peliculas.aplicacion.manejadores.alquiler.ManejadorObtenerAlquilerInfo;
import com.ceiba.servicios_peliculas.dominio.AlquilerInfo;

@RestController
@RequestMapping("/alquiler")
public class AlquilerController {
	
	private final ManejadorObtenerAlquilerInfo manejadorObtenerAlquilerInfo;
	private final ManejadorAlquilar manejadorAlquilar;
	
	public AlquilerController(ManejadorObtenerAlquilerInfo alquilerManejador, ManejadorAlquilar manejadorAlquilar) {
		
		this.manejadorObtenerAlquilerInfo = alquilerManejador;
		this.manejadorAlquilar = manejadorAlquilar;
	}
	
	@GetMapping("/obtenerAlquilerInfo/peliculaId/{id}")
	public AlquilerInfo obtenerAlquilerInfo(@PathVariable long id) {
		
		return manejadorObtenerAlquilerInfo.obtenerAlquilerInfo(id);
	}
	
	@PostMapping("/alquilar")
	public void alquilar(@RequestBody ComandoAlquilerEjecutar comandoAlquilerEjecutar) {	
		
		this.manejadorAlquilar.alquilar(comandoAlquilerEjecutar);
	}


}
