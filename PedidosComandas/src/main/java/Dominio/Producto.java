package Dominio;

import java.util.*;

public class Producto {

	ArrayList<LineaComanda> nProductos;
	ArrayList<Info_Elaboracion> info_Elaboracion;
	private int idProducto;
	private String descripcionProducto;
	private float precio;

	public void getIdProducto() {
		// TODO - implement Producto.getIdProducto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idProducto
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public float getPrecio() {
		return this.precio;
	}

	/**
	 * 
	 * @param precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDescripcionProducto() {
		return this.descripcionProducto;
	}

	/**
	 * 
	 * @param descripcionProducto
	 */
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

}