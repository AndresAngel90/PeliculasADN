package com.ceiba.servicios_peliculas.dominio;

import com.ceiba.servicios_peliculas.dominio.excepcion.PeliculaExcepcion;

public class Pelicula {
	
	private static final  String ERRORID = "el id no puede ser un valor negativo";
	private static final  String FECHAERROR = "Hay error en la fecha por favor verifique";
	private static final  String NOMBREPELICULAERROR = "El nombre de la pelicula es vacio o es mayor a 100 caracteres";
	private static final  String URLERROR = "La url de la imagen es vacio o es mayor a 1000 caracteres";
	private static final  String SINOPSISERROR = "La sinopsis de la pelicula es vacio o es mayor a 255 caracteres";
	
	private long peliculaID;
	
	private String tituloPelicula;
	
	private String fechaEstreno;
	
	private String urlImagen;
	
	private String sinopsis;

	public Pelicula(long peliculaID, String tituloPelicula, String fechaEstreno, String urlImagen, String sinopsis) {
		validarIdPelicula(peliculaID);
		validaNombrePelicula(tituloPelicula);
		validaFecha(fechaEstreno);
		validaURLImg(urlImagen);
		validaSinopsis(sinopsis);
		this.peliculaID = peliculaID;
		this.tituloPelicula = tituloPelicula;
		this.fechaEstreno = fechaEstreno;
		this.urlImagen = urlImagen;
		this.sinopsis = sinopsis;
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
	
	private void validaSinopsis(String sinopsis) {
		if(("").equals(sinopsis) || sinopsis.length()>255 ) {
			throw new PeliculaExcepcion(SINOPSISERROR);
		}
	}

	public long getPeliculaID() {
		return peliculaID;
	}

	public String getTituloPelicula() {
		return tituloPelicula;
	}

	public String getFechaEstreno() {
		return fechaEstreno;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public String getSinopsis() {
		return sinopsis;
	}	
	
	
}
