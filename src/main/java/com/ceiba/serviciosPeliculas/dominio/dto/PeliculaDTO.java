package com.ceiba.serviciosPeliculas.dominio.dto;

public class PeliculaDTO {
	
	private long peliculaID;
	
	private String tituloPelicula;
	
	private String fechaEstreno;
	
	private String urlImagen;

	public String getTituloPelicula() {
		return tituloPelicula;
	}

	public void setTituloPelicula(String tituloPelicula) {
		this.tituloPelicula = tituloPelicula;
	}

	public String getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public long getPeliculaID() {
		return peliculaID;
	}

	public void setPeliculaID(long peliculaID) {
		this.peliculaID = peliculaID;
	}
	
	
}
