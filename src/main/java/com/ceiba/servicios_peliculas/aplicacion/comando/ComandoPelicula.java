package com.ceiba.servicios_peliculas.aplicacion.comando;

public class ComandoPelicula {
	
	private String nombre;
	
	private String fechaEstreno;
	
	private Integer stock;
	
	private Integer stockInicial;	
	
	private String imageUrl;
	
	private String sinopsis;
	
	public ComandoPelicula() {
		super();
	}

	public ComandoPelicula(String nombre, String fechaEstreno, Integer stock, Integer stockInicial, String imageUrl,
			String sinopsis) {
		this.nombre = nombre;
		this.fechaEstreno = fechaEstreno;
		this.stock = stock;
		this.stockInicial = stockInicial;
		this.imageUrl = imageUrl;
		this.sinopsis = sinopsis;
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
