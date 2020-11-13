package Dominio;

import java.util.*;

public class Turno {

	private int idTurno;
	private String nombreTurno;
	Pase nPase;
	ArrayList<Servicio> nServicios;

	public int getIdTurno() {
		return this.idTurno;
	}

	/**
	 * 
	 * @param idTurno
	 */
	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	public String getNombreTurno() {
		return this.nombreTurno;
	}

	/**
	 * 
	 * @param nombreTurno
	 */
	public void setNombreTurno(String nombreTurno) {
		this.nombreTurno = nombreTurno;
	}

}