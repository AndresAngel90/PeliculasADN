package com.ceiba.servicios_peliculas.dominio;

import com.ceiba.servicios_peliculas.dominio.excepcion.PeliculaExcepcion;

public class Alquiler {
	private static final  String ERRORPELICULA = "Hay campos vacios en su peticion por favor revisar";
	private static final  String TARIFAERROR = "Hay error en la tarífa por favor verifique";
	private static final  String FECHAERROR = "Hay error en la fecha por favor verifique";
	private final Pelicula pelicula;
	private int tarifa;
	private String fechaDevolucion;
	
	public Alquiler(Pelicula pelicula, int tarifa, String fechaDevolucion) {
		validarPelicula(pelicula);
		validarTarifa(tarifa);
		validaFecha(fechaDevolucion);
		this.pelicula = pelicula;
		this.tarifa = tarifa;
		this.fechaDevolucion = fechaDevolucion;
	}
	
	private void validarPelicula(Pelicula pelicula) {
		if(pelicula == null) {
			throw new PeliculaExcepcion(ERRORPELICULA);
		}
	}
	private void validarTarifa(int tarifa) {
		if(tarifa == 0 || tarifa <5000) {
			throw new PeliculaExcepcion(TARIFAERROR);
		}
	}
	private void validaFecha(String fecha) {
		if(("").equals(fecha)) {
			throw new PeliculaExcepcion(FECHAERROR);
		}
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
