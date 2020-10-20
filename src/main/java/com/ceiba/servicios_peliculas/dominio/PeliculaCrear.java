package com.ceiba.servicios_peliculas.dominio;

import com.ceiba.servicios_peliculas.dominio.excepcion.PeliculaExcepcion;

public class PeliculaCrear {
	
	private static final  String FECHAERROR = "Hay error en la fecha por favor verifique";
	private static final  String NOMBREPELICULAERROR = "El nombre de la pelicula es vacio o es mayor a 100 caracteres";
	private static final  String STOCKINICIALERROR = "El stock inicial no puede ser igual a 0 o negativo";
	private static final  String STOCKERROR = "El stock no puede ser mayor al stock inicial o negativo";
	private static final  String URLERROR = "La url de la imagen es vacio o es mayor a 1000 caracteres";
	private static final  String SINOPSISERROR = "La sinopsis de la pelicula es vacio o es mayor a 255 caracteres";
	
	private String nombre;
	private String fechaEstreno;
	private Integer stock;
	private Integer stockInicial;	
	private String imageUrl;
	private String sinopsis;
	
	public PeliculaCrear(String nombre, String fechaEstreno, Integer stock, Integer stockInicial, String imageUrl,
			String sinopsis) {
		validaNombrePelicula(nombre);
		validaFecha(fechaEstreno);
		validaStockInicial(stockInicial);
		validaStock(stock, stockInicial);
		validaURLImg(imageUrl);
		validaSinopsis(sinopsis);
		this.nombre = nombre;
		this.fechaEstreno = fechaEstreno;
		this.stock = stock;
		this.stockInicial = stockInicial;
		this.imageUrl = imageUrl;
		this.sinopsis = sinopsis;
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
	
	private void validaStockInicial(int stock) {
		if(stock <= 0) {
			throw new PeliculaExcepcion(STOCKINICIALERROR);
		}
	}
	
	private void validaStock(int stock, int stockInicial) {
		if(stock > stockInicial || stock < 0) {
			throw new PeliculaExcepcion(STOCKERROR);
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
	
	
	public String getNombre() {
		return nombre;
	}
	public String getFechaEstreno() {
		return fechaEstreno;
	}
	public Integer getStock() {
		return stock;
	}
	public Integer getStockInicial() {
		return stockInicial;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	
	
	

}
