package com.ceiba.servicios_peliculas.dominio;

import com.ceiba.servicios_peliculas.dominio.excepcion.PeliculaExcepcion;

public class AlquilerEjecutar {
	private static final  String ERRORID = "el id no puede ser un valor negativo";
	private static final  String FECHAERROR = "Hay error en la fecha por favor verifique";
	private static final  String TARIFAERROR = "Hay error en la tarífa por favor verifique";
	private final long idPelicula;
	private final String fechaDevolucion;
	private final int tarifa;
	public AlquilerEjecutar(long idPelicula, String fechaDevolucion, int tarifa) {
		validarIdPelicula(idPelicula);
		validaFecha(fechaDevolucion);
		validarTarifa(tarifa);
		this.idPelicula = idPelicula;
		this.fechaDevolucion = fechaDevolucion;
		this.tarifa = tarifa;
	}
	
	private void validarIdPelicula(long id) {
		if(id<0) {
			throw new PeliculaExcepcion(ERRORID);
		}
	}
	
	private void validaFecha(String fecha) {
		if(fecha == null || fecha.equals("")) {
			throw new PeliculaExcepcion(FECHAERROR);
		}
	}
	
	private void validarTarifa(int tarifa) {
		if(tarifa == 0 || tarifa <5000) {
			throw new PeliculaExcepcion(TARIFAERROR);
		}
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
