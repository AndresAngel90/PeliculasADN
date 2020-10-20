package com.ceiba.servicios_peliculas.dominio;

import com.ceiba.servicios_peliculas.dominio.excepcion.PeliculaExcepcion;

public class AlquilerInfo {
	
	private static final  String ERRORID = "el id no puede ser un valor negativo";
	private static final  String FECHAERROR = "Hay error en la fecha por favor verifique";
	private static final  String NOMBREPELICULAERROR = "El nombre de la pelicula es vacio o es mayor a 100 caracteres";
	private static final  String URLERROR = "La url de la imagen es vacio o es mayor a 1000 caracteres";
	
	long idPelicula;
	
	String nombrePelicula;
	
	String fechaEstrenoAlquiler;
	
	String urlImagen;
	
	Integer tarifa;
	
	String fechaDevolucion;
	
	

	public AlquilerInfo(long idPelicula, String nombrePelicula, String fechaEstrenoAlquiler, String urlImagen) {
		validarIdPelicula(idPelicula);
		validaNombrePelicula(nombrePelicula);
		validaFecha(fechaEstrenoAlquiler);
		validaURLImg(urlImagen);
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
	
	private void validarIdPelicula(long id) {
		if(id<0) {
			throw new PeliculaExcepcion(ERRORID);
		}
	}
	
	private void validaFecha(String fecha) {
		if(("").equals(fecha)) {
			throw new PeliculaExcepcion(FECHAERROR);
		}
	}
	
	private void validaNombrePelicula(String nombrePelicula) {
		if(("").equals(nombrePelicula) || nombrePelicula.length()>100 ) {
			throw new PeliculaExcepcion(NOMBREPELICULAERROR);
		}
	}
	
	private void validaURLImg(String url) {
		if(("").equals(url) || url.length()>1000 ) {
			throw new PeliculaExcepcion(URLERROR);
		}
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
