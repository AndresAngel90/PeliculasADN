package com.ceiba.serviciosPeliculas.dominio.dto;

public class AlquilerDTO {
	
	long idPelicula;
	
	String nombrePelicula;
	
	String fechaDevolucion;
	
	String fechaEstrenoAlquiler;
	
	public String getFechaEstrenoAlquiler() {
		return fechaEstrenoAlquiler;
	}

	public void setFechaEstrenoAlquiler(String fechaEstrenoAlquiler) {
		this.fechaEstrenoAlquiler = fechaEstrenoAlquiler;
	}

	String urlImagen;
	
	Integer tarifa;

	public String getNombrePelicula() {
		return nombrePelicula;
	}

	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}

	public String getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Integer getTarifa() {
		return tarifa;
	}

	public void setTarifa(Integer tarifa) {
		this.tarifa = tarifa;
	}

	public long getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(long idPelicula) {
		this.idPelicula = idPelicula;
	}
	
	

}
