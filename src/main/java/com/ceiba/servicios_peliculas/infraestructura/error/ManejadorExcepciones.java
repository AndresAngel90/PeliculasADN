package com.ceiba.servicios_peliculas.infraestructura.error;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ceiba.servicios_peliculas.dominio.excepcion.AlquilerExcepcion;
import com.ceiba.servicios_peliculas.dominio.excepcion.PeliculaExcepcion;

public class ManejadorExcepciones {
	
//	private static final String OCURRIO_UN_ERROR = "Ocurrió un error por favor intente más tarde";
//	
//	private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();
//	
//	public ManejadorExcepciones() {
//		
//		CODIGOS_ESTADO.put(AlquilerExcepcion.class.getSimpleName(),  HttpStatus.BAD_REQUEST.value());
//		CODIGOS_ESTADO.put(PeliculaExcepcion.class.getSimpleName(),  HttpStatus.BAD_REQUEST.value());
//		
//	}
//	
//	@ExceptionHandler(Exception.class)
//    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
//        ResponseEntity<Error> resultado;
//
//        String excepcionNombre = exception.getClass().getSimpleName();
//        String mensaje = exception.getMessage();
//        Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);
//
//        if (codigo != null) {
//            Error error = new Error(excepcionNombre, mensaje);
//            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
//        } else {
//            Error error = new Error(excepcionNombre, OCURRIO_UN_ERROR);
//            resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return resultado;
//    }

}
