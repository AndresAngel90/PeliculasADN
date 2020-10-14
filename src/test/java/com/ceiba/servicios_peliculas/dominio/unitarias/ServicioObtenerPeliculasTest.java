package com.ceiba.servicios_peliculas.dominio.unitarias;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.servicios_peliculas.dominio.dto.AlquilerDTO;
import com.ceiba.servicios_peliculas.dominio.dto.PeliculaDTO;
import com.ceiba.servicios_peliculas.dominio.repositorio.AlquilerRepository;
import com.ceiba.servicios_peliculas.dominio.repositorio.PeliculasRepository;
import com.ceiba.servicios_peliculas.dominio.servicio.pelicula.ServicioAlquilerPeliculas;
import com.ceiba.servicios_peliculas.dominio.servicio.pelicula.ServicioObtenerPelicula;
import com.ceiba.servicios_peliculas.testdatabuilder.TestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServicioObtenerPeliculasTest {
	
	@InjectMocks
	ServicioObtenerPelicula servicioObtenerPelicula;
	
	@Mock
	PeliculasRepository peliculasRepository;
	
	@Test
	public void getAlquilerInfoTest() {		
		
		List<PeliculaDTO> listaPeliculas = new TestDataBuilder().listaPeliculas();
		
		when(peliculasRepository.obtenerListaPeliculasDisponibles()).thenReturn(listaPeliculas);			
		
		List<PeliculaDTO> listaPeliculasresp = servicioObtenerPelicula.obtenerPeliculas();
		assertTrue(!listaPeliculasresp.isEmpty());
		
	}

}
