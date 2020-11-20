package Dominio;

public class LineaComanda {

	Comanda nLineas;
	Producto nLinea;
	private int idLineaComanda;
	private int cantidad;

	public void getIdLineaComanda() {
		// TODO - implement LineaComanda.getIdLineaComanda
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idLineaComanda
	 */
	public void setIdLineaComanda(int idLineaComanda) {
		this.idLineaComanda = idLineaComanda;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	/**
	 * 
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}