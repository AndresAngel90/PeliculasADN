package com.ceiba.serviciosPeliculas.infraestructura;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorPeliculasTest {
	
	public static final long CODIGO_PELICULA_10 = 10l;
	
	@Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    public void getListaPeliculasTest()throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders
                .get("/peliculas/obtenerListaPeliculas")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    	
    	
    }
    
    @Test
    public void getAlquilerByID()throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders
                .get("/peliculas/obtenerAlquilerInfo/peliculaId/{id}",CODIGO_PELICULA_10)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idPelicula").value(CODIGO_PELICULA_10));
    	
    	
    }
    
    @Test
    public void alquilarById()throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders
                .get("/peliculas/alquilar/peliculaId/{id}",CODIGO_PELICULA_10)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    	
    	
    }

}