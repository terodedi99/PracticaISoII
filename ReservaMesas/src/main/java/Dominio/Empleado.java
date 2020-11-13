package Dominio;

import java.util.*;

public class Empleado {

	private String DNI;
	private String nombre;
	private String apellidos;
	private long tfno_contacto;
	private Rol tipoEmpleado;
	Restaurante nRestaurante;
	ArrayList<Servicio> nServicios;

	public String getDNI() {
		// TODO - implement Empleado.getDNI
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param DNI
	 */
	public void setDNI(String DNI) {
		// TODO - implement Empleado.setDNI
		throw new UnsupportedOperationException();
	}

	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	/**
	 * 
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public long getTfno_contacto() {
		return this.tfno_contacto;
	}

	/**
	 * 
	 * @param tfno_contacto
	 */
	public void setTfno_contacto(long tfno_contacto) {
		this.tfno_contacto = tfno_contacto;
	}

}