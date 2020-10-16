package com.ceiba.servicios_peliculas.dominio.excepcion;

public class AlquilerExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public AlquilerExcepcion(String mensaje) {
        super(mensaje);
    }

}
