package com.ceiba.servicios_peliculas.dominio.servicio.pelicula;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.servicios_peliculas.dominio.dto.AlquilerDTO;
import com.ceiba.servicios_peliculas.dominio.repositorio.AlquilerRepository;

@Component
public class ServicioAlquilerPeliculas {
	
	
	
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	private static final int TARIFA = 5000;
	private static final int TARIFA6MESES = 2500;
	private static final int TARIFA3MESES = 5000;
	
	
	public AlquilerDTO alquilarInfo(long idPelicula) {
		
		AlquilerDTO alquilerDTO =  new AlquilerDTO();
		
		alquilerDTO = alquilerRepository.alquilerInfo(idPelicula);
		
		alquilerDTO.setTarifa(calculoTarifa(alquilerDTO.getFechaEstrenoAlquiler()));
		
		alquilerDTO.setFechaDevolucion(calculoFechaDevolucion());
		
		return alquilerDTO;
	}
	
	
	public void alquilar(long idPelicula) {
		
		alquilerRepository.alquilarPelicula(idPelicula);
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
