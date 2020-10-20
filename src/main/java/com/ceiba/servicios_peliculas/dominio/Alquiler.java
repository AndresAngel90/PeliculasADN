package com.ceiba.servicios_peliculas.dominio;


public class Alquiler {
	
	private final Pelicula pelicula;
	private int tarifa;
	private String fechaDevolucion;
	
	public Alquiler(Pelicula pelicula, int tarifa, String fechaDevolucion) {
		this.pelicula = pelicula;
		this.tarifa = tarifa;
		this.fechaDevolucion = fechaDevolucion;
	}
	
	public Pelicula getPelicula() {
		return pelicula;
	}

	public int getTarifa() {
		return tarifa;
	}

	public String getFechaDevolucion() {
		return fechaDevolucion;
	}	
	

}
