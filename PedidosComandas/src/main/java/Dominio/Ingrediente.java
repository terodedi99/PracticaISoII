package Dominio;

import java.util.*;

public class Ingrediente {

	ArrayList<Info_Elaboracion> info_Elaboracion;
	private int idIngrediente;
	private String descripcionIngrediente;
	private float stock;
	private float cantidad;
	private String unidad;

	public int getIdIngrediente() {
		return this.idIngrediente;
	}

	/**
	 * 
	 * @param idIngrediente
	 */
	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getDescripcionIngrediente() {
		return this.descripcionIngrediente;
	}

	/**
	 * 
	 * @param descripcionIngrediente
	 */
	public void setDescripcionIngrediente(String descripcionIngrediente) {
		this.descripcionIngrediente = descripcionIngrediente;
	}

	public String getUnidad() {
		return this.unidad;
	}

	/**
	 * 
	 * @param unidad
	 */
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public float getStock() {
		return this.stock;
	}

	/**
	 * 
	 * @param stock
	 */
	public void setStock(float stock) {
		this.stock = stock;
	}

	public float getCantidad() {
		return this.cantidad;
	}

	/**
	 * 
	 * @param cantidad
	 */
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

}