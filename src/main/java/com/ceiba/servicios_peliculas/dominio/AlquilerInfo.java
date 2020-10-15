package com.ceiba.servicios_peliculas.dominio;

public class AlquilerInfo {
	
	long idPelicula;
	
	String nombrePelicula;
	
	String fechaEstrenoAlquiler;
	
	String urlImagen;
	
	Integer tarifa;
	
	String fechaDevolucion;
	
	

	public AlquilerInfo(long idPelicula, String nombrePelicula, String fechaEstrenoAlquiler, String urlImagen) {
		this.idPelicula = idPelicula;
		this.nombrePelicula = nombrePelicula;
		this.fechaEstrenoAlquiler = fechaEstrenoAlquiler;
		this.urlImagen = urlImagen;
	}	

	public AlquilerInfo(long idPelicula, String nombrePelicula, String fechaEstrenoAlquiler, String urlImagen,
			Integer tarifa, String fechaDevolucion) {
		
		this.idPelicula = idPelicula;
		this.nombrePelicula = nombrePelicula;
		this.fechaEstrenoAlquiler = fechaEstrenoAlquiler;
		this.urlImagen = urlImagen;
		this.tarifa = tarifa;
		this.fechaDevolucion = fechaDevolucion;
	}

	public long getIdPelicula() {
		return idPelicula;
	}

	public String getNombrePelicula() {
		return nombrePelicula;
	}

	public String getFechaEstrenoAlquiler() {
		return fechaEstrenoAlquiler;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public Integer getTarifa() {
		return tarifa;
	}

	public String getFechaDevolucion() {
		return fechaDevolucion;
	}
	
	public void setTarifa(Integer tarifa) {
		this.tarifa = tarifa;
	}

	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	

}
