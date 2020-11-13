package Dominio;

import java.util.Date;

public class Servicio {

	private int idServicio;
	private Date fecha;
	private int num_comensales;
	private Estado estado;
	private String comentarios;
	Turno nTurno;
	Empleado nEmpleado;
	Mesa nMesa;

	public int getIdServicio() {
		return this.idServicio;
	}

	/**
	 * 
	 * @param idServicio
	 */
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public Date getFecha() {
		return this.fecha;
	}

	/**
	 * 
	 * @param fecha
	 */
	public Date setFecha(Date fecha) {
		// TODO - implement Servicio.setFecha
		throw new UnsupportedOperationException();
	}

	public int getNum_comensales() {
		return this.num_comensales;
	}

	/**
	 * 
	 * @param num_comensales
	 */
	public void setNum_comensales(int num_comensales) {
		this.num_comensales = num_comensales;
	}

	public Estado getEstado() {
		return this.estado;
	}

	/**
	 * 
	 * @param estado
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	/**
	 * 
	 * @param comentarios
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public void update() {
		// TODO - implement Servicio.update
		throw new UnsupportedOperationException();
	}

}