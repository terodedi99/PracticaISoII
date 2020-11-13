package Dominio;

import java.util.*;

public class Pase {

	private int idPase;
	private String nombrePase;
	ArrayList<Turno> nTurnos;

	public int getIdPase() {
		return this.idPase;
	}

	/**
	 * 
	 * @param idPase
	 */
	public void setIdPase(int idPase) {
		this.idPase = idPase;
	}

	public String getNombrePase() {
		return this.nombrePase;
	}

	/**
	 * 
	 * @param nombrePase
	 */
	public void setNombrePase(String nombrePase) {
		this.nombrePase = nombrePase;
	}

}