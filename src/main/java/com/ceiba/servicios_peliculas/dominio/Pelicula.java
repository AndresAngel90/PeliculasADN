package com.ceiba.servicios_peliculas.dominio;


public class Pelicula {
	
	private long peliculaID;
	
	private String tituloPelicula;
	
	private String fechaEstreno;
	
	private String urlImagen;
	
	private String sinopsis;

	public Pelicula(long peliculaID, String tituloPelicula, String fechaEstreno, String urlImagen, String sinopsis) {
		
		this.peliculaID = peliculaID;
		this.tituloPelicula = tituloPelicula;
		this.fechaEstreno = fechaEstreno;
		this.urlImagen = urlImagen;
		this.sinopsis = sinopsis;
	}
	
	

	public long getPeliculaID() {
		return peliculaID;
	}

	public String getTituloPelicula() {
		return tituloPelicula;
	}

	public String getFechaEstreno() {
		return fechaEstreno;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public String getSinopsis() {
		return sinopsis;
	}	
	
	
}
