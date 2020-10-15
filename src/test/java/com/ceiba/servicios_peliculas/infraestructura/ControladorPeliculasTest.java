package com.ceiba.servicios_peliculas.infraestructura;

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


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorPeliculasTest {
	
	public static final long CODIGO_PELICULA_10 = 10l;
	public static final String FECHA_DEVOLUCION = "22/10/2020";
	public static final int TARIFA = 7500;
	
	@Autowired
    private MockMvc mvc;
    
    @Test
    public void getListaPeliculasTest()throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders
                .get("/peliculas/obtenerListaPeliculas")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    	
    	
    }
    
    @Test
    public void getAlquilerByID()throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders
                .get("/alquiler/obtenerAlquilerInfo/peliculaId/{id}",CODIGO_PELICULA_10)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idPelicula").value(CODIGO_PELICULA_10));
    	
    	
    }
    
    @Test
    public void alquilarById()throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders
                .get("/alquiler/alquilar/peliculaId/{id}/fechaDevolucion/{fechaDevolucion}/tarifa/{tarfia}",CODIGO_PELICULA_10, FECHA_DEVOLUCION, TARIFA)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    	
    	
    }

}