package Dominio;

public class Info_Elaboracion {

	private Producto nIngredientes;
	private Ingrediente nProductos;
	private float cantidad;

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