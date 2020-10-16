package com.ceiba.servicios_peliculas.testdatabuilder;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.servicios_peliculas.aplicacion.comando.ComandoAlquilerEjecutar;
import com.ceiba.servicios_peliculas.dominio.AlquilerInfo;
import com.ceiba.servicios_peliculas.dominio.Pelicula;

public class TestDataBuilder {
	
	private static final long IDPELICULA = 77l;	
	private static final long IDPELICULADB = 10l;	
	private static final String NOMBREPELICULA = "Star Wars Episodio V: El imperio Contraataca";	
	private static final String FECHAESTRENO = "25/12/1980";	
	private static final String IMGURL = "POSTER URL";
	private static final int TARIFA = 7500;
	private static final String FECHADEVOLUCION = "20/10/2020";
	
	
	private long idPelicula;
	private long idPeliculaDB;
	private String fechaEstreno;
	private String nombrePelicula;
	private String imgUrl;
	private int tarifa;
	private String fechaDevolucion;
	public TestDataBuilder() {
		this.idPeliculaDB = IDPELICULADB;
		this.idPelicula = IDPELICULA;
		this.nombrePelicula = NOMBREPELICULA;
		this.fechaEstreno = FECHAESTRENO;
		this.imgUrl = IMGURL;
		this.tarifa = TARIFA;
		this.fechaDevolucion = FECHADEVOLUCION;
	}
	
	public AlquilerInfo alquilerDtoBuilder() {
		
		return new AlquilerInfo(this.idPelicula, this.nombrePelicula, this.fechaEstreno, this.imgUrl, this.tarifa, this.fechaDevolucion);
		
	}
	
	public List<Pelicula> listaPeliculas() {
		
		List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
	
		Pelicula peliculaDTO = new Pelicula(this.idPelicula, this.nombrePelicula, this.fechaEstreno, this.imgUrl);
		
		listaPeliculas.add(peliculaDTO);
		
		return listaPeliculas;
		
	}
	
	public ComandoAlquilerEjecutar crearComandoEjecutar() {
		return new ComandoAlquilerEjecutar(this.idPeliculaDB, this.fechaDevolucion, this.tarifa);
	}
	

}
