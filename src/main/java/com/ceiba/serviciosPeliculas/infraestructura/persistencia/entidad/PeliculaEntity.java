package com.ceiba.serviciosPeliculas.infraestructura.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name = "Peliculas")
@NamedQuery(name = "Pelicula.listar" , query = "SELECT p "
		+ "FROM Peliculas p "
		+ "where p.stock  > 0")

@NamedQuery(name = "Pelicula.byID" , query = "SELECT p "
		+ "FROM Peliculas p "
		+ "where p.id = :idPelicula")

@NamedQuery(name = "AlquilarPelicula.byID" , query = "UPDATE Peliculas p "
		+ "SET p.stock = stock - 1 "
		+ "WHERE p.id = :idPelicula")
public class PeliculaEntity {
	
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "FECHA_ESTRENO")
	private String fechaEstreno;
	
	@Column(name = "STOCK")
	private Integer stock;
	
	@Column(name = "IMAGE_URL")
	private String imageUrl;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	

}
