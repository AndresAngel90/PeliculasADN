package com.ceiba.servicios_peliculas.dominio;

public class AlquilerEjecutar {
	
	private final long idPelicula;
	private final String fechaDevolucion;
	private final int tarifa;
	public AlquilerEjecutar(long idPelicula, String fechaDevolucion, int tarifa) {
		
		this.idPelicula = idPelicula;
		this.fechaDevolucion = fechaDevolucion;
		this.tarifa = tarifa;
	}
	
	public long getIdPelicula() {
		return idPelicula;
	}
	public String getFechaDevolucion() {
		return fechaDevolucion;
	}
	public int getTarifa() {
		return tarifa;
	}
	
	

}
