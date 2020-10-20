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

import com.ceiba.servicios_peliculas.aplicacion.comando.ComandoAlquilerEjecutar;
import com.ceiba.servicios_peliculas.aplicacion.comando.ComandoPelicula;
import com.ceiba.servicios_peliculas.testdatabuilder.TestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorPeliculasTest {
	
	public static final long CODIGO_PELICULA_10 = 501l;
	public static final long CODIGO_PELICULA_70 = 70l;
	public static final String FECHA_DEVOLUCION = "22/10/2020";
	public static final int TARIFA = 7500;
	public static final String ALQUILERXCEPTION = "AlquilerExcepcion";
	public static final String EXCPTIONNOCONTROLADA = "Ocurrió un error por favor intente más tarde";
	public static final String ERRORIDNEG ="el id no puede ser un valor negativo";
	public static final String ERRORTARIFA = "Hay error en la tarífa por favor verifique";
	public static final String ERRORFECHA= "Hay error en la fecha por favor verifique";
	private static final  String NOMBREPELICULAERROR = "El nombre de la pelicula es vacio o es mayor a 100 caracteres";
	private static final  String STOCKINICIALERROR = "El stock inicial no puede ser igual a 0 o negativo";
	private static final  String STOCKERROR = "El stock no puede ser mayor al stock inicial o negativo";
	
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
    	ComandoAlquilerEjecutar comandoAlquilerEjecutar = new TestDataBuilder().crearComandoEjecutar();
    	mvc.perform(MockMvcRequestBuilders
                .post("/alquiler/alquilar")
                .content(objectMapper.writeValueAsString(comandoAlquilerEjecutar))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    	
    	
    }
    
    @Test
    public void agregar()throws Exception {
    	ComandoPelicula comandoPelicula = new TestDataBuilder().crearComandoPelicula();
    	mvc.perform(MockMvcRequestBuilders
                .post("/peliculas/agregar")
                .content(objectMapper.writeValueAsString(comandoPelicula))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    	
    	
    }
    
    @Test
    public void generarExcepcionNocontrolada()throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders
                .post("/peliculas/agregar")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(500))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value(EXCPTIONNOCONTROLADA));
    	
    	
    }
    
    @Test
    public void generarExcepcionControlada()throws Exception {
    	
    	mvc.perform(MockMvcRequestBuilders
                .get("/alquiler/obtenerAlquilerInfo/peliculaId/{id}",CODIGO_PELICULA_70)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombreExcepcion").value(ALQUILERXCEPTION));
    	
    }
    
    @Test
    public void alquilarByIdError()throws Exception {
    	ComandoAlquilerEjecutar comandoAlquilerEjecutar = new TestDataBuilder().crearNegComandoEjecutar();
    	mvc.perform(MockMvcRequestBuilders
                .post("/alquiler/alquilar")
                .content(objectMapper.writeValueAsString(comandoAlquilerEjecutar))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value(ERRORIDNEG));
    	
    	
    }
    
    @Test
    public void tarifaError()throws Exception {
    	ComandoAlquilerEjecutar comandoAlquilerEjecutar = new TestDataBuilder().tarifaComandoError();
    	mvc.perform(MockMvcRequestBuilders
                .post("/alquiler/alquilar")
                .content(objectMapper.writeValueAsString(comandoAlquilerEjecutar))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value(ERRORTARIFA));
    	
    	
    }
    
    @Test
    public void fechaError()throws Exception {
    	ComandoAlquilerEjecutar comandoAlquilerEjecutar = new TestDataBuilder().fechaComandoError();
    	mvc.perform(MockMvcRequestBuilders
                .post("/alquiler/alquilar")
                .content(objectMapper.writeValueAsString(comandoAlquilerEjecutar))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value(ERRORFECHA));
    	
    	
    }
    
    @Test
    public void agregarNombreError()throws Exception {
    	ComandoPelicula comandoPelicula = new TestDataBuilder().peliculaComandoErrorNombre();
    	mvc.perform(MockMvcRequestBuilders
                .post("/peliculas/agregar")
                .content(objectMapper.writeValueAsString(comandoPelicula))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value(NOMBREPELICULAERROR));
    	
    }
    
    @Test
    public void agregarFechaError()throws Exception {
    	ComandoPelicula comandoPelicula = new TestDataBuilder().peliculaComandoErrorfecha();
    	mvc.perform(MockMvcRequestBuilders
                .post("/peliculas/agregar")
                .content(objectMapper.writeValueAsString(comandoPelicula))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value(ERRORFECHA));
    	
    }
    
    @Test
    public void agregarStockErrorInicial()throws Exception {
    	ComandoPelicula comandoPelicula = new TestDataBuilder().peliculaComandoErrorStockInicial();
    	mvc.perform(MockMvcRequestBuilders
                .post("/peliculas/agregar")
                .content(objectMapper.writeValueAsString(comandoPelicula))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value(STOCKINICIALERROR));
    	
    }
    
    @Test
    public void agregarStockError()throws Exception {
    	ComandoPelicula comandoPelicula = new TestDataBuilder().peliculaComandoErrorStock();
    	mvc.perform(MockMvcRequestBuilders
                .post("/peliculas/agregar")
                .content(objectMapper.writeValueAsString(comandoPelicula))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value(STOCKERROR));
    	
    	
    }

}