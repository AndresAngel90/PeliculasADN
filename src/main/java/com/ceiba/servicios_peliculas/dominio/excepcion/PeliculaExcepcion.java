package com.ceiba.servicios_peliculas.dominio.excepcion;

public class PeliculaExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public PeliculaExcepcion(String mensaje) {
		super(mensaje);
	}

}
