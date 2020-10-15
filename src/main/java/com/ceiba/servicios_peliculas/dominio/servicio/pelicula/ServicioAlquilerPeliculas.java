package com.ceiba.servicios_peliculas.dominio.servicio.pelicula;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import com.ceiba.servicios_peliculas.dominio.Alquiler;
import com.ceiba.servicios_peliculas.dominio.AlquilerInfo;
import com.ceiba.servicios_peliculas.dominio.Pelicula;
import com.ceiba.servicios_peliculas.dominio.repositorio.AlquilerRepository;
import com.ceiba.servicios_peliculas.dominio.repositorio.PeliculasRepository;

public class ServicioAlquilerPeliculas {
	
	private final AlquilerRepository alquilerRepository;
	
	private final PeliculasRepository peliculasRepository;
	
	public ServicioAlquilerPeliculas(AlquilerRepository alquilerRepository, PeliculasRepository peliculasRepository) {
		
		this.alquilerRepository = alquilerRepository;
		this.peliculasRepository = peliculasRepository;
		
	}
	
	private static final int TARIFA = 5000;
	private static final int TARIFA6MESES = 2500;
	private static final int TARIFA3MESES = 5000;
	
	
	public AlquilerInfo alquilarInfo(long idPelicula) {
		
		AlquilerInfo alquilerDTO = alquilerRepository.alquilerInfo(idPelicula);
		
		alquilerDTO.setTarifa(calculoTarifa(alquilerDTO.getFechaEstrenoAlquiler()));
		
		alquilerDTO.setFechaDevolucion(calculoFechaDevolucion());
		
		return alquilerDTO;
	}
	
	
	public void alquilar(long idPelicula, String fechaDevolucion, int tarifa) {
		
		Pelicula pelicula = peliculasRepository.obtenerPeliculaByID(idPelicula);
		Alquiler alquiler =  new Alquiler(pelicula, tarifa, fechaDevolucion);
		alquilerRepository.alquilarPelicula(alquiler);
	}
	
	public int calculoTarifa(String fechaEstreno) {
		
		int tarifa = 0;
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate fechaEstrenoPelicula = LocalDate.parse(fechaEstreno, df);			
		
		LocalDate fechaActual = LocalDate.now();
		
		
		long diferencia = ChronoUnit.MONTHS.between(fechaEstrenoPelicula, fechaActual);
		
		if(diferencia <= 6 && diferencia > 3) {
			
			tarifa  = TARIFA + TARIFA6MESES;
		}else if(diferencia <= 3 ) {
			
			tarifa = TARIFA + TARIFA3MESES;
		}else {
			
			tarifa =  TARIFA;
		}
		
		return tarifa;
		
	}
	
	public String calculoFechaDevolucion() {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");		
		
		Calendar fechaEntrega = Calendar.getInstance();
		fechaEntrega.add(Calendar.DATE, 7);
		
		if(fechaEntrega.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			
			fechaEntrega.add(Calendar.DATE, 1);
		}else if(fechaEntrega.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			
			fechaEntrega.add(Calendar.DATE, -1);
		}
		
		return formato.format(fechaEntrega.getTime());
		
	}
	

}
