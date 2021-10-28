/**
 * EstadoEnum.java
 */
package com.hbt.semillero.enums;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author midac
 * @version 
 */
public enum EstadoEnum {
	ACTIVO("enum.estado.activo"), 
	INACTIVO("enum.estado.inactivo");
	
	/**
	 * Atributo que contiene la clave del mensaje para la internacionalizacion
	 */
	private String codigoMensajex;

	/**
	 * Constructor que recibe como parametro el codigo del mensaje
	 * 
	 * @param codigoMensaje, Clave del mensaje para para internacionalizacion
	 */
	EstadoEnum(String codigoMensajex) {
		this.codigoMensajex = codigoMensajex;
	}

	/**
	 * Metodo que retorna el valor del atributo
	 * 
	 * @return cadena con el codigo del mensaje
	 */
	public String getCodigoMensajex() {
		return codigoMensajex;
	}

	/**
	 * Metodo que establece el valor del atributo
	 *
	 * @param codigoMensajex
	 */
	public void setCodigoMensajex(String codigoMensajex) {
		this.codigoMensajex = codigoMensajex;
	}}


