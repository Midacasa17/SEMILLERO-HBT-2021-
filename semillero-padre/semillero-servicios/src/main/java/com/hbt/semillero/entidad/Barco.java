/**
 * Barco.java
 */
package com.hbt.semillero.entidad;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.interfaces.AccionesVehiculoInterface;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author midac
 * @version 
 */
public  class Barco extends Vehiculo implements AccionesVehiculoInterface{
	private String nombreCapitan;
	private String puertoLlegda;
	
	/**
	 * Metodo encargado de retornar el valor del atributo nombreCapitan
	 * @return El nombreCapitan asociado a la clase
	 */
	public String getNombreCapitan() {
		return nombreCapitan;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo nombreCapitan
	 * @param nombreCapitan El nuevo nombreCapitan a modificar.
	 */
	public void setNombreCapitan(String nombreCapitan) {
		this.nombreCapitan = nombreCapitan;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo puertoLlegda
	 * @return El puertoLlegda asociado a la clase
	 */
	public String getPuertoLlegda() {
		return puertoLlegda;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo puertoLlegda
	 * @param puertoLlegda El nuevo puertoLlegda a modificar.
	 */
	public void setPuertoLlegda(String puertoLlegda) {
		this.puertoLlegda = puertoLlegda;
	}
	@Override
	public int obtenerVelocidadMaxima() {
		
		return 100;
	}
	public long obtenerPesoMaxima() {
		
		return 20L;
	}
	public boolean DeterminarTipoVehiculo(TipoVehiculoEnum TipoVehiculo) throws Exception {
		
		return false;
	}
	@Override
	public Long obternerPesoMaximoCarga() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEmun) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
