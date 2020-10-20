package com.ceiba.servicios_peliculas.testdatabuilder;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.servicios_peliculas.aplicacion.comando.ComandoAlquilerEjecutar;
import com.ceiba.servicios_peliculas.aplicacion.comando.ComandoPelicula;
import com.ceiba.servicios_peliculas.dominio.AlquilerInfo;
import com.ceiba.servicios_peliculas.dominio.Pelicula;

public class TestDataBuilder {
	
	private static final long IDPELICULA = 77l;	
	private static final long IDPELICULADB = 501l;	
	private static final String NOMBREPELICULA = "Star Wars Episodio V: El imperio Contraataca";	
	private static final String FECHAESTRENO = "25/12/1980";	
	private static final String IMGURL = "POSTER URL";
	private static final int TARIFA = 7500;
	private static final String FECHADEVOLUCION = "20/10/2020";
	private static final String SINOPSIS = "argumento de la pelicula";	
	private static final int STOCK = 10;
	public static final long CODIGO_PELICULA_NEG = -501l;
	
	private long idPelicula;
	private long idPeliculaDB;
	private String fechaEstreno;
	private String nombrePelicula;
	private String imgUrl;
	private int tarifa;
	private String fechaDevolucion;
	private String sinopsis;
	private int stock;
	private long codigoPeliculaNeg;
	
	public TestDataBuilder() {
		this.idPeliculaDB = IDPELICULADB;
		this.idPelicula = IDPELICULA;
		this.nombrePelicula = NOMBREPELICULA;
		this.fechaEstreno = FECHAESTRENO;
		this.imgUrl = IMGURL;
		this.tarifa = TARIFA;
		this.fechaDevolucion = FECHADEVOLUCION;
		this.sinopsis = SINOPSIS;
		this.stock = STOCK;
		this.codigoPeliculaNeg = CODIGO_PELICULA_NEG;
	}
	
	public AlquilerInfo alquilerDtoBuilder() {
		
		return new AlquilerInfo(this.idPelicula, this.nombrePelicula, this.fechaEstreno, this.imgUrl, this.tarifa, this.fechaDevolucion);
		
	}
	
	public List<Pelicula> listaPeliculas() {
		
		List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
	
		Pelicula peliculaDTO = new Pelicula(this.idPelicula, this.nombrePelicula, this.fechaEstreno, this.imgUrl, this.sinopsis);
		
		listaPeliculas.add(peliculaDTO);
		
		return listaPeliculas;
		
	}
	
	public ComandoAlquilerEjecutar crearComandoEjecutar() {
		return new ComandoAlquilerEjecutar(this.idPeliculaDB, this.fechaDevolucion, this.tarifa);
	}
	
	public ComandoPelicula crearComandoPelicula() {
		return new ComandoPelicula(this.nombrePelicula, this.fechaEstreno, this.stock, this.stock, this.imgUrl, this.sinopsis);
		
	}
	
	public ComandoAlquilerEjecutar tarifaComandoError() {
		return new ComandoAlquilerEjecutar(this.idPeliculaDB, this.fechaDevolucion, 4000);
	}
	
	public ComandoAlquilerEjecutar crearNegComandoEjecutar() {
		return new ComandoAlquilerEjecutar(this.codigoPeliculaNeg, this.fechaDevolucion, this.tarifa);
	}
	
	public ComandoAlquilerEjecutar fechaComandoError() {
		return new ComandoAlquilerEjecutar(this.idPeliculaDB, "", this.tarifa);
	}
	
	public ComandoPelicula peliculaComandoErrorNombre() {
		return new ComandoPelicula("", this.fechaEstreno, this.stock, this.stock, this.imgUrl, this.sinopsis);
		
	}
	
	public ComandoPelicula peliculaComandoErrorfecha() {
		return new ComandoPelicula(this.nombrePelicula, "", this.stock, this.stock, this.imgUrl, this.sinopsis);
		
	}
	
	public ComandoPelicula peliculaComandoErrorStockInicial() {
		return new ComandoPelicula(this.nombrePelicula, this.fechaEstreno, 7, 0, this.imgUrl, this.sinopsis);
		
	}
	
	public ComandoPelicula peliculaComandoErrorStock() {
		return new ComandoPelicula(this.nombrePelicula, this.fechaEstreno, 7, 5, this.imgUrl, this.sinopsis);
		
	}
	

}
