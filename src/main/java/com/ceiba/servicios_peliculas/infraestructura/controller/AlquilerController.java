package com.ceiba.servicios_peliculas.infraestructura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/alquilar/peliculaId/{id}/fechaDevolucion/{dia}/{mes}/{anio}/tarifa/{tarifa}")
	public void alquilar(@PathVariable long id, @PathVariable String dia , @PathVariable String mes , @PathVariable String anio, @PathVariable int tarifa) {
		String fechaDevolucion = dia +"/" + mes +"/" + anio;
		manejadorAlquilar.alquilar(id, fechaDevolucion, tarifa);
	}


}
