package com.ceiba.serviciosPeliculas.dominio;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.serviciosPeliculas.dominio.dto.AlquilerDTO;
import com.ceiba.serviciosPeliculas.dominio.dto.PeliculaDTO;
import com.ceiba.serviciosPeliculas.dominio.repositorio.AlquilerRepository;
import com.ceiba.serviciosPeliculas.dominio.repositorio.PeliculasRepository;
import com.ceiba.serviciosPeliculas.dominio.servicio.pelicula.ServicioAlquilerPeliculas;
import com.ceiba.serviciosPeliculas.dominio.servicio.pelicula.ServicioObtenerPelicula;
import com.ceiba.serviciosPeliculas.testDataBuilder.TestDataBuilder;

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
