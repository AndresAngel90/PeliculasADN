package com.ceiba.serviciosPeliculas.dominio;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.serviciosPeliculas.dominio.dto.AlquilerDTO;
import com.ceiba.serviciosPeliculas.dominio.repositorio.AlquilerRepository;
import com.ceiba.serviciosPeliculas.dominio.servicio.pelicula.ServicioAlquilerPeliculas;
import com.ceiba.serviciosPeliculas.testDataBuilder.TestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServicioAlquilerPeliculasTest {	
	
	private static final int TARIFA = 5000;
	private static final int TARIFA6MESES = 7500;
	private static final int TARIFA3MESES = 10000;
	
	@InjectMocks
	ServicioAlquilerPeliculas servicioAlquilerPeliculas;
	
	@Mock
	AlquilerRepository alquilerRepository;
	
	@Test
	public void getAlquilerInfoTest() {		
		
		AlquilerDTO alquilerDTO =  new TestDataBuilder().alquilerDtoBuilder();
		
		when(alquilerRepository.alquilerInfo(alquilerDTO.getIdPelicula())).thenReturn(alquilerDTO);			
		
		AlquilerDTO alquilerDTOResp = servicioAlquilerPeliculas.alquilarInfo(alquilerDTO.getIdPelicula());
		assertTrue(alquilerDTOResp.getIdPelicula() == alquilerDTOResp.getIdPelicula());
		
	}
	
	@Test
	public void calcularTarifaNormal() {		
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");	
		int tarifa = 0;		
		Calendar fechaActual = Calendar.getInstance();
		fechaActual.add(Calendar.MONTH, -8);
		tarifa = servicioAlquilerPeliculas.calculoTarifa(formato.format(fechaActual.getTime()));
		assertTrue(TARIFA == tarifa);
		
	}
	
	@Test
	public void calcularTarifaSeisMeses() {		
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");	
		int tarifa = 0;		
		Calendar fechaActual = Calendar.getInstance();
		fechaActual.add(Calendar.MONTH, -5);
		tarifa = servicioAlquilerPeliculas.calculoTarifa(formato.format(fechaActual.getTime()));
		assertTrue(TARIFA6MESES == tarifa);
		
	}
	
	@Test
	public void calcularTarifaTresMeses() {		
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");	
		int tarifa = 0;		
		Calendar fechaActual = Calendar.getInstance();
		fechaActual.add(Calendar.MONTH, -2);
		tarifa = servicioAlquilerPeliculas.calculoTarifa(formato.format(fechaActual.getTime()));
		assertTrue(TARIFA3MESES == tarifa);
		
	}

}
