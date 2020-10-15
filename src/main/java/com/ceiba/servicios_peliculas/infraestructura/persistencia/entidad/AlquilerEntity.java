package com.ceiba.servicios_peliculas.infraestructura.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "alquiler")
public class AlquilerEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PELICULA", referencedColumnName = "id")
    private PeliculaEntity pelicula;
    
    @Column(name = "FECHA_DEVOLUCION")
	private String fechaDevolucion;
    
    @Column(name = "VALOR_ALQUILER")
	private int valorAlquiler;
    
    @Column(name = "ESTADO_ALQUILER")
	private String estadoAlquiler;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PeliculaEntity getPelicula() {
		return pelicula;
	}

	public void setPelicula(PeliculaEntity pelicula) {
		this.pelicula = pelicula;
	}

	public String getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public int getValorAlquiler() {
		return valorAlquiler;
	}

	public void setValorAlquiler(int valorAlquiler) {
		this.valorAlquiler = valorAlquiler;
	}

	public String getEstadoAlquiler() {
		return estadoAlquiler;
	}

	public void setEstadoAlquiler(String estadoAlquiler) {
		this.estadoAlquiler = estadoAlquiler;
	}

}
