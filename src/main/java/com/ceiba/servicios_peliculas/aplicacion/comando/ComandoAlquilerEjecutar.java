package com.ceiba.servicios_peliculas.aplicacion.comando;

public class ComandoAlquilerEjecutar {
	
	private long idPelicula;
	private String fechaDevolucion;
	private int tarifa;
	
	public ComandoAlquilerEjecutar() {
		super();
	}
	
	public ComandoAlquilerEjecutar(long idPelicula, String fechaDevolucion, int tarifa) {
		
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
