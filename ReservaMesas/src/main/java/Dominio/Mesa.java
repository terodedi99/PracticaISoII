package Dominio;

import java.util.*;

public class Mesa {

	private int idMesa;
	private String nombreMesa;
	ArrayList<Servicio> nServicios;

	public int getIdMesa() {
		return this.idMesa;
	}

	/**
	 * 
	 * @param idMesa
	 */
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}

	public String getNombreMesa() {
		return this.nombreMesa;
	}

	/**
	 * 
	 * @param nombreMesa
	 */
	public void setNombreMesa(String nombreMesa) {
		this.nombreMesa = nombreMesa;
	}

}