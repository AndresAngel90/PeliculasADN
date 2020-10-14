package com.ceiba.servicios_peliculas.testdatabuilder;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.servicios_peliculas.dominio.dto.AlquilerDTO;
import com.ceiba.servicios_peliculas.dominio.dto.PeliculaDTO;

public class TestDataBuilder {
	
	private static final long IDPELICULA = 77l;	
	private static final String NOMBREPELICULA = "Star Wars Episodio V: El imperio Contraataca";	
	private static final String FECHAESTRENO = "25/12/1980";	
	private static final String IMGURL = "POSTER URL";
	private static final int TARIFA = 7500;
	private static final String FECHADEVOLUCION = "20/10/2020";
	
	
	private long idPelicula;
	private String fechaEstreno;
	private String nombrePelicula;
	private String imgUrl;
	private int tarifa;
	private String fechaDevolucion;
	public TestDataBuilder() {
		
		this.idPelicula = IDPELICULA;
		this.nombrePelicula = NOMBREPELICULA;
		this.fechaEstreno = FECHAESTRENO;
		this.imgUrl = IMGURL;
		this.tarifa = TARIFA;
		this.fechaDevolucion = FECHADEVOLUCION;
	}
	
	public AlquilerDTO alquilerDtoBuilder() {
		
		AlquilerDTO alquilerDTO = new AlquilerDTO();
		
		alquilerDTO.setIdPelicula(this.idPelicula);
		alquilerDTO.setNombrePelicula(this.nombrePelicula);
		alquilerDTO.setFechaEstrenoAlquiler(this.fechaEstreno);
		alquilerDTO.setUrlImagen(this.imgUrl);
		alquilerDTO.setTarifa(this.tarifa);
		alquilerDTO.setFechaDevolucion(this.fechaDevolucion);
		return alquilerDTO;
		
	}
	
public List<PeliculaDTO> listaPeliculas() {
		
		List<PeliculaDTO> listaPeliculas = new ArrayList<PeliculaDTO>();
	
		PeliculaDTO peliculaDTO = new PeliculaDTO();
		
		peliculaDTO.setPeliculaID(this.idPelicula);
		peliculaDTO.setTituloPelicula(this.nombrePelicula);
		peliculaDTO.setFechaEstreno(this.fechaEstreno);
		peliculaDTO.setUrlImagen(this.imgUrl);
		
		listaPeliculas.add(peliculaDTO);
		
		return listaPeliculas;
		
	}
	

}
